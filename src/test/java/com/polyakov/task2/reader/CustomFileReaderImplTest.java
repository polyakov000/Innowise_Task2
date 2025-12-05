package com.polyakov.task2.reader;

import com.polyakov.task2.component.TextComponent;
import com.polyakov.task2.component.TextComposite;
import com.polyakov.task2.exception.CustomFileException;
import com.polyakov.task2.parser.*;
import com.polyakov.task2.reader.impl.CustomFileReaderImpl;
import com.polyakov.task2.service.TextService;
import com.polyakov.task2.service.impl.TextServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CustomFileReaderImplTest {
  private static final CustomFileReader customFileReader = new CustomFileReaderImpl();
  private static Path tempFile;

  @BeforeEach
  void setUp() throws IOException {
    tempFile = Files.createTempFile("testFile", ".txt");
    Files.writeString(tempFile, "Hello, world!");
  }

  @AfterEach
  void tearDown() throws IOException {
    Files.deleteIfExists(tempFile);
  }

  @Test
  void readFile() throws CustomFileException {
    String actualContent = customFileReader.readFile(tempFile.toString());
    String expectedContent = "Hello, world!";
    assertEquals(expectedContent, actualContent);
  }
}