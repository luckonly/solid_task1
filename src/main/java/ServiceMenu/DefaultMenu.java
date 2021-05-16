package ServiceMenu;

import Order.OrderDelivery;
import Order.OrderShop;
import Shop.Shop;
import java.util.*;

public class DefaultMenu implements MenuInterface {

    private static int currentMenuStep = 1;
    private static Map<Integer, String> mainMenuList;
    private static Map<Integer, String> newOrderMenuList;
    private StringBuilder sb;
    private Scanner scanner;
    private Shop shop;
    private OrderShop orderShop;

    public DefaultMenu(Shop shop) {
        getAvailableCommandsToMenuList();
        this.sb = new StringBuilder();
        this.shop = shop;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void goToStartPage() {

        sb.delete(0, sb.length());

        sb.append("-----------------------------------------------\n");
        sb.append("Выберите действие из списка доступных действий:\n");

        for (Object value : mainMenuList.values()) {
            sb.append(value);
        }

        System.out.println(sb);

        try {

            int userChoice = scanner.nextInt();

            if (mainMenuList.containsKey(userChoice)) {

                if (userChoice == 1) {
                    shop.printPriceListItems();
                    printMenu();
                } else {
                    currentMenuStep = userChoice;
                    printMenu();
                }
            } else {
                System.out.println("Не правильный выбор. Пожалуйста, повторите попытку");
            }
        } catch (InputMismatchException e) {
            System.out.println("Не правильный выбор. Пожалуйста, повторите попытку");
        }
    }

    @Override
    public void getAvailableCommandsToMenuList() {

        mainMenuList = new HashMap<Integer, String>();
        mainMenuList.put(1, "1. Показать список доступных товаров\n");
        mainMenuList.put(2, "2. Создать новый заказ\n");

        newOrderMenuList = new HashMap<Integer, String>();
        newOrderMenuList.put(1, "1. Начать подбор товара в корзину\n");
        newOrderMenuList.put(2, "2. Показать текущую корзину\n");
        newOrderMenuList.put(3, "3. Сформировать заказ и вернуться в предыдущее меню\n");
        newOrderMenuList.put(4, "4. Не сохранять заказ и вернуться в предыдущее меню\n");

    }

    @Override
    public void printMenu() {

        if (currentMenuStep == 1) {
            goToStartPage();
            currentMenuStep = 0;
        }

        if (currentMenuStep == 2) {
            goToOrderMenu();
            currentMenuStep = 0;
        }

    }

    @Override
    public void goToOrderMenu() {

        Scanner scanner = new Scanner(System.in);

        sb.delete(0, sb.length());
        sb.append("-----------------------------------------------\n");
        sb.append("Вы находитесь в меню создания нового заказа\n");
        sb.append("-----------------------------------------------\n");
        sb.append("Выберите действие из списка доступных действий:\n");

        for (Object value : newOrderMenuList.values()) {
            sb.append(value);
        }

        System.out.println(sb);

        while (true) {

            try {

                int userChoice = scanner.nextInt();

                if (userChoice == 1) {
                    addItemsToTheBasket();
                }

                if (userChoice == 2) {
                    if (orderShop != null) {
                        orderShop.printAllItems();
                    } else {
                        System.out.println("Корзина пустая");
                    }
                }

                if (userChoice == 3) {
                    if (orderShop != null) {
                        scanner.nextLine();
                        System.out.println("Введите адрес доставки:");
                        String deliveryAddress = scanner.nextLine();
                        addDeliveryOrder(deliveryAddress);
                        break;
                    } else {
                        System.out.println("Сначала добавьте товар в корзину");
                    }
                }

                if (userChoice == 4) {
                    break;
                }

            } catch (InputMismatchException e) {

            }
        }

        goToStartPage();

    }
