package Item;

public class ItemShop extends Item {

    String manufacturer;

    public ItemShop(String name, String manufacturer) {
        super(name);
        this.name = name;
        this.manufacturer = manufacturer;
    }

    public ItemShop(String name) {
        super(name);
    }

    public String getName() {
        return name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public String toString() {
        return name + ", производитель: " + manufacturer;
    }
}
