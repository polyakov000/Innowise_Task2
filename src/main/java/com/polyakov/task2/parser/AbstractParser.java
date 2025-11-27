package com.polyakov.task2.parser;

import com.polyakov.task2.component.TextComponent;

import java.util.List;

public abstract class AbstractParser {
  private AbstractParser nextParser;

  public AbstractParser(AbstractParser nextParser) {
    this.nextParser = nextParser;
  }

  public void setNextParser(AbstractParser nextParser) {
    this.nextParser = nextParser;
  }

  public AbstractParser getNextParser() {
    return nextParser;
  }

  public abstract TextComponent parse(String string);
}
