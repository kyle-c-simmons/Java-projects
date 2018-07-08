public interface checkout {

    public void checkoutItem(Person p, Item i, int days);
    public void checkinItem();
    public void addItem(Item i);
    public void removeItem(String name);
    public void updateItem(String name);

}
