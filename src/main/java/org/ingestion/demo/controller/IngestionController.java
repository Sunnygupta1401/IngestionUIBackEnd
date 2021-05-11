package org.ingestion.demo.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.ingestion.demo.model.Config;
import org.ingestion.demo.model.Customer;
import org.ingestion.demo.service.ConfigService;
import org.ingestion.demo.service.IngestionService;
import org.ingestion.demo.service.SparkJobSubmitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@CrossOrigin
public class IngestionController {

	@Autowired
	IngestionService customerService;
	
	@Autowired
	ConfigService configService;
	
	@Value("${basePath}")
	String basePath;

	@RequestMapping(value = "/getAllCustomers", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Customer> getAllCustomers(Model model) throws JsonGenerationException, JsonMappingException, IOException {

		List<Customer> listOfCustomers = customerService.getAllCustomers();
		model.addAttribute("customer", new Customer());
		model.addAttribute("listOfCustomers", listOfCustomers);
		ObjectMapper mapper= new ObjectMapper();
		//java object to json file
		mapper.writeValue(new File("c:\\tmp\\customer.json"), listOfCustomers);
		return listOfCustomers;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET, headers = "Accept=application/json")
	public String goToHomePage() {
		return "redirect:/getAllCustomers";
	}

	@RequestMapping(value = "/getCustomer/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Customer getCustomerById(@PathVariable int id) {
		return customerService.getCustomer(id);
		
	}

	@RequestMapping(value = "/addCustomer", method = RequestMethod.POST, headers = "Accept=application/json")
	public Customer addCustomer(@RequestBody Customer customer) {
		return customerService.addCustomer(customer);

	}

	@RequestMapping(value = "/addCustomer", method = RequestMethod.PUT, headers = "Accept=application/json")
	public Customer updateCustomer(@RequestBody Customer customer) {
		return customerService.updateCustomer(customer); 

	}	

	@RequestMapping(value = "/deleteCustomer/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public void deleteCustomer(@PathVariable("id") int id) {
		customerService.deleteCustomer(id);


	}
	
@RequestMapping(value = "/generateJson", method = RequestMethod.POST, headers = "Accept=application/json")
	public void generateJson(@RequestBody String rawJson,@RequestHeader String pk) throws IOException {
		Path path = Paths.get(basePath+pk+".json");
		Files.write(path, rawJson.getBytes());
		System.out.println(rawJson);
		System.out.println(pk);
		configService.insertJsonConfig(rawJson,pk);
	}		

@RequestMapping(value = "/generateJson", method = RequestMethod.PUT, headers = "Accept=application/json")
public void updateJson(@RequestBody String rawJson,@RequestHeader String pk,@RequestHeader("id") String id) throws IOException {
	Path path = Paths.get(basePath+pk+".json");
	System.out.print("updateJson");
	Files.write(path, rawJson.getBytes());
	System.out.println(rawJson);
	System.out.println(pk);
	configService.updateJsonConfig(rawJson,pk,Integer.valueOf(id));
}

@RequestMapping(value = "/getAllConfig", method = RequestMethod.GET, headers = "Accept=application/json")
public List<Config> getAllConfig() throws IOException {
	return configService.getAllConfig();
}		

@RequestMapping(value = "/deleteConfig", method = RequestMethod.DELETE, headers = "Accept=application/json")
public void deleteConfig(@RequestHeader("id") String id) {
		configService.deleteConfig(Integer.valueOf(id));


}


@RequestMapping(value = "/getConfig/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
public String getConfig(@PathVariable("id")  int id) throws IOException {
	System.out.println(id);
	String data=configService.getConfig(id);
	System.out.println(data);
	return data;
	
}			

@RequestMapping(value = "/triggerJob", method = RequestMethod.GET, headers = "Accept=application/json")
public void triggerJob(@RequestHeader("pk") String pk) throws IOException
{
	System.out.println("Trigger Job for PK "+pk);
	
	(new SparkJobSubmitter(basePath+pk+".json", configService)).start();
	
}



}
