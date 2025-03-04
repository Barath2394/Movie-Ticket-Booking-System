import java.util.Scanner;

public class MovieTicketBookingSystem {
    public static void main(String[] args) {
        MovieShowtimesBST showtimesBST = new MovieShowtimesBST();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Movie Ticket Booking Menu ---");
            System.out.println("1. Add Showtime");
            System.out.println("2. Search Showtime");
            System.out.println("3. Delete Showtime");
            System.out.println("4. Display All Showtimes");
            System.out.println("5. Exit");

            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter movie name: ");
                    String movieName = scanner.nextLine();
                    System.out.print("Enter showtime (HH:MM format): ");
                    String time = scanner.nextLine();
                    showtimesBST.addShowtime(new Showtime(movieName, time));
                    break;
                case 2:
                    System.out.print("Enter showtime to search (HH:MM format): ");
                    String searchTime = scanner.nextLine();
                    showtimesBST.searchShowtime(searchTime);
                    break;
                case 3:
                    System.out.print("Enter showtime to delete (HH:MM format): ");
                    String deleteTime = scanner.nextLine();
                    showtimesBST.deleteShowtime(deleteTime);
                    break;
                case 4:
                    showtimesBST.displayShowtimes();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option! Please try again.");
            }
        }
    }
}

