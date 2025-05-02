package Movie;

import java.util.Scanner;

public class Movie {

    Scanner cin = new Scanner(System.in);

    private String Name;
    private String MovieId;
    private String Type;
    private String Language;
    private Database db;

    public Movie() {
    }

    public Movie(String Name, String MovieId, String Type, String Language) {
        this.Name = Name;
        this.MovieId = MovieId;
        this.Type = Type;
        this.Language = Language;
    }

    public void setDb() {
        db = new Database(); // 在这里 new，而不是构造器
    }

    public String getName() {
        return Name;
    }

    public String getMovieId() {
        return MovieId;
    }

    public String getType() {
        return Type;
    }

    public String getLanguage() {
        return Language;
    }

    public void setMovie() {
    
        String movieID = "";
        System.out.println("\n\nHow many movie you want add?");
        int addMovie = cin.nextInt();
        cin.nextLine();
        int count = db.movieIdSize() - 1;
        int check = 0;
        if (addMovie >= 1) {
            for (int i = 0; i < addMovie; i++) {

                System.out.print("\n\nMovie Name : ");
                String MovieName = cin.nextLine();
                boolean bool = false;
                do {
                    System.out.print("Movie ID : ");
                    movieID = cin.nextLine();
                    if (movieID.length() == 4 && Character.isUpperCase(movieID.charAt(0))
                            && Character.isDigit(movieID.charAt(1)) && Character.isDigit(movieID.charAt(2))
                            && Character.isDigit(movieID.charAt(3))) {
                        bool = false;
                    } else {
                        System.out.print("Your Movie ID is wrong format\n");
                        bool = true;
                    }
                } while (bool);

                System.out.print("Movie Type : ");
                String MovieType = cin.nextLine();

                System.out.print("Movie Language : ");
                String MovieLan = cin.nextLine();

                Movie newMovie = new Movie(MovieName, movieID, MovieType, MovieLan);

                do {
                    db.showMovieFromMovie(count);
                    System.out.println("\n\nAre you sure you want to add into Library? (Yes / No)");
                    String choice = cin.nextLine().trim();
                    if (choice.equalsIgnoreCase("yes") || choice.equalsIgnoreCase("y")) {
                        db.addMovieFromMovie(newMovie);
                        check++;
                        count++;
                        System.out.println("\n\nYour Movie has been add");
                        bool = false;
                    } else if (choice.equalsIgnoreCase("no") || choice.equalsIgnoreCase("n")) {
                        bool = false;
                    } else {
                        System.err.println("\n\nWe can't understand your input, please try again");
                        bool = true;
                    }
                } while (bool);
            }
        } else {
            return;
        }
    }

    public void clearMovie() {
        Database db =new Database();

        boolean check = true;
        System.out.println("\n\nDelete Movie List");
        System.out.print("Movie ID delete:");
        String movieId = cin.nextLine();
        System.out.println("");
        String pendingName = db.getMovieNameByMovieIdFromMovie(movieId);
        do {
            System.out.println("\nAre you sure you want to delete this Movie : " + pendingName);
            String choice = cin.nextLine();
            if (choice.equalsIgnoreCase("Yes") || choice.equalsIgnoreCase("y")) {
                db.clearMovieFromMovie(movieId);
                System.out.println("\n\nMovie " + pendingName + " have been deleted");
                check = false;
            } else if (choice.equalsIgnoreCase("No") || choice.equalsIgnoreCase("n")) {
                check = false;
            } else {
                System.out.println("We don't understand your input");
                check = true;
            }
        } while (check);

    }

    public void choiceMovie() {
        setDb();
        db.showAllMovieFromMovie();
        System.out.println("Select Your Movie Number");
        int choice = cin.nextInt();
        choice += -1;

        String movieName = db.getMovieNameBySomethingIntFromMovie(choice);
        String movieID = db.getMovieIdBySomethingIntFromMovie(choice);
        Schedule sc = new Schedule();
        sc.getSchedule(movieID);
        String[] schedule = sc.getDateAndTime();
        String selectedDate2 = schedule[0];
        String selectedTime2 = schedule[1];
   

        /*String[] seatInfo = se.storeAllValue();
        String scheduleId = seatInfo[0];
        String totalPendingSeat = seatInfo[1]; // 格式为 ,A1,A2,...
        String[] seats = totalPendingSeat.split(",");
        int numberOfPeople = seats.length - 1; 


        Booking booking = new Booking();
        booking.setMovie(movieName);
        booking.setdate(selectedDate2);
        booking.settime(selectedTime2);
        booking.setnumberofperson(numberOfPeople);
        booking.setseatnumber(totalPendingSeat);
            
        */
    }

}