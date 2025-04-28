
public class Customer extends User {

    private static int nextCustomerID=1001;
    private int customerID;
    private User[] users;
    private static int customerCount = 0;

    public Customer() {
        users = new User[100];
    }

    public Customer(String name, int age, String gender, String phoneNo, String password, String email) {
        super(name, age, gender, phoneNo, password, email);
        this.customerID=nextCustomerID++;
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
        String phoneNo;

        System.out.println("\n=====Registration=====");
        System.out.print("Name: ");
        String name = cin.nextLine();

        System.out.print("Age: ");
        int age = cin.nextInt();
        cin.nextLine();

        System.out.print("Gender(M/F): ");
        String gender = cin.next();
        cin.nextLine();

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
        if (customerCount < users.length) {
            users[customerCount] = newUser;
            customerCount++;
            System.out.println("User Registered Successfully! ");

        } else {
            System.out.println("User storage is full!");
            System.exit(0);
        }
        System.out.println(users[customerCount-1].toString());
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

    public void showAllCustomer(){
        for(int i = 0;i<customerCount;i++){
            System.out.println(users[i].toString());
            }
    }

    public String toString() {
        return "\n=====User Details=====" + "\nCustomerID: " + customerID + super.toString();
    }
}
