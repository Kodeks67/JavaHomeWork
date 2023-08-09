import java.util.*;

class Laptop {
    private final String brand;
    private final int ram;
    private final int storage;
    private final String os;
    private final String color;

    public Laptop(String brand, int ram, int storage, String os, String color) {
        this.brand = brand;
        this.ram = ram;
        this.storage = storage;
        this.os = os;
        this.color = color;
    }


    public int getRam() {
        return ram;
    }

    public int getStorage() {
        return storage;
    }

    public String getOs() {
        return os;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Brand: " + brand +
                ", RAM: " + ram + "GB" +
                ", Storage: " + storage + "GB" +
                ", OS: " + os +
                ", Color: " + color;
    }

    public static void main(String[] args) {
        Set<Laptop> laptops = new HashSet<>();
        laptops.add(new Laptop("Lenovo", 8, 256, "Windows 10", "Silver"));
        laptops.add(new Laptop("HP", 16, 512, "Windows 11", "Black"));
        laptops.add(new Laptop("Dell", 16, 512, "Ubuntu", "Silver"));
        laptops.add(new Laptop("Apple", 16, 1024, "macOS", "Space Gray"));

        filterLaptops(laptops);
    }

    public static void filterLaptops(Set<Laptop> laptops) {
        Scanner scanner = new Scanner(System.in);
        Map<Integer, String> criteria = new HashMap<>();
        criteria.put(1, "RAM");
        criteria.put(2, "Storage");
        criteria.put(3, "OS");
        criteria.put(4, "Color");

        System.out.println("Выберите критерий фильтрации:");
        for (Map.Entry<Integer, String> entry : criteria.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }

        int choice = scanner.nextInt();
        scanner.nextLine(); // Очистка буфера

        if (criteria.containsKey(choice)) {
            System.out.println("Введите минимальное значение для " + criteria.get(choice) + ":");
            int minValue = scanner.nextInt();
            scanner.nextLine(); // Очистка буфера

            for (Laptop laptop : laptops) {
                boolean passFilter = switch (choice) {
                    case 1 -> laptop.getRam() >= minValue;
                    case 2 -> laptop.getStorage() >= minValue;
                    case 3 -> laptop.getOs().equalsIgnoreCase(String.valueOf(minValue));
                    case 4 -> laptop.getColor().equalsIgnoreCase(String.valueOf(minValue));
                    default -> false;
                };

                if (passFilter) {
                    System.out.println(laptop);
                }
            }
        } else {
            System.out.println("Неверный выбор критерия.");
        }
    }
}
