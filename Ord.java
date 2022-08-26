
// Labb 4 DD1380
// Skriv ut startpositionen på den först förekommande unika delföljden 

// lägg till StringIndexOutOfBoundsException, sen klar!

import java.util.*;

public class Ord {

    public static void main(String[] args) {

        HashMap<String, Integer> count = new HashMap<String, Integer>();

        Scanner sc = new Scanner(System.in);

        int längd = sc.nextInt(); // läser in ordets längd
        String ord = sc.next(); // läser in hela sekvensen

        sc.close();

        int n = ord.length();

        // build hash map : ord and how often it appears
        
        for (int i = 0; i < (n-1); i += 2) { // i += 2 funkar men ger inte alla fall?

            String c = ord.substring(i, längd);
            //System.out.println(c);
            längd += 2;

            count.put(c, count.getOrDefault(c, 0) + 1);
        }

        System.out.println(count);

        // söker i hashmappen
        int i = 1;
        for(Integer value: count.values()) {

            if (value == 1) {
                System.out.println(i);
            } else if (value != 1) {
                i++;
            } else if ( i > count.size()) { // alternativt bara else
                System.out.println(-1);
            }
        } 
    }
}


