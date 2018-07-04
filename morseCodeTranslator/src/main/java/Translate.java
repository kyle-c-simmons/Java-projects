import java.util.HashMap;

public class Translate {

    private HashMap<String, Character> morseToEnglish = new HashMap<String, Character>();

    private String string = ".... . .-.. .-.. --- / -.. .- .. .-.. -.-- / .--. .-. --- --. .-. .- -- -- . .-. / --. --- --- -.. / .-.. ..- -.-. -.- " +
            "/ --- -. / - .... . / -.-. .... .- .-.. .-.. . -. --. . ... / - --- -.. .-";

    private String text[] = string.split(" / ");



    public void morseCode() {
        morseToEnglish.put(".-", 'A');
        morseToEnglish.put("-...", 'B');
        morseToEnglish.put("-.-.", 'C');
        morseToEnglish.put("-..", 'D');
        morseToEnglish.put(".", 'E');
        morseToEnglish.put("..-.", 'F');
        morseToEnglish.put("--.", 'G');
        morseToEnglish.put("....", 'H');
        morseToEnglish.put("..", 'I');
        morseToEnglish.put(".---", 'J');
        morseToEnglish.put("-.-", 'K');
        morseToEnglish.put(".-..", 'L');
        morseToEnglish.put("--", 'M');
        morseToEnglish.put("-.", 'N');
        morseToEnglish.put("---", 'O');
        morseToEnglish.put(".--.", 'P');
        morseToEnglish.put("--.-", 'Q');
        morseToEnglish.put(".-.", 'R');
        morseToEnglish.put("...", 'S');
        morseToEnglish.put("-", 'T');
        morseToEnglish.put("..-", 'U');
        morseToEnglish.put("...-", 'V');
        morseToEnglish.put(".--", 'W');
        morseToEnglish.put("-..-", 'X');
        morseToEnglish.put("-.--", 'Y');
        morseToEnglish.put("--..", 'Z');
        morseToEnglish.put(" ", '-');

        System.out.println(text.toString());

    }

    public void translateToEnglish(){

        for (String word: text){
            String letter[] = word.split(" ");
            for (String letter: word){

            }
        }
    }



    public String getString() {
        return string;
    }

    public String[] getTemp() {
        return text;
    }

    @Override
    public String toString() {
        for(int i = 0; i < text.length - 1; i++) {
            return text[i];
        }
        return null;
    }
}
