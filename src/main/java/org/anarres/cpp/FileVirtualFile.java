package org.anarres.cpp;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
/**
 * A simple virtual file that is represented by a File
 *
 * @author Roland Praml, FOCONIS AG
 *
 */
public class FileVirtualFile implements VirtualFile {

  private final String name;

  private final File file;
  
  private Charset charset = Charset.defaultCharset();

  public FileVirtualFile(String name, File file) {
    this.name = name;
    this.file = file;
  }
  
  public FileVirtualFile(String name) {
    this(new File(name));
  }
  
  public FileVirtualFile(File file) {
    this.name = file.getAbsolutePath();
    this.file = file;
  }

  @Override
  public String getName() {
    return name;
  }
  
  /**
   * @return the charset
   */
  public Charset getCharset() {
    return charset;
  }
  
  /**
   * @param charset the charset to set
   */
  public void setCharset(Charset charset) {
    this.charset = charset;
  }
  
  @Override
  public Source getSource() throws IOException {
    return new FileLexerSource(file, charset);
  }
}
