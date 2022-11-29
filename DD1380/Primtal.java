
// labb 2 DD1380 
// hittar minsta primtalsfaktorn för en summa

import java.util.Scanner; 

public class Primtal {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        long summa = 0;
        for (int i = 0; i<n; i++) {

            long tal = sc.nextLong();

            // aderar alla tal
            summa += tal;
        }
        sc.close();
        
        // hitta nu minsta primtalsfaktorn av summan  
        System.out.println(smallestDivisor(summa));
    }

    static long smallestDivisor(long summan) { // retunerar och tar en int
        
        // om delbart med 2
        if (summan % 2 == 0)
            return 2;
     
        // börjar från 3 och stegar med 2 så länge i * i <= summan
        for (int i = 3; i * i <= summan; i += 2) {
            if (summan % i == 0)
                return i; 
        }
     
        return summan; // om ej hittar
    }
}    

