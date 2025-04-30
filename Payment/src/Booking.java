import java.util.ArrayList;

public class Booking {

    private String bookingID;
    private static int bookingidCount = 1;

        private String movie;
        private int numofhall= 3;
        private String seatnumber="04A";
        private String email= "eason061221@gmail.com";
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
                Booking newbooking = new Booking(this.movie, this.date, this.time);
                confirm.add(newbooking);
                System.out.println("Make payment successfully");
    
            }else{
                System.out.println("Booking cancelled");
                System.exit(0); //must modify !
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
    System.out.println("Email: " + email);
    System.out.println("The title movie: " + movie);
    System.out.println("Date: " + date);
    System.out.println("Time: " + time);
    System.out.println("Number of Hall: " + numofhall);
    System.out.println("Your seat number: " + seatnumber);
    System.out.println("Number of Person: " + numberofperson);
}

    }

