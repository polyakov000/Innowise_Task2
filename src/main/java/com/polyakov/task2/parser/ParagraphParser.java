package com.polyakov.task2.parser;

import com.polyakov.task2.component.TextComponent;
import com.polyakov.task2.component.TextComponentType;
import com.polyakov.task2.component.TextComposite;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ParagraphParser extends AbstractParser{
  private static final Logger log = LogManager.getLogger();
  private static final String SENTENCE_DELIMITER = "(?<=[.!?])\\s+";
  public ParagraphParser(AbstractParser nextParser) {
    super(nextParser);
  }

  @Override
  public TextComponent parse(String string) {
    TextComponent paragraph = new TextComposite(TextComponentType.PARAGRAPH);
    String[] sentences = string.split(SENTENCE_DELIMITER);
    for(String sentence: sentences){
      TextComponent sentenceComponent = getNextParser().parse(sentence);
      paragraph.add(sentenceComponent);
    }
    log.info("Paragraph has been parsed");
    return paragraph;
  }
}
