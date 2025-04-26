public class Staff extends User {

    private String staffID;
    private String position;

    public Staff() {
    }

    public Staff(String name, int age, String gender,String phoneNo, String password, String email,String staffID, String position) {
        super(name, age, gender, phoneNo, password, email);
        this.staffID = staffID;
        this.position = position;
    }

    public String getStaffID() {
        return staffID;
    }

    public String getPosition() {
        return position;
    }

    public void setStaffID(String staffID){
        this.staffID=staffID;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void staffLogin(){

    }

}
