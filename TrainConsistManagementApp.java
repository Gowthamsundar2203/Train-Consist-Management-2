import java.util.*;
import java.util.stream.*;

class Bogie {
    int capacity;

    Bogie(int capacity) {
        this.capacity = capacity;
    }
}

public class Performancecomparison {
    public static void main(String[] args) {
        List<Bogie> bogies = new ArrayList<>();

        for (int i = 0; i < 100000; i++) {
            bogies.add(new Bogie((int)(Math.random() * 100)));
        }

        long startLoop = System.nanoTime();
        List<Bogie> loopResult = new ArrayList<>();
        for (Bogie b : bogies) {
            if (b.capacity > 60) {
                loopResult.add(b);
            }
        }
        long endLoop = System.nanoTime();

        long startStream = System.nanoTime();
        List<Bogie> streamResult = bogies.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());
        long endStream = System.nanoTime();

        System.out.println("Loop Time: " + (endLoop - startLoop));
        System.out.println("Stream Time: " + (endStream - startStream));
    }
}