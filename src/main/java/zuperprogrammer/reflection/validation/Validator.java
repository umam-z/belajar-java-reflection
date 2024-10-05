package zuperprogrammer.reflection.validation;

import zuperprogrammer.reflection.annotation.NotBlank;
import zuperprogrammer.reflection.data.Person;

import java.lang.reflect.Field;

public class Validator {
    public static void validate(Object person) throws IllegalAccessException {
        Class<?> aClass = person.getClass();
        for (Field field : aClass.getDeclaredFields()) {
            field.setAccessible(true);
            NotBlank annotation = field.getAnnotation(NotBlank.class);
            if (annotation != null) {
               String value = (String) field.get(person);
               if (!annotation.allowEmptyString()) value = value.trim();
               if (value == null || value.isEmpty()) {
                   throw new RuntimeException("Field: " + field.getName() + " is blank");
               }
            }
        }
    }
}
