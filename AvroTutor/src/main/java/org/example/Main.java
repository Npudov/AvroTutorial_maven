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

        // Serialize user1 to disk
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
    }
}
