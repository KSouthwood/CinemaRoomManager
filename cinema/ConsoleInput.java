package cinema;

import java.util.Scanner;

public class ConsoleInput {
    private static final Scanner input = new Scanner(System.in);

    private static int getInput(int maxVal) {
        String input = ConsoleInput.input.nextLine();
        int number = Integer.parseInt(input);
        if (number < 1 || number > 9) {
            number = -1;
        }
        return number;
    }

    public int getNumber(String msg, int maxVal) {
        int number = -1;
        while (number == -1) {
            System.out.println(msg);
            number = getInput(maxVal);
            if (number == -1) {
                System.out.println("Invalid entry. Number must be between 1 and 9.");
            }
        }
        return number;
    }
}
