import java.util.Scanner;

public class Mainpayment {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in); 

        System.out.print("how many ticket your buy?");
        int ticketnum = input.nextInt(); //给user input
        // .之前是variable, .之后是那个variable要做的operation

        System.out.println("Your ticketnum is " + ticketnum);

        //ClassName objectName = new ClassName();
        payment details = new payment(ticketnum, 0);
        //objects = 访问payment（class）里面的variable
        //new payments() 代表调用了payment的class

        details.displayticket(); // run void
        details.calculatetotalprice();


        System.out.println("Your price is " + details.gettotalprice()); //如果要读data就用get不是直接把function丢下去

        System.out.println("-----------------------------------");
        System.out.println("Choose a payment method to make payment");
        System.out.println("1. Cash");
        System.out.println("2.Credit Card");
        System.out.println("3. Touch n Go");

       int method = input.nextInt();

       switch(method){
         case 1:
            System.out.print("Please enter your amount: ");
            double amount = input.nextDouble();
            double balance = payment.paymentmethod_cash(amount);

            if(balance >= amount){
                System.out.print("Payment successful !");
                System.out.print("Your balance is " + balance);
            }else{
                System.out.print("Payment unsuccessful !");
            }
            

           



           
        }

    }
}
