package Bill;
import java.time.LocalDate;
import java.util.UUID;
import Payment.Payment;
import Movie.Movie;
import java.util.Random; 

public class Invoice {
    private String invoiceID; 
    private LocalDate invoiceDate; 
    private Payment payment;
    private Ticket ticket; 
    private Movie movie; 

    public Invoice() {}
    
    public Invoice(Payment payment, Ticket ticket, Movie movie) {
        this.payment = payment;
        this.ticket = ticket;
        this.movie = movie;
        this.invoiceID = generateInvoiceID(); 
        this.invoiceDate = LocalDate.now();
    }

    private String generateInvoiceID() { //Universally Unique Identifier 把UUID变成string substring是写提取几个就几个
        return "INVOICE-" + UUID.randomUUID().toString().substring(0, 8); 
    }

    public String getInvoiceID() {
        return invoiceID;
    }

    public LocalDate getInvoiceDate() {
        return invoiceDate;
    }

    private String generateLuckyDraw() { //生成幸运抽奖
        // 这里可以根据需要生成不同的奖品
        String[] prizes = {"Free Popcorn", "Free Movie Ticket", "Discount Voucher","Free Drink", "Gift Card"};
        Random random = new Random();
        int index = random.nextInt(prizes.length);
        return prizes[index];
    }

    public void printInvoice() {
        System.out.println("========== INVOICE ==========");
        System.out.println("Invoice ID : " + getInvoiceID());
        System.out.println("Date : " + getInvoiceDate());
        System.out.println("-----------------------------");
        System.out.println("Movie Details :");
        System.out.println("Movie Name : " + movie.getName());
        System.out.println("-----------------------------");
        System.out.println("Ticket Details :");
        System.out.println("Ticket ID : " + ticket.getTicketID());
        System.out.println("-----------------------------");
        System.out.println("Payment Details : ");
        System.out.println("Total Amount : RM " + String.format("%.2f", payment.getpaymentamount()));
        System.out.println("Total Price : RM " + String.format("%.2f", payment.gettotalprice()));
        System.out.println("-----------------------------");
        System.out.println("Lucky Draw Result : " + generateLuckyDraw());
        System.out.println("-----------------------------");
        System.out.println("Thank you for your purchase!");
        System.out.println("=============================");
    }
}