package cinema;

import java.util.Arrays;

public class CinemaSeating {
    private int rows;
    private int seats;
    private int frontTickets;
    private int backTickets;
    private int soldTickets;
    private int incomeCurrent;
    private int incomeTotal;
    private String[][] isAvailable;
    private final int SEAT_THRESHOLD = 60;
    final private int PRICE_FRONT = 10;
    final private int PRICE_BACK  = 8;

    CinemaSeating(int a_rows, int a_seats) {
        rows = a_rows;
        seats = a_seats;
        isAvailable = new String[rows][seats];
        for (String[] row : isAvailable) {
            Arrays.fill(row, "S");
        }

        // set up ticket pricing
        frontTickets = PRICE_FRONT;
        if (rows * seats > SEAT_THRESHOLD) {
            backTickets = PRICE_BACK;
        } else {
            backTickets = PRICE_FRONT;
        }

        int frontRows = rows / 2;
        incomeTotal = (frontRows * seats * frontTickets) + ((rows - frontRows) * seats * backTickets);
    }

    @Override
    public String toString() {
        StringBuilder seating = new StringBuilder();
        seating.append("\nCinema:\n");
        seating.append("  1 2 3 4 5 6 7 8 9", 0, (seats * 2) + 1).append("\n");
        for (int row = 0; row < rows; row++) {
            seating.append(row + 1);
            for (String seat : isAvailable[row]) {
                seating.append(" ").append(seat);
            }
            seating.append("\n");
        }

        return seating.toString();
    }

    /**
     * Buy a seat in the theater.
     *
     * Attempt to purchase a seat in the cinema. Return the ticket price if successful or -1 if the seat is already
     * taken. Update amount of tickets sold and income from sold tickets as well.
     *
     * @param p_row     row number of seat to buy
     * @param p_seat    seat number to buy
     * @return          ticket price if successful, -1 otherwise
     */
    public int buySeat(int p_row, int p_seat) {
        int ticketPrice = -1;
        if (isAvailable[p_row][p_seat].equals("S")) {
            isAvailable[p_row][p_seat] = "B";
            if (p_row < rows / 2) {
                ticketPrice = frontTickets;
            } else {
                ticketPrice = backTickets;
            }
            soldTickets++;
            incomeCurrent += ticketPrice;
        }
        return ticketPrice;
    }

    public int getRows() {
        return rows;
    }

    public int getSeats() {
        return seats;
    }

    public void printStatistics() {
        System.out.println("Number of purchased tickets: " + soldTickets);
        System.out.printf("Percentage: %.2f%%%n", ((double) soldTickets / (rows * seats)) * 100);
        System.out.println("Current income: $" + incomeCurrent);
        System.out.println("Total income: $" + incomeTotal);
        System.out.println();
    }
}
