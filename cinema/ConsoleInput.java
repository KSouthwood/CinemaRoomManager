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

    /**
     * Get an integer number from console input
     *
     * Get an integer number in a certain range (specified using minVal and maxVal) with a specified prompt (msg).
     * Optionally make sure the input number is within the range (validate) or just pass back the invalid number.
     *
     * @param msg       String to be printed as a prompt
     * @param minVal    Minimum value to accept
     * @param maxVal    Maximum value to accept
     * @param validate  Set to true to validate the input is in range
     * @return  a valid integer in the range minVal - maxVal unless validate is false
     */
    public int getNumber(String msg, int minVal, int maxVal, boolean validate) {
        int number = -2;
        while (number == -2) {
            if (!msg.isEmpty()) {
                System.out.println(msg);
            }
            number = getInput(minVal, maxVal);
            if (validate && number == -1) {
                System.out.println("Invalid entry. Number must be between " + minVal + " and " +
                    maxVal + ".");
                number = -2;
            }
        }
        return number;
    }
}
