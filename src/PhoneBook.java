import java.util.*;

public class PhoneBook {
    private final Map<String, HashSet<String>> phoneBook = new HashMap<>();

    public void add(String surname, String phoneNumber) {
        phoneBook.put(surname, phoneBook.getOrDefault(surname, new HashSet<>()));
        phoneBook.computeIfAbsent(surname, k -> new HashSet<>()).add(phoneNumber);
    }

    public HashSet<String> get(String surname) {
        return phoneBook.get(surname);
    }
}

