package Shop;

import Item.ItemShop;

public class ItemPriceList {

    ItemShop itemShop;
    double quantity;
    double price;

    public ItemPriceList(ItemShop itemShop, double quantity, double price) {
        this.itemShop = itemShop;
        this.quantity = quantity;
        this.price = price;
    }

    public ItemPriceList(ItemShop itemShop) {
        this.itemShop = itemShop;
    }

    public ItemShop getItemShop() {
        return itemShop;
    }

    public void setItemShop(ItemShop itemShop) {
        this.itemShop = itemShop;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return itemShop + ", количество: " + quantity + ", цена: " + price;
    }
}
