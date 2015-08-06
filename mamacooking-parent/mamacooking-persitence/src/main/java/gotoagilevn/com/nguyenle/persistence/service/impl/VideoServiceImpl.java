package gotoagilevn.com.nguyenle.persistence.service.impl;

import gotoagilevn.com.nguyenle.persistence.repository.VideoRepository;
import gotoagilevn.com.nguyenle.persistence.service.VideoService;
import gotoagilevn.com.nguyenle.persistence.vo.Video;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VideoServiceImpl implements VideoService {

	private final static Logger LOGGER = Logger.getLogger(VideoServiceImpl.class.getName());

	@Autowired
	VideoRepository videoRepositoryJPA;

	@Override
	public int saveVideoToDatabase(Video video) {

		try {
	
			videoRepositoryJPA.save(video);
			LOGGER.info("YAHHHOOOO ");
		} catch (Exception ex) {
			LOGGER.error(ex.getMessage());
		}

		return 1;
	}

}
