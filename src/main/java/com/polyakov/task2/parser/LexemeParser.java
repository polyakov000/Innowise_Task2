package com.polyakov.task2.parser;

import com.polyakov.task2.component.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LexemeParser extends AbstractParser {
  private static final String LEXEME_TO_PARTS_DELIMITER = "\\p{Punct}+$";
  private static final Logger log = LogManager.getLogger();

  public LexemeParser(AbstractParser nextParser) {
    super(nextParser);
  }

  @Override
  public TextComponent parse(String string) {
    TextComposite lexeme = new TextComposite(TextComponentType.LEXEME);

    String wordPart = string.replaceAll(LEXEME_TO_PARTS_DELIMITER, "");
    String punctuationPart = string.substring(wordPart.length());

    if (!wordPart.isEmpty()) {
      TextComponent wordComponent = getNextParser().parse(wordPart);
      lexeme.add(wordComponent);
    }

    if (!punctuationPart.isEmpty()) {
      for (char ch : punctuationPart.toCharArray()) {
        lexeme.add(new PunctuationLeaf(ch));
      }
    }

    log.info("Lexeme has been parsed");
    return lexeme;
  }
}
