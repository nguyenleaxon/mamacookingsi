package gotoagilevn.com.nguyenle.persistence.service.impl;

import java.text.Normalizer;

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
			String videoName = Normalizer.normalize(video.getName(), Normalizer.Form.NFD);
			String unicodeVideoName = videoName.replaceAll("[^\\x00-\\x7F]", ""); 
			video.setUnicodeName(unicodeVideoName);
			videoRepositoryJPA.save(video);
			LOGGER.info("YAHHHOOOO ");
		} catch (Exception ex) {
			LOGGER.error(ex.getMessage());
		}

		return 1;
	}

}
