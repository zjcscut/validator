package org.throwable;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;

/**
 * @author zjc
 * @version 2016/11/28 23:34
 * @description ConstraintValidator&lt;Status,String&gt;中前者是注解类型,后者是需要判断的参数类型
 */
public class StatusValidator implements ConstraintValidator<Status, String> {

	private final String[] ALL_STATUS = {"created", "paid", "shipped", "closed"};

	@Override
	public void initialize(Status constraintAnnotation) {

	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
//		context.disableDefaultConstraintViolation();  //禁用默认的错误信息提示
//		context.buildConstraintViolationWithTemplate("新的错误信息提示").addConstraintViolation(); //使用新的错误信息提示
		return Arrays.asList(ALL_STATUS).contains(value);
	}
}
