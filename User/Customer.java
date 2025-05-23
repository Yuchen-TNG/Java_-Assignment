//Author: LEON CHANG RUI HERN
//Module: Customer
//System: Cinema Ticket System
//Group: DFT1S3G11

import Payment.Booking;
import Movie.Movie;


public class Customer extends User implements Interface {

    private static int nextCustomerID = 1001;
    private int custProfile;
    private int customerID;
    private static User[] users = new User[100];
    private static int customerCount = 0;
    private boolean checkLogin;
    private String loggedInEmail;

    Movie mv = new Movie();
    Booking booking = new Booking();

    public Customer() {
    }

    public Customer(String name, int age, String gender, String birthday, String phoneNo, String email,
        String password) {
        super(name, age, gender, birthday, phoneNo, email, password);
        this.customerID = nextCustomerID++;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void Register() {
        String email = "";
        String phoneNo = "";
        int age;
        String birthday = null;

        System.out.println("\n=====Registration=====");
        System.out.print("Name: ");
        String name = cin.nextLine();

        while (true) {
            System.out.print("Age: ");
            if (cin.hasNextInt()) {
                age = cin.nextInt();
                break;
            } else {
                System.out.println("invalid, please enter your age");
                cin.next();
            }
        }

        System.out.print("Gender(M/F): ");
        String gender = cin.next().toUpperCase();
        cin.nextLine();

        while (true) {
            System.out.print("Birthday(DD/MM/YYYY): ");
            birthday = cin.next();
            cin.nextLine();
            if (birthday.matches("\\d{2}/\\d{2}/\\d{4}")) {
                break;
            } else {
                System.out.println("Invalid Format. please follow the format(DD/MM/YYYY)");
            }
        }

        while (true) {
            System.out.print("PhoneNo: ");
            phoneNo = cin.next();
            cin.nextLine();
            if (phoneNo.matches("\\d{3}-\\d{3}-\\d{4}") ||
                    phoneNo.matches("\\d{3}-\\d{4}-\\d{4}")) {
                break;
            } else {
                System.out.println("invalid phone No. please follow the format(000-000-0000 or 000-0000-0000)");
            }
        }
        while (true) {
            System.out.print("Email: ");
            email = cin.next();
            cin.nextLine();
            if (email.contains("@gmail.com")) {
                break;
            } else {
                System.out.println("invalid please include '@gmail.com'");
            }
        }
        System.out.print("Password: ");
        String password = cin.next();
        cin.nextLine();

        Customer newUser = new Customer(name, age, gender, birthday, phoneNo, email, password);
        if (customerCount < users.length) {
            users[customerCount] = newUser;
            customerCount++;
            System.out.println("User Registered Successfully! ");
        } else {
            System.out.println("User storage is full!");
            System.exit(0);
        }
    }

    public void loginCustAcc() {
        Booking booking = new Booking();

        if (customerCount == 0) {
            System.out.println("No customers registered yet.");
            return;
        }else

        while (true) {
            System.out.println("\n=====Customer Login=====");
            System.out.print("Email: ");
            String email = cin.next();

            System.out.print("Password: ");
            String password = cin.next();

            for (int i = 0; i < customerCount; i++) {
                if (users[i] == null)
                    continue;
                if (users[i].getEmail().equals(email) && users[i].getPassword().equals(password)) {
                    System.out.println("Login Successfully!");
                    this.custProfile = i;
                    checkLogin = true;
                    loggedInEmail = email;
                    booking.setEmail(loggedInEmail);
                    getMenu();
                    return;
                }
            }
            System.out.println("Login Failed! Invalid email or password.");
            System.out.println("1. Try again | 2. back menu ");
            int valid;
            boolean verifyinput = false;
            while (!verifyinput) {
                System.out.print("Select: ");
                if (cin.hasNextInt()) {
                    valid = cin.nextInt();
                    if (valid == 1 || valid == 2) {
                        switch (valid) {
                            case 1:
                                verifyinput = true;
                                break;
                            case 2:
                                cin.nextLine();
                                return;
                        }
                    } else {
                        System.out.println("invalid ! please select the number 1 or 2");
                    }
                } else {
                    System.out.println("invalid ! please select the number 1 or 2");
                    cin.next();
                    verifyinput = false;
                }
            }
        }
    }

    public void Logout() {
        System.out.println("Logout.....");
        if (checkLogin) {
            System.out.println("Logout Successfully.");
            checkLogin = false;
        } else {
            System.out.println("No user is currently logged in.");
        }
    }

    public void showAllCustomer() {

        if (customerCount == 0) {
            System.out.println("No customers registered yet.");
            return;
        } else {
            System.out.println(
                    "\n+=========================================================================================================================+");
            System.out.println(
                    "|                                                      CUSTOMER LISTS                                                     |");
            System.out.println(
                    "|=========================================================================================================================|");
            System.out.printf("%-3s %-15s %-25s %-8s %-10s %-13s %-17s %-23s %-2s\n", "|", "Customer ID", "Name", "Age",
                    "Gender", "Birthday", "PhoneNo", "Email", "|");
            System.out.println(
                    "|-------------------------------------------------------------------------------------------------------------------------|");
            for (int i = 0; i < customerCount; i++) {
                Customer customer = (Customer) users[i];
                if (users[i] != null) {
                    System.out.printf("%-3s %-15d %-25s %-8d %-10s %-13s %-17s %-23s %-2s\n", "|",
                            customer.getCustomerID(),
                            customer.getName(),
                            customer.getAge(), customer.getGender(), customer.getBirthday(), customer.getPhoneNo(),
                            customer.getEmail(), "|");
                }
            }
            System.out.println(
                    "+=========================================================================================================================+");
        }
        System.out.println("Press Key[enter] to exit");
        cin.nextLine();
    }

    public void getMenu() {
        int selection;

        do {
            
            displayCustMenu();
            selection = cin.nextInt();

            switch (selection) {
                case 0:
                    Logout();
                    return;
                case 1:
                    viewProfile();
                    break;
                case 2:
                    mv.choiceMovie();
                    break;
                case 3:
                    cin.nextLine(); 
                    System.out.print("Enter Booking ID to cancel (e.g. B001): ");
                    String cancelID = cin.nextLine();
                    booking.cancelBookingByID(cancelID,Booking.confirm);
                    break;
                default:
                    System.out.println("Invalid choice! Please select a number 0 to 3.");
            }
        } while (selection != 0);
        cin.close();
    }

    public void viewProfile() {
        
            System.out.println(users[custProfile].toString());
        
    }

    public String toString() {
        return "\n\n+==============================+"+"\n|         User Profile         |" +"\n|==============================|"+ "\n| CustomerID: " + customerID +"             |"+ super.toString()+"\n+==============================+";
    }

    public void displayCustMenu() {

        System.out.println("\n+=======================+");
        System.out.println("|     CUSTOMER MENU     |");
        System.out.println("|=======================|");
        System.out.println("| 1. View Profile       |");
        System.out.println("| 2. View Movie         |");
        System.out.println("| 3. Cancel Booking     |");
        System.out.println("| 0. Logout             |");
        System.out.println("+=======================+");
        System.out.print("Selection(0-3): ");
        while (!cin.hasNextInt()) {
            System.out.println("Invalid choice! Please select a number 0 to 3.");
            cin.next();
            System.out.print("Selection(0-3): ");
        }

    }
}
