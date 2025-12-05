package com.polyakov.task2.service;

import com.polyakov.task2.component.TextComponent;

public interface TextService {
  String findSentenceWithMaxCountOfSimilarWords(TextComponent textComponent);
  String sortSentencesByLexemes(TextComponent textComponent);
  String switchLastFirstLexemeInSentence(TextComponent textComponent);
}
