package com.shall.customeraccount.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.shall.customeraccount.model.Customer;
import com.shall.customeraccount.network.response.ResponseVO;
import com.shall.customeraccount.service.GenericService;

@RestController
@RequestMapping("/v1/customer")
public class CustomerController {

	@Autowired
	private GenericService<Customer, Long> service;

	@RequestMapping(value = "/", produces = "application/json; charset=UTF-8", method = RequestMethod.GET)
	public ResponseEntity<ResponseVO<Iterable<Customer>>> getAllCustomerAccounts() {
		return ResponseEntity.ok(new ResponseVO<>(service.findAll()));
	}

	@RequestMapping(value = "/{customer-id}", produces = "application/json; charset=UTF-8", method = RequestMethod.GET)
	public ResponseEntity<ResponseVO<Customer>> findCustomerById(@PathVariable("customer-id") String customerId) {
		return ResponseEntity.ok(new ResponseVO<>(service.find(Long.parseLong(customerId))));
	}

	@RequestMapping(value = "/", produces = "application/json; charset=UTF-8", method = RequestMethod.POST)
	public ResponseEntity<ResponseVO<Customer>> saveCustomer(@RequestBody Customer customer) {
		return ResponseEntity.ok(new ResponseVO<>(service.save(customer)));
	}

	@RequestMapping(value = "/{customer-id}", produces = "application/json; charset=UTF-8", method = RequestMethod.PATCH)
	public ResponseEntity<ResponseVO<Customer>> updateCustomer(@PathVariable("customer-id") Long customerId,
			@RequestBody Customer customer) {
		customer.setCustomerId(customerId);
		return ResponseEntity.ok(new ResponseVO<>(service.update(customer)));
	}

	@RequestMapping(value = "/{customer-id}", produces = "application/json; charset=UTF-8", method = RequestMethod.DELETE)
	public ResponseEntity<ResponseVO<Boolean>> deleteCustomer(@PathVariable("customer-id") Long customerId) {
		return ResponseEntity.ok(new ResponseVO<>(service.delete(customerId)));
	}

}
