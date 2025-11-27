package com.polyakov.task2.component;

import java.util.List;

public interface TextComponent {
  void add(TextComponent component);
  void remove(TextComponent component);
  List<TextComponent> getChildren();
  TextComponentType getType();
}
