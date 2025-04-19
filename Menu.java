import java.util.Scanner;

public class Menu {
    public static void main(String[] args) throws Exception {

        Scanner cin = new Scanner(System.in);
        Customer user = new Customer();
        Movie movie = new Movie();
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
                    user.Register();
                    break;
                case 2:
                    user.loginCustAcc();
                    break;
                case 3:

                    break;
                case 4:
                    System.out.println("Thank you for using Cinema Ticket System. Goodbye!");
                    break;
                case 5:
                    System.out.println("Select Your Movie");
                    movie.setMovie();
                    movie.getMovie();
                    movie.clearMovie();
                    break;
                default:
                    System.out.println("Invalid choice! Please select a number between 1 and 4.");
            }
        } while (selection != 4);

        cin.close();
    }

    public static void displayMainMenu() {
        System.out.println("\n======CINIME TICKET======");
        System.out.println("1. Register");
        System.out.println("2. Login Customer");
        System.out.println("3. Login Staff");
        System.out.println("4. Exit");
        System.out.println("5. kaizhenPart");
        System.out.print("Selection: ");
    }
}
