import java.util.Scanner;

public class User {

    Scanner cin = new Scanner(System.in);
    private String name;
    private int age;
    private String gender;
    private String birthday;
    private String phoneNo;
    private String email;
    private String password;

    public User() {
    }

    public User(String name, int age, String gender, String birthday, String phoneNo, String email, String password) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.birthday = birthday;
        this.phoneNo = phoneNo;
        this.email = email;
        this.password = password;
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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getphoneNo() {
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
        return String.format("\nName: %s\nAge: %d\nGender: %s\nBirthday: %s\nPhoneNo: %s\nEmail: %s", name, age, gender,
                birthday, phoneNo, email);
    }

}
