import java.util.Scanner;

public class Menu {
    public static void main(String[] args) throws Exception {

        Scanner cin = new Scanner(System.in);
        User user = new User();
        Movie movie = new Movie();
        int selection;

        do {s
            displayMainMenu();
            while (!cin.hasNextInt()) {
                System.out.println("Invalid choice! Please select a number between 1 and 2.");
                cin.next();
                displayMainMenu();
            }
            selection = cin.nextInt();
            cin.nextLine();

            switch (selection) {
                case 1:
                user.displayUserMenu();
                    break;
                case 2:
                    System.out.println("Thank you for using Cinema Ticket System. Goodbye!");
                    break;
                case 3:
                    System.out.println("Select Your Movie");
                    movie.setMovie();
                    movie.getMovie();
                    movie.clearMovie();
                    break;
                default:
                    System.out.println("Invalid choice! Please select a number between 1 and 2.");
            }
        } while (selection != 2);

        cin.close();
    }

    public static void displayMainMenu() {
        System.out.println("\n======CINIME TICKET======");
        System.out.println("1. Login");
        System.out.println("2. Exit");
        System.out.println("3. kaizhenPart");
        System.out.print("Selection: ");
    }
}
