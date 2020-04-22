import org.junit.Test;
import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class MyUnsafeTest {

    @Test
    private void testMyUnsafeClass() {
        Unsafe unsafe = reflectGetUnsafe();
//        unsafe.allocateMemory();
    }

    private static Unsafe reflectGetUnsafe() {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            return (Unsafe) field.get(null);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
