package Bill;

import java.util.UUID;

import Payment.Booking;

public class Ticket {
    private String ticketID;
    private Booking booking;
    private static int ticketCounter = 1;
    private int ticketNo;

    public Ticket(Booking booking) {
        this.booking = booking;
        this.ticketID = generateTicketID(); // 自动生成 Ticket ID
        this.ticketNo = ticketCounter++; // 自动生成 Ticket No
    }

    private String generateTicketID() {
        return "TICKET-" + UUID.randomUUID().toString().substring(0, 16); // 生成唯一 ID
    }

    public String getTicketID() {
        return ticketID;
    }

    public int getTicketNo() {
        return ticketNo;
    }

    public void printTicket() {
        System.out.println("========== TICKET ==========");
        System.out.println("Ticket Details : ");
        System.out.println("Ticket ID : " + getTicketID());
        System.out.println("Ticket No : " + getTicketNo());
        System.out.println("hahahaahahahah3");
        System.out.println("Seat : " + booking.getseatnumber());
        System.out.println("-----------------------------");
        System.out.println("Thank you for your purchase!");
        System.out.println("=============================");
    }
}