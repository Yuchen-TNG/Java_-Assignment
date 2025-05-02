import java.util.Scanner;

import Movie.Movie;
import Movie.Schedule;
import Movie.Seat;

public class Menu {
    public static void main(String[] args) throws Exception {

        Scanner cin = new Scanner(System.in);
        Customer customer = new Customer();
        Staff staff = new Staff();
        Movie mv = new Movie();
        int selection;
        Schedule schedule = new Schedule();
        Seat seat = new Seat();

        do {
            displayMainMenu();
            while (!cin.hasNextInt()) {
                System.out.println("Invalid choice! Please select a number 0 to 3.");
                cin.next();
                System.out.print("Selection(0-3): ");
            }
            selection = cin.nextInt();
            cin.nextLine();

            switch (selection) {
                case 0:
                    System.out.println("Thank you for using Cinema Ticket System. Goodbye!");
                    break;
                case 1:
                    customer.Register();
                    break;
                case 2:
                    customer.loginCustAcc();
                    break;
                case 3:
                    staff.staffLogin();
                    break;
                case 4:
                    schedule.setSchedule();
                    break;
                default:
                    System.out.println("Invalid choice! Please select a number 0 to 3.");
            }
        } while (selection != 0);

        cin.close();
    }

    public static void displayMainMenu() {
        System.out.println("\n+==============================+");
        System.out.println("|     CINIME TICKET SYSTEM     |");
        System.out.println("|==============================|");
        System.out.println("| 1. Register                  |");
        System.out.println("| 2. Login Customer            |");
        System.out.println("| 3. Login Staff               |");
        System.out.println("| 0. Exit                      |");
        System.out.println("+==============================+");
        System.out.print("Selection(0-3): ");
    }
}
