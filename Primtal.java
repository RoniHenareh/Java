
// labb 2 DD1380 
// hittar minsta primtalsfaktorn för en summa

import java.util.Scanner; 

public class Primtal {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int summa = 0;
        for (int i = 0; i<n; i++) {

            int tal;
            tal = sc.nextInt();

            summa += tal;
        }
        sc.close();
        
        // hitta nu minsta primtalsfaktorn av summan  
        System.out.println(smallestDivisor(summa));
    }
  
    // flera funktioner i samma klass
    static int smallestDivisor(int n) { // retunerar och tar en int
        
        // om delbart med 2
        if (n % 2 == 0)
            return 2;
     
        // börjar från 3 och stegar med 2 så länge i * i <= n
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0)
                return i;
        }
     
        return n;
    }
}    

