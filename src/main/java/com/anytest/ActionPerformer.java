package com.anytest;

import java.util.Date;
public class ActionPerformer {
	
	public static void main(String[] args) {
		
		final Bus bus = new Bus(600000L, "ABCDBusModel", 100L, 35, true);
		final Truck truck = new Truck(700000L, "ABCDTruckModel", 300L, 30000L);
		
		final SaleTransaction busSaleTransaction = new SaleTransaction(new Date(), bus,650000L);
		final SaleTransaction truckSaleTransaction = new SaleTransaction(new Date(), truck,780000L);
		
		HibernateInterface.exectueQuery("delete from com.anytest.SaleTransaction");
		HibernateInterface.exectueQuery("delete from com.anytest.Vehicle");
		
		HibernateInterface.saveEntities(busSaleTransaction);
		HibernateInterface.saveEntities(truckSaleTransaction);
		
		System.out.println("SaleTransaction records =" + HibernateInterface.getRecordsOfType(SaleTransaction.class));
	}

}