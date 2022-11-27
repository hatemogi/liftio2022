package liftio2022;

import io.vavr.collection.List;

public class ListFunctions {

    public static <A> int length(List<A> xs) {
        if (xs.isEmpty()) return 0;
        else return 1 + length(xs.tail());
    }

    public static <T> List<T> replicate(int n, T a) {
        if (n <= 0) return List.empty();
        else return replicate(n - 1, a).prepend(a);
    }
}
