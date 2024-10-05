package zuperprogrammer.reflection;

import org.junit.jupiter.api.Test;
import zuperprogrammer.reflection.data.Person;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class PrimitiveTypeTest {
    @Test
    void testClass() {
        Class<Integer> integerClass = Integer.class;
        Class<Long> longClass = long.class;
        Class<Boolean> booleanClass = boolean.class;
        System.out.println(longClass.isPrimitive());
        System.out.println(integerClass.isPrimitive());
        System.out.println(booleanClass.isPrimitive());
    }

    @Test
    void testGetPrimitive() throws NoSuchFieldException {
        Class<Person> personClass = Person.class;
        Field age = personClass.getDeclaredField("age");
        System.out.println(age.getType().isPrimitive());
    }

    @Test
    void testGetFieldValue() throws NoSuchFieldException, IllegalAccessException {
        Class<Person> personClass = Person.class;
        Field age = personClass.getDeclaredField("age");
        age.setAccessible(true);
        System.out.println(age.getType().isPrimitive());

        Person person = new Person("Ahmad", "Fulan");
        person.setAge(24);

        System.out.println(age.getInt(person));
    }

    @Test
    void testInvokeMethod() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<Person> personClass = Person.class;
        Method setAge = personClass.getDeclaredMethod("setAge", int.class);

        Person person = new Person("ahmad", "fulan");
        person.setAge(25);
        setAge.invoke(person, 24);

        System.out.println(person);
    }
}
