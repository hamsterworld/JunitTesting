package junit.testing.ch2.p58;

public class NYStore implements Store{

    private Product productName;
    private int count;

    public void AddInventory(Product productName,int count){
      this.productName  = productName;
      this.count = count;
    }

    public boolean HasEnoughInventory(Product productName,int count){
        if(productName.equals(Product.Shampoo) && this.count > count){
            return true;
        }
        return false;
    }

    @Override
    public void RemoveInventory(Product productName, int count) {
        if(productName.equals(Product.Shampoo) && this.count > count){
            this.count -= count;
        }
    }

    public int getCount() {
        return count;
    }
}
