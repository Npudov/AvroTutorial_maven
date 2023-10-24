package org.example;

import org.apache.avro.Schema;
import org.apache.avro.file.DataFileReader;
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericDatumWriter;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.io.DatumReader;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.specific.SpecificDatumReader;
import org.example.avro.User;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Benchmark)
@Fork(value = 1, warmups = 2)
@Warmup(iterations = 3 ,time = 300, timeUnit = TimeUnit.MILLISECONDS)
public class BenchmarkRunner {

    private static Schema schema;

    static {
        try {
            schema = new Schema.Parser().parse(new File("AvroTutor/src/main/avro/user.avsc"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static GenericRecord user1 = new GenericData.Record(schema);
    private static File file = new File("users.avro");
    private static DatumWriter<GenericRecord> datumWriter = new GenericDatumWriter<GenericRecord>(schema);
    private static DataFileWriter<GenericRecord> dataFileWriter = new DataFileWriter<GenericRecord>(datumWriter);

    private static DatumReader<User> userDatumReader = new SpecificDatumReader<>(User.class);
    private static DataFileReader<User> dataFileReader;

    static {
        try {
            dataFileReader = new DataFileReader<User>(file, userDatumReader);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    @Param({"100", "1000", "10000"})
    private static int N;
    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    public static void init() throws Exception {
        //Schema schema = new Schema.Parser().parse(new File("src/main/avro/user.avsc"));


        for (int i=0;i<N;i++) {
            dataFileWriter.create(schema, file);
            dataFileWriter.append(user1);
            dataFileWriter.close();

            User user = null;
            while (dataFileReader.hasNext()) {
                // Reuse user object by passing it to next(). This saves us from
                // allocating and garbage collecting many objects for files with
                // many items.
                user = dataFileReader.next(user);
            }
        }
    }

    @Setup
    public void setUp() {
        for (int i=0; i<N;i++) {
            user1.put("stringField", "abcdef");
            user1.put("intField", 256);
            user1.put("listField", Arrays.asList(1, 2, 3));
        }
    }

    public static void main(String[] args) throws Exception {
        //org.openjdk.jmh.Main.main(args);
        Options opt = new OptionsBuilder()
                .include(BenchmarkRunner.class.getSimpleName())
                .forks(1)
                .build();

        new Runner(opt).run();
    }
}
