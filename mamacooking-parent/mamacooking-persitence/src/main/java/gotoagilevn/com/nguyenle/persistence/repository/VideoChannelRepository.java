package gotoagilevn.com.nguyenle.persistence.repository;

import java.util.List;

import gotoagilevn.com.nguyenle.persistence.vo.VideoChannel;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoChannelRepository extends MongoRepository<VideoChannel, String>  {

	
	@Query("{isActive : ?0}")
	public List<VideoChannel> findAllActiveChannel(boolean active);
}
