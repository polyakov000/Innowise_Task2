package com.polyakov.task2.service.impl;

import com.polyakov.task2.component.TextComponent;
import com.polyakov.task2.component.TextComponentType;
import com.polyakov.task2.component.TextComposite;
import com.polyakov.task2.exception.TextComponentException;
import com.polyakov.task2.service.TextService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;
import java.util.stream.Collectors;

public class TextServiceImpl implements TextService {
  private static final Logger log = LogManager.getLogger();
  @Override
  public String findSentenceWithMaxCountOfSimilarWords(TextComponent textComponent) {
    TextComponent resultSentence = new TextComposite(TextComponentType.SENTENCE);

    try {
      validateTextComposite(textComponent);

      int maxCount = 0;
      for (TextComponent paragraph : textComponent.getChildren()) {
        for (TextComponent sentence : paragraph.getChildren()) {
          int count = countMaxSimilarWords(sentence);
          if (count > maxCount) {
            maxCount = count;
            resultSentence = sentence;
          }
        }
      }
    }catch (TextComponentException e){
      log.error(e.getMessage());
    }
    return resultSentence.toString();
  }

  @Override
  public String sortSentencesByLexemes(TextComponent textComponent) {
    List<TextComponent> sentences = new ArrayList<>();
    try {
      validateTextComposite(textComponent);
      for (TextComponent paragraph : textComponent.getChildren()) {
        sentences.addAll(paragraph.getChildren());
      }
      sentences.sort(Comparator.comparingInt(s ->  s.getChildren().size()));
    }catch (TextComponentException e){
      log.error(e.getMessage());
    }
    return sentences.stream()
            .map(TextComponent::toString)
            .collect(Collectors.joining("\n"));
  }

  @Override
  public String switchLastFirstLexemeInSentence(TextComponent textComponent) {
    TextComponent modifiedText = new TextComposite(TextComponentType.TEXT);
    try {
      validateTextComposite(textComponent);
      modifiedText = textComponent;
      for (TextComponent paragraph : modifiedText.getChildren()) {
        for (TextComponent sentence :  paragraph.getChildren()) {
          switchLexemes(sentence);
        }
      }
    }catch (TextComponentException e){
      log.error(e.getMessage());
    }
    return modifiedText.toString();
  }

  private void validateTextComposite(TextComponent textComponent) throws TextComponentException {
    if (!(textComponent instanceof TextComposite) ||
            textComponent.getType() != TextComponentType.TEXT) {
      throw new TextComponentException("TextComponent must be TEXT type");
    }
  }

  private int countMaxSimilarWords(TextComponent sentence) {
    Map<String, Integer> wordCount = new HashMap<>();

    for (TextComponent lexeme : sentence.getChildren()) {
      String word = extractWord(lexeme);
      if (!word.isEmpty()) {
        wordCount.put(word.toLowerCase(),
                wordCount.getOrDefault(word.toLowerCase(), 0) + 1);
      }
    }

    return wordCount.values().stream().max(Integer::compareTo).orElse(0);
  }

  private String extractWord(TextComponent lexeme) {
    StringBuilder sb = new StringBuilder();
    for (TextComponent child : lexeme.getChildren()) {
      if (child.getType() == TextComponentType.WORD) {
        sb.append(child);
      }
    }
    return sb.toString();
  }

  private void switchLexemes(TextComponent sentence) {
    List<TextComponent> lexemes = sentence.getChildren();
    if (lexemes.size() < 2) {
      return;
    }
    TextComponent first = lexemes.get(0);
    TextComponent last = lexemes.get(lexemes.size() - 1);

    lexemes.set(0, last);
    lexemes.set(lexemes.size() - 1, first);
  }

}
