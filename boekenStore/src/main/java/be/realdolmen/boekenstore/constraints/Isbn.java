package be.realdolmen.boekenstore.constraints;

import javax.validation.Constraint;
import javax.validation.Payload;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Constraint(validatedBy = { IsbnValidator.class })
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RUNTIME)
public @interface Isbn {
	String message() default "{com.realdolmen.boekenstore.constraints.Isbn}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
