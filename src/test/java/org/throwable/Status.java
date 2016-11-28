package org.throwable;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @author zjc
 * @version 2016/11/28 23:33
 * @description
 */
@Constraint(validatedBy = {StatusValidator.class})
@Documented
@Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Status {

	String message() default "不正确的状态 , 应该是 'created', 'paid', shipped', closed'其中之一";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
