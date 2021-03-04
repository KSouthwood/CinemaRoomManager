package cinema;

public class Cinema {

    public static void main(String[] args) {
        ConsoleInput input = new ConsoleInput();
        int rows = input.getNumber("Enter the number of rows:", 9);
        int seats = input.getNumber("Enter the number of seats in each row:", 9);
//        calculateProfit(rows, seats);
        CinemaSeating seating = new CinemaSeating(rows, seats);
        System.out.println(seating.toString());
        int ticketPrice = -1;
        while (ticketPrice == -1) {
            int row = input.getNumber("Enter a row number:", rows) - 1;
            int seat = input.getNumber("Enter a seat number in that row:", seats) - 1;
            ticketPrice = seating.buySeat(row, seat);
            if (ticketPrice == -1) {
                System.out.println("That seat is unavailable. Try again.\n");
            }
        }
        System.out.println("\nTicket price: $" + ticketPrice);
        System.out.println(seating.toString());
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