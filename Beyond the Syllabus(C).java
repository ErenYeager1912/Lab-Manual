import java.util.*;
class Box<T> {
    T value;
    Box(T value) {
        this.value = value;
    }
    T getValue() {
        return value;
    }
}
public class Main {
    public static <K, V> void printPair(K key, V value) {
        System.out.println(key + " = " + value);
    }
    public static <T extends Number> T maxNumber(T a, T b) {
        if (a.doubleValue() > b.doubleValue())
            return a;
        else
            return b;
    }
    public static void main(String[] args) {
        Box<Integer> intBox = new Box<>(100);
        Box<String> strBox = new Box<>("Hello Generics");
        System.out.println("Integer Box Value : " + intBox.getValue());
        System.out.println("Type of stored item : " + intBox.getValue().getClass().getName());
        System.out.println("String Box Value : " + strBox.getValue());
        System.out.println("Type of stored item : " + strBox.getValue().getClass().getName());
        System.out.println();
        System.out.println("---- Key-Value Pairs ----");
        printPair("Rahul", 88);
        printPair(101, "CSE");
        System.out.println();
        System.out.println("Maximum Number : " + maxNumber(89, 75));
        List<String> names = Arrays.asList("Rahul", "Sneha", "Kiran");
        System.out.println("Maximum (Alphabetical) : " + Collections.max(names));
        List<Integer> marks = Arrays.asList(75, 92, 89);
        System.out.println("Maximum Marks : " + Collections.max(marks));
    }
}
