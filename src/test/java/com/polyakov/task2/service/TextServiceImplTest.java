package com.polyakov.task2.service;

import com.polyakov.task2.component.TextComponent;
import com.polyakov.task2.parser.*;
import com.polyakov.task2.service.impl.TextServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.StringJoiner;

import static org.junit.jupiter.api.Assertions.*;

class TextServiceImplTest {
  private static final TextService textService = new TextServiceImpl();
  private static TextComponent component;
  private static String text;

  @BeforeEach
  void setUp() {
    StringJoiner  stringJoiner= new StringJoiner("\n");
    text = stringJoiner.add(" Hello! Hello world!")
            .add("  Hello hello hello hello!")
                    .toString();

    System.out.println(text);
    AbstractParser parser = new TextParser(
            new ParagraphParser(
                    new SentenceParser(
                            new LexemeParser(
                                    new WordParser()
                            )
                    )
            )
    );
    component = parser.parse(text);
    System.out.println(component.toString());
  }

  @AfterEach
  void tearDown() {
  }

  @Test
  void findSentenceWithMaxCountOfSimilarWords() {
    String expected = "Hello hello hello hello! ";
    String actual = textService.findSentenceWithMaxCountOfSimilarWords(component);
    assertEquals(expected,actual);
  }

  @Test
  void sortSentencesByLexemes() {
    StringJoiner stringJoiner = new StringJoiner("\n");
    String expected = stringJoiner.add("Hello! ")
                    .add("Hello world! ")
                            .add("Hello hello hello hello! ")
                                    .toString();
    String actual = textService.sortSentencesByLexemes(component);
    assertEquals(expected, actual);
  }

  @Test
  void switchLastFirstLexemeInSentence() {
    StringJoiner stringJoiner = new StringJoiner("\n");
    String expected = stringJoiner.add("Hello! world! Hello ")
            .add(" hello! hello hello Hello").toString();
    String actual = textService.switchLastFirstLexemeInSentence(component);
    assertEquals(expected, actual.strip());
  }
}