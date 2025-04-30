public class Ticket{
    private String ticketID;
    private int customerID;
    private payment payment;
    private static int idCounter = 1;

    public Ticket(int customerID, payment payment) {
        this.ticketID = generateTicketID();
        this.customerID = customerID;
        this.payment = payment;
    }

    private static String generateTicketID() {
        return "A" + String.format("%03d", idCounter++); 
    }

    public String getTicketID() {
        return ticketID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public payment getPayment() {
        return payment;
    }

    public void setPayment(payment payment) {
        this.payment = payment;

    }

    @Override
    public String toString() {
        return "Ticket" + "\nTicketID : " + ticketID + "\nCustomer : " + getCustomerID() + "\nPayment : " + payment + "";
    }
}
