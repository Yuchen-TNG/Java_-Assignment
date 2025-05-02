package Movie;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import Payment.Booking;

public class Seat {
    private String scheduleId;
    private String seatId;
    private int row;
    private int column;
    private String bookedSeat;
    Scanner cin = new Scanner(System.in);
    String totalPendingSeat;
    String pendingScheduleId;
    private Booking booking = new Booking();

    public Seat() {
    }

    public Seat(String scheduleId, String seatId, int column, int row, String bookedSeat) {
        this.scheduleId = scheduleId;
        this.seatId = seatId;
        this.row = row;
        this.column = column;
        this.bookedSeat = bookedSeat;
    }

    private Database db;

    public void setDb() {
        db = new Database(); // 在这里 new，而不是构造器
    }

    public String getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(String scheduleId) {
        this.scheduleId = scheduleId;
    }

    public String getSeatId() {
        return seatId;
    }

    public void setSeatId(String seatId) {
        this.seatId = seatId;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public String getBookedSeat() {
        return bookedSeat;
    }

    public void setBookedSeat(String bookedSeat) {
        this.bookedSeat = bookedSeat;
    }

    public void showSeat(String scheduleId) {
        setDb();
        int index = -1;
        char letter = 'A';

        for (int i = 0; i < db.scheduleIdSize(); i++) {

            if (db.getScheduleIdBySomthingFromSeat(i).equals(scheduleId)) {
                pendingScheduleId = db.getScheduleIdBySomthingFromSeat(i);
                index = i;

                break;
            }
        }
        System.out.println(" __________________________");
        System.out.println("/          Screen          \\");
        System.out.println("");
        ArrayList<String> bookedList = new ArrayList<>(
        Arrays.asList(db.getBookedSeatBySomthingFromSeat(index).split(",")));
        for (int r = 0; r < db.getRowBySomethingFromSeat(5); r++) {
            System.out.print(" " + (r + 1) + " ");
        }
        System.out.println();

        for (int j = 0; j < db.getColumnBySomethingFromSeat(1); j++) {
            for (int e = 0; e < db.getRowBySomethingFromSeat(1); e++) {
                String seatCode = "" + letter + (e + 1); // 生成座位编号，如 A1, A2, B1...
                if (bookedList.contains(seatCode)) {
                    System.out.print("[X]");
                } else {
                    System.out.print("[ ]");
                }
            }
            System.out.println("  " + letter); // 行标签 A, B, ...
            letter++;
        }

        // 输出列号
        System.out.println();

        selectSeat(scheduleId);
    }

    public void selectSeat(String scheduleId) {
        Database db = new Database();
        int index = -1;
        int people = 0;
        Scanner cin = new Scanner(System.in);
        boolean bool = true;

        do {
            try {
                System.out.print("How many seats do you want to choose?\nNumber of people: ");
                people = cin.nextInt();
                db.setUserNumberOfPerson(people);
                bool = false;
            } catch (Exception e) {
                System.out.println("Enter valid number,try again");
                bool = true;
                cin.nextLine();
            }
        } while (bool);
        totalPendingSeat = Integer.toString(people);

        // 查找对应的排期
        System.out.println("\nWhich seat you want?");
        for (int i = 0; i < db.scheduleIdSize(); i++) {
            if (db.getScheduleIdBySomthingFromSeat(i).equals(scheduleId)) {
                index = i;
                break;
            }
        }
        cin.nextLine();
        int e = 0;
        if (index != -1 && db.bookedSeatSize() > index) {
            for (int i = 0; i < people; i++) {
                do {
                    e++;
                    System.out.print(e + ". Seat Number: ");
                    String pendingSeat = cin.nextLine();
                    if (pendingSeat.matches("[A-J][1-9]")) {
                        Seat selectBookedSeat = db.getSeat(index);
                        String existing = selectBookedSeat.getBookedSeat();
                        if (existing.contains(pendingSeat)) {
                            System.out.println("That seat is already booked. Please choose another one.");
                            e--;
                            bool = true;
                        } else {
                            db.setUserSeatNumber(existing + "," + pendingSeat);
                            selectBookedSeat.setBookedSeat(existing + "," + pendingSeat);
                            bool = false;
                        }
                    } else {
                        bool = true;
                        System.out.println("\nEnter invalid,try again\nWhich seat you want?");
                        e--;
                    }
                } while (bool);

                booking.setTicket(db.getUserMovie(), db.getUserDate(), db.getUserTime(), db.getUserSeatNumber(),
                        db.getUserNumberOfPerson());
            }
        } else {
            System.out.println("Invalid schedule or no seats available.");
        }
        booking.displayticket();
    }


    public String[] storeAllValue() {
        Schedule sc = new Schedule();
        return new String[] { pendingScheduleId, totalPendingSeat, sc.getDateAndTime2() };
    }

    public void editSeat() {
        setDb();

        int selection = 0;
        int choice;
        String scheduleID = "";
        String seatId = "";
        int row = 0;
        int column = 0;
        String bookedSeat = "";

        showSeatDetails();
        while (true) {
            System.out.print("Selection(No): ");
            if (cin.hasNextInt()) {
                selection = cin.nextInt();
                if (selection <= db.seatIdSize() && selection > 0) {
                    break;
                } else {
                    System.out.println("Invalid, please input the range of schedule lists");
                }
            } else {
                System.out.println("Invalid, please enter the number");
                cin.next();
            }
        }
        Seat slectionSeat = db.getSeat(selection - 1);
        do {
            System.out.println("\n======Edit Seat======");
            System.out.println("1. Schedule Id");
            System.out.println("2. Seat Id");
            System.out.println("3. Row");
            System.out.println("4. Column");
            System.out.println("5. BookedSeat");
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
                    slectionSeat.setScheduleId(scheduleID);
                    break;
                case 2:
                    System.out.println("\n=====Edit Seat Id=====");
                    while (true) {
                        System.out.print("Seat Id: ");
                        seatId = cin.next();
                        if (seatId.matches("^[S][E]\\d{3}")) {
                            break;
                        } else {
                            System.out.println(
                                    "inavalid please follow the format : (SE000),first character must be SE and Uppercase");
                        }
                    }
                    slectionSeat.setSeatId(seatId);
                    break;
                case 3:
                    System.out.println("\n=====Edit Row=====");
                    while(true){
                        System.out.print("Row: ");
                        row = cin.nextInt();
                        if(row <= 9){
                            break;
                        }else{
                            System.out.println("Invalid, the hall is not enough space to add the seat");
                        }
                    }
                    slectionSeat.setRow(row);
                    break;
                case 4:
                    System.out.println("\n=====Edit Column=====");
                    while(true){
                        System.out.print("Column: ");
                        column = cin.nextInt();
                        if(column <= 10){
                            break;
                        }else{
                            System.out.println("Invalid, the hall is not enough space to add the seat");
                        }
                    }
                    slectionSeat.setColumn(column);
                    break;
                case 5:
                    System.out.println("\n=====Edit BookedSeat=====");
                    
                        System.out.print("BookedSeat: ");
                        bookedSeat = cin.next();
                       
                    slectionSeat.setBookedSeat(bookedSeat);
                    break;
                case 6:
                    System.out.println("Save successfully");
                    break;
                default:
                    System.out.println("Invalid, please input the range of the choice ");
            }
        } while (choice != 6);
        showSeatDetails();
    }

    public void showSeatDetails() {
        setDb();

        System.out.println("\n============================SEATS LISTS============================");
        System.out.printf("%-4s %-12s %-10s %-12s %-8s %-10s\n", "No", "ScheduleId", "Seat Id", "Column", "Row",
                "Booked Seat");
        System.out.println("-------------------------------------------------------------------");

        for (int i = 0; i < db.seatIdSize(); i++) {
            System.out.printf("%-4d %-12s %-10s %-12s %-8s %-2s \n", (i + 1),
                    db.getScheduleIdBySomthingFromSeat(i),
                    db.getSeatId(i), db.getColumn(i),
                    db.getRow(i), db.getBookedSeatBySomthingFromSeat(i));
        }
        System.out.println("===================================================================");
    public void setSeat(String scheduleId){
        
    }
}

