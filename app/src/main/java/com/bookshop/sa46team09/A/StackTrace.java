package com.bookshop.sa46team09.A;



import java.io.PrintWriter;
import java.io.StringWriter;

public class StackTrace {

    public static String trace(Exception ex) {
        StringWriter outStream = new StringWriter();
        ex.printStackTrace(new PrintWriter(outStream));
        return outStream.toString();
    }
}
