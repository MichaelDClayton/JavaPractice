package files;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileWriter {
    public  static String filename = "sample.txt";
    public static String text = "Hello World";

    public static void main(String[] args) throws IOException {
        writeWithPrintWriter();
        writeWithBufferedWriter();
    }

    public static void writeWithBufferedWriter() throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new java.io.FileWriter("buffered_" + filename));
        bufferedWriter.write(text);
        bufferedWriter.close();
    }

    public static void writeWithPrintWriter() throws IOException {
        PrintWriter printWriter = new PrintWriter(new java.io.FileWriter("printwriter_" + filename));
        printWriter.printf("Product name is %s and its price is %d $", "iPhone", 1000);
        printWriter.close();
    }

}
