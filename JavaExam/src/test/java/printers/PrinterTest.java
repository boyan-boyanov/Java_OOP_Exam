package printers;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class PrinterTest {
    @Test
    public void testPrint() {
        String message = "Hello, world!";
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        PrintFile mockPrintFile = mock(PrintFile.class);



        Printer.Print(message, mockPrintFile);

        assertTrue(message.equals(outContent.toString().trim()));

    }
}