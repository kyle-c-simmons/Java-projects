public class Controller {

    public static void main(String[] args) {

        for (int i = 2; i <= 50; i++) {

            for(int j = 2; j <= i; j++) {

                if(j == i) {
                    System.out.println(i);
                }

                if(i%j == 0) {
                    break;
                }

            }

        }
    }

}
