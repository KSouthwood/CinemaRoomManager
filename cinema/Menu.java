package cinema;

public class Menu {
    private final CinemaSeating seating;
    private final ConsoleInput input = new ConsoleInput();

    Menu(CinemaSeating cinema) {
        seating = cinema;
    }

    public void mainMenu() {
        int choice = -1;
        while (choice != 0) {
            System.out.println("1. Show the seats");
            System.out.println("2. Buy a ticket");
            System.out.println("0. Exit");
            choice = input.getNumber("", 0, 2);
            switch (choice) {
                case 1:
                    System.out.println(seating.toString());
                    break;
                case 2:
                    buySeat();
                    break;
                default:
                    break;
            }
        }
    }

    private void buySeat() {
        int ticketPrice = -1;
        while (ticketPrice == -1) {
            int row = input.getNumber("\nEnter a row number:", 1, seating.getRows()) - 1;
            int seat = input.getNumber("Enter a seat number in that row:", 1, seating.getSeats()) - 1;
            ticketPrice = seating.buySeat(row, seat);
            if (ticketPrice == -1) {
                System.out.println("That seat is unavailable. Try again.\n");
            }
        }
        System.out.println("Ticket price: $" + ticketPrice + "\n");
    }
}
