package com.javastudio.tutorial;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

class WriteToFileTest {

    public static final String TEMP_FILE_PREFIX = "tmp";
    public static final String TEMP_FILE_SUFFIX = ".txt";

    @Test
    @Tag("Java6")
    void writeTextToFileUsingTheClassicFileWriterAndBufferedWriter() throws IOException {
        File file = File.createTempFile(TEMP_FILE_PREFIX, TEMP_FILE_SUFFIX);
        System.out.println(file.getAbsolutePath());
        try (FileWriter fileWriter = new FileWriter(file);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            bufferedWriter.write("This is a test");
            bufferedWriter.newLine();
        }
    }

    @Test
    @Tag("Java7")
    void writeTextToFileUsingNIOClassFiles() throws IOException {
        Path path = File.createTempFile(TEMP_FILE_PREFIX, TEMP_FILE_SUFFIX).toPath();
        System.out.println(path.toAbsolutePath());
        String content = "This is a test";
        Files.write(path, content.getBytes(StandardCharsets.UTF_8), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
    }
}
