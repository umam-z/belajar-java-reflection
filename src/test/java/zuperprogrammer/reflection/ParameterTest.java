package zuperprogrammer.reflection;

import org.junit.jupiter.api.Test;
import zuperprogrammer.reflection.data.Person;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class ParameterTest {
    @Test
    void testGetParameter() {
        Class<Person> personClass = Person.class;
        Method[] methods = personClass.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
            Parameter[] parameters = method.getParameters();
            for (Parameter parameter : parameters) {
                System.out.println("Parameter Name: " + parameter.getName());
                System.out.println("Parameter Type: " + parameter.getType());
            }
            System.out.println("======================");
        }
    }

    @Test
    void testInvokeMethodWithParameter() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<Person> personClass = Person.class;

        Method firstName = personClass.getDeclaredMethod("setFirstName", String.class);

        Person person = new Person("Ahmad", "Fulan");
        firstName.invoke(person,"Mohammad");

        System.out.println(person.getFirstName());
    }
}
