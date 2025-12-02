package com.polyakov.task2.reader;

import com.polyakov.task2.exception.CustomFileException;
import com.polyakov.task2.parser.AbstractParser;
import com.polyakov.task2.parser.ParagraphParser;
import com.polyakov.task2.parser.SentenceParser;
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
  }
}