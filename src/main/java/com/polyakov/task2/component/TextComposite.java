package com.polyakov.task2.component;

import java.util.ArrayList;
import java.util.List;

public class TextComposite implements TextComponent{
  private static final String WHITESPACE = " ";
  private static final String TABULATION = "\t";
  private static final String NEW_LINE = "\n";
  private List<TextComponent> components = new ArrayList<>();
  private TextComponentType type;

  public TextComposite(TextComponentType type) {
    this.type = type;
  }

  @Override
  public void add(TextComponent component) {
    components.add(component);
  }

  @Override
  public void remove(TextComponent component) {
    components.remove(component);
  }

  @Override
  public List<TextComponent> getChildren() {
    return components;
  }

  @Override
  public TextComponentType getType() {
    return type;
  }
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    switch (getType()) {
      case TEXT:
        for (TextComponent component : getChildren()) {
          sb.append(TABULATION)
                  .append(component.toString())
                  .append(NEW_LINE);
        }
        break;

      case PARAGRAPH:
        for (TextComponent component : getChildren()) {
            sb.append(component.toString());
        }
        break;

      case SENTENCE:
        for (TextComponent component : getChildren()) {
          sb.
                  append(component.toString())
                  .append(WHITESPACE);
        }
        break;

      case LEXEME:
        for (TextComponent component : getChildren()) {
          sb.append(component.toString());
        }
        break;

      case WORD:
        for (TextComponent component : components) {
          sb.append(component.toString());
        }
        break;
    }
    return sb.toString();
  }
}
