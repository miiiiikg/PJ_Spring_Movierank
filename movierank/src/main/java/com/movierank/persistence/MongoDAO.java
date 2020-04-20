package com.movierank.persistence;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.movierank.domain.MovieDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class MongoDAO {
	// 종류가 다른 일꾼이 있다
	// MongoOperations 기능은 다 해준다 (조회,삭제,입력 )자동화가 되어있다, 디테일이 떨어짐
	// 쓰기는 편하지만 디테일이 떨어진다 
	@Autowired
	private MongoOperations mongoOper;
	
	// MovieDTO Type 객체를 생성 이름을 자동으로 생성
	// => movieDTO 첫글자 소문자로 만듬
	
	public void save(MovieDTO mDto) {
		log.info(">>>>>> 영화 랭킹 정보 MongoDB에 저장");
		// insert 에러가난다  save 업데이트 똑같은 id값으로 들어오면 새로들어온 값으로 업데이트를 해준다
		// mongo 중복데이터 상관없음, _id는 절때 중복x
		mongoOper.save(mDto);
	}
	
	public void dropCol() {
		log.info(">>>> Collection Drop");
		// 통으로 지워버리는것 dropCollection
		mongoOper.dropCollection("movie");
	}
	
	public List<MovieDTO> movieList() {
		log.info(">>>>> 영화 랭킹 정보 MongoDB에서 Select");
		// cri : key값 , query : value값
		// Criteria cri = new Criteria(key);
		// cri.is(value);
		// SELECT * FROM movie
		// WHERE key = value;
		Criteria cri = new Criteria();
		Query query = new Query(cri);
		List<MovieDTO> list = mongoOper.find(query, MovieDTO.class, "movie");
		for (MovieDTO one : list) {
			log.info(one.toString());
		}
		
		//List<MovieDTO> list = mongoOper.find(query, entityClass);
		
		return list;
	}
}
