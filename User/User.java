//Author: LEON CHANG RUI HERN
//Module: User
//System: Cinema Ticket System
//Group: DFT1S3G11

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

    public String getGender() {
        return gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public int getAge() {
        return age;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String toString() {
        return String.format("\n| Name: %-22s |\n| Age: %-23d |\n| Gender: %-20s |\n| Birthday: %-18s |\n| PhoneNo: %-19s |\n| Email: %-21s |", name, age, gender,
                birthday, phoneNo, email);
    }

}
