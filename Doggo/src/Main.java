import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static ArrayList<Integer> places = new ArrayList<>();

   // String scan = "";

    Scanner scanner = new Scanner(System.in);
    int i = scanner.nextInt();

    int place = 1;


    public static void main(String[] args) {
        setupPlaces();
    }

    private static void setupPlaces() {
        for (int i = 1; i <= 100; i++) {
            places.add(i);
            if(i == 1 || i == 21 || i == 31) {
                System.out.println(i + "st");
            }
            else if(i >= 10 && i <= 20) {
                System.out.println(i + "nd");
            }
            else if(i == 2 || i == 22 || i == 32 || i == 42 ||)
            else {
                System.out.println(i + "th");
            }
            //String fish = "hahaha";
            //fish.charAt(1);

        }


    }

    /*public String toString(ArrayList<Integer> places) {

    }*/

        // Convert to string
        // add st, nd, rd, th

    }
