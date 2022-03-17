package com.yoonveloping.jpabook.domain;

import javax.persistence.Embeddable;
import lombok.Getter;

@Embeddable // 내장 타입임을 명시 (어딘가에 내장될 수 있다.)
@Getter
public class Address {

	private String city;
	private String street;
	private String zipcode;

	// JPA 스펙 상 만든 것
	protected Address() {
	}

	public Address(String city, String street, String zipcode) {
		this.city = city;
		this.street = street;
		this.zipcode = zipcode;
	}
}
