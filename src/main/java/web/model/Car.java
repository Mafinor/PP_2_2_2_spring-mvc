package web.model;

public class Car {
    private int serial;
    private String manufacturer;
    private String model;

    public Car(int serial, String manufacturer, String model) {
        this.serial = serial;
        this.manufacturer = manufacturer;
        this.model = model;
    }

    public int getSerial() {
        return serial;
    }

    public void setSerial(int serial) {
        this.serial = serial;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
