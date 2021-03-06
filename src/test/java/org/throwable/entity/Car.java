package org.throwable.entity;

import org.throwable.Status;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author zjc
 * @version 2016/11/28 0:02
 * @description
 */
public class Car {

	@NotNull
	private String name;
	@NotNull
	@Size(min = 2,max = 10)
	private String license;
	@Min(2)
	private Integer seatCount;
	@Status
	private String status;

	public Car() {
	}

	public Car(String name, String license, Integer seatCount) {
		this.name = name;
		this.license = license;
		this.seatCount = seatCount;
	}


	public Car(String name, String license, Integer seatCount,String status) {
		this.name = name;
		this.license = license;
		this.seatCount = seatCount;
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLicense() {
		return license;
	}

	public void setLicense(String license) {
		this.license = license;
	}

	public Integer getSeatCount() {
		return seatCount;
	}

	public void setSeatCount(Integer seatCount) {
		this.seatCount = seatCount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
