package gotoagilevn.com.nguyenle.schedual.endpoint;

import gotoagilevn.com.nguyenle.persistence.service.VideoService;
import gotoagilevn.com.nguyenle.persistence.vo.Video;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;

@MessageEndpoint
public class JmsServiceActivator {
	
	private final static Logger LOGGER = Logger.getLogger(AddCategoryPropertiesTransform.class.getName());
	
	@Autowired
	VideoService videoService;
	
	@ServiceActivator
	public void readVideoFromQueeu(Video video) {
		LOGGER.info("Reading Video From Queeu : " + video.getName());
		videoService.saveVideoToDatabase(video);
		LOGGER.info("########### DONE SAVING DATABASE  " + video.getName());
	}
	
}
