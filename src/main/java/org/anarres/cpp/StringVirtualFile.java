package org.anarres.cpp;

import java.io.IOException;
/**
 * A simple virtual file that repesents it's content by a string
 *
 * @author Roland Praml, FOCONIS AG
 *
 */
public class StringVirtualFile implements VirtualFile {

  private final String name;

  private final String content;

  public StringVirtualFile(String name, String content) {
    this.name = name;
    this.content = content;
  }

  @Override
  public String getName() {
    return name;
  }
  
  @Override
  public Source getSource() throws IOException {
    return new StringLexerSource(content, true);
  }
}
