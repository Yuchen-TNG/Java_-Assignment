import java.util.Scanner;


public class Customer extends User {
    Scanner cin = new Scanner(System.in);
    private static int nextCustID=1001;
    private int customerID;
    private String phoneNo;

    public Customer() {
        this.customerID=nextCustID++;
    }

    public Customer(String name, char gender, int age, String password, String email, String phoneNo) {
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

    public void createCustAcc(){
        System.out.println("=====Create Account=====");
        System.out.println("CustomerID = "+getCustomerID());
        System.out.print("Name: ");
  
    }

}
