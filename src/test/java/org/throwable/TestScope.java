package org.throwable;

import org.junit.BeforeClass;
import org.junit.Test;
import org.throwable.entity.Car;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

/**
 * @author zjc
 * @version 2016/11/28 0:00
 * @description
 */
public class TestScope {

	private static Validator validator;


	@BeforeClass
	public static void setUp() throws Exception {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	private <T> String validateBean(T bean) throws Exception {
		//方法的第二个不定参数数组是group
		Set<ConstraintViolation<T>> constraintViolations = validator.validate(bean);
		for (ConstraintViolation<T> constraintViolation : constraintViolations) {
			System.out.println("对象属性:" + constraintViolation.getPropertyPath());
			System.out.println("信息模板:" + constraintViolation.getMessageTemplate());
			System.out.println("错误信息:" + constraintViolation.getMessage());
		}
		return "success";
	}

	private <T> String validateBeanResurn(T bean) throws Exception {
		Set<ConstraintViolation<T>> constraintViolations = validator.validate(bean);
		for (ConstraintViolation<T> constraintViolation : constraintViolations) {
			return constraintViolation.getPropertyPath() + constraintViolation.getMessage();
		}
		return "success";
	}

	@Test
	public void Test1() throws Exception {
		Car car = new Car(null, "zzzzz", 2);
		validateBean(car);
	}

	@Test
	public void Test2() throws Exception {
		Car car = new Car("car", "z", 2);
		validateBean(car);
	}

	@Test
	public void Test3() throws Exception {
		Car car = new Car("car", "zsss", 1);
		validateBean(car);
	}

	@Test
	public void Test4() throws Exception {
		Car car = new Car(null, "z", 1);
		System.out.println(validateBeanResurn(car));
	}

	@Test
	public void Test5() throws Exception {
		Car car = new Car(null, "z", 1);
		System.out.println(validateBean(car));
	}

	@Test
	public void Test6() throws Exception {
		Car car = new Car("car", "zss", 2,"yes");
		validateBean(car);
	}



}
