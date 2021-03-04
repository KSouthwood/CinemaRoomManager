package cinema;

import java.util.Arrays;

public class CinemaSeating {
    private int rows;
    private int seats;
    private String[][] isAvailable;
    private int frontHalfPrice = 10;
    private int backHalfPrice;
    private int seatThreshold = 60;

    CinemaSeating(int a_rows, int a_seats) {
        rows = a_rows;
        seats = a_seats;
        isAvailable = new String[rows][seats];
        for (String[] row : isAvailable) {
            Arrays.fill(row, "S");
        }
        if (rows * seats > seatThreshold) {
            backHalfPrice = 8;
        } else {
            backHalfPrice = 10;
        }
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
     * taken.
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
                ticketPrice = frontHalfPrice;
            } else {
                ticketPrice = backHalfPrice;
            }
        }
        return ticketPrice;
    }
}
