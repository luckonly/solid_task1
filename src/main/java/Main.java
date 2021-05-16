import Item.ItemShop;
import ServiceMenu.DefaultMenu;
import ServiceMenu.MenuInterface;
import Shop.*;

public class Main {

    public static void main(String[] args) {

        Shop shop = new Shop("Онлайн ГиперМаркет");
        createTestItemsList(shop);
        MenuInterface menu = new DefaultMenu(shop);
        menu.printMenu();

    }

    private static void createTestItemsList(Shop shop) {
        shop.addPriceListItem(new ItemPriceList(
                new ItemShop("Молоко 1 л.", "Савушкин продукт"),250,50));
        shop.addPriceListItem(new ItemPriceList(
                new ItemShop("Хлеб", "Хлебозавод №1"),350,80));
        shop.addPriceListItem(new ItemPriceList(
                new ItemShop("Сметана 250 мл.", "Молочная страна"),300,40));
        shop.addPriceListItem(new ItemPriceList(
                new ItemShop("Колбаса вареная 1 кг.", "Мясные изделия"),500,60));
    }

}