package lab5;

public class Parser {
    
    static String getType(String s) {
        int firstSpace = s.indexOf(' ');
        return s.substring(1, firstSpace).strip();
    }

    static String getName(String s) {
        int nameIndex = s.indexOf("namn=");
        int gtIndex = s.indexOf('>');
        return s.substring(nameIndex+6, gtIndex-1).strip();
    }

    static String getDesc(String s) {
        int gtIndex = s.indexOf('>');
        return s.substring(gtIndex+1).strip();
    }
}
