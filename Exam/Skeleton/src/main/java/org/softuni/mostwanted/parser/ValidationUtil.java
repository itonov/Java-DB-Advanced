package org.softuni.mostwanted.parser;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import java.util.Set;

public final class ValidationUtil {

    public static <T> boolean isValid(T t) {
        Set<ConstraintViolation<T>> validate = Validation.buildDefaultValidatorFactory().getValidator().validate(t);
        return validate.size() == 0;
    }
}
