package gotoagilevn.com.nguyenle.persistence.repository;

import gotoagilevn.com.nguyenle.persistence.vo.VideoNameKeyword;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoNameKeywordRepository extends MongoRepository<VideoNameKeyword, String> {

    @Override
    public List<VideoNameKeyword> findAll();
    
    @Query("{name : ?0}")
	VideoNameKeyword findVideoNameKeyByName(String name);
}
