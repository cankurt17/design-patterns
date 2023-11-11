interface ICar { // Arayüz tasarımı
    String getColor();

    double getPrice();

    void showCarInfo();

}

class BMW implements ICar {

    private String color;
    private double price;

    public BMW(String color, double price) {
        this.color = color;
        this.price = price;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void showCarInfo() {
        System.out.println("Araba Markası : BMW");
        System.out.println("Araba Fiyatı : " + price);
        System.out.println("Araba Rengi : " + color);

    }

}

class Audi implements ICar {
    private String color;
    private double price;

    public Audi(String color, double price) {
        this.color = color;
        this.price = price;
    }

    @Override
    public String getColor() {
        return color;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public void showCarInfo() {
        System.out.println("Araba Markası : Audi");
        System.out.println("Araba Fiyatı : " + price);
        System.out.println("Araba Rengi : " + color);

    }
}

class CarFactory {  
 
    public static ICar createCar(String mark, String color, double price) {

        ICar car;
        if (mark.equals("BMW")) {
            car = new BMW(color, price);
        } else if (mark.equals("Audi")) {
            car = new Audi(color, price);
        } else {
            throw new RuntimeException(mark + " markasının üretimi desteklenmemektedir.");
        }
        return car;
    }
}

public class FactoryPattern {
    public static void main(String[] args) {

        ICar bmw = CarFactory.createCar("BMW", "Siyah", 240000);
        ICar audi = CarFactory.createCar("Audi", "Beyaz", 194000);

        bmw.showCarInfo();
        System.out.println("");
        audi.showCarInfo();
    }
}