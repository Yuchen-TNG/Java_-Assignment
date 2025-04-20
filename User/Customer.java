import java.util.Scanner;

public class Customer extends User {
    Scanner cin = new Scanner(System.in);
    private static int nextCustID = 1000;
    private int customerID;
    private static User[] users = new User[100];
    private static int userCount = 0;

    public Customer() {
        this.customerID = nextCustID++;
    }

    public Customer(String name, int age, String gender, String phoneNo, String password, String email) {
        super(name, age, gender, phoneNo, password, email);
        this.customerID = nextCustID++;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void Register() {
        String email = "";
        String phoneNo;

        System.out.println("\n=====Registration=====");
        System.out.print("Name: ");
        String name = cin.nextLine();

        System.out.print("Age: ");
        int age = cin.nextInt();

        System.out.print("Gender(M/F): ");
        String gender = cin.next();

        while (true) {
            System.out.print("PhoneNo: ");
            phoneNo = cin.next();
            if (phoneNo.matches("\\d{3}-\\d{3}-\\d{4}") || phoneNo.matches("\\d{3}-\\d{4}-\\d{4}")) {
                break;
            } else {
                System.out.println("invalid phone No. please follow the format(000-000-0000 or 000-0000-0000)");
            }
        }
        while (true) {
            System.out.print("Email: ");
            email = cin.next();
            if (email.contains("@gmail.com")) {
                break;
            } else {
                System.out.println("invalid please include '@gmail.com'");
            }
        }
        System.out.print("Password: ");
        String password = cin.next();
        cin.nextLine();

        Customer newUser = new Customer(name, age, gender, phoneNo, password, email);
        if (getuserCount() < getusers().length) {
            users[userCount] = newUser;
            incretmentUserCount();
            System.out.println("User Registered Successfully! ");

        } else {
            System.out.println("User storage is full!");
            System.exit(0);
        }
    }

    public static void incretmentUserCount(){
        userCount++;
    }

    public static User[] getusers() {
        return users;
    }

    public static int getuserCount() {
        return userCount;
    }

    public void loginCustAcc() {

        while (true) {
            System.out.println("\n=====Customer Login=====");
            System.out.print("Email: ");
            String email = cin.next();
            System.out.print("Password: ");
            String password = cin.next();

            for (int i = 0; i < userCount; i++) {
                if (users[i] == null)
                    continue;
                if (users[i].getEmail().equals(email) && users[i].getPassword().equals(password)) {
                    System.out.println("Login Successfully!");
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

    public String toString() {
        return "\n=====User Details=====" + "\nUserID: " + getCustomerID() + super.toString();
    }
}
