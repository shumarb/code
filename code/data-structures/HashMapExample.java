import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;

class HashMapExample extends BasicOperations {
    private HashMap<String, Integer> hMap = new HashMap<> ();
    private HashSet<Integer> numbersSet = new HashSet<> ();
    private HashSet<String> namesSet = new HashSet<> ();
    private Random myRandom = new Random();

    private void displaysMessage(int messageType, String message, boolean isDisplayNewLine, boolean isDisplayLine) {
        if (messageType == 0) {
            System.out.println(message);
        } else {
            System.out.print(message);
        }
        if (isDisplayNewLine) {
            displaysNewLine();
        }
        if (isDisplayLine) {
            displaysLine();
        }
    }

    private String formsKey() {
        StringBuilder name = new StringBuilder();
        String alphabeticString = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        do {
            for (int j = 0; j < 5; j++) {
                name.append(alphabeticString.charAt(myRandom.nextInt(alphabeticString.length())));
            }    
        } while (namesSet.contains(name.toString()));
        return name.toString();
    }
    
    private void explanation() {
        displaysLine();
        displaysMessage(0, "=========== Explanation ============", false, false);
        displaysMessage(0, "HashMap is a data structure that stores key-value mappings based on a hash function.", true, false);
        displaysMessage(0, "Key HashMap operations based on the Java API: ", true, false);
        displaysMessage(0, " * put(K key, V value): Stores the key-value mapping into the HashMap", true, false);
        displaysMessage(0, " * remove(K key, V value): Removes the key-value mapping from the HashMap", true, false);
        displaysMessage(0, " * replace(K key, V oldValue, V newValue): Replaces the value of a key-value mapping if the key is mapped to the specified value in the HashMap", false, false);
        displaysMessage(0, " * get(K key): Returns the value that the specified key is mapped to, or return null if the HashMap contains no mapping for this key", true, false);
        displaysMessage(0, " * keySet(): Returns a set view of the mappings in the HashMap", true, false);
        displaysMessage(0, " * containsValue(V value): Returns true if the specified value is associated with >= 1 key-value mapping in the HashMap", true, false);
        displaysMessage(0, " * containKey(K key): Returns true if the HashMap contains a mapping for the specified key.", true, false);
        displaysMessage(0, " * clear(): Remove all elements in HashMap", true, false);
        displaysMessage(0, " * isEmpty(): Return true if the HashMap is empty, else return false", true, false);
        displaysMessage(0, " * values(): Returns a Collection view of the values contained in the HashMap", true, false);
        displaysMessage(0, " * size(): Obtains number of key-value mappings in the HashMap", false, true);
    }

    private void displaysHashMap(int messageType, String message, boolean isDisplayNewLine, boolean isDisplayLine) {
        if (messageType == 0) {
            System.out.println(message + hMap);
        } else {
            System.out.print(message + hMap);
        }
        if (isDisplayNewLine) {
            displaysNewLine();
        }
        if (isDisplayLine) {
            displaysLine();
        }
    }

    private void insertion() {
        displaysMessage(0, "============ Insertion ============", false, false);
        int numberOfElements = myRandom.nextInt(5, 13);
        displaysMessage(0, "Forming a HashMap with " + numberOfElements + " elements:", true, false);
        formsData(numberOfElements);
        for (Integer data: set) {
            String name = formsKey();
            namesSet.add(name);
            numbersSet.add(data);
            displaysMessage(0, " * Inserting: [" + name + ", " + data + "]", true, false);
            hMap.put(name, data);  
        }
        displaysHashMap(0, "HashMap: ", false, true);
    }

    private void operations() {
        displaysMessage(0, "============ Operations ============", false, false);
        displaysHashMap(0, "HashMap: ", true, false);

        String name = formsKey();
        displaysMessage(0, " * containsKey(" + name + "): " + hMap.containsKey(name), true, false);
        int value = formsData(false);
        displaysMessage(0, " * containsValue(" + value + "): " + hMap.containsValue(value), true, false);
        displaysMessage(0, " * isEmpty(): " + hMap.isEmpty(), true, false);
        displaysMessage(0, " * size(): " + hMap.size(), true, false);
        displaysMessage(0, " * keySet(): " + hMap.keySet(), true, false);
        displaysMessage(0, " * values(): " + hMap.values(), false, true);
    }

    private void search() {
        displaysMessage(0, "============ Search ============", false, false);
        displaysHashMap(0, "HashMap: ", true, false);
        int maximum = Integer.MIN_VALUE;
        int minimum = Integer.MAX_VALUE;
        String maximumKey = "";
        String minimumKey = "";
        for (Map.Entry <String, Integer> hMapEntries: hMap.entrySet()) {
            if (hMapEntries.getValue() > maximum) {
                maximum = hMapEntries.getValue();
                maximumKey = hMapEntries.getKey();
            }
            if (hMapEntries.getValue() < minimum) {
                minimum = hMapEntries.getValue();
                minimumKey = hMapEntries.getKey();
            }
        }
        displaysMessage(0, " * Maximum: " + maximum + " | Key: " + maximumKey, true, false);
        displaysMessage(0, " * Minimum: " + minimum + " | Key: " + minimumKey, false, true);
    }

    private void deletion() {
        displaysMessage(0, "============ Deletion ============", false, false);
        int indexToDelete = myRandom.nextInt(0, hMap.size());
        int i = 0;
        String keyToDelete = "";
        for (Map.Entry <String, Integer> hMapEntries: hMap.entrySet()) {
            keyToDelete = hMapEntries.getKey();
            if (i++ == indexToDelete) {
                break;
            }
        }
        displaysMessage(1, " Deleting: [" + keyToDelete + ", " + hMap.get(keyToDelete) + "]", true, false);
        displaysNewLine();
        displaysMessage(1, " * Before: ", false, false);
        displaysHashMap(0, "", true, false);
        hMap.remove(keyToDelete);
        displaysMessage(1, " * After: ", false, false);
        displaysHashMap(1, "", true, true);
    }
    
    private void run() {
        explanation();
        insertion();
        operations();
        search();
        deletion();
    }
    public static void main(String[] args) {
        HashMapExample obj = new HashMapExample();
        obj.run();
    }
}
