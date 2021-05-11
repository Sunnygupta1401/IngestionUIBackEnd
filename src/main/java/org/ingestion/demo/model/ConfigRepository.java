package org.ingestion.demo.model;

import org.springframework.data.repository.CrudRepository;

public interface ConfigRepository extends CrudRepository<Config, Integer>{

	 Config findById(int id);
	
}
