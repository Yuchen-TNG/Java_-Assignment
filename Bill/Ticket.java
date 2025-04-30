package Bill;
import java.util.UUID;

public class Ticket<Customer> {
    private String ticketID; 
    private Customer customer; 

    public Ticket(Customer customer) {
        this.customer = customer;
        this.ticketID = generateTicketID(); // 自动生成 Ticket ID
    }

    private String generateTicketID() {
        return "TICKET-" + UUID.randomUUID().toString().substring(0, 8); // 生成唯一 ID
    }

    public String getTicketID() {
        return ticketID;
    }

    public int getCustomerID() {
        return customer.getCustomerID();
    }



    public void printTicket() {
        System.out.println("========== TICKET ==========");
        System.out.println("Customer Details : ");
        System.out.println("Name : " + customer.getName());
        System.out.println("Customer ID : " + getCustomerID());
        System.out.println("-----------------------------");
        System.out.println("Ticket Details : ");
        System.out.println("Ticket ID : " + getTicketID());
        System.out.println("-----------------------------");
        System.out.println("Thank you for your purchase!");
        System.out.println("=============================");
    }
}