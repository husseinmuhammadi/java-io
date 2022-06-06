package com.javastudio.tutorial;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

class ApplicationTest {
    private static Properties properties = new Properties();

    @BeforeAll
    static void beforeAll() throws IOException {
        try (InputStream resource = Application.class.getClassLoader().getResourceAsStream("application.properties")) {
            properties.load(resource);
        }
    }

    @Test
    void givenApplicationProperties_whenGettingProjectVersion_thenItMustEqualToArtifactVersion() {
        Assertions.assertThat(properties.getProperty("project.version")).contains("SNAPSHOT");
    }
}