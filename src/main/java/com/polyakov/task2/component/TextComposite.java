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

    for (TextComponent component : components) {
      switch (component.getType()) {
        case TEXT:
          sb.append(component.toString());
          break;

        case PARAGRAPH:
          sb.append(TABULATION)
                  .append(component.toString())
                  .append(NEW_LINE);
          break;

        case SENTENCE:
          sb.append(component.toString())
                  .append(WHITESPACE);
          break;

        case LEXEME:
          sb.append(component.toString())
                  .append(WHITESPACE);
          break;

        case WORD:
          sb.append(component.toString());
          break;

        case PUNCTUATION:
          sb.append(((PunctuationLeaf)component).getTextContent());
          break;

        case LETTER:
            sb.append(((LetterLeaf) component).getTextContent());
          break;
      }
    }

    return sb.toString().trim();
  }

}
