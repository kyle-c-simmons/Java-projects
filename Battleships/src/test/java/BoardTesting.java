public class BoardTesting {

    private int[][] board = new int [3][3];

    public void initBoard(int[][] board) {

        //PatrolBoat pb = new PatrolBoat("Patrol Boat 1", board);
        //pb.initBoat();

        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 3; column++) {

                if (board[row][column] == 1) {
                    System.out.print("[p]");
                } else {
                    System.out.print("[x]");
                }
            }

            System.out.println();

        }
    }

    public int[][] getBoard() {
        return board;
    }
}
