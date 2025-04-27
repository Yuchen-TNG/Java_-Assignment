public class Booking {
    private String movie="The minecraft movie";
    private String Cinemaven="Kuala Lumpur- Setapak Central";
    private int numofhall= 3;
    private String seatnumber="04A";
    private String name= "Yuchen";
    private String email= "eason061221@gmail.com";

    public String getmovie(){
        return movie;
    }

    

public void displayticket(){
    System.out.println("The title movie: " + movie); //maybe movie.get()?
    System.out.println("Cinema venue: " + Cinemaven);
    System.out.println("Number of Hall: " + numofhall);
    System.out.println("Your seat number" + seatnumber);
    System.out.println("Name: " + name);
    System.out.println("Email: " + email);
}
}

   