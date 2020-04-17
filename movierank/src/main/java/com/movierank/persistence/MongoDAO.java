package com.movierank.persistence;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.movierank.domain.MovieDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class MongoDAO {
	@Autowired
	private MongoOperations mongoOper;
	
	public void save(MovieDTO mDto) {
		log.info(">>>>>> 영화 랭킹 정보 MongoDB에 저장");
		mongoOper.save(mDto);
	}
	
	public void dropCol() {
		log.info(">>>> Collection Drop");
		mongoOper.dropCollection("movieDTO");
	}
	
	public List<MovieDTO> movieList() {
		log.info(">>>>> 영화 랭킹 정보 MongoDB에 저장");
		
		//List<MovieDTO> list = mongoOper.find(query, entityClass);
		
		return null;
	}
}
