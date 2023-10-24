package org.example;

import org.apache.avro.Schema;
import org.apache.avro.file.DataFileReader;
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericDatumReader;
import org.apache.avro.generic.GenericDatumWriter;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.io.DatumReader;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.specific.SpecificDatumReader;
import org.apache.avro.specific.SpecificDatumWriter;
import org.example.avro.User;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) throws IOException {

        User user1 = User.newBuilder()
                .setStringField("abcdef")
                .setIntField(256)
                .setListField(Arrays.asList(1, 2, 3))
                .build();

        File file = new File("users.avro");

        // Serialize user1, user2 and user3 to disk
        DatumWriter<User> userDatumWriter = new SpecificDatumWriter<User>(User.class);
        DataFileWriter<User> dataFileWriter = new DataFileWriter<User>(userDatumWriter);
        dataFileWriter.create(user1.getSchema(), file);
        dataFileWriter.append(user1);
        dataFileWriter.close();

        String sizeFile = String.valueOf(file.length());
        try (PrintWriter printWriter = new PrintWriter("result.txt")){
            printWriter.write(sizeFile);
        }

        // Deserialize Users from disk
        DatumReader<User> userDatumReader = new SpecificDatumReader<>(User.class);
        DataFileReader<User> dataFileReader = new DataFileReader<User>(file, userDatumReader);
        User user = null;
        while (dataFileReader.hasNext()) {
        // Reuse user object by passing it to next(). This saves us from
        // allocating and garbage collecting many objects for files with
        // many items.
            user = dataFileReader.next(user);
            System.out.println(user);
        }




        /*Schema schema = new Schema.Parser().parse(new File("AvroTutor/src/main/avro/user.avsc"));



        GenericData.Array<Integer> numbers = new GenericData.Array<>(3, schema);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);

        GenericRecord user1 = new GenericData.Record(schema);
        user1.put("stringField", "abcdef");
        user1.put("intField", 256);
        user1.put("listField", Arrays.asList(numbers));


        // Serialize user1 and user2 to disk
        File file = new File("users.avro");
        DatumWriter<GenericRecord> datumWriter = new GenericDatumWriter<GenericRecord>(schema);
        DataFileWriter<GenericRecord> dataFileWriter = new DataFileWriter<GenericRecord>(datumWriter);
        dataFileWriter.create(schema, file);
        dataFileWriter.append(user1);
        dataFileWriter.close();
        String sizeFile = String.valueOf(file.length());
        try (PrintWriter printWriter = new PrintWriter("result.txt")){
            printWriter.write(sizeFile);
        }

        // Deserialize users from disk
        DatumReader<GenericRecord> datumReader = new GenericDatumReader<GenericRecord>(schema);
        DataFileReader<GenericRecord> dataFileReader = new DataFileReader<GenericRecord>(file, datumReader);
        GenericRecord user = null;
        while (dataFileReader.hasNext()) {
            // Reuse user object by passing it to next(). This saves us from
            // allocating and garbage collecting many objects for files with
            // many items.
            user = dataFileReader.next(user);
            System.out.println(user);
        }*/
    }
}
