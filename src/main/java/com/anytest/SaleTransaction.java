package com.anytest;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import lombok.Data;

import org.hibernate.annotations.Any;
import org.hibernate.annotations.AnyMetaDef;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.MetaValue;

@Data
@Entity
public class SaleTransaction {

	@Id
	@GeneratedValue
	private Long Id;
	private Date saleDate;
	private Long salePrice;

	 @Any (metaColumn = @Column(name = "vehicleType"))
	 @AnyMetaDef(idType = "long", metaType = "string",
	 metaValues = {
	 @MetaValue(targetEntity = Bus.class, value = "bus"),
	 @MetaValue(targetEntity = Truck.class, value = "truck")
	 })
	@Cascade( { org.hibernate.annotations.CascadeType.ALL})
	@JoinColumn(name = "vehicleId")
	private Vehicle vehicle;
	
	public SaleTransaction() {
	}

	public SaleTransaction(final Date saleDate, final Vehicle vehicle,final Long salePrice) {
		this.saleDate = saleDate;
		this.vehicle = vehicle;
		this.salePrice=salePrice;
	}
}