import java.util.Date;

public class payment {
    private String paymentID;
    private double paymentamount; // number of price of ticket
    private String method; // touch n go, cash, credit card
    private static double tax = 0.06;
    private double totalprice;// payment amount + (tax * paymentamount)
    private boolean paymentstatus; // true = success, false = failed
    private String[] paymenthistory;

    //fakedata
    private String movie="The minecraft movie";
    private String Cinemaven="Kuala Lumpur- Setapak Central";
    private int numofhall= 3;
    private String seatnumber="04A";
    private int numofticket= 2;
    private String name= "Yuchen";
    private String email= "eason061221@gmail.com";

    public String getpaymentID(){
        return paymentID;
    }

    public double getpaymentamount(){
        return paymentamount;
    }

    public String getmethod(){
        return method;
    }

    public double gettotalprice(){
        return totalprice;
    }

    public boolean getpaymentstatus(){
        return paymentstatus;
    }

    //set

    public void setpaymentamount(double paymentamount){
        this.paymentamount=paymentamount;
    }

    public void setpaymentID(String paymentID){
        this.paymentID= paymentID;
    }

    public void setmethod(String method){
        this.method=method;
    }

    public void settotalprice(double totalprice){
        this.totalprice=totalprice;
    }

    public void setpaymentstatus(boolean paymentstatus){
        this.paymentstatus=paymentstatus;
    }


}
