package printers;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PrinterTest {
    private String message;

    @Before
    public void setUp() {
        message = "Test Message";
    }


    @Test
    public void print() {

        String expected = "Test Message";
        assertEquals(message, expected);
    }
}