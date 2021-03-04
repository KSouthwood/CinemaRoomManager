package cinema;

import java.util.Scanner;

public class ConsoleInput {
    private static final Scanner input = new Scanner(System.in);

    private static int getInput(int minVal, int maxVal) {
        String input = ConsoleInput.input.nextLine();
        int number = Integer.parseInt(input);
        if (number < minVal || number > maxVal) {
            number = -1;
        }
        return number;
    }

    public int getNumber(String msg, int minVal, int maxVal) {
        int number = -1;
        while (number == -1) {
            if (!msg.isEmpty()) {
                System.out.println(msg);
            }
            number = getInput(minVal, maxVal);
            if (number == -1) {
                System.out.println("Invalid entry. Number must be between " + minVal + " and " +
                    maxVal + ".");
            }
        }
        return number;
    }
}
