import java.util.Scanner;

public class User {

    Scanner cin = new Scanner(System.in);
    private String name;
    private int age;
    private String gender;
    private String phoneNo;
    private String email;
    private String password;

    public User() {
    }

    public User(String name, int age, String gender, String phoneNo, String password, String email) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.phoneNo = phoneNo;
        this.password = password;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getphoneNo(){
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String toString() {
        return String.format("\nName: %s\nAge: %d\nGender: %s\nPhoneNo: %s\nEmail: %s", name, age, gender,phoneNo, email);
    }

}
