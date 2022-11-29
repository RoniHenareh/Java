package lab4.uppgift1;

public class Client {

    public static void main(String[] args) {

        // Get a suitcase filled with some things
        Component suitcase = createSuitcase();

        // test

        // Add a water bottle containing water to the suitcase
        Composite waterBottle = new Composite("Water bottle", 0.1);
        Leaf water = new Leaf("Water", 1);
        waterBottle.add(water);
        suitcase.add(waterBottle);

        // Inspect suitcase
        inspectAndWeigh(suitcase); // 10.76 kg
    
        // Remove waterBottle from suitcase
        System.out.println("##### Removing water bottle. #####");
        suitcase.remove(waterBottle);

        inspectAndWeigh(suitcase); // 9.66 kg

        // Inspect only water bottle
        inspectAndWeigh(waterBottle); // 1.10 kg
        
        // Removing water from water bottle
        System.out.println("##### Removing water from water bottle. #####");
        waterBottle.remove(water);
        inspectAndWeigh(waterBottle);

        // Inspect only water
        inspectAndWeigh(water); // 0.1 kg water bottle, 1 kg water

        //System.exit(0); // Pythons quit()
    }

    // hitta vikt för väskor
    private static void inspectAndWeigh(Component comp) {
        // Print structure and mass of suitcase
        System.out.println(comp.toString());
        System.out.printf("Total weight is %.2f kg.\n\n", comp.getWeight());
    }

    // hitta vikt för prylar
    private static void inspectAndWeigh(Leaf l) {
        // Print structure and mass of suitcase
        System.out.println(l.toString());
        System.out.printf("Weight is %.2f kg.\n\n", l.getWeight());
    }

    // test resväska med saker
    private static Component createSuitcase() {
        Component suitcase = new Component("Suitcase", 2);

        Leaf shirt = new Leaf("Shirt", 0.7);
        Leaf pants = new Leaf("Pants", 1.2);
        Leaf socks = new Leaf("Socks", 0.3);
        Leaf hat = new Leaf("Hat", 0.4);
        suitcase.add(shirt);
        suitcase.add(pants);
        suitcase.add(socks);
        suitcase.add(hat);

        // mindre "väska" 1
        Composite shoesBag = new Composite("Shoe bag", 0.2);
        suitcase.add(shoesBag);

        // prylar i mindre "väska" 1
        Leaf runningShoes = new Leaf("Running shoes", 1.2);
        Leaf danceShoes = new Leaf("Dance shoes", 0.9);
        Leaf dressShoes = new Leaf("Dress shoes", 1.4);
        shoesBag.add(runningShoes);
        shoesBag.add(danceShoes);
        shoesBag.add(dressShoes);

        // mindre "väska" 2
        Composite toiletBag = new Composite("Toilet bag", 0.1);
        suitcase.add(toiletBag);

        // prylar i mindre "väska" 2
        Leaf hairBrush = new Leaf("Hair brush", 0.4);
        toiletBag.add(hairBrush);

        // mindre "väska" 3
        Composite plasticBag = new Composite("Plastic bag", 0.01);
        toiletBag.add(plasticBag);

        // prylar i mindre "väska" 3
        Leaf toothbrush = new Leaf("Toothbrush", 0.1);
        Leaf razor = new Leaf("Razor", 0.05);
        Leaf shavingCream = new Leaf("Shaving cream", 0.4);
        Leaf deoderant = new Leaf("Deoderant", 0.3);

        plasticBag.add(toothbrush);
        plasticBag.add(razor);
        plasticBag.add(shavingCream);
        plasticBag.add(deoderant);
  
        return suitcase;
    }
}