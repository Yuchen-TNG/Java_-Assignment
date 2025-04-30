public class Customer extends User implements Interface {

    private static int nextCustomerID = 1001;
    private int customerID;
    private static User[] users = new User[100];
    private static int customerCount = 0;
    private boolean checkLogin;

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

    public User[] getusers() {
        return users;
    }

    public static int getCustomerCount() {
        return customerCount;
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
        String gender = cin.next();
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
        System.out.println(users[customerCount - 1].toString());
    }

    public void loginCustAcc() {

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
                    checkLogin = true;
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

    public static void showAllCustomer() {
        if (customerCount == 0) { 
            System.out.println("\nNo customers registered yet.");
            return;
        }
        for (int i = 0; i < customerCount; i++) {
            if (users[i] != null) {
                System.out.println(users[i].toString());
            }
        }
    }

    public void getMenu() {
        int selection;

        do {
            displayCustMenu();
            while (!cin.hasNextInt()) {
                System.out.println("Invalid choice! Please select a number between 1 and 3.");
                cin.next();
            }
            displayCustMenu();
            selection = cin.nextInt();

            switch (selection) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    Logout();
                    return;
                default:
                    System.out.println("Invalid choice! Please select a number between 1 and 3.");
            }
        } while (selection != 3);
        cin.close();
    }

    public String toString() {
        return "\n\n=====User Details=====" + "\nCustomerID: " + customerID + super.toString();
    }

    public static void displayCustMenu() {
        System.out.println("\n====Customer Menu====");
        System.out.println("1. View Movie");
        System.out.println("2. Booking Ticket");
        System.out.println("3. Logout");
        System.out.print("Selection: ");
    }
}
