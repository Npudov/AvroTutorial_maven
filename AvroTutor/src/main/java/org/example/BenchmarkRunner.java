package org.example;

import org.apache.avro.Schema;
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericDatumWriter;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.io.DatumWriter;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.io.File;
import java.io.IOException;
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

    @Param({"100", "1000", "10000"})
    private static int N;
    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    public static void init() throws Exception {
        //Schema schema = new Schema.Parser().parse(new File("src/main/avro/user.avsc"));


        for (int i=0;i<N;i++) {
            File file = new File("users.avro");
            DatumWriter<GenericRecord> datumWriter = new GenericDatumWriter<GenericRecord>(schema);
            DataFileWriter<GenericRecord> dataFileWriter = new DataFileWriter<GenericRecord>(datumWriter);
            dataFileWriter.create(schema, file);
            dataFileWriter.append(user1);
            dataFileWriter.close();
        }
    }

    @Setup
    public void setUp() {
        user1.put("stringField", "abcdef");
        user1.put("intField", 256);
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
