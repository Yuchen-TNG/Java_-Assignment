package Payment;
import java.util.ArrayList;
import java.util.List;

public class Booking {

    private String bookingID;
    private static int bookingidCount = 1;

        private String movie;
        private int numofhall= 3;
        private String seatNumbers; 
        private String email;
        private int numberofperson;
        private String date;
        private String time;

        public static ArrayList<Booking> confirm = new ArrayList<>();


        public Booking(){
            this.bookingID = generateBookingID();
        }

        public Booking(String movie, String date, String time, int numberofperson) {
            this.bookingID = generateBookingID();
            this.movie = movie;
            this.date = date;
            this.time = time;
            this.numberofperson = numberofperson;
            this.seatNumbers = seatNumbers;
        }
        public void setTicket(String movie,String date,String time,String seatNumber,int numberOfPerson){
            this.movie=movie;
            this.date=date;
            this.time=time;
            this.seatNumbers=seatNumber;
            this.numberofperson=numberOfPerson;
        }
        public void setEmail(String email) {
            this.email = email;
        }

        public void setdate(String date){
            this.date = date;
        }

        public void settime(String time){
            this.time = time;
        }

        public void setnumberofperson(int numberofperson){
            this.numberofperson = numberofperson;
        }

        public void setseatnumber(String seatnumber){
            seatNumbers=seatnumber;
        }

        public String getseatnumber(){
            return String.join(",", seatNumbers);
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
                Booking newbooking = new Booking();
                newbooking.setdate(this.date);
                newbooking.settime(this.time);
                newbooking.setMovie(this.movie);
                newbooking.setEmail(this.email);
                newbooking.setnumberofperson(this.numberofperson); // 复制 numberofperson
                newbooking.setnumberofperson(this.numberofperson);
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

 public void cancelBookingByID(String id, ArrayList<Booking> confirm) {
    boolean removed = false;

    for (int i = 0; i < confirm.size(); i++) {
        Booking b = confirm.get(i);
        if (b.getbookingID().equalsIgnoreCase(id)) {
            confirm.remove(i);
            removed = true;
            System.out.println("Booking with ID " + id + " has been cancelled.");
            break;
        }
    }

    if (!removed) {
        System.out.println("No booking found with ID: " + id);
    }
}
    
 public void displayticket(){
    System.out.println("==============================================");
    System.out.println("The title movie: " + movie);
    System.out.println("Date: " + date);
    System.out.println("Time: " + time);
    System.out.println("Your seat number: " + seatNumbers);
    System.out.println("Number of Person: " + numberofperson);

}

}

