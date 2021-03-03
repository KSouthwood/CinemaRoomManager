package cinema;

public class Cinema {

    public static void main(String[] args) {
        ConsoleInput input = new ConsoleInput();
        int rows = input.getNumber("Enter the number of rows:");
        int seats = input.getNumber("Enter the number of seats in each row:");
        calculateProfit(rows, seats);
    }

    private static void calculateProfit(int p_rows, int p_seats) {
        int priceFrontHalf = 10;
        int priceBackHalf = 8;

        if (p_rows * p_seats <= 60) {
            priceBackHalf = 10;
        }

        int rowsFrontHalf = p_rows / 2;
        int profit = (rowsFrontHalf * p_seats * priceFrontHalf) +
                ((p_rows - rowsFrontHalf) * p_seats * priceBackHalf);

        System.out.println("Total income:\n$" + profit);
    }
}