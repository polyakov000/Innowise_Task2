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
    AbstractParser parser = new TextParser(
            new ParagraphParser(
                    new SentenceParser(
                            new LexemeParser(
                                    new WordParser()))));
    TextComposite text = (TextComposite) parser.parse(actual);
    System.out.println(text.toString());
    TextService textService = new TextServiceImpl();
    System.out.println(textService.findSentenceWithMaxCountOfSimilarWords(text));
    System.out.println(textService.sortSentencesByLexemes(text));
    System.out.println(textService.switchLastFirstLexemeInSentence(text));
  }
}