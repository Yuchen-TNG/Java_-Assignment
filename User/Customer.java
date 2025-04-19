import java.util.Scanner;

public class Customer extends User {
    Scanner cin = new Scanner(System.in);
    private static int nextCustID = 1001;
    private int customerID;
    private String phoneNo;
    private static User[] users = new User[100];
    private static int userCount = 0;

    public Customer() {
        this.customerID = nextCustID++;
    }

    public Customer(String name, String gender, int age, String password, String email, String phoneNo) {
        super(name, gender, age, password, email);
        this.customerID = nextCustID++;
        this.phoneNo = phoneNo;
    }

    public int getCustomerID() {
        return customerID;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public void Register() {
        System.out.println("\n=====Registration=====");
        System.out.print("Name: ");
        String name = cin.next();
        System.out.print("Gender: ");
        String gender = cin.next();
        System.out.print("Age: ");
        int age = cin.nextInt();
        System.out.print("Password: ");
        String password = cin.next();
        System.out.print("Email: ");
        String email = cin.next();

        Customer newUser = new Customer(name, gender, age, password, email, phoneNo);
        if (userCount < users.length) {
            users[userCount++] = newUser;
            System.out.println("User Registered Successfully! ");
        } else {
            System.out.println("User storage is full!");
            System.exit(0);
        }
    }

    public void loginCustAcc() {

        System.out.println("\n=====Customer Login=====");
        System.out.print("Email: ");
        String email = cin.next();
        System.out.print("Password: ");
        String password = cin.next();

        boolean validation = false;
        for (int i = 0; i < userCount; i++) {
            if (users[i] == null)
                continue;
            if (users[i].getEmail().equals(email) && users[i].getPassword().equals(password)) {
                validation = true;
                System.out.println("Login Successfully!");
            }
        }
        if (!validation) {
            System.out.println("Login Failed! Invalid email or password.");
        }
    }
}
