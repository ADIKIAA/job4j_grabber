package ru.job4j.kiss;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class MaxMin {

    public <T> T max(List<T> value, Comparator<T> comparator) {
        return compare(value, comparator, c -> c < 0);
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        return compare(value, comparator, c -> c > 0);
    }

    public static <T> T compare(List<T> value, Comparator<T> comparator, Predicate<Integer> predicate) {
        T t = value.get(0);
        int c;
        for (int i = 1; i < value.size(); i++) {
            c = comparator.compare(t, value.get(i));
            if (predicate.test(c)) {
                t = value.get(i);
            }
        }
        return t;
    }

    public static void main(String[] args) {
        MaxMin test = new MaxMin();
        System.out.println(test.max(List.of(1, 2, 4, 6, 7, 8, 77), Integer::compareTo));
    }
}
