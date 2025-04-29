import java.util.Scanner;

public class Menu {
    public static void main(String[] args) throws Exception {

        Scanner cin = new Scanner(System.in);
        Customer customer = new Customer();
        Staff staff = new Staff();
        Interface currentUser = null;
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
                    customer.Register();
                    break;
                case 2:
                    customer.loginCustAcc();
                    currentUser=customer;
                    break;
                case 3:
                    staff.staffLogin();
                    currentUser=staff;
                    break;
                case 4:
                if(currentUser != null){
                    currentUser.Logout();
                    currentUser=null;
                }else{
                    System.out.println("No user is currently logged in.");
                }
                    break;
                case 5:
                    System.out.println("Thank you for using Cinema Ticket System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice! Please select a number between 1 and 4.");
            }
        } while (selection != 5);

        cin.close();
    }

    public static void displayMainMenu() {
        System.out.println("\n======CINIME TICKET======");
        System.out.println("1. Register");
        System.out.println("2. Login Customer");
        System.out.println("3. Login Staff");
        System.out.println("4. Logout");
        System.out.println("5. Exit");
        System.out.print("Selection: ");
    }
}
