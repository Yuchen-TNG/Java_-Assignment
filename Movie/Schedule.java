package Movie;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Schedule {

    String scheduleId;
    String movieID;
    String time;
    String date;
    String duration;
    DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm");
    Scanner cin = new Scanner(System.in); // 加上Scanner
    private String selectedTime2;
    private String selectedDate2;

    public Schedule() {
    }

    public Schedule(String movieID, String scheduleId, String time, String date, String duration) {
        this.movieID = movieID;
        this.scheduleId = scheduleId;
        this.time = time;
        this.date = date;
        this.duration = duration;
    }

    private Database db;

    public void setDb() {
        db = new Database(); // 在这里 new，而不是构造器
    }

    public String getScheduleId() {
        return scheduleId;
    }

    public String getMovieId() {
        return movieID;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getDuration() {
        return duration;
    }

    public void setScheduleId(String scheduleId) {
        this.scheduleId = scheduleId;
    }

    public void setMovieId(String movieID) {
        this.movieID = movieID;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public void getSchedule(String movieID) {
        int e = 0;
        setDb();

        ArrayList<String> pendingDate = new ArrayList<>();
        ArrayList<String> pendingTime = new ArrayList<>();
        Seat se = new Seat();
        System.out.println("\nSchedule for: " + db.getMovieNameByMovieIdFromMovie(movieID));
        System.out.println("This is available date");

        for (int i = 0; i < db.scheduleIdSize(); i++) {
            if (db.getPendingDateByMovieIDFromSchedule(movieID, i) == null) {
            } else {
                pendingDate.add(e, db.getPendingDateByMovieIDFromSchedule(movieID, i));
                e++;
            }

        }

        // Step 2: 日期排序
        pendingDate.sort((d1, d2) -> {
            LocalDate date1 = LocalDate.parse(d1, dateFormat);
            LocalDate date2 = LocalDate.parse(d2, dateFormat);
            return date1.compareTo(date2);
        });

        // Step 3: 输出日期选项
        for (int i = 0; i < pendingDate.size(); i++) {
            System.out.println((i + 1) + ". " + pendingDate.get(i));
        }

        // Step 4: 用户选日期
        int choiceDate = 0;
        boolean wrong;
        do {
            System.out.print("Which date is preferred? \nSelect Date:");
            try {
                choiceDate = cin.nextInt();
                if (choiceDate < 1 || choiceDate > pendingDate.size()) {
                    System.out.println("Out of range. Try again.");
                    wrong = true;
                } else {
                    wrong = false;
                }
            } catch (InputMismatchException p) {
                cin.next(); // clear buffer
                System.out.println("Only numbers are allowed. Try again.");
                wrong = true;
            }
        } while (wrong);

        String selectedDate = pendingDate.get(choiceDate - 1);
        db.setUserDate(selectedDate);
        // Step 5: 找出该日期对应的时间
        e = 0;
        for (int i = 0; i < db.scheduleIdSize(); i++) {
            boolean bool = false;
            if (bool = db.getPendingDateByMovieIDAndSelectedDate(movieID, i, selectedDate)) {
                pendingTime.add(db.getPendingTimeByMovieIDFromSchedule(movieID, i));
                e++;
            }
        }

        pendingTime.sort((t1, t2) -> {
            LocalTime time1 = LocalTime.parse(t1, timeFormat);
            LocalTime time2 = LocalTime.parse(t2, timeFormat);
            return time1.compareTo(time2);
        });

        // Step 6: 输出时间选项
        System.out.println("\n\nAvailable Times:");
        for (int i = 0; i < pendingTime.size(); i++) {
            System.out.println((i + 1) + ". " + pendingTime.get(i));
        }

        // Step 7: 用户选时间
        int choiceTime = 0;
        int index = 0;
        do {
            System.out.print("\nWhich time is preferred?\nSelect Time: ");
            choiceTime = cin.nextInt();
            if (choiceTime < 1 || choiceTime > pendingTime.size()) {
                System.out.println("Out of range. Try again.");
                wrong = true;
            } else {
                wrong = false;
                for (int i = 0; i < db.scheduleIdSize(); i++) {
                    if (pendingTime.get(choiceTime - 1).equals(db.getTimeBySomthingFromSchedule(i))
                            && pendingDate.get(choiceDate - 1).equals(db.getDateBySomthingFromSchedule(i))) {
                        index = i;
                    }
                }

            }
        } while (wrong);

        String selectedTime = pendingTime.get(choiceTime - 1);
        db.setUserTime(selectedTime);

        se.showSeat(db.getScheduleIdBySomthingFromSchedule(index));

    }

    // =================================================Set
    // Schedule=======================================================
    public void setSchedule() {
        setDb();

        int selection = 0;
        int choice;
        String date = "";
        String time = "";
        String movieID = "";
        String scheduleID = "";
        String duration;

        showSchedule();
        while (true) {
            System.out.print("Selection(No): ");
            if (cin.hasNextInt()) {
                selection = cin.nextInt();
                if (selection <= db.scheduleIdSize() && selection > 0) {
                    break;
                } else {
                    System.out.println("Invalid, please input the range of schedule lists");
                }
            } else {
                System.out.println("Invalid, please enter the number");
                cin.next();
            }
        }
        Schedule slectionSchdule = db.getSchedule(selection - 1);
        do {
            System.out.println("\n=====Edit Schedule=====");
            System.out.println("1. Schedule Id");
            System.out.println("2. Movie Id");
            System.out.println("3. Date");
            System.out.println("4. Time");
            System.out.println("5. Duration");
            System.out.println("6. Save");
            System.out.println("=======================");
            System.out.print("Choice(1-6): ");
            while (!cin.hasNextInt()) {
                System.out.println("Invalid, please enter the number");
                cin.next();
                System.out.print("Choice: ");
            }
            choice = cin.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("\n=====Edit Schedule Id=====");
                    while (true) {
                        System.out.print("Schedule Id: ");
                        scheduleID = cin.next();
                        if (scheduleID.matches("^[S]\\d{3}")) {
                            break;
                        } else {
                            System.out.println(
                                    "inavalid please follow the format : (S000),first character must be S and Uppercase");
                        }
                    }
                    slectionSchdule.setScheduleId(scheduleID);
                    break;
                case 2:
                    System.out.println("\n=====Edit Movie Id=====");
                    while (true) {
                        System.out.print("Movie Id: ");
                        movieID = cin.next();
                        if (movieID.matches("^[M]\\d{3}")) {
                            break;
                        } else {
                            System.out.println(
                                    "inavalid please follow the format : (M000),first character must be M and Uppercase");
                        }
                    }
                    slectionSchdule.setMovieId(movieID);
                    break;
                case 3:
                    System.out.println("\n=====Edit Date=====");
                    while (true) {
                        System.out.print("Date: ");
                        date = cin.next();
                        if (date.matches("\\d{4}-\\d{2}-\\d{2}")) {
                            int month = Integer.parseInt(date.split("-")[1]);
                            int day = Integer.parseInt(date.split("-")[2]);
                            if(month<12&&day<31){
                            break;
                            }else{
                                System.out.println("invalid, please input the correct month and day");
                            }
                        } else {
                            System.out.println("invalid please follow the format(yyyy-mm-dd)");
                        }
                    }
                    slectionSchdule.setDate(date);
                    break;
                case 4:
                    System.out.println("\n=====Edit Time=====");
                    while (true) {
                        System.out.print("Time: ");
                        time = cin.next();
                        if (time.matches("\\d{2}:\\d{2}")) {
                            int hour = Integer.parseInt(time.split(":")[0]);
                            int minute = Integer.parseInt(time.split(":")[1]);
                            if (hour < 24 && minute < 60) {
                                break;
                            } else {
                                System.out.println("Invalid please enter the time correctly");
                            }
                        } else {
                            System.out.println("invalid please follow the format(00:00)");
                        }
                    }
                    slectionSchdule.setTime(time);
                    break;
                case 5:
                    System.out.println("\n=====Edit Duration=====");
                    while (true) {
                        System.out.print("Duration: ");
                        duration = cin.next();
                        if (duration.matches("\\d{2}:\\d{2}:\\d{2}")) {
                            int hour = Integer.parseInt(duration.split(":")[1]);
                            int second = Integer.parseInt(duration.split(":")[2]);
                            if (hour < 60 && second < 60) {
                                break;
                            }else{
                                System.out.println("Invalid please enter the time correctly cannot exceed 60 minite and second");
                            }
                        } else {
                            System.out.println("Invalid, please follow the time format (01:59:59)");
                        }
                    }
                    slectionSchdule.setDuration(duration);
                    break;
                case 6:
                    System.out.println("Save successfully");
                    break;
                default:
                    System.out.println("Invalid, please input the range of the choice ");
            }
        } while (choice != 6);
        showSchedule();

    }
    // ================================================Schedule
    // Display==========================================================

    public void showSchedule() {
        setDb();

        System.out.println("\n========================SCHEDULE LISTS========================");
        System.out.printf("%-4s %-12s %-10s %-12s %-8s %-10s\n", "No", "ScheduleId", "Movie ID", "Date", "Time",
                "Duration");
        System.out.println("--------------------------------------------------------------");

        for (int i = 0; i < db.scheduleIdSize(); i++) {
            System.out.printf("%-4d %-12s %-10s %-12s %-8s %-2s \n", (i + 1),
                    db.getScheduleIdBySomthingFromSchedule(i),
                    db.getMovieIdBySomthingFromSchedule(i), db.getDateBySomthingFromSchedule(i),
                    db.getTimeBySomthingFromSchedule(i), db.getDurationBySomthingFromSchedule(i));
        }
        System.out.println("==============================================================");
    }

    public void setDate_Time(String selectedDate, String selectedTime) {
        this.selectedDate2 = selectedDate;
        this.selectedTime2 = selectedTime;
    }

    public String[] getDateAndTime() {
        return new String[] { selectedDate2, selectedTime2 };
    }

    public String getDateAndTime2() {
        return selectedDate2 + selectedTime2;
    }

    public void setSchedule(String movieId){

    }

}
