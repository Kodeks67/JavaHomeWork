import java.util.*;

class PhoneBook {
    public static void main(String[] args) {
        HashMap<String, List<String>> phoneBook = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        // Цикл для добавления имени и номера телефона пользователем
        while (true) {
            System.out.print("Введите имя (или 'exit' для завершения): ");
            if (!scanner.hasNextLine()) {
                break; // Прерываем цикл, если ввод закончился
            }
            String name = scanner.nextLine();

            if (name.equalsIgnoreCase("exit")) {
                break;
            }

            System.out.print("Введите номер телефона: ");
            if (!scanner.hasNextLine()) {
                break; // Прерываем цикл, если ввод закончился
            }
            String phoneNumber = scanner.nextLine();

            addPhoneNumber(phoneBook, name, phoneNumber);
        }

        // Вывод отсортированной телефонной книги
        printSortedPhoneBook(phoneBook);
    }

    // Метод для добавления телефона в телефонную книгу
    public static void addPhoneNumber(HashMap<String, List<String>> phoneBook, String name, String phoneNumber) {
        List<String> numbers = phoneBook.getOrDefault(name, new ArrayList<>());
        numbers.add(phoneNumber);
        phoneBook.put(name, numbers);
    }

    // Метод для вывода телефонной книги в порядке убывания числа телефонов
    public static void printSortedPhoneBook(HashMap<String, List<String>> phoneBook) {
        // Создаем список записей (пары имя-телефон) и сортируем его
        List<Map.Entry<String, List<String>>> sortedEntries = new ArrayList<>(phoneBook.entrySet());
        sortedEntries.sort((entry1, entry2) -> Integer.compare(entry2.getValue().size(), entry1.getValue().size()));

        // Выводим отсортированные записи
        for (Map.Entry<String, List<String>> entry : sortedEntries) {
            String name = entry.getKey();
            List<String> phoneNumbers = entry.getValue();
            System.out.println(name + ": " + phoneNumbers);
        }
    }
}
