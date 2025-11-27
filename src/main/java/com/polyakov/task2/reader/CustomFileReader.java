package com.polyakov.task2.reader;

import com.polyakov.task2.exception.CustomFileException;

import java.util.List;

public interface CustomFileReader {
  String readFile(String filePath) throws CustomFileException;
}
