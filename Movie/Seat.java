package Movie;

import java.util.ArrayList;

public class Seat {
    ArrayList<String> scheduleId = new ArrayList<>();
    ArrayList<String> id = new ArrayList<>();
    ArrayList<Integer> row = new ArrayList<>();
    ArrayList<Integer> column = new ArrayList<>();

    public Seat() {
        addSeat("S001", "SE001", 10, 20);
        addSeat("S002", "SE002", 10, 20);
        addSeat("S003", "SE003", 10, 20);
        addSeat("S004", "SE004", 10, 20);
        addSeat("S005", "SE001", 10, 20);
        addSeat("S006", "SE002", 10, 20);
        addSeat("S007", "SE003", 10, 20);
        addSeat("S008", "SE004", 10, 20);
        addSeat("S009", "SE003", 10, 20);
        addSeat("S010", "SE004", 10, 20);

    }

    public void addSeat(String scheduleId, String id, int row, int column) {
        this.scheduleId.add(scheduleId);
        this.id.add(id);
        this.row.add(row);
        this.column.add(column);
    }

    public void showSeat(String scheduleId) {
        int index = 0;
        System.out.println(scheduleId);
        for (int i = 0; i < this.scheduleId.size(); i++) {
            System.out.println("2");
            if (this.scheduleId.get(i).equals(scheduleId)) {
                System.out.println("3");
                for (int j = 0; column.get(index) > j; j++) {
                    for (int e = 0; e < row.get(index); e++) {
                        System.out.print("[ ]");
                    }
                    System.out.println("");
                }
            } else {
                index++;
            }
        }
    }

}
