package Movie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Seat {
    Database db = new Database();
    private String scheduleId;
    private String seatId;
    private int row;
    private int column;
    private String bookedSeat;
    Scanner cin = new Scanner(System.in);
    String totalPendingSeat;
    String pendingScheduleId;

    public Seat() {
    }

    public Seat(String scheduleId, String seatId, int column, int row, String bookedSeat) {
        this.scheduleId = scheduleId;
        this.seatId = seatId;
        this.row = row;
        this.column = column;
        this.bookedSeat = bookedSeat;
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
        int index = -1;
        char letter = 'A';
        System.out.println(scheduleId);

        // 找到对应的 schedule index
        for (int i = 0; i < db.scheduleIdSize(); i++) {
            if (db.getScheduleIdBySomthingFromSeat(i).equals(scheduleId)) {
                pendingScheduleId=db.getScheduleIdBySomthingFromSeat(i);
                index = i;
                break;
            }
        }

        // 把 "A1,B3,D6" 变成 List<String>
        ArrayList<String> bookedList = new ArrayList<>(
                Arrays.asList(db.getBookedSeatBySomthingFromSeat(index).split(",")));

        for (int j = 0; j < getColumn(); j++) {
            for (int e = 0; e < getRow(); e++) {
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
        for (int r = 0; r < getRow(); r++) {
            System.out.print(" " + (r + 1) + " ");
        }
        System.out.println();

        selectSeat(scheduleId);
    }

    public void selectSeat(String scheduleId) {
        int index = -1;
        int people = 0;
        Scanner cin = new Scanner(System.in);
        boolean bool = true;

        do {
            try {
                System.out.print("How many seats do you want to choose? ");
                people = cin.nextInt();
                bool = false;
            } catch (Exception e) {
                System.out.println("Enter valid number,try again");
                bool = true;
                cin.nextLine();
            }
        } while (bool);
        totalPendingSeat=Integer.toString(people);

        // 查找对应的排期
        System.out.println("Which seat you want? ");
        for (int i = 0; i < db.scheduleIdSize(); i++) {
            if (db.getScheduleIdBySomthingFromSeat(i).equals(scheduleId)) {
                index = i;
                break;
            }
        }
        cin.nextLine();
        if (index != -1 && db.bookedSeatSize() > index) {
            for (int i = 0; i < people; i++) {
                do {
                    String pendingSeat = cin.nextLine();
                    if (pendingSeat.matches("[A-J][1-9]")) {
                        Seat selectBookedSeat = db.getSeat(index);
                        selectBookedSeat.setBookedSeat(pendingSeat);
                        bool = false;
                    } else {
                        bool = true;
                        System.out.println("Enter invalid,try again\nWhich seat you want?");
                    }
                } while (bool);

            }
            System.out.print(getBookedSeat()); // 打印更新后的座位信息
        } else {
            System.out.println("Invalid schedule or no seats available.");
        }
    }


    public String[] storeAllValue() {
        Schedule sc = new Schedule();
        return new String[] { pendingScheduleId, totalPendingSeat, sc.getDateAndTime2() };
    }
}
