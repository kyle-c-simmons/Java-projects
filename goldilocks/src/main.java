public class main {



    public static void main(String[] args) {

        Seat one = new Seat( 120, 100);
        Seat two = new Seat( 90, 30);
        Seat three = new Seat( 1, 110);
        Seat four = new Seat( 90, 110);



        Goldilocks a = new Goldilocks(120, 100);




        Seat[] seatArray = new Seat[2];

        seatArray[0] = one;

        seatArray[1] = two;

        seatArray[2] = three;



        for (int i = 0; i < seatArray.length ; i++){

           if (seatArray[i].temperature <= a.temperature){

               if ( seatArray[i].weight >= a.weight){

                   System.out.println(i + 1);
               }

               //all good
               // print out the pos
               // i + 1

           }



        }


        //seat array

        // add a bunch of seats

        //then the [position of the seat dictates its number






    }


}
