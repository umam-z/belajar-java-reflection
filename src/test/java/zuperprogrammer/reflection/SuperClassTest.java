package zuperprogrammer.reflection;

import org.junit.jupiter.api.Test;
import zuperprogrammer.reflection.data.Person;

public class SuperClassTest {
    @Test
    void testGetSuperClass() {
        Class<Person> personClass = Person.class;
        System.out.println(personClass);

        Class<? super Person> objectClass = personClass.getSuperclass();
        System.out.println(objectClass);

        Class<? super Person> nullClass = objectClass.getSuperclass();
        System.out.println(nullClass);
    }
}
