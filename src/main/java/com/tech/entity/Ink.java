package com.tech.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@DiscriminatorValue("I")
public class Ink extends Item {

	@Column(name="ink_code")
	private String code;
	
	@Max(value=1000, message="must be less than or equal to 1000")
	@Min(value=10, message="must be greater than or equal to 10")
	@NotNull(message="is required")
	@Column(name = "item_qty")
	private Integer itemQty;

	public Ink() {
		super();
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getItemQty() {
		return itemQty;
	}

	public void setItemQty(Integer itemQty) {
		this.itemQty = itemQty;
	}
	
}
