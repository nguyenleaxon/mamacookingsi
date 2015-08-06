package gotoagilevn.com.nguyenle.persistence.repository;

import gotoagilevn.com.nguyenle.persistence.vo.Category;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoCategoryRepository extends MongoRepository<Category,String> {

	@Query("{name : ?0}")
	Category findByName(String name);
	
	@Override
	public <S extends Category> S save(S arg0);
}
