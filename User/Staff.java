import java.util.Scanner;

public class Staff extends User implements Interface{

    Scanner cin = new Scanner(System.in);
    private String staffID;
    private String position;
    private boolean checkLogin;
    private static Staff[] staff = new Staff[10];
    private static int staffCount = 0;
    Movie movie = new Movie();

    static {
        staff[0] = new Staff("Leon", 30, "M", "01110738155", "staff@gmail.com", "password123", "S001", "Manager");
    }

    public Staff() {
    }

    public Staff(String name, int age, String gender, String phoneNo,String email, String password, String staffID,
            String position) {
        super(name, age, gender, phoneNo, password, email);
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
                    System.out.println("Select Your Movie");
                    movie.setMovie();
                    movie.getMovie();
                    movie.clearMovie();
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

    public void Logout(){
        System.out.println("Logout.....");
if(checkLogin){
    System.out.println("Logout Successfully.");
    checkLogin = false;
}else{
    System.out.println("No user is currently logged in.");
}
    }

    public void getMenu(){

    }

}
