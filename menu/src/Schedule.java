
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class Schedule extends Movie {
    DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    ArrayList<String> movieID = new ArrayList<>();
    ArrayList<String> time = new ArrayList<>();
    ArrayList<String> date = new ArrayList<>();
    ArrayList<String> duration = new ArrayList<>();
    boolean wrong = true;

    public Schedule() {
        addSchedule("M001", "10:00", "2025-01-28", "  2 hours");
        addSchedule("M001", "13:00", "2025-02-27", "  2 hours");
        addSchedule("M001", "10:00", "2025-01-21", "  2 hours");
        addSchedule("M001", "13:00", "2025-02-01", "  2 hours");
        addSchedule("M002", "15:00", "2025-03-28", "1.5 hours");
        addSchedule("M002", "13:00", "2025-04-28", "  2 hours");
        addSchedule("M003", "15:00", "2025-05-28", "1.5 hours");
    }

    public void addSchedule(String movieID, String time, String date, String duration) {
        this.movieID.add(movieID);
        this.time.add(time);
        this.date.add(date);
        this.duration.add(duration);
    }

    public void getSchedule(String movieID) {
        Movie mv = new Movie();
        ArrayList<String> pendingDate = new ArrayList<>();
        ArrayList<String> pendingTime = new ArrayList<>();
        System.out.println(mv.getMovieNameById(movieID) + " :");
        for (int i = 0; i < this.time.size(); i++) {
            if (this.movieID.get(i).equals(movieID)) {
                pendingDate.add(0, date.get(i));
            }
        }

        pendingDate.sort((d1, d2) -> {
            LocalDate date1 = LocalDate.parse(d1, dateFormat);
            LocalDate date2 = LocalDate.parse(d2, dateFormat);
            return date1.compareTo(date2);
        });
        for (int i = 0; i < pendingDate.size(); i++) {
            System.out.println((i + 1) + ".   " + pendingDate.get(i));
        }
        System.out.println("Which date is perform with you?");
        do {
            try {
                int choice = cin.nextInt();
                if (choice > pendingDate.size() || choice <= 0) {
                    System.out.println("Out of number, please try again");
                    wrong = true;
                } else {
                    wrong = false;
                }
            } catch (InputMismatchException e) {
                cin.next();
                System.out.println("It only accept for number, please try again");
                wrong = true;
            }
        } while (wrong);


        /*
         * System.out.print((index+1)+". ");
         * System.out.printf("%-10s %-15s %-15s",
         * "Time: " + time.get(i),
         * "     Date: " + date.get(i),
         * "     Duration: " + duration.get(i)+"\n");
         */
    }

    public void setSchedule() {

    }
}