package Payment;
import java.text.DecimalFormat;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Payment {
    private static double paymentamount = 12.00; // number of price of ticket
    private int method; // touch n go, cash, credit card
    private static double tax = 0.06;
    private double totalprice;
    private String[] paymenthistory;
    private YearMonth expiredMonth;

    private Booking booking;
    private double userpay;
    private long cardnumber;
    private int CVV;

    public payment(Booking booking) {
        this.booking = booking;
    }

    public void setmethod(int method){
        this.method = method;
    }

    public long getcardnumber(){
        return cardnumber;
    }

    public void calculatetotalprice(){
        this.totalprice = paymentamount + (paymentamount * booking.getnumberofperson()) * tax; //(12.00 x 3.00)* 0.06;
    }

    public double gettotalprice(){
        return totalprice;
    }

    public void setexpiredMonth(YearMonth expiredMonth){
        this.expiredMonth = expiredMonth;
    }

    public boolean validExpiredMonth(){
            YearMonth now = YearMonth.now(); // Get the current month and year
            System.out.println("Current date: " + now);  // Add this to debug
            System.out.println("Expired date: " + expiredMonth); // Add this to debug
            return expiredMonth != null && !expiredMonth.isBefore(now); // Check if the expiredMonth is after or equal to the current month/year
        }

        public void paymentmethod() {
            Scanner input = new Scanner(System.in);
        
            while (true) {
                switch (this.method) {
                    case 1:
                        System.out.print("Please enter your amount: ");
                        userpay = input.nextDouble();
                        input.nextLine();
                        DecimalFormat df = new DecimalFormat("0.00");
        
                        if (userpay >= totalprice) {
                            System.out.println("Payment successful. Remaining money: " + df.format(userpay - totalprice));
                            return; // 退出方法
                        } else {
                            System.out.println("Payment unsuccessful, please try again.");
                        }
                        break;
        
                    case 2:
                        System.out.print("Enter card number (16 digits): ");
                        cardnumber = input.nextLong();
                        input.nextLine();
        
                        String Cardnumber = String.valueOf(cardnumber); // convert long to string
                        if (Cardnumber.length() == 16) {
                            System.out.print("Enter CVV (3 digits): ");
                            CVV = input.nextInt(); //let user input
                            input.nextLine();
        
                            if (CVV >= 100 && CVV <= 999) {
                                System.out.print("Enter expiry date (MM/yy): ");
                                String exp = input.nextLine();
                                if (exp.length() == 5 && exp.charAt(2) == '/') {
                                    expiredMonth = YearMonth.parse(exp, DateTimeFormatter.ofPattern("MM/yy"));
                                    if (validExpiredMonth()) {
                                        System.out.println("Payment successful");
                                        return;
                                    } else {
                                        System.out.println("Payment unsuccessful, your card is expired.");
                                    }
                                } else {
                                    System.out.println("Invalid format. Please enter date as MM/yy.");
                                }
        
                            } else {
                                System.out.println("Fail, please enter the correct CVV.");
                            }
                        } else {
                            System.out.println("Payment failed. Card number must be 16 digits.");
                        }
                        break;
        
                    case 3:
                        input.nextLine(); // 清除残留换行
                        System.out.println("This is QR code, scan this to complete your payment");
                        System.out.println("█████████████████████████");
                        System.out.println("██  ██  ██      ██  ██ ██");
                        System.out.println("██  ██  ██████  ████   ██");
                        System.out.println("██      ██  ██      █  ██");
                        System.out.println("██  ████  ████  ████   ██");
                        System.out.println("██  ██      ██  ██  ██ ██");
                        System.out.println("█████████████████████████");
                        System.out.println("██                     ██");
                        System.out.println("██                     ██");
                        System.out.println("██                     ██");
                        System.out.println("█████████████████████████");
        
                        System.out.print("Did you complete the payment? (y/n): ");
                        String answer = input.nextLine().toLowerCase();
        
                        if (answer.equals("y") || answer.equals("yes")) {
                            System.out.println("Payment successful");
                            return;
                        } else {
                            System.out.println("Payment failed! Please try again.");
                        }
                        break;
        
                    default:
                        System.out.println("Please enter a correct number (1 - 3): ");
                        if (input.hasNextInt()) {
                            this.method = input.nextInt();
                            input.nextLine();
                        } else {
                            input.nextLine(); // 清掉无效输入
                            System.out.println("Invalid input. Please enter a number.");
                        }
                        break;
                }
            }
        } //while 的（）；        
        }