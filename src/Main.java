import java.util.*;

public class Main {
    public static void main(String[] args) {
        String[] words = {"яблоко", "груша", "банан", "апельсин", "апельсин", "тыква", "арбуз",
                            "яблоко", "груша", "банан", "арбуз", "капуста", "яблоко", "баклажан",};

        Map<String, Integer> uniqueWords = new HashMap<>();

        for (var word : words) {
            uniqueWords.put(word, uniqueWords.getOrDefault(word, 0) + 1);
        }

        for (var entry : uniqueWords.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

    }
}