
// labb 1 DD1380
// Addera två namn

import java.util.Scanner; 

public class Namn {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        String allaNamn = "";

        for (int i = 0; i<n; i++) {

            String namn;
            namn = sc.next();

            allaNamn += namn;
        }
        sc.close();

        System.out.println(allaNamn);

    }
    
}
