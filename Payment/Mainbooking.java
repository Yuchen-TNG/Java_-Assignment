//Author: TNGYUCHEN
//Module: Main booking
//System: Cinema Ticket System
//Group: DFT1S3G11

package Payment;
import java.util.Scanner;

public class Mainbooking {
    public static void main(String[] args){
        //confirm = Array名字
        
        Scanner input = new Scanner(System.in);
        

        System.out.print("Do you confirm to make boooking? (y/n)");
        String choice = input.nextLine().toLowerCase();

        Booking show = new Booking();
        show.userchoice(choice, Booking.confirm);
        show.autoshowbooking(Booking.confirm);
        Payment payment = new Payment(show); //call payment function

        payment.calculatetotalprice();

        System.out.print("Price: " + Payment.gettotalprice() + "\n");


    System.out.println("Please choose a method to complete your booking: (1/2/3)"); //做table比较好看
    System.out.println("1. Cash");
    System.out.println("2. Credit Card");
    System.out.println("3. Touch N go");

    System.out.print("The method number that your choose is: ");

    int method = input.nextInt();

    input.nextLine();
    payment.setmethod(method);
    
    payment.paymentmethod();
    
    input.close();
    }
    
}

 
        /*Booking show = new Booking();

        
        System.out.println("Booking ID: " +  show.getbookingID());
        System.out.println("--------------------------");

        show.displayticket();*/
