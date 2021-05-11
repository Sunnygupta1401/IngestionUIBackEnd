package org.ingestion.demo.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.ingestion.demo.model.Config;
import org.ingestion.demo.model.ConfigRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConfigService {

	@Autowired
	EntityManager em;
	
	@Autowired
	ConfigRepository configRepository;

	@Transactional
	public void insertJsonConfig(String body, String pk) {
		System.out.print("generateJson1 "+body);
		Config config = new Config();
		config.setPk(pk);
		config.setBody(body);
		em.persist(config);
	}
	

	@Transactional
	public void updateJsonConfig(String body, String pk, int id) {
		System.out.print("generateJson1");
		Config config = new Config();
		config.setId(id);
		config.setPk(pk);
		config.setBody(body);
		
		configRepository.save(config);
	}
	
	@Transactional
	public void deleteConfig(int id) {
		configRepository.delete(id);
		
	}

	public List<Config> getAllConfig() {
		List<Config> newList = new ArrayList<>();
		List<Config> returnList = new ArrayList<>();

		configRepository.findAll().forEach(newList::add);

		for (Config config : newList) {

			Config conf = new Config();
			conf.setId(config.getId());

			conf.setPk(config.getPk());

			returnList.add(conf);
		}

		return returnList;

	}

	public String getConfig(int id) {
		return configRepository.findOne(id).getBody();

	}
	
	public void triggerJob(String jsonPath) throws IOException {
		String command="test";
		
		ProcessBuilder processBuilder = new ProcessBuilder(command,jsonPath);
		Process process=processBuilder.start();
		String output="";
		processBuilder.redirectErrorStream(true);
		try(BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))){
			output=reader.lines().collect(Collectors.joining(System.lineSeparator()));
		}
		
		System.out.println(output);
	}

}
