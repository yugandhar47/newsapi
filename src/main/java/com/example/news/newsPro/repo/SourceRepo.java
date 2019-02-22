package com.example.news.newsPro.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.news.newsPro.model.Source;

@Repository
public interface SourceRepo extends CrudRepository<Source, Integer>{

	public List<Source> findByName(String name);

}
