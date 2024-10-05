package zuperprogrammer.reflection;

import org.junit.jupiter.api.Test;
import zuperprogrammer.reflection.data.Person;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayTest {
    @Test
    void testArrayClass() {
        Class<String[]> aClass = String[].class;
        Class<int[]> aClass1 = int[].class;
        Class<Person> personClass = Person.class;

        System.out.println(aClass.isArray());
        System.out.println(aClass1.isArray());
        System.out.println(personClass.isArray());
    }

    @Test
    void testArrayMember() {
        Class<String[]> aClass = String[].class;

        System.out.println(Arrays.toString(aClass.getDeclaredFields()));
        System.out.println(Arrays.toString(aClass.getDeclaredConstructors()));
        System.out.println(Arrays.toString(aClass.getDeclaredMethods()));
        System.out.println(aClass.getComponentType());
    }

    @Test
    void testArrayManipulation() {
        Class<String[]> aClass = String[].class;
        String[] array = (String[]) Array.newInstance(aClass.getComponentType(), 10);
        System.out.println(Arrays.toString(array));
        Array.set(array, 0,"Mohammad");
        Array.set(array, 1,"Sirajul");
        Array.set(array, 2,"Umam");
        System.out.println(Arrays.toString(array));
        System.out.println(Array.get(array,0));
        System.out.println(Array.get(array,1));
        System.out.println(Array.get(array,2));
        System.out.println(Array.get(array,3));
    }
}
