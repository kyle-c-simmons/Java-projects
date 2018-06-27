public class Main {
    public static void main(String[] args) {
        System.out.println(calculate(20, 10, 10));
    }

    private static String calculate(int a, int b, int c) {
        int result1, result2, result3, result4;

        if(a + b == c) {
            return "a + b = c: " + c;
        }
        if(b + a == c) {
            return "b + a = c: " + c;
        }
        if(a + c == b) {
            return "a + c = b: " + b;
        }
        if(c + a == b) {
            return "c + a = b: " + b;
        }
        if(b + c == a) {
            return "b + c = a: " + a;
        }
        if(c + b == a) {
            return "c + b = a: " + a;
        }

        /*
        if(a + b == c || b + a == c || a + c == b || c + a == b || b + c == a || c + b == a) {
            result1 = a = b = c;
            return "These numbers can be added: " + result1;
        }
        else if(a - b == c || b - a == c || a - c == b || c - a == b || b - c == a || c - b == a) {
            result2 = a = b = c;
            return "These numbers can Subracted: " + result2;
        }
        else if(a * b == c || a * c == b || b * c == a) {
            result3 = a = b = c;
            return "These numbers can be Multiplyed: " + result3;
        }
        else if( a / b == c || a / c == b || b / c == a) {
            result4 = a = b = c;
            return  "These numbers can be Divided: " + result4;
        }
        */

        return null;
    }


}
