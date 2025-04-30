import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Schedule {

    ArrayList<String> scheduleId = new ArrayList<>();
    ArrayList<String> movieID = new ArrayList<>();
    ArrayList<String> time = new ArrayList<>();
    ArrayList<String> date = new ArrayList<>();
    ArrayList<Double> duration = new ArrayList<>();
    DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm");
    Scanner cin = new Scanner(System.in); // 加上Scanner

    public Schedule() {
        addSchedule("S001", "M001", "11:00", "2025-01-28", 2);
        addSchedule("S002", "M001", "12:00", "2025-02-27", 2);
        addSchedule("S003", "M001", "13:00", "2025-01-21", 2);
        addSchedule("S004", "M001", "14:00", "2025-02-01", 2);
        addSchedule("S005", "M002", "15:00", "2025-03-28", 1.5);
        addSchedule("S006", "M002", "13:00", "2025-04-28", 2);
        addSchedule("S007", "M003", "15:00", "2025-05-28", 1.5);
    }

    public void addSchedule(String scheduleId, String movieID, String time, String date, double duration) {
        this.scheduleId.add(scheduleId);
        this.movieID.add(movieID);
        this.time.add(time);
        this.date.add(date);
        this.duration.add(duration);
    }

    // ===============================================Get Schedule==============================================================
    public String[] getSchedule(String movieID) {
        ArrayList<String> pendingDate = new ArrayList<>();
        ArrayList<String> pendingTime = new ArrayList<>();
        Movie mv = new Movie();

        System.out.println("\nSchedule for: " + mv.getMovieNameById(movieID));

        // Step 1: 找出此电影的所有日期
        for (int i = 0; i < this.date.size(); i++) {
            if (this.movieID.get(i).equals(movieID)) {
                if (!pendingDate.contains(date.get(i))) {
                    pendingDate.add(date.get(i));
                }
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
            System.out.print("Which date is preferred? ");
            try {
                choiceDate = cin.nextInt();
                if (choiceDate < 1 || choiceDate > pendingDate.size()) {
                    System.out.println("Out of range. Try again.");
                    wrong = true;
                } else {
                    wrong = false;
                }
            } catch (InputMismatchException e) {
                cin.next(); // clear buffer
                System.out.println("Only numbers are allowed. Try again.");
                wrong = true;
            }
        } while (wrong);

        String selectedDate = pendingDate.get(choiceDate - 1);

        // Step 5: 找出该日期对应的时间
        for (int i = 0; i < this.time.size(); i++) {
            if (this.movieID.get(i).equals(movieID) && this.date.get(i).equals(selectedDate)) {
                pendingTime.add(this.time.get(i));
            }
        }

        // Step 6: 输出时间选项
        System.out.println("Available times:");
        for (int i = 0; i < pendingTime.size(); i++) {
            System.out.println((i + 1) + ". " + pendingTime.get(i));
        }

        // Step 7: 用户选时间
        int choiceTime = 0;
        do {
            System.out.print("Which time is preferred? ");
            try {
                choiceTime = cin.nextInt();
                if (choiceTime < 1 || choiceTime > pendingTime.size()) {
                    System.out.println("Out of range. Try again.");
                    wrong = true;
                } else {
                    wrong = false;
                }
            } catch (InputMismatchException e) {
                cin.next(); // clear buffer
                System.out.println("Only numbers are allowed. Try again.");
                wrong = true;
            }
        } while (wrong);

        String selectedTime = pendingTime.get(choiceTime - 1);

        // Step 8: 打印最终确认信息
        for (int i = 0; i < this.movieID.size(); i++) {
            if (this.movieID.get(i).equals(movieID)
                    && this.date.get(i).equals(selectedDate)
                    && this.time.get(i).equals(selectedTime)) {
                System.out.println("\n Your selected schedule:");
                System.out.printf(" Movie ID: %s\n Date: %s\n Time: %s\n Duration: %s\n",
                        this.movieID.get(i), this.date.get(i), this.time.get(i), this.duration.get(i));
                break;
            }
        }
        return new String[]{selectedDate, selectedTime};
    }

    // =================================================Set Schedule=======================================================
    public void setSchedule() {
        int selection;
        int choice;
        String date = "";
        String time = "";
        String movieID = "";
        String scheduleID = "";
        double duration = 0.0;

        showSchedule();
        while (true) {
            System.out.print("Selection: ");
            if (cin.hasNextInt()) {
                selection = cin.nextInt();
                if (selection <= scheduleId.size() && selection > 0) {
                    break;
                } else {
                    System.out.println("Invalid, please input the range of schedule lists");
                }
            } else {
                System.out.println("Invalid, please enter the number");
                cin.next();
            }
        }
        do {
            System.out.println("\n=====Edit Schedule=====");
            System.out.println("1. Schedule Id");
            System.out.println("2. Movie Id");
            System.out.println("3. Date");
            System.out.println("4. Time");
            System.out.println("5. Duration");
            System.out.println("6. Save");
            System.out.println("=======================");
            while (true) {
                System.out.print("Choice: ");
                if (cin.hasNextInt()) {
                    choice = cin.nextInt();//-------------------------------------
                    




                    if (choice <= 6 && choice > 0) {
                        break;
                    } else {
                        System.out.println("Invalid, please input the range of the choice ");
                    }
                } else {
                    System.out.println("Invalid, please enter the number");
                    cin.next();
                }
            }

            switch (choice) {
                case 1:
                    System.out.println("\n=====Edit Schedule Id=====");
                    System.out.print("Schedule Id: ");
                    scheduleID = cin.next();
                    this.scheduleId.set(selection - 1, scheduleID);
                    break;
                case 2:
                    System.out.println("\n=====Edit Movie Id=====");
                    while (true) {
                        System.out.print("Movie Id: ");
                        movieID = cin.next();
                        if (movieID.matches("^[M]\\d{3}")) {
                            break;
                        } else {
                            System.out
                                    .println(
                                            "inavalid please follow the format : (M000),first character must be M and Uppercase");
                        }
                    }
                    this.movieID.set(selection - 1, movieID);
                    break;
                case 3:
                    System.out.println("\n=====Edit Date=====");
                    while (true) {
                        System.out.print("Date: ");
                        date = cin.next();
                        if (date.matches("\\d{4}-\\d{2}-\\d{2}")) {
                            break;
                        } else {
                            System.out.println("invalid please follow the format(yyyy-mm-dd)");
                        }
                    }
                    this.date.set(selection - 1, date);
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
                    this.time.set(selection - 1, time);
                    break;
                case 5:
                    System.out.println("\n=====Edit Duration=====");
                    while (true) {
                        System.out.print("Duration: ");
                        if (cin.hasNextDouble() || cin.hasNextInt()) {
                            duration = cin.nextDouble();
                            break;
                        } else {
                            System.out.println("Invalid, please input the number");
                            cin.next();
                        }
                    }
                    this.duration.set(selection - 1, duration);
                    break;
                case 6:
                    break;
            }
        } while (choice != 6);
        showSchedule();

    }
    // ================================================Schedule Display==========================================================

    public void showSchedule() {
        System.out.println("\n========================SCHEDULE LISTS========================");
        System.out.printf("%-4s %-12s %-10s %-12s %-8s %-10s\n", "No", "ScheduleId", "Movie ID", "Date", "Time",
                "Duration");
        System.out.println("--------------------------------------------------------------");

        for (int i = 0; i < scheduleId.size(); i++) {
            System.out.printf("%-4d %-12s %-10s %-12s %-8s %-2s hours\n", (i + 1), this.scheduleId.get(i),
                    this.movieID.get(i), this.date.get(i), this.time.get(i), this.duration.get(i));
        }
        System.out.println("==============================================================");
    }
}
