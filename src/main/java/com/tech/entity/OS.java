package com.tech.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.springframework.lang.Nullable;

@Entity
@DiscriminatorValue("O")
public class OS extends Item {

	@Nullable
	@Column(name="item_serial")
	private String serial;

	public OS() {
		
	}

	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}
	
	
}
