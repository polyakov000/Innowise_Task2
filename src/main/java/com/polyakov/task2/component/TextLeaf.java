package com.polyakov.task2.component;

import java.util.Collections;
import java.util.List;

public class TextLeaf implements TextComponent{
  private String string;
  private TextComponentType type;

  public TextLeaf(String string, TextComponentType type) {
    this.string = string;
    this.type = type;
  }

  public String getTextContent() {
    return string;
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
}
