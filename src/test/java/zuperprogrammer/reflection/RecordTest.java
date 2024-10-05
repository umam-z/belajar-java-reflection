package zuperprogrammer.reflection;

import org.junit.jupiter.api.Test;
import zuperprogrammer.reflection.data.Product;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;

public class RecordTest {
    @Test
    void testClassRecord() {
        Class<Product> productClass = Product.class;

        System.out.println(productClass.isRecord());
        System.out.println(Arrays.toString(productClass.getDeclaredFields()));
        System.out.println(Arrays.toString(productClass.getDeclaredMethods()));
        System.out.println(Arrays.toString(productClass.getDeclaredConstructors()));
        System.out.println(Arrays.toString(productClass.getRecordComponents()));
    }

    @Test
    void testGetRecordValue() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<Product> productClass = Product.class;
        Method id = productClass.getDeclaredMethod("id");
        Product appleIphone = new Product("1", "Apple Iphone", 20_000_000L);
        System.out.println(id.invoke(appleIphone));
    }

    @Test
    void testGetRecordValueByComponent() throws InvocationTargetException, IllegalAccessException {
        Class<Product> productClass = Product.class;
        RecordComponent[] components = productClass.getRecordComponents();

        Product appleIphone = new Product("1", "Apple Iphone", 20_000_000L);

        for (RecordComponent component : components) {
            Method accessor = component.getAccessor();
            System.out.println(accessor.getName());
            System.out.println(accessor.invoke(appleIphone));
        }
    }
}
