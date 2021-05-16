package ServiceMenu;

public interface MenuInterface {
    void printMenu();
    void goToStartPage();
    void getAvailableCommandsToMenuList();
    void goToOrderMenu();
    void addDeliveryOrder(String deliveryAddress);
    void addItemsToTheBasket();
}
