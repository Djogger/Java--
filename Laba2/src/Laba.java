public class Laba {
    public static void main(String[] args) {
        lightCar car = new lightCar(1935, "Cadillac", 1300000);
        System.out.printf("weight: %d(кг.) \tbrand: %s \tcost: %d(руб.)\n", car.weight, car.brand, car.cost);

        System.out.println(car.getSpeed());

        lightCarInformation vehicle = new lightCarInformation("USA", 2007, true);
        System.out.printf("country: %s \tyear: %d \tquality: %b\n\n", vehicle.country, vehicle.year, vehicle.quality);

        car.speedUp(5);
        System.out.println(car.getSpeed());
        car.speedLow(200);
        System.out.println(car.getSpeed());
        car.setSpeed(55);
        System.out.println(car.getSpeed());


        truck car2 = new truck(11845, "КамАЗ", 4800000);
        System.out.printf("\nweight: %d(кг.) \tbrand: %s \tcost: %d(руб.)\n", car2.weight, car2.brand, car2.cost);

        truckInformation vehicle2 = new truckInformation("Российская Федерация", 1995, true);
        System.out.printf("country: %s \tyear: %d \tquality: %b\n\n", vehicle2.country, vehicle2.year, vehicle2.quality);

        car2.speedUp(25);


        motorbike bike = new motorbike(206, "Aprilia Tuono V4", 1300000);
        System.out.printf("\nweight: %d(кг.) \tbrand: %s \tcost: %d(руб.)\n", bike.weight, bike.brand, bike.cost);
        motorbikeInformation vehicle3 = new motorbikeInformation("Италия", 2019, true);
        System.out.printf("country: %s \tyear: %d \tquality: %b\n\n", vehicle3.country, vehicle3.year, vehicle3.quality);

        bike.speedUp(145);


        motorbike bike2 = new motorbike(158, "Aprilia Kuota D5", 980000);
        System.out.printf("\nweight: %d(кг.) \tbrand: %s \tcost: %d(руб.)\n", bike2.weight, bike2.brand, bike2.cost);
        motorbikeInformation vehicle4 = new motorbikeInformation("Италия", 2017, true);
        System.out.printf("country: %s \tyear: %d \tquality: %b\n\n", vehicle4.country, vehicle4.year, vehicle4.quality);

        bike2.speedUp(5);
        bike2.speedUp(65);
        bike2.speedLow(10);
        bike2.speedUp(10.);

        System.out.println("\nКоличество созданных объектов, связанных с классом 'motorbike',\n" +
                "и сами объекты 'motorbike': " + motorbike.getCount());
    }
}

abstract class Vehicle {
    int weight;
    String brand;
    int cost;
    int speed = 0;
    double speed_d = 0;

    Vehicle(int weight, String brand, int cost) {
        this.weight = weight;
        this.brand = brand;
        this.cost = cost;
    }

    int getSpeed() {
        return speed;
    }

    void setSpeed(int number) {
        speed = number;
    }

    public void speedUp(int value) {
        speed += value;

        System.out.printf("Теперь %s идёт со скоростью: %d km/h.\n",brand, speed);
    }

    public void speedUp(double value1) {
        speed_d += value1;

        System.out.printf("Теперь %s идёт со скоростью: %f km/h.\n",brand, speed_d);
    }

    public void speedLow(int value) {
        speed -= value;
        if (speed < 0) {
            speed = 0;
        }

        System.out.printf("Теперь %s идёт со скоростью: %d km/h.\n",brand, speed);
    }
}

class lightCar extends Vehicle {
    String country;
    int year;
    boolean quality; // Качественно ли сделана.

    /** Конструктор по умолчанию **/
    public lightCar() {
        super(0, "", 0);
    }

    public lightCar(int x, String y, int z) {
        super(x, y, z);
    }

    @Override
    public void speedUp(int speed) {
        System.out.printf("К скорости машины прибавляется: %d", speed);
    }
}
class lightCarInformation extends lightCar {
    /** Конструктор по умолчанию **/
    public lightCarInformation() {
        this("", 0, false);
    }

    public lightCarInformation(String country, int year, boolean quality) {
        super.country = country;
        super.year = year;
        super.quality = quality;
    }
}

class truck extends Vehicle {
    String country;
    int year;
    boolean quality; // Качественно ли сделана.

    /** Конструктор по умолчанию **/
    public truck() {
        super(0, "", 0);
    }

    public truck(int x, String y, int z) {
        super(x, y, z);
    }
}
class truckInformation extends truck {
    /** Конструктор по умолчанию **/
    public truckInformation() {
        this("", 0, false);
    }

    public truckInformation(String country, int year, boolean quality) {
        super.country = country;
        super.year = year;
        super.quality = quality;
    }
}

class motorbike extends Vehicle {
    String country;
    int year;
    boolean quality; // Качественно ли сделана.

    static int count = 0;

    /** Конструктор по умолчанию **/
    public motorbike() {
        super(0, "", 0);
        count++;
    }

    public motorbike(int x, String y, int z) {
        super(x, y, z);
        count++;
    }

    public static int getCount() {
        return count;
    }

    public String getBrand() {
        return super.brand;
    }
}
class motorbikeInformation extends motorbike {
    /** Конструктор по умолчанию **/
    public motorbikeInformation() {
        this("", 0, false);
    }

    public motorbikeInformation(String country, int year, boolean quality) {
        super.country = country;
        super.year = year;
        super.quality = quality;

    }
}


