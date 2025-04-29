public class Staff extends User implements Interface {

    private String staffID;
    private String position;
    private boolean checkLogin;
    private static Staff[] staff = new Staff[10];
    private static int staffCount = 0;
    Movie movie = new Movie();
    Customer customer = new Customer();

    static {
        staff[0] = new Staff("Leon", 30, "M", "18/6/2006", "01110738155", "staff@gmail.com", "password123", "S001",
                "Manager");
    }

    public Staff() {
    }

    public Staff(String name, int age, String gender, String birthday, String phoneNo, String email, String password, String staffID, String position) {
        super(name, age, gender, birthday, phoneNo, email, password);
        this.staffID = staffID;
        this.position = position;
        staffCount++;
    }

    public String getStaffID() {
        return staffID;
    }

    public String getPosition() {
        return position;
    }

    public void setStaffID(String staffID) {
        this.staffID = staffID;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void staffLogin() {

        while (true) {
            System.out.println("\n=====Staff Login=====");
            System.out.print("Email: ");
            String email = cin.next();
            System.out.print("Password: ");
            String password = cin.next();

            for (int i = 0; i < staffCount; i++) {
                if (staff[i] == null)
                    continue;
                if (staff[i].getEmail().equals(email) && staff[i].getPassword().equals(password)) {
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

    public void getMenu() {
        int selection;

        do {
            displayStaffMenu();
            while (!cin.hasNextInt()) {
                System.out.println("Invalid choice! Please select a number between 1 and 3.");
                cin.next();
            }
            displayStaffMenu();
            selection = cin.nextInt();

            switch (selection) {
                case 1:
                    Customer.showAllCustomer();
                    break;
                case 2:
                    System.out.println("Select Your Movie");
                    movie.setMovie();
                    movie.getMovie();
                    movie.clearMovie();
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

    public static void displayStaffMenu() {
        System.out.println("\n====Staff Menu====");
        System.out.println("1. View Customer Details");
        System.out.println("2. Add Movie");
        System.out.println("3. Logout");
        System.out.print("Selection: ");
    }

}
