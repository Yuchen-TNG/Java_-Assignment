import java.util.Scanner;

public class Mainpayment {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);

        System.out.print("how many ticket your buy?");
        int ticketnum = input.nextInt();


        System.out.println("Your ticketnum is " + ticketnum);
        


        //ClassName objectName = new ClassName();
        payment details = new payment(ticketnum);
        //objects = 访问payment（class）里面的variable
        //new payments() 代表调用了payment的class

        details.displayticket(); // run void
        details.calculatetotalprice();

        
    }
}
