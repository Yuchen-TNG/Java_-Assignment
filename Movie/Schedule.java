import java.util.ArrayList;

public class Schedule extends Movie {
    
    ArrayList<String> time = new ArrayList<>();
    ArrayList<String> date = new ArrayList<>();
    ArrayList<String> duration = new ArrayList<>();
    
    public Schedule(){
    }

    public void addSchedule(String time, String date, String duration){
        this.time.add(time);
        this.date.add(date);
        this.duration.add(duration);
    }
}