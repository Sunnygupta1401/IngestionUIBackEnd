package org.ingestion.demo.dao;

import java.util.List;

import org.ingestion.demo.model.Customer;

public interface IngestionDao {
	public List<Customer> getAllCustomers() ;

	public Customer getCustomer(int id) ;

	public Customer addCustomer(Customer customer);

	public void updateCustomer(Customer customer) ;

	public void deleteCustomer(int id) ;
}
