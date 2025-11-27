package com.polyakov.task2.component;

import java.util.ArrayList;
import java.util.List;

public class TextComposite implements TextComponent{

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
}
