public class Board {

    private int[][] board = new int [3][3];


    public void initBoard(int[][] board) {

        PatrolBoat boat1 = new PatrolBoat(0,0, 2);

        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 3; column++) {

                if(boat1.getX() == row && boat1.getY() == column) {
                    boat1.getShip_length();

                    for(int len = 0; len < boat1.getShip_length(); len++) {
                        board[boat1.getX()][boat1.getY()] = 'p';
                        System.out.print("[p]");
                    }

                    column++;
                }

                else {
                    System.out.print("[x]");
                }

                /*
                if (board[row][column] == 0) {
                    System.out.print("[p]");
                }
                else if (board[row][column] == 1){
                    System.out.print("[x]");
                }
                */
            }

            System.out.println();
        }
    }

    public void drawShip() {

    }



    public int[][] getBoard() {
        return board;
    }
}
