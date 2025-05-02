import Movie.Database;
import Movie.Movie;
import Movie.Schedule;
import Payment.Booking;

public class Staff extends User implements Interface {

    private String staffID;
    private double salary;
    private boolean checkLogin;
    private static Staff[] staff = new Staff[5];
    private static int staffCount = 0;
    Database db = new Database();
    Movie mv = new Movie();
    Schedule schedule = new Schedule();
    Customer customer = new Customer();
    Booking booking = new Booking();

    static {
        try {
            staff[0] = new Staff("Leon Chang Rui Hern", 19, "M", "18/06/2006", "011-1073-8155", "leon@cinema.my","leon123",
                    "S001", 99999);
            staff[1] = new Staff("LeBron James", 40, "M", "30/12/1984", "012-233-4146", "james@cinema.my", "james123",
                    "S002", 4000);
            staff[2] = new Staff("Emma Stone", 36, "F", "06/11/1988", "017-455-8417", "emma@cinema.my", "emma123",
                    "S003", 3000);
            staff[3] = new Staff("Chris Evans", 44, "M", "13/06/1981", "011-2730-2323", "chris@cinema.my", "chris123",
                    "S004", 4200);
            staff[4] = new Staff("Zendaya Coleman", 28, "F", "01/09/1996", "013-329-9223", "zendaya@cinema.my","zendaya123",
                    "S005", 2600);

        } catch (Exception e) {
            System.err.println("Error initializing staff: " + e.getMessage());
        }
    }

    public Staff() {
    }

    public Staff(String name, int age, String gender, String birthday, String phoneNo, String email, String password,
            String staffID, double salary) {
        super(name, age, gender, birthday, phoneNo, email, password);
        this.staffID = staffID;
        this.salary = salary;
        staffCount++;
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

    public void showAllStaff() {

        if (staffCount == 0) {
            System.out.println("No staff registered yet.");
            return;
        } else {
            System.out.println(
                    "\n+=====================================================================================================================================+");
            System.out.println(
                    "|                                                            STAFF LISTS                                                              |");
            System.out.println(
                    "|=====================================================================================================================================|");
            System.out.printf("%-3s %-15s %-25s %-8s %-10s %-14s %-17s %-21s %-12s %-2s\n", "|", "Staff ID", "Name",
                    "Age",
                    "Gender", "Birthday", "PhoneNo", "Email", "Salary (RM)", "|");
            System.out.println(
                    "|-------------------------------------------------------------------------------------------------------------------------------------|");
            for (int i = 0; i < staffCount; i++) {

                if (staff[i] != null) {
                    System.out.printf("%-3s %-15s %-25s %-8d %-10s %-14s %-17s %-21s %-12.2f %-2s\n", "|",
                            staff[i].staffID, staff[i].getName(), staff[i].getAge(), staff[i].getGender(),
                            staff[i].getBirthday(), staff[i].getPhoneNo(), staff[i].getEmail(), staff[i].salary, "|");
                }
            }
            System.out.println(
                    "+=====================================================================================================================================+");
        }
        System.out.println("Press Key[enter] to exit");
        cin.nextLine();

    }

    public void getMenu() {
        int selection;

        do {
            displayStaffMenu();
            selection = cin.nextInt();

            switch (selection) {
                case 0:
                    Logout();
                    return;
                case 1:
                    customer.showAllCustomer();
                    break;
                case 2:
                    showAllStaff();
                    break;
                case 3:
                    System.out.println("Select Your Movie");
                    mv.setMovie();
                    break;
                case 4:
                    System.out.println("Select Your MovieId: ");
                    String movieId = cin.next();
                    schedule.getSchedule(movieId);
                    break;
                case 5:
                    System.out.println("Booking");
                    
                    booking.autoshowbooking(Booking.confirm);
                    break;
                default:
                    System.out.println("Invalid choice! Please select a number 0 to 3.");
            }
        } while (selection != 0);
        cin.close();
    }

    public void displayStaffMenu() {
        System.out.println("\n+============================+");
        System.out.println("|         STAFF MENU         |");
        System.out.println("|============================|");
        System.out.println("| 1. View Customer Details   |");
        System.out.println("| 2. View Staff Details      |");
        System.out.println("| 3. Add Movie               |");
        System.out.println("| 4. Check Schedule          |");
        System.out.println("| 5. View Customer Booking   |");
        System.out.println("| 0. Logout                  |");
        System.out.println("+============================+");
        System.out.print("Selection(0-3): ");
        while (!cin.hasNextInt()) {
            System.out.println("Invalid choice! Please select a number 0 to 3.");
            cin.next();
            System.out.print("Selection(0-3): ");
        }
    }

}
