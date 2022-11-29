import java.util.*; 
import java.io.*;

public class Island {

    public static void main(String[] args) throws IOException {

        int[] input = new int[2]; // En array för att lagra input

        int water = 0;
        char island = '@';

        // snabbare alternativ till Scanner 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
            
        // läser input
        try { 
            
            String inputString = br.readLine();
            String[] inputStringArray = inputString.split(" ");

            input[0] = Integer.parseInt(inputStringArray[0]);
            input[1] = Integer.parseInt(inputStringArray[1]);

            int storlek = input[0] * input[1];

            // snabbare alternativ till en Boolean array
            BitSet islandsInformation = new BitSet(storlek); // tom
            
            while(water < input[0]) { // går igenom hela

                String rader = br.readLine(); // läser in rad för rad

                for (int i = 0; i < input[1]; i++){ // går igenom varje tecken 

                    if(rader.charAt(i) == island){ // om tecknet är ett @ 
                        islandsInformation.set(water * input[1] + i); // index där vi har en ö 
                    }
                }
                water++; // stegar
            }

            //System.out.print(islandsInformation);
            System.out.print(countIslands(input, islandsInformation, storlek));
            System.out.print("\n");

        } catch(IOException e){
            }    
    }

    public static int countIslands(int[] input, BitSet islandsInformation, int storlek) {

        int i = 0;
        int count = 0;

        LinkedList<Integer> listToVisit = new LinkedList<>();

        //System.out.print("islandinformation: ");
        //System.out.println(islandsInformation); // lista med index där vi har en ö

        while(i < storlek){ // Söker igenom hela storleken (av kartan)

            if (islandsInformation.get(i)){ // if True = ö

                count +=1; // stega
                
                islandsInformation.flip(i); // Tar bort ön om vi redan räknat den

                listToVisit.add(i); // Undersöker om grannar
                //System.out.print("listToVisit: ");
                //System.out.println(listToVisit);
                
                while(listToVisit.isEmpty() != true) { 

                    //System.out.print("input[0]: ");
                    //System.out.println(input[0]);

                    //System.out.print("input[1]: ");
                    //System.out.println(input[1]);

                    int index = listToVisit.removeFirst(); // pop
                    //System.out.print("index: ");
                    //System.out.println(index);

                    int rad = (index)/ input[1];
                    //System.out.print("rad: ");
                    //System.out.println(rad);

                    int kol = (index) % input[1];
                    //System.out.print("kol: ");
                    //System.out.println(kol);

                    // BitSet.get retunerar true/false
                    // BitSet.flip tar bort ett värde från listan

                    if(rad != 0 && islandsInformation.get(index - input[1])){ // Kollar uppe

                        listToVisit.add(index - input[1]); // om hittar en ö, lägg till i lista
                        islandsInformation.flip(index - input[1]); // ta bort denna ö

                    }if(rad != input[0]-1 && islandsInformation.get(index + input[1])){ // Kollar nere

                        listToVisit.add(index + input[1]); // om hittar en ö, lägg till i lista
                        islandsInformation.flip(index + input[1]); // ta bort denna ö
                    }
                    if(kol != 0 && islandsInformation.get(index - 1)){ // Kollar vänster

                        listToVisit.add(index - 1); // om hittar en ö, lägg till i lista
                        islandsInformation.flip(index - 1); // ta bort denna ö
                    }
                    if(kol != input[1]-1 && islandsInformation.get(index + 1)){ // Kollar höger

                        listToVisit.add(index + 1); // om hittar en ö, lägg till i lista
                        islandsInformation.flip(index + 1); // ta bort denna ö
                    }
                }
            }
            i++;
        }
        return count;
    }
}

      