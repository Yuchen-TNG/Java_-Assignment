package Movie;

import java.util.ArrayList;

public class Database {

    static ArrayList<Movie> movieData=new ArrayList<>();
    static ArrayList<Schedule> scheduleData = new ArrayList<>();
    static ArrayList<Seat> seatData = new ArrayList<>();
    private static boolean isMovieDataLoaded = false;
    public Movie mv;
    public Schedule sc;
    
    public Database() {
        if (isMovieDataLoaded) return;
        loadMovieData();
        loadScheduleData();
        loadSeatData();
        isMovieDataLoaded = true;
    }

    public void loadMovieData() {
        movieData.add(new Movie("Godzilla", "M001", "Action", "English"));
        movieData.add(new Movie("Titanic", "M002", "Romance", "English"));
        movieData.add(new Movie("Titanic", "M003", "Romance", "English"));
        movieData.add(new Movie("Doraemon", "M004", "Animation", "Japanese"));
    }

    public void loadScheduleData() {
        scheduleData.add(new Schedule("M001", "S001", "11:00", "2025-01-28", "2 hours"));
        scheduleData.add(new Schedule("M001", "S002", "09:00", "2025-01-28", "2 hours"));
        scheduleData.add(new Schedule("M001", "S003", "08:00", "2025-01-28", "2 hours"));
        scheduleData.add(new Schedule("M001", "S004", "01:00", "2025-01-28", "2 hours"));
        scheduleData.add(new Schedule("M001", "S005", "12:00", "2025-02-27", "2 hours"));
        scheduleData.add(new Schedule("M001", "S006", "13:00", "2025-01-21", "2 hours"));
        scheduleData.add(new Schedule("M001", "S007", "14:00", "2025-02-01", "2 hours"));
        scheduleData.add(new Schedule("M002", "S008", "15:00", "2025-03-28", "1.5 hours"));
        scheduleData.add(new Schedule("M002", "S009", "13:00", "2025-04-28", "2 hours"));
        scheduleData.add(new Schedule("M003", "S010", "15:00", "2025-05-28", "1.5 hours"));
    }

    public void loadSeatData() {
        seatData.add(new Seat("S001", "SE001", 10, 9, "A1,A2,A3"));
        seatData.add(new Seat("S001", "SE001", 10, 9, "A1,A2,A3"));
        seatData.add(new Seat("S001", "SE001", 10, 9, "A1,A2,A3"));
        seatData.add(new Seat("S002", "SE002", 10, 9, "B1,B2,B3"));
        seatData.add(new Seat("S003", "SE003", 10, 9, "C1,C2,C3"));
        seatData.add(new Seat("S004", "SE004", 10, 9, "D1,D2,D3"));
        seatData.add(new Seat("S005", "SE001", 10, 9, "E1,E2,E3"));
        seatData.add(new Seat("S006", "SE002", 10, 9, "F1,F2,F3"));
        seatData.add(new Seat("S007", "SE003", 10, 9, "G1,G2,G3"));
        seatData.add(new Seat("S008", "SE004", 10, 9, "H1,H2,H3"));
        seatData.add(new Seat("S009", "SE003", 10, 9, "I1,I2,I3"));
        seatData.add(new Seat("S010", "SE004", 10, 9, "J1,J2,J3"));
    }

    public void choiceMovie() {
        mv.choiceMovie(); 
    }

    public void setSchedule(){
        sc.setSchedule();
    }

    public int movieIdSize() {
        return movieData.size();
    }

    public int scheduleIdSize() {
        return scheduleData.size();
    }

    public int bookedSeatSize() {
        return seatData.size();
    }

    public void addMovieFromMovie(Movie movie) {
        movieData.add(movie);
    }

    public void showMovieFromMovie(int count) {
        System.out.printf("\n\n%-25s%-8s%-15s%-15s\n", "Movie Name", "ID", "Type", "Language");
        Movie movie = movieData.get(count);
        System.out.printf("%-25s%-8s%-15s%-15s\n", movie.getName(), movie.getMovieId(), movie.getType(),
                movie.getLanguage());
    }

    public void showAllMovieFromMovie() {
        System.out.printf("\n\n%-5s%-25s%-8s%-15s%-15s\n", "No", "Movie Name", "ID", "Type", "Language");
        for (int i = 0; i < movieData.size(); i++) {
            Movie movie = movieData.get(i);

            System.out.printf("%-5s%-25s%-8s%-15s%-15s\n", (i + 1), movie.getName(), movie.getMovieId(),
                    movie.getType(),
                    movie.getLanguage());
        }
    }

    public void clearMovieFromMovie(String movieId) {
        for (int i = 0; i < movieData.size(); i++) {
            if (movieData.get(i).getMovieId().equals(movieId)) {
                movieData.remove(i);
                return;
            }
        }
    }

    public String getMovieNameByMovieIdFromMovie(String movieId) {
        for (int i = 0; i < movieData.size(); i++) {
            if (movieData.get(i).getMovieId().equals(movieId)) {
                return movieData.get(i).getName();
            }
        }
        return "Can't find the data";
    }

    public String getMovieNameBySomethingIntFromMovie(int choice) {
        return movieData.get(choice).getName();
    }

    public String getMovieIdBySomethingIntFromMovie(int choice) {
        return movieData.get(choice).getMovieId();
    }

    public String getPendingDateByMovieIDFromSchedule(String movieID, int index) {
        if (scheduleData.get(index).getMovieId().equals(movieID)) {
            String pendingDate = "";
            pendingDate = scheduleData.get(index).getDate();
            return pendingDate;
        } else
            return null;
    }

    public String getPendingTimeByMovieIDFromSchedule(String movieID, int index) {


        if (scheduleData.get(index).getMovieId().equals(movieID)) {
            String pendingTime = "";
            pendingTime = scheduleData.get(index).getTime();
            return pendingTime;
        } else
            return "Date";
    }

    public boolean getPendingDateByMovieIDAndSelectedDate(String movieID, int index, String selectedDate) {

        if (getMovieIdBySomthingFromSchedule(index).equals(movieID)
                && scheduleData.get(index).getDate().equals(selectedDate)) {
            return true;
        } else
            return false;
    }

    public Schedule getSchedule(int index) {
        return scheduleData.get(index);
    }

    public Seat getSeat(int index) {
        return seatData.get(index);
    }

    public String getScheduleIdBySomthingFromSchedule(int something) {
        return scheduleData.get(something).getScheduleId();
    }

    public String getMovieIdBySomthingFromSchedule(int something) {
        return scheduleData.get(something).getMovieId();
    }

    public String getDateBySomthingFromSchedule(int something) {
        return scheduleData.get(something).getDate();
    }

    public String getTimeBySomthingFromSchedule(int something) {
        return scheduleData.get(something).getTime();
    }

    public String getDurationBySomthingFromSchedule(int something) {
        return scheduleData.get(something).getDuration();
    }

    public String getScheduleIdBySomthingFromSeat(int something) {
        return seatData.get(something).getScheduleId();
    }

    public String getBookedSeatBySomthingFromSeat(int something) {
        return seatData.get(something).getBookedSeat();
    }

    public int getColumnBySomethingFromSeat(int something) {
        return seatData.get(something).getColumn();
    }

    public int getRowBySomethingFromSeat(int something) {
        return seatData.get(something).getRow();
    }
}