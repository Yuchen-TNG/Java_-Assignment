package Bill;
import java.time.LocalDate;
import java.util.UUID;
import Payment.payment;
import Movie.Movie;
public class Invoice {
    private String invoiceID; 
    private LocalDate invoiceDate; 
    private payment payment;
    private Ticket ticket; 
    private Movie movie; 

    public Invoice(payment payment, Ticket ticket, Movie movie) {
        this.payment = payment;
        this.ticket = ticket;
        this.movie = movie;
        this.invoiceID = generateInvoiceID(); 
        this.invoiceDate = LocalDate.now();
    }

    private String generateInvoiceID() {
        return "INVOICE-" + UUID.randomUUID().toString().substring(0, 8); 
    }

    public String getInvoiceID() {
        return invoiceID;
    }

    public LocalDate getInvoiceDate() {
        return invoiceDate;
    }

    public void printInvoice() {
        System.out.println("========== INVOICE ==========");
        System.out.println("Invoice ID: " + getInvoiceID());
        System.out.println("Date: " + getInvoiceDate());
        System.out.println("-----------------------------");
        System.out.println("Movie Details:");
        System.out.println("Movie Name: " + movie.getName());
        System.out.println("-----------------------------");
        System.out.println("Ticket Details:");
        System.out.println("Ticket ID: " + ticket.getTicketID());
        System.out.println("-----------------------------");
        System.out.println("Payment Details:");
        System.out.println("Total Price: RM " + String.format("%.2f", payment.gettotalPrice()));
        System.out.println("Total Amount: RM " + String.format("%.2f", payment.gettotalAmount()));
        System.out.println("-----------------------------");
        System.out.println("Thank you for your purchase!");
        System.out.println("=============================");
    }
}