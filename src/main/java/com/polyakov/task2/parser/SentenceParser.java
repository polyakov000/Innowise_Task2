package com.polyakov.task2.parser;

import com.polyakov.task2.component.TextComponent;
import com.polyakov.task2.component.TextComponentType;
import com.polyakov.task2.component.TextComposite;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SentenceParser extends AbstractParser {
  private static final Logger log = LogManager.getLogger();
  private static final String LEXEME_DELIMITER = "\\s+";

  public SentenceParser(AbstractParser nextParser) {
    super(nextParser);
  }

  @Override
  public TextComponent parse(String string) {
    TextComponent sentence = new TextComposite(TextComponentType.SENTENCE);
    String[] lexemes = string.trim().split(LEXEME_DELIMITER);
    for (String lexeme : lexemes) {
      TextComponent lexemeComponent = getNextParser().parse(lexeme);
      sentence.add(lexemeComponent);
    }
    log.info("Sentence has been parsed");
    return sentence;
  }
}
