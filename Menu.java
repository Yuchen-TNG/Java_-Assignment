import java.util.Scanner;

import Movie.Movie;
import Movie.Schedule;

public class Menu {
    public static void main(String[] args) throws Exception {

        Scanner cin = new Scanner(System.in);
        Customer customer = new Customer();
        Staff staff = new Staff();
        Movie mv =new Movie();
        int selection;

        do {
            displayMainMenu();
            while (!cin.hasNextInt()) {
                System.out.println("Invalid choice! Please select a number between 1 and 4.");
                cin.next();
                displayMainMenu();
            }
            selection = cin.nextInt();
            cin.nextLine();

            switch (selection) {
                case 1:
                mv.choiceMovie();
                    break;
                case 2:
                    customer.loginCustAcc();
                    break;
                case 3:
                    staff.staffLogin();
                    break;
                case 4:
                    System.out.println("Thank you for using Cinema Ticket System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice! Please select a number between 1 and 4.");
            }
        } while (selection != 4);

        cin.close();
    }

    public static void displayMainMenu() {
        System.out.println("\n======CINIME TICKET======");
        System.out.println("1. ");
        System.out.println("2. Login Customer");
        System.out.println("3. Login Staff");
        System.out.println("4. Exit");
        System.out.print("Selection: ");
    }
}
