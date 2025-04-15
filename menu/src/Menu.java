import java.util.Scanner;
public class Menu {
    public static void main(String[] args) throws Exception {
        Scanner cin = new Scanner(System.in);
        Movie movie = new Movie();
        
        System.out.println("Select Your Movie");
   
        movie.getMovie();
        



        cin.close();
    }
}
