package Shop;

import Order.Order;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Shop {

    private String name;
    private Map<Integer, ItemPriceList> priceList;
    private List<Order> shopOrderList;
    private List<Order> deliveryOrderList;

    public Shop(String name) {
        this.name = name;
        this.priceList = new HashMap<>();
        this.shopOrderList = new ArrayList<>();
        System.out.println("Добро пожаловать в интернет-магазин " + name);
    }

    public void addPriceListItem(ItemPriceList priceItem) {
        if (!priceList.containsValue(priceItem)) {
            priceList.put(priceList.size() + 1, priceItem);
        }
    }

    public void addShopOrder(Order order) {
        shopOrderList.add(order);
    }

    public void printPriceListItems() {
        for (int i = 1; i < priceList.size() + 1; i++) {
            System.out.println(i + ".  " + priceList.get(i));
        }
    }

    public ItemPriceList getPriceListItemByKey(int key) throws NullPointerException {
        return priceList.get(key);
    }

    public void addDeliveryOrder(Order deliveryOrder) {
        shopOrderList.add(deliveryOrder);
    }

}