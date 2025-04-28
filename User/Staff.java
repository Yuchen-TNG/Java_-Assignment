public class Staff extends User {

    private String staffID;
    private String position;
    private Staff[] staff;
    private static int staffCount = 0;
    Movie movie = new Movie();

    public Staff() {
        staff = new Staff[3];
    }

    public Staff(String name, int age, String gender, String phoneNo, String password, String email, String staffID,
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
        if (staffCount < staff.length) {
            this.staff[staffCount] = new Staff("leon", 19, "M", "01110738155", "Ruihern2006.", "staff@gmail.com", "S001",
                    "senior");
                    staffCount++;
        }

        while (true) {
            System.out.println("\n=====Staff Login=====");
            System.out.print("Email: ");
            String email = cin.next();
            System.out.print("Password: ");
            String password = cin.next();

            for (int i = 0; i < staffCount; i++) {
                if (this.staff[i] == null)
                    continue;
                if (this.staff[i].getEmail().equals(email) && this.staff[i].getPassword().equals(password)) {
                    System.out.println("Login Successfully!");
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

}
