package com.polyakov.task2.reader;

import com.polyakov.task2.exception.CustomFileException;
import com.polyakov.task2.reader.impl.CustomFileReaderImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CustomFileReaderImplTest {
  private static final String FILE_PATH = "data/input.txt";
  private static final CustomFileReader customFileReader = new CustomFileReaderImpl();

  @BeforeEach
  void setUp() {
  }

  @AfterEach
  void tearDown() {
  }

  @Test
  void readFile() throws CustomFileException {
    String actual = customFileReader.readFile(FILE_PATH);
    String expected = new String("    It has survived not only five centuries, but also the leap into electronic\n" +
            "typesetting, remaining essentially unchanged. It was popularised in the with the\n" +
            "release of Letraset sheets containing Lorem Ipsum passages, and more recently with\n" +
            "desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.\n" +
            "\n" +
            "    It is a long established fact that a reader will be distracted by the readable\n" +
            "content of a page when looking at its layout. The point of using Ipsum is that it has a\n" +
            "more-or-less normal distribution of letters, as opposed to using 'Content here, content\n" +
            "here', making it look like readable English.\n" +
            "\n" +
            "    It is a established fact that a reader will be of a page when looking at its\n" +
            "layout.\n" +
            "\n" +
            "    Bye.");
    assertEquals(actual,expected);
  }
}