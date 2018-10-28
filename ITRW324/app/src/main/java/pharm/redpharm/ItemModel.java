package pharm.redpharm;

public class ItemModel {

    private String ItemName , ItemPrice ,ItemPicture ;

    public ItemModel(String ItemName , String ItemPrice, String ItemPicture){
        this.ItemName = ItemName;
        this.ItemPrice = ItemPrice;
        this.ItemPicture = ItemPicture;
    }

    public String getItemName() {
        return ItemName;
    }
    public String getItemPrice() {
        return ItemPrice;
    }
    public String getItemPicture() {
        return ItemPicture;
    }
}
