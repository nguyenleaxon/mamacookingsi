package gotoagilevn.com.nguyenle.schedual.endpoint;

import gotoagilevn.com.nguyenle.persistence.service.VideoCategoryService;
import gotoagilevn.com.nguyenle.persistence.service.VideoService;
import gotoagilevn.com.nguyenle.persistence.vo.Category;
import gotoagilevn.com.nguyenle.persistence.vo.Video;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;

@MessageEndpoint
public class LoggingRejectVideoServiceActivator {

	private final static Logger LOGGER = Logger
			.getLogger(LoggingRejectVideoServiceActivator.class.getName());

	@Autowired
	private VideoService videoService;

	@Autowired
	private VideoCategoryService categoryService;

	@ServiceActivator
	public void loggingRejectVideo(Video video) {

		Category unknowCategory = null;
		try {
			unknowCategory = categoryService.findByName("unknow");
			video.setVideoCategory(unknowCategory);
			videoService.saveVideoToDatabase(video);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			LOGGER.error("Error Message " + e.getMessage());
		}
		LOGGER.info("######### Video Name " + video.getName() + " Doesn't exist in keywords table #######");
	}
}
