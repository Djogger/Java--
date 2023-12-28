import java.util.ArrayList;
import java.util.LinkedList;
import static java.util.Objects.hash;

public class HashTable2 {
    public static void main(String[] args) {
        hashTableCode2<Object, Order> table = new hashTableCode2<>();

        Order order = new Order();
        Order order2 = new Order("01.11.2023", new String[] {"two number nine", "number nine large",
                "number six with extra dip", "number seven",
                "two number fourty-fifth (one with cheese)",
                "large sodaaaaaa"}, true);

        table.put("00000", order);
        table.put("73885", order2);

        table.println();

        Order value = table.get("00000");
        Order value2 = table.get("73885");

        value.getInfo();

        value.changeStatus();

        value.getInfo();

        System.out.println("\n");

        value2.getInfo();

        value2.changeStatus();

        value2.getInfo();
    }
}

class hashTableCode2<K, V> {
    private final ArrayList<LinkedList<Entry<K, V>>> table;

    hashTableCode2() {
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

class Order {
    String date;
    String[] goods;
    boolean status;

    public Order() {
        this ("00.00.00", new String[] {"Empty"}, false);
    }

    public Order(String date, String[] goods, boolean status) {
        this.date = date;
        this.goods = goods;
        this.status = status;
    }

    public void changeStatus() {
        if (!status) {
            this.status = true;
            return;
        }

        this.status = false;
    };

    public void getInfo() {
        StringBuilder goodsString = new StringBuilder();

        for (int i = 0; i < this.goods.length; i++) {
            goodsString.append(this.goods[i]);

            if (i != this.goods.length - 1) {
                goodsString.append(", ");
            }
        }

        System.out.println("date: " + this.date + " goods: " + goodsString + " status: " + this.status);
    }
}