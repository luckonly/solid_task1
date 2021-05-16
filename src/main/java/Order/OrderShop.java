package Order;
import Shop.ItemPriceList;
import Shop.Shop;

import java.util.*;

public class OrderShop extends Order {

    Shop shop;
    List<ItemPriceList> itemShopList;

    public OrderShop(Shop shop, String clientName) {
        super(clientName);
        this.shop = shop;
        this.itemShopList = new ArrayList<>();
    }

    public boolean addItem(int inputNumber, double inputQuantity) {

        try {
            ItemPriceList itemPriceList = shop.getPriceListItemByKey(inputNumber);

            if (inputQuantity > itemPriceList.getQuantity()) {
                return false;
            }

            itemPriceList.setQuantity(itemPriceList.getQuantity() - inputQuantity);
            itemShopList.add(new ItemPriceList(
                    itemPriceList.getItemShop(),inputQuantity, itemPriceList.getPrice()));

            return true;

        } catch (NullPointerException e) {
            return false;
        }
    }

    public void printAllItems() {

        double sum = 0;

        StringBuilder sb = new StringBuilder();
        sb.append("-------------------\n");
        sb.append("В корзине:\n");

        for (int i = 0; i < itemShopList.size(); i++) {
            if (i > 0) sb.append("\n");
            sb.append(itemShopList.get(i));
            sum += itemShopList.get(i).getPrice() * itemShopList.get(i).getQuantity();
        }

        System.out.println(sb.toString());
        System.out.println("Общая сумма заказа: " + sum);

    }
}
