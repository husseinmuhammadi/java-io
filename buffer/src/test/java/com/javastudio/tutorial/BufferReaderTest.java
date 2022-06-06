package com.javastudio.tutorial;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

@ExtendWith(MockitoExtension.class)
class BufferReaderTest {

    @Test
    void readTextFileUsingStreamAsUnderLayingSource() throws IOException {
        String buffer;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                this.getClass().getClassLoader().getResourceAsStream("rfc6238.txt")))) {
            while ((buffer = reader.readLine()) != null) {

            }
        }
    }

    @Test
    void readTextFileWrappingFileReaderInBufferReader() throws IOException {
        String buffer;

        // By default, this will use a buffer of 8 KB.
        try (BufferedReader reader =
                     new BufferedReader(new FileReader("src/main/resources/rfc6238.txt"), 16384)) {
            while ((buffer = reader.readLine()) != null) {

            }
        }
    }
}
