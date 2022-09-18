import java.util.*;

// class som representerar varje person
class Student implements Comparable<Student> {

    // defines what it means to be an person
    String date;
    String FirstName;
    String LastName;
    int points;

    // constructor
    public Student(String date, String FirstName, String LastName, int points) {

        // This keyword refers to current instance itself
        this.date = date;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.points = points;
    }

    // för att printa:
    public String getDate() {

        return date;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return LastName;

    }

    public int getPoints(){
        
        return points;
    }
   
    @Override
    public String toString(){
        return(this.getDate() + " "  + this.getFirstName() +  " "  + this.getLastName() + " "  + this.getPoints());
    }

    // metod för att sortera
    public int compareTo(Student obj) {

        // först på efternamn
        if (!this.LastName.equals(obj.getLastName())) {
            return this.LastName.compareTo(obj.getLastName());

            // sen på efternamn
        } else if (!this.FirstName.equals(obj.getFirstName())) {
            return this.FirstName.compareTo(obj.getFirstName());

            // visa endast det högsta resultatet
        } else if (this.points != obj.getPoints()) {

            if (this.points < obj.getPoints()) {
                return -1;
            }
            return 1;

        } else {
            return -this.date.compareTo(obj.getDate());
        } 
    }

}

// main klassen
class Sort { 

    // metod för att ta bort dubletter
    static boolean hasName(List<Student> student, String firstName, String lastName) {

        for (int i = 0; i < student.size(); i++) {
            Student s = student.get(i);
            if (s.getFirstName().equals(firstName) && s.getLastName().equals(lastName)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        String slutdatum = sc.next();

        // lista för att lagra student objekt
        ArrayList<Student> ar = new ArrayList<Student>();

        for (int i = 0; i < N; i++) {

            String datum = sc.next();
            String förnamn = sc.next();
            String efternamn = sc.next();
            int poäng = sc.nextInt();

            // tar endast med data tills slutdatumet
            if (slutdatum.compareTo(datum) >= 0) { 

                // skapar student objekt
                Student obj = new Student(datum, förnamn, efternamn, poäng);

                ar.add(obj);

            } else {
                continue; // hoppa över
            }
        }
        sc.close();

        boolean ans = ar.isEmpty();

        if (ans == false) {

            // sortera enligt kraven
            Collections.sort(ar);

            // ta bort dubletter
            ar.removeIf(s -> (hasName(ar.subList(ar.indexOf(s)+1, ar.size()), s.getFirstName(), s.getLastName())));
            
            // printar hela listan
            for (int i = 0; i < ar.size(); i++) { 
                System.out.println(ar.get(i));
            }

        } else {
            System.out.println("EMPTY");
        }
    }
}