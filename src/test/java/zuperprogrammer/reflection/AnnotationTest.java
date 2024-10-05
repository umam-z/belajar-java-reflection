package zuperprogrammer.reflection;

import org.junit.jupiter.api.Test;
import zuperprogrammer.reflection.data.Person;
import zuperprogrammer.reflection.validation.Validator;

public class AnnotationTest {
    @Test
    void testValidateUsingReflection() throws IllegalAccessException {
        Person person = new Person("Ahmad", "  ");
        Validator.validate(person);
    }
}
