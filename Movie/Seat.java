package Movie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import Payment.Booking;

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
        addSeat("S004", "SE004", 10, 9, "D1,D2,D3");
        addSeat("S005", "SE001", 10, 9, "E1,E2,E3");
        addSeat("S006", "SE002", 10, 9, "F1,F2,F3");
        addSeat("S007", "SE003", 10, 9, "G1,G2,G3");
        addSeat("S008", "SE004", 10, 9, "H1,H2,H3");
        addSeat("S009", "SE003", 10, 9, "I1,I2,I3");
        addSeat("S010", "SE004", 10, 9, "J1,J2,J3");

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
        int people=0;
        boolean bool = true;
        Scanner cin = new Scanner(System.in);
        
        // 获取用户输入座位数
        do {
            System.out.print("How many seats do you want to choose? ");
            try {
                people = cin.nextInt();
                cin.nextLine();  // 清除换行符
                bool = false;  // 继续下一步，因为输入是有效数字
            } catch (Exception e) {
                System.out.print("Enter a valid number, please try again: ");
                cin.next();  // 清除无效输入
                bool = true;  // 继续循环
            }
        } while (bool);

        // 查找对应的排期
        System.out.print("Which seat you want? ");
        for (int i = 0; i < this.scheduleId.size(); i++) {
            if (this.scheduleId.get(i).equals(scheduleId)) {
                index = i;
                break;
            }
        }

        if (index != -1 && bookedSeat.size() > index) {
            System.out.print(bookedSeat.get(index));
            // 选择座位
            for (int i = 0; i < people; i++) {
                String pendingSeat = cin.nextLine();
                // 如果想要添加到座位字符串中，应该是拼接而不是插入
                bookedSeat.set(index, bookedSeat.get(index) + "," + pendingSeat);
            }
            System.out.print(bookedSeat.get(index)); // 打印更新后的座位信息
        } else {
            System.out.println("Invalid schedule or no seats available.");
        }
    }

}
