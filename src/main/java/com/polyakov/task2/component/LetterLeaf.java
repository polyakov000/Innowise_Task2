package com.polyakov.task2.component;

import java.util.List;

public class LetterLeaf implements TextComponent{
  private char symbol;
  private final TextComponentType type = TextComponentType.LETTER;

  public LetterLeaf(char symbol) {
    this.symbol = symbol;
  }

  public char getTextContent() {
    return symbol;
  }

  @Override
  public void add(TextComponent component) {
    throw new UnsupportedOperationException("Cannot add component to a TextLeaf");
  }

  @Override
  public void remove(TextComponent component) {
    throw new UnsupportedOperationException("Cannot remove component from a TextLeaf");
  }

  @Override
  public List<TextComponent> getChildren() {
    throw new UnsupportedOperationException("TextLeaf doesn't have any TextComponents");
  }

  @Override
  public TextComponentType getType() {
    return type;
  }

  @Override
  public String toString() {
    return String.valueOf(symbol);
  }
}
