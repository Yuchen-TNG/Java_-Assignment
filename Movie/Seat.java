package Movie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class Seat {

    ArrayList<String> scheduleId = new ArrayList<>();
    ArrayList<String> seatId = new ArrayList<>();
    ArrayList<Integer> row = new ArrayList<>();
    ArrayList<Integer> column = new ArrayList<>();
    ArrayList<String> bookedSeat = new ArrayList<>();
    String totalPendingSeat;
    String pendingScheduleId;
    Scanner cin = new Scanner(System.in);

    public Seat() {}

    public Seat(String scheduleId, String seatId, int column, int row, String bookedSeat) {}


    public void showSeat(String scheduleId) {
        int index = -1;
        char letter = 'A';
        System.out.println(scheduleId);

        // 找到对应的 schedule index
        for (int i = 0; i < this.scheduleId.size(); i++) {
            if (this.scheduleId.get(i).equals(scheduleId)) {
                index = i;
                break;
            }
        }

        // 把 "A1,B3,D6" 变成 List<String>
        ArrayList<String> bookedList = new ArrayList<>(Arrays.asList(bookedSeat.get(index).split(",")));
        

        for (int j = 0; j < column.get(index); j++) {
            for (int e = 0; e < row.get(index); e++) {
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
        for (int r = 0; r < row.get(index); r++) {
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

        // 查找对应的排期
        System.out.println("Which seat you want? ");
        for (int i = 0; i < this.scheduleId.size(); i++) {
            if (this.scheduleId.get(i).equals(scheduleId)) {
                index = i;
                break;
            }
        }
        cin.nextLine();
        if (index != -1 && bookedSeat.size() > index) {
            for (int i = 0; i < people; i++) {
                do {
                    String pendingSeat = cin.nextLine();
                    if (pendingSeat.matches("[A-J][1-9]")) {
                        bookedSeat.set(index, bookedSeat.get(index) + "," + pendingSeat);
                        bool = false;
                    } else {
                        bool = true;
                        System.out.println("Enter invalid,try again\nWhich seat you want?");
                    }
                } while (bool);

            }
            System.out.print(bookedSeat.get(index)); // 打印更新后的座位信息
        } else {
            System.out.println("Invalid schedule or no seats available.");
        }
    }

    public void setPendingSeat(String totalPendingSeat,String scheduleId){
        this.totalPendingSeat=totalPendingSeat;
        this.pendingScheduleId=scheduleId;
    }

    public String[] storeAllValue(){
        Schedule sc=new Schedule();
        return new String[]{pendingScheduleId,totalPendingSeat,sc.getDateAndTime2()};
    }
}
