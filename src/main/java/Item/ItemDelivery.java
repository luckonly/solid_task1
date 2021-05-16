package Item;

public class ItemDelivery extends Item {

    String deliveryInfo;

    public ItemDelivery(String name, String deliveryInfo) {
        super(name);
        this.deliveryInfo = deliveryInfo;
    }

}
