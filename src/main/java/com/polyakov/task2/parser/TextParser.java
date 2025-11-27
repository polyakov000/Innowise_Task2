package com.polyakov.task2.parser;

import com.polyakov.task2.component.TextComponent;
import com.polyakov.task2.component.TextComponentType;
import com.polyakov.task2.component.TextComposite;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TextParser extends AbstractParser{
  private static final Logger log = LogManager.getLogger();
  private static final String PARAGRAPH_DELIMITER = "\\n{2,}";

  public TextParser(AbstractParser nextParser) {
    super(nextParser);
  }

  @Override
  public TextComponent parse(String string) {
    TextComponent text = new TextComposite(TextComponentType.TEXT);
    String[] paragraphs = string.split(PARAGRAPH_DELIMITER);
    for(String paragraph : paragraphs){
      TextComponent paragraphComponent = getNextParser().parse(paragraph);
      text.add(paragraphComponent);
    }
    log.info("Text has been parsed");
    return text;
  }
}
