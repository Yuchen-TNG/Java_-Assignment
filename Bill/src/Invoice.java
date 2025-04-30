import java.util.Date;
import java.util.UUID;

public class Invoice {
    private String invoiceID;
    private String paymentID;
    private payment payment;
    private String ticketID;
    private String customerName;
    private String seatNumber;
    private String movieTitle;
    private Date date;

    public Invoice(String paymentID, payment payment, String ticketID, String customerName, String seatNumber,
            String movieTitle, Date date) {
        this.invoiceID = generateUniqueID("INV");
        this.paymentID = payment.getpaymentID();
        this.payment = payment;
        this.ticketID = ticketID;
        this.customerName = customerName;
        this.seatNumber = seatNumber;
        this.movieTitle = movieTitle;
        this.date = (date != null) ? date : new Date(); 
    }

    private String generateUniqueID(String prefix) {
        return prefix + "-" + UUID.randomUUID().toString();
    }

    public String getInvoiceID() {
        return invoiceID;
    }

    public void setInvoiceID(String invoiceID) {
        this.invoiceID = invoiceID;
    }

    public String getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(String paymentID) {
        this.paymentID = paymentID;
    }

    public payment getPayment() {
        return payment;
    }

    public void setPayment(payment payment) {
        this.payment = payment;
    }

    public String getTicketID() {
        return ticketID;
    }

    public void setTicketID(String ticketID) {
        this.ticketID = ticketID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public double getTotalPrice() {
        return payment.gettotalprice(); 
    }

    public double getFinalAmount() {
        return payment.getpaymentamount(); 
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Invoice" + "\nInvoiceID : " + invoiceID + "\nPayment ID : " + getPaymentID() +
                "\nTicket ID" + getTicketID() + "\nCustomer Name : " + customerName +
                "\nSeat Number : " + seatNumber + "\nMovie Title : " + movieTitle + 
                "\nTotal Price : " + payment.gettotalprice() + "\nFinal Amount (6%Tax) : " + payment.getpaymentamount() + "\nDate : " + date + 
                "\nPayment Status : " + (payment.getpaymentstatus() ? "Success" : "Failed")  + "";
    }
}