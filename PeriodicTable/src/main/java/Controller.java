import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * This periodTable program will use string manipulation on elements from the periodic table
 *
 * @author Kyle Simmons
 * @version 1.0
 * @since 07-07-2018
 */

public class Controller {

    private static ArrayList<String > words = new ArrayList<>();
    private static HashMap<String, String> periodicTable = new HashMap<String, String>();

    public static void main(String[] args) {
       //partTwo("Chlorine", "Ch");
       //partTwo("Chromium", "Cr");
       //partTwo("Cesium", "Ce");
       //partTwo("Cerium", "Ci");

    }

    public boolean getSymbolFromElement(String element, String symbol) {

        String setSymbol;

        // Store the element in an arrayList.
        words.add(element);

        // Make the first element letter capital
        element.substring(0,1).toUpperCase();

        // Sort alphabetically
        char[] elementLetter = element.toCharArray();
        Arrays.sort(elementLetter);
        String sortedString = new String(elementLetter);

        // Store the symbol from the element
        setSymbol = sortedString.substring(1, 3);

        // Make the first character[0] uppercase in symbol
        String symbolFirst = setSymbol.substring(0,1).toUpperCase();
        String symbolSecond = setSymbol.substring(1,2).toLowerCase();
        setSymbol = symbolFirst + symbolSecond;

        periodicTable.put(element, setSymbol);

        if(setSymbol.contains(symbol)) {
            //System.out.print(sortedString + ":     Expected: " + symbol + " Result: " + setSymbol + "    ");
            return true;
        }
        else {
            return false;
        }
    }

    public boolean partTwo(String element, String symbol) {

        // Setup
        ArrayList<String > symbols = new ArrayList<>();
        String setSymbol;

        // Add all words to ArrayList
        words.add(element);
        element.substring(0,1).toUpperCase();

        // Sort alphabetically
        char[] elementLetter = element.toCharArray();
        Arrays.sort(elementLetter);
        String sortedString = new String(elementLetter);
        setSymbol = sortedString.substring(0, 2);

        /*
        If a symbol is not in the symbols array list, execute.
         */
        if(!symbols.contains(setSymbol)) {

            // Setup arrays for getting expected and actual value.
            char[] first = symbol.toCharArray();
            char[] second = setSymbol.toCharArray();

            // Rearrange arrays
            Arrays.sort(first);
            Arrays.sort(second);

            // Check if both symbols equal each other, if so return true.
            if(Arrays.equals(first, second)) {
                //System.out.println(second);
                return true;
            }

            /*
            If a word has already used a letter, then the next word will skip it.
             */
            else {
                for (String w : words) {
                    for (int j = 0; j < sortedString.length(); j++) {
                        StringBuffer s = new StringBuffer(sortedString);

                        try {
                            // Delete the character from the word and put into var
                            s.delete(1, j + 1);
                            String str = s.substring(0, 2);

                            // check if the expected symbol equals new one (recursive)
                            if(symbol.equals(str)) {
                                //System.out.println(str);
                                return true;
                            }
                        // if the j+1 goes out of pounds, catch it
                        } catch (StringIndexOutOfBoundsException sio) {
                            System.out.print("");
                        }
                    }
                }
            }
        }
        return false;
    }
}


