import java.util.ArrayList;
import java.util.Scanner;

public class Movie {

    Scanner cin = new Scanner(System.in);
    ArrayList<String> Name = new ArrayList<>();
    ArrayList<String> ID = new ArrayList<>();
    ArrayList<String> Type = new ArrayList<>();
    ArrayList<String> Language = new ArrayList<>();
    ArrayList<String> Language = new ArrayList<>();
    ArrayList<String> Language = new ArrayList<>();
    int i=0;
    int e = -1;

    public Movie() {
        addMovie("Godzilla", "M001", "Action", "English");
        addMovie("Titanic", "M002", "Romance", "English");
        addMovie("Doraemon", "M003", "Animation", "Japanese");
    }

    public void addMovie(String Name, String ID, String Type, String Language) {
        this.Name.add(Name);
        this.ID.add(ID);
        this.Type.add(Type);
        this.Language.add(Language);
    }

    public void setMovie() {
        System.out.println("\n\nHow many movie you want add?");
        int addMovie = cin.nextInt();
        cin.nextLine();
        int count = Name.size() - 1;
        int check = 0;
        if (addMovie >= 1) {
            for (int i = 0; i < addMovie; i++) {

                System.out.print("\n\nMovie Name : ");
                String MovieName = cin.nextLine();
                Name.add(MovieName);
                boolean bool = false;
                do {
                    System.out.print("Movie ID : ");
                    String MovieID = cin.nextLine();
                    if (MovieID.length() == 4 && Character.isUpperCase(MovieID.charAt(0))
                            && Character.isDigit(MovieID.charAt(1)) && Character.isDigit(MovieID.charAt(2))
                            && Character.isDigit(MovieID.charAt(3))) {
                        ID.add(MovieID);
                        bool = false;
                    } else {
                        System.out.print("Your Movie ID is wrong format\n");
                        bool = true;
                    }
                } while (bool);

                System.out.print("Movie Type : ");
                String MovieType = cin.nextLine();
                Type.add(MovieType);

                System.out.print("Movie Language : ");
                String MovieLan = cin.nextLine();
                Language.add(MovieLan);
                count++;
                do {
                    System.out.printf("\n\n%-25s%-8s%-15s%-15s\n", "Movie Name", "ID", "Type", "Language");
                    System.out.printf("%-25s%-8s%-15s%-15s\n", Name.get(count), ID.get(count), Type.get(count),
                            Language.get(count));
                    System.out.println("\n\nAre you sure you want to add into Library? (Yes / No)");
                    String choice = cin.nextLine().trim();
                    if (choice.equalsIgnoreCase("yes") || choice.equalsIgnoreCase("y")) {
                        check++;
                        System.out.println("\n\nYour Movie has been add");
                        bool = false;

                    } else if (choice.equalsIgnoreCase("no") || choice.equalsIgnoreCase("n")) {

                        Name.remove(count);
                        ID.remove(count);
                        Type.remove(count);
                        Language.remove(count);
                        count--;
                        i--;
                        bool = false;
                    } else {
                        System.err.println("\n\nWe can't understand your input, please try again");
                        bool = true;
                    }
                } while (bool);

                if (check == addMovie) {
                    getMovie();
                } else {
                    continue;
                }
            }
        } else {
            return;
        }
    }

    public void clearMovie() {
        boolean check = true;
        System.out.println("\n\nDelete Movie List");
        System.out.print("Movie ID delete:");
        String id = cin.nextLine();

        for (i = 0; i < ID.size(); i++) {
            if (id.equals(ID.get(i))) {
                e++;
                check = true;
                i=ID.size()-1;
            } else {
                check = false;
            }
        }

        if (check) {

            do {
                System.out.println("\nAre you sure you want to delete this Movie : " + Name.get(e));
                String choice = cin.nextLine();
                if (choice.equalsIgnoreCase("Yes") || choice.equalsIgnoreCase("y")) {
                    Name.remove(e);
                    ID.remove(e);
                    Type.remove(e);
                    Language.remove(e);
                    System.out.println("\n\nMovie " + Name.get(e) + " have been deleted");
                    check = false;

                } else if (choice.equalsIgnoreCase("No") || choice.equalsIgnoreCase("n")) {
                    check = false;
                } else {
                    System.out.println("We don't understand your input");
                    check = true;
                }
            } while (check);
        } else {
            System.out.println("\n\nSystem can't find the Movie Details");
        }
        return;
    }

    public void getMovie() {
        System.out.printf("\n\n%-3s%-25s%-8s%-15s%-15s\n", "No", "Movie Name", "ID", "Type", "Language");
        for (i = 0; i <= Name.size() - 1; i++) {
            System.out.printf("%-3d%-25s%-8s%-15s%-15s\n", i + 1, Name.get(i), ID.get(i), Type.get(i), Language.get(i));
        }
    }

    public String[] getID(){
        String[] movieid=new String[ID.size()];
        for(i=0;i<ID.size();i++){
            movieid[i]=ID.get(i);
        }
        return movieid;
    }
}
