package gotoagilevn.com.nguyenle.persistence.repository;

import gotoagilevn.com.nguyenle.persistence.vo.Video;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoRepository extends MongoRepository<Video, String> {
   
	
}
