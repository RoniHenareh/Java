
// Labb 4 DD1380
// Skriv ut startpositionen på den först förekommande unika delföljden 

import java.util.*;
import java.util.Map.Entry;

public class Ord {

    public static void main(String[] args) { 

        // använder som dic
        // ordet : antal gånger ordet förekommer
        LinkedHashMap<String, Integer> count = new LinkedHashMap<String, Integer>();

        Scanner sc = new Scanner(System.in);

        long längd = sc.nextLong(); // läser in ordets längd
        String ord = sc.next(); // läser in hela sekvensen

        sc.close();

        long n = ord.length(); // hela sekvensens längd
        //System.out.println(n);

        long test = längd - 1; // villkor
        for (int i = 0; i < (n - test); i ++) {

            // kollar på delar av längden storlek för varje i
            String c = ord.substring((int)i, (int)längd);
            //System.out.println(c);
            längd += 1; // stegar

            // lägger till i vår "dict"
            count.put(c, count.getOrDefault(c, 0) + 1);

        }

        //System.out.println(count);

        // sök i hashmappen
        Integer value = 1;
        String svar;

        boolean found = false;

        // iterate each entry of hashmap
        for(Entry<String, Integer> entry: count.entrySet()) {

            // hittar unika ordet
            if(entry.getValue() == value) {
            
                svar = entry.getKey();
                //System.out.println(svar);
                found = true;

                // printar rätt index
                long p = ord.indexOf(svar);
                System.out.println(p);
                break;
            }
        }
        
        if (!found) {
            System.out.println("-1"); 
        }
    }
}



