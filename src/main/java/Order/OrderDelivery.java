package Order;

public class OrderDelivery extends Order {

    String deliveryAddress;
    Order shopOrder;

    public OrderDelivery(String clientName, String deliveryAddress, Order shopOrder) {
        super(clientName);
        this.deliveryAddress = deliveryAddress;
        this.shopOrder = shopOrder;
    }

}
