package org.anarres.cpp;

import java.io.BufferedReader;
import java.io.StringReader;
import java.util.Collections;
import javax.annotation.Nonnull;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CppReaderTest {

    public static String testCppReader(@Nonnull String in, Feature... f)
            throws Exception {
        System.out.println("Testing " + in);
        StringReader r = new StringReader(in);
        CppReader p = new CppReader(r);
        p.getPreprocessor().setFileSystem(name-> {
          return new FileVirtualFile("src/test/resources/"+name);
        });
        p.getPreprocessor().addFeatures(f);
        BufferedReader b = new BufferedReader(p);

        StringBuilder out = new StringBuilder();
        String line;
        while ((line = b.readLine()) != null) {
            System.out.println(" >> " + line);
            out.append(line).append("\n");
        }

        return out.toString();
    }

    @Test
    public void testVarargs()
            throws Exception {
        // The newlines are irrelevant, We want exactly one "foo"
        testCppReader("#include <varargs.c>\n");
    }


}
