package data_structures;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;

public class _06_HashTable {
    public static void printTable(Hashtable<String, List<String>> table) {
        System.out.printf("%-10s %-15s %-40s%n", "Hash", "Word", "Synonyms");
        System.out.println("---------------------------------------------------------------");

        for (String key : table.keySet()) {
            int hash = key.hashCode() % 21;
            String value = table.get(key).toString();
            System.out.printf("%-10d %-15s %-40s%n", hash, key, value);
        }
    }

    public static void main(String[] args) {
        Hashtable<String, List<String>> synonyms = new Hashtable<>();

        synonyms.put("happy", Arrays.asList("joyful", "cheerful", "content"));
        synonyms.put("angry", Arrays.asList("furious", "irate", "mad"));
        synonyms.put("fast", Arrays.asList("quick", "speedy", "rapid"));
        synonyms.put("smart", Arrays.asList("intelligent", "clever", "bright"));
        synonyms.put("difficult", Arrays.asList("challenging", "tough", "hard"));
        synonyms.put("big", Arrays.asList("large", "huge", "enormous"));
        synonyms.put("small", Arrays.asList("tiny", "miniature", "petite"));
        synonyms.put("beautiful", Arrays.asList("gorgeous", "stunning", "lovely"));
        synonyms.put("easy", Arrays.asList("simple", "effortless", "straightforward"));
        synonyms.put("strong", Arrays.asList("powerful", "sturdy", "robust"));

        printTable(synonyms);

        synonyms.remove("big");

        System.out.println("Table after removing key 'big': ");
        printTable(synonyms);
    }
}