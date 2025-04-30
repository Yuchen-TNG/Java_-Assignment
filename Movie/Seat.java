package Movie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Seat {

    ArrayList<String> scheduleId = new ArrayList<>();
    ArrayList<String> id = new ArrayList<>();
    ArrayList<Integer> row = new ArrayList<>();
    ArrayList<Integer> column = new ArrayList<>();
    ArrayList<String> bookedSeat = new ArrayList<>();
    Scanner cin = new Scanner(System.in);

    public Seat() {

        addSeat("S001", "SE001", 10, 9, "A1,A2,A3");
        addSeat("S002", "SE002", 10, 9, "B1,B2,B3");
        addSeat("S003", "SE003", 10, 9, "C1,C2,C3");
        addSeat("S004", "SE004", 10, 9, "A1,A2,A3");
        addSeat("S005", "SE001", 10, 9, "A1,A2,A3");
        addSeat("S006", "SE002", 10, 9, "A1,A2,A3");
        addSeat("S007", "SE003", 10, 9, "A1,A2,A3");
        addSeat("S008", "SE004", 10, 9, "A1,A2,A3");
        addSeat("S009", "SE003", 10, 9, "A1,A2,A3");
        addSeat("S010", "SE004", 10, 9, "A1,A2,A3");

    }

    public void addSeat(String scheduleId, String id, int column, int row, String bookedSeat) {

        this.scheduleId.add(scheduleId);
        this.id.add(id);
        this.row.add(row);
        this.column.add(column);
        this.bookedSeat.add(bookedSeat);
    }

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
        System.out.print("How many seat you want to choose?");
        int people = cin.nextInt();
        System.out.print("Which seat you want?");
        for (int i = 0; i < this.scheduleId.size(); i++) {
            if (this.scheduleId.get(i).equals(scheduleId)) {
                index = i;
                break;
            }
        }

        for (int i = 0; i < people; i++) {
            String pendingSeat = cin.nextLine();
            cin.next();
            bookedSeat.add(index, "," + pendingSeat);
        }

        System.out.print(bookedSeat.get(index));
    }

}
