package cinema;

public class Cinema {

    public static void main(String[] args) {
        ConsoleInput input = new ConsoleInput();
        int rows = input.getNumber("Enter the number of rows:", 1, 9, true);
        int seats = input.getNumber("Enter the number of seats in each row:", 1, 9, true);
        System.out.println();
        CinemaSeating seating = new CinemaSeating(rows, seats);
        Menu menu = new Menu(seating);
        menu.mainMenu();
    }
}