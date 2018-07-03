import java.util.Random;

public abstract class Ship {

    private int[][] ship = new int[3][3];
    private int x;
    private int y;
    private int ship_length;

    public Ship(int x, int y, int ship_length) {
        this.x = x;
        this.y = y;
        this.ship_length = ship_length;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getShip_length() {
        return ship_length;
    }
}
