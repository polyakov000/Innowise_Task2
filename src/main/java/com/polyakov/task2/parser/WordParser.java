package com.polyakov.task2.parser;

import com.polyakov.task2.component.LetterLeaf;
import com.polyakov.task2.component.TextComponent;
import com.polyakov.task2.component.TextComponentType;
import com.polyakov.task2.component.TextComposite;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class WordParser extends AbstractParser {
  private static final Logger log = LogManager.getLogger();

  public WordParser() {
    super(null);
  }

  @Override
  public TextComponent parse(String string) {
    TextComposite word = new TextComposite(TextComponentType.WORD);
    for (char ch : string.toCharArray()) {
      word.add(new LetterLeaf(ch));
    }
    log.info("Word has been parsed");
    return word;
  }
}
