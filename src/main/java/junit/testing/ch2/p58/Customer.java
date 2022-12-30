package junit.testing.ch2.p58;

public class Customer {

    public boolean Purchase(Store store,Product productName,int count){
        if(store.HasEnoughInventory(productName, count)){
            store.RemoveInventory(productName, count);
            return true;
        }
        return false;
    }
}
