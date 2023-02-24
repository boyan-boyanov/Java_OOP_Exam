package printers;

public class Printer {
    public static void Print(String message, PrintFile printFile){

        System.out.println(message);
        printFile.write(message);

    }
}
