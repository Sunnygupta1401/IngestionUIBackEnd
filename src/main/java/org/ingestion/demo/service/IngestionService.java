package org.ingestion.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.ingestion.demo.dao.IngestionDao;
import org.ingestion.demo.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("customerService")
public class IngestionService {

	@Autowired
	IngestionDao customerDao;

	@Transactional
	public List<Customer> getAllCustomers() {
		return customerDao.getAllCustomers();
	}

	@Transactional
	public Customer getCustomer(int id) {
		return customerDao.getCustomer(id);
	}

	@Transactional
	public Customer addCustomer(Customer customer) {
		customerDao.addCustomer(customer);
		return customer;
	}

	@Transactional
	public Customer updateCustomer(Customer customer) {
		customerDao.updateCustomer(customer);
		return customer;
	}

	@Transactional
	public void deleteCustomer(int id) {
		customerDao.deleteCustomer(id);
	}
}
