package junit.testing.ch2.p58;

public interface Store {
    void AddInventory(Product productName, int count);

    boolean HasEnoughInventory(Product productName, int count);

    void RemoveInventory(Product productName,int count);

    int getCount();
}