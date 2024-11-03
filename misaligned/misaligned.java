public class Misaligned {
    static String actualManual = "";

    public static void printOnConsole(String manualItem) {
        System.out.print(manualItem);
    }

    public static int printColorMap(Printer printer) {
        String[] majorColor = {"White", "Red", "Black", "Yellow", "Violet"};
        String[] minorColor = {"Blue", "Orange", "Green", "Brown", "Slate"};
        int count = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                printer.print(i * 5 + j + " | " + majorColor[i] + " | " + minorColor[j] + "\n");
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int result = printColorMap(Misaligned::mockPrintOnConsole);
        assert result == 25;

        String expectedConsoleBuffer =
                "1 | White | Orange\n" +
                "2 | White | Green\n" +
                "3 | White | Brown\n" +
                "4 | White | Slate\n" +
                "5 | Red | Blue\n" +
                "6 | Red | Orange\n" +
                "7 | Red | Green\n" +
                "8 | Red | Brown\n" +
                "9 | Red | Slate\n" +
                "10 | Black | Blue\n" +
                "11 | Black | Orange\n" +
                "12 | Black | Green\n" +
                "13 | Black | Brown\n" +
                "14 | Black | Slate\n" +
                "15 | Yellow | Blue\n" +
                "16 | Yellow | Orange\n" +
                "17 | Yellow | Green\n" +
                "18 | Yellow | Brown\n" +
                "19 | Yellow | Slate\n" +
                "20 | Violet | Blue\n" +
                "21 | Violet | Orange\n" +
                "22 | Violet | Green\n" +
                "23 | Violet | Brown\n" +
                "24 | Violet | Slate\n";

        assert actualManual.equals(expectedConsoleBuffer);

        System.out.println("All is well (maybe!)");
    }

    public static void mockPrintOnConsole(String manualItem) {
        actualManual += manualItem;
    }

    interface Printer {
        void print(String manualItem);
    }
}
