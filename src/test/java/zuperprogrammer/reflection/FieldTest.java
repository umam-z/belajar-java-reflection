package zuperprogrammer.reflection;

import org.junit.jupiter.api.Test;
import zuperprogrammer.reflection.data.Person;

import java.lang.reflect.Field;

public class FieldTest {
    @Test
    void testGetFields() {
        Class<Person> personClass = Person.class;

        Field[] fields = personClass.getDeclaredFields();

        for (Field field : fields) {
            System.out.println(field.getName() + ": " + field.getType().getName());
        }
    }

    @Test
    void testGetValue() throws NoSuchFieldException, IllegalAccessException {
        Class<Person> personClass = Person.class;
        Field firstName = personClass.getDeclaredField("firstName");

        Person person = new Person("Ahmad", "Fulan");
        firstName.setAccessible(true);
        String result = (String) firstName.get(person);
        System.out.println(result);

        Person person1 = new Person("Baihaki", "Fulan2");
        firstName.setAccessible(true);
        String result1 = (String) firstName.get(person1);
        System.out.println(result1);
    }

    @Test
    void testSetValue() throws NoSuchFieldException, IllegalAccessException {
        Class<Person> personClass = Person.class;
        Field firstName = personClass.getDeclaredField("firstName");

        Person person = new Person("Ahmad", "Fulan");
        firstName.setAccessible(true);
        firstName.set(person, "Mustafa");
        System.out.println(person.getFirstName());

        Person person1 = new Person("Baihaki", "Fulan2");
        firstName.setAccessible(true);
        firstName.set(person, "Tono");
        System.out.println(person1.getFirstName());
    }
}
