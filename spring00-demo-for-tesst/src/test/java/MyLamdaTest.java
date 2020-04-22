import java.util.function.Consumer;

public class MyLamdaTest {
    public static void main(String[] args) {
        Consumer<String> consumer = s -> System.out.println(s);
        consumer.accept("lamda");
    }
}
