import java.util.Iterator;
import java.util.NoSuchElementException;

public class IteratorPattern {
    public static Iterator<Integer> range(int start, int end) {
        return new Iterator<>() {
            private int index = start;

            @Override
            public boolean hasNext() {
                return index < end;
            }

            @Override
            public Integer next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return index++;
            }
        };
    }

    public static void main(String[] args) {
        var iterator = range(0, 10);
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // or using a lambda
        iterator.forEachRemaining(System.out::println);
    }
}

