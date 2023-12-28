import java.util.ArrayList;
import java.util.LinkedList;
import static java.util.Objects.hash;

public class HashTable {
    public static void main(String[] args) {


        hashTableCode<Object, Object> table = new hashTableCode<>();

        table.put("ab", 5);
        table.put('a', 5);
        table.put(97, 19);
        table.put("Banana", 105);

        table.println();

        Object value = table.get("Banana");
        System.out.println("\n" + value + "\n");
        Object value2 = table.get("B");
        System.out.println("\n" + value2 + "\n");

        System.out.println("\n" + table.size() + "\n");

        table.remove('a');

        table.println();

        System.out.println("\n" + table.size());

        System.out.println("\n" + table.isEmpty());
    }
}

class hashTableCode<K, V> {
    private final ArrayList<LinkedList<Entry<K, V>>> table;

    hashTableCode() {
        this.table = new ArrayList<>();
    }

    static class Entry<K, V> {
        K key;
        V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public void setValue(V values) {
            value = values;
        }

        @Override
        public String toString() {
            return "Entry[key = " + key + ", value = " + value + "]";
        }
    }

    public void put(K keys, V values) {
        int index = hash(keys) % 16;

        if (index >= table.size()) {
            for (int i = 0; i <= index; i++) {
                table.add(null);
            }
        }

        if (table.get(index) == null) {
            table.set(index, new LinkedList<>());
        }

        for (Entry<K, V> entry : table.get(index)) {
            if (entry.getKey().equals(keys)) {
                entry.setValue(values);
                return;
            }
        }
        table.get(index).add(new Entry<>(keys, values));

    }

    public V get(K key) {
        int index = hash(key) % 16;

        if (index >= table.size()) {
            System.out.println("Такого значения нет.");
            return null;
        }

        LinkedList<Entry<K, V>> value = table.get(index);

        if (value == null) {
            System.out.println("Такого значения нет.");
            return null;
        }

        for (Entry<K, V> entry : value) {
            if (entry.getKey().equals(key)) {
                return entry.value;
            }
        }

        System.out.println("Такого значения нет.");
        return null;
    }

    public void remove(K key) {
        int index = hash(key) % 16;

        LinkedList<Entry<K, V>> value = table.get(index);

        for (int i = 0; i < value.size(); i++) {
            if (value.get(i).getKey().equals(key)) {
                value.remove(i);
            }
        }

    }

    public int size() {
        int size = 0;

        for (LinkedList<Entry<K, V>> entry : table) {
            if (entry != null) {
                size += entry.size();
            }
        }

        return size;
    }

    public boolean isEmpty() {
        if (table.size() != 0) {
            return false;
        }

        return true;
    }

    public void println() {
        for (int i = 0; i < table.size(); i++) {
            if (table.get(i) != null) {
                System.out.println(table.get(i).toString());
            }
        }
    }
}














/*
class hashTablea<K, V> {
    private static class Entry<K, V> {
        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private List<LinkedList<Entry<K, V>>> table;

    public hashTablea () {
        table = new ArrayList<>();
    }

    public void put(K key, V value) {
        int size = table.size();

        if (table.isEmpty()) {
            size += 1;
        }

        int index = Math.abs(hash(key) % size);

        if (this.table.get(index) == null) {
            LinkedList<Entry<K, V>> a = new LinkedList<>();
            Entry<K, V> b = new Entry(key, value);
            a.add(b);
            table.add(a);
        }

        for (Entry<K, V> entry : table[index]) {
            if (entry.getKey().equals(key)) {
                entry.setValue(value);
                return;
            }
        }
        table[index].add(new Entry<K, V>(key, value));
        size++;
    }*/
