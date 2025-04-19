public class Staff extends User {
    private static int nextStaffID=101;
    private int staffID;
    private String position;

    public Staff() {
        this.staffID=nextStaffID++;
    }

    public Staff(String name, String gender, int age, String password, String email, String position) {
        super(name, gender, age, password, email);
        this.staffID = nextStaffID++;
        this.position = position;
    }

    public int getStaffID() {
        return staffID;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

}
