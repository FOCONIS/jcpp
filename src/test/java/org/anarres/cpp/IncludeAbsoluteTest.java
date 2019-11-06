package org.anarres.cpp;

import com.google.common.io.CharStreams;
import java.io.BufferedReader;
import java.io.File;
import java.io.Reader;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static org.junit.Assert.*;

/**
 *
 * @author shevek
 */
public class IncludeAbsoluteTest {

    private static final Logger LOG = LoggerFactory.getLogger(IncludeAbsoluteTest.class);

    @Test
    public void testAbsoluteInclude() throws Exception {


        String input = "#include <testpath>\n";
        LOG.info("Input: " + input);
        Preprocessor pp = new Preprocessor();
        pp.addInput(new StringLexerSource(input, true));
        pp.setFileSystem(name -> {
          if (name.equals("testpath")) {
            return new StringVirtualFile(name, "absolute-result");
          } else {
            return null;
          }
        });
        Reader r = new CppReader(pp);
        String output = CharStreams.toString(r);
        r.close();
        LOG.info("Output: " + output);
        assertTrue(output.contains("absolute-result"));
    }
}
