package leetcodeMedium;

import java.util.*;

public class InsertDeleteGetRandomO1 {

    ArrayList<Integer> values;
    HashMap<Integer, Integer> locations;
    Random random = new Random();

    public InsertDeleteGetRandomO1() {

        values = new ArrayList<>();
        locations = new HashMap<>();
    }

    public boolean insert(int value) {

        if (locations.containsKey(value)) {
            return false;
        }
        locations.put(value, values.size());
        values.add(value);
        return true;
    }

    public boolean remove(int value) {

        if (!locations.containsKey(value)) {

            return false;
        }
        int location = locations.get(value);

        if (location < values.size() - 1) {

            int lastOne = values.get(values.size() - 1);
            values.set(location, lastOne);
            locations.put(lastOne, location);
        }
        locations.remove(value);
        values.remove(values.size() - 1);
        return true;
    }

    public int getRandom() {

        return values.get(random.nextInt(values.size()));
    }

    public static void main(String[] args) {

        InsertDeleteGetRandomO1 insertDeleteGetRandomO1 = new InsertDeleteGetRandomO1();

        System.out.println(insertDeleteGetRandomO1.insert(123));
        System.out.println(insertDeleteGetRandomO1.insert(123));
    }

}
