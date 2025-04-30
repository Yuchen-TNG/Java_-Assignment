import java.util.Date;

public class payment {
    private String paymentID;
    private static double paymentamount = 12.00; // number of price of ticket
    private int method; // touch n go, cash, credit card
    private static double tax = 0.06;
    private static double totalprice;// payment amount + (tax * paymentamount)
    private boolean paymentstatus; // true = success, false = failed
    private String[] paymenthistory;

    //fakedata
    private String movie="The minecraft movie";
    private String Cinemaven="Kuala Lumpur- Setapak Central";
    private int numofhall= 3;
    private String seatnumber="04A";
    private static int numofticket;
    private String name= "Yuchen";
    private String email= "eason061221@gmail.com";

    public payment(int numofticket, int method){
        payment.numofticket= numofticket;
        this.method= method;

    }

    public String getpaymentID(){
        return paymentID;
    }

    public double getpaymentamount(){
        return paymentamount;
    }

    public int getmethod(){
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

    public void setmethod(int method){
        this.method=method;
    }

    public void settotalprice(double totalprice){
        this.totalprice=totalprice;
    }

    public void setpaymentstatus(boolean paymentstatus){
        this.paymentstatus=paymentstatus;
    }

    public static void calculatetotalprice(){
        totalprice = paymentamount*numofticket  + ((paymentamount*numofticket)*tax);
    }

    //cash
    public static double  paymentmethod_cash(double amount){
        double balance = totalprice - amount;
        if (balance > 0) {
            return balance;
        }
        return 0;
    }

    //credit card
    public static boolean paymenthod_creditcard(String cardnumber){
        if (cardnumber.length() == 16){
            return true;
        }else{
            return false;
        }
    }

    public static boolean CVV(int CVV){
        if (CVV >= 100 && CVV  <= 999){
            return true;
        }else{
            return false;
        }
    }

    


}
