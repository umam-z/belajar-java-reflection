package zuperprogrammer.reflection;

import org.junit.jupiter.api.Test;
import zuperprogrammer.reflection.data.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class ConstructorTest {
    @Test
    void testGetConstructor() {
        Class<Person> personClass = Person.class;
        Constructor<?>[] constructors = personClass.getDeclaredConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor.getName());
            System.out.println(Arrays.toString(constructor.getParameterTypes()));
            System.out.println("==============");
        }
    }

    @Test
    void testCreateObjectUsingConstructor() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<Person> personClass = Person.class;
        Constructor<Person> constructor = personClass.getConstructor();
        Constructor<Person> constructorParameters = personClass.getConstructor(String.class, String.class);

        Person person = constructor.newInstance();
        Person person1 = constructorParameters.newInstance("Mohammad", "Fulan");

        System.out.println(person);
        System.out.println(person1);
    }
}
