import java.lang.reflect.Array;
import java.util.ArrayList;

public abstract class Items{

    private int item_id;
    private String item_name;


    public Items(int item_id, String item_name) {
        this.item_id = item_id;
        this.item_name = item_name;
    }

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }
}
