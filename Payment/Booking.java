package Payment;
import java.util.ArrayList;

public class Booking {

    private String bookingID;
    private static int bookingidCount = 1;

        private String movie;
        private int numofhall= 3;
        private String seatnumber="04A";
        private String email;
        private int numberofperson = 3;
        private String date;
        private String time;


        public Booking(){
            this.bookingID = generateBookingID();
        }

        public Booking(String movie, String date, String time) {
            this.bookingID = generateBookingID();
            this.movie = movie;
            this.date = date;
            this.time = time;
        }

        public Booking(String movie) {
            this.bookingID = generateBookingID();
            this.movie = movie;
        }

        public void setEmail(String email) {
            this.email = email;
        }
    
        public String getmovie(){
            return movie;
        }

        public String getbookingID(){
            return bookingID;
        }

        public int getnumberofperson(){
            return numberofperson;
        }

        public void setMovie(String movie) {
            this.movie = movie;
        }

        public String generateBookingID(){
            String id = String.format("B%03d",bookingidCount);
            bookingidCount++;
            return id;

        }

        public void userchoice(String choice,  ArrayList<Booking> confirm ){
            if(choice.equals("y" ) || choice.equals("yes")){
        if (this.movie == null || this.date == null || this.time == null) {
            System.out.println("Error: Movie, date, or time is not set.");
            return;
        }
                Booking newbooking = new Booking(this.movie, this.date, this.time);
                newbooking.setEmail(this.email);
                confirm.add(newbooking);
                System.out.println("Make payment successfully");
    
            }else{
                System.out.println("Booking cancelled");
                return;
            }
        }

        public void autoshowbooking(ArrayList<Booking> confirm){
            for(int i = 0; i < confirm.size(); i++){
                Booking b = confirm.get(i);
                b.displayticket();
                System.out.println("==============================================\n");
            }
 } 
    
 public void displayticket(){
    System.out.println("==============================================");
    System.out.println("Email: " + email); //d
    System.out.println("The title movie: " + movie);
    System.out.println("Date: " + date);
    System.out.println("Time: " + time);
    System.out.println("Number of Hall: " + numofhall);
    System.out.println("Your seat number: " + seatnumber);
    System.out.println("Number of Person: " + numberofperson);
    
}

}

