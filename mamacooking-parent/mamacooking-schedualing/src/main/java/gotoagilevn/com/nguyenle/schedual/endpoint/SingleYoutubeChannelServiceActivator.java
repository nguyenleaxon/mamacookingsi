package gotoagilevn.com.nguyenle.schedual.endpoint;

import gotoagilevn.com.nguyenle.persistence.vo.VideoChannel;

import org.apache.log4j.Logger;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;

@MessageEndpoint
public class SingleYoutubeChannelServiceActivator {
	
	private final static Logger LOGGER = Logger.getLogger(SingleYoutubeChannelServiceActivator.class.getName()); 
	
	//@Autowired
	//private VideoCategoryService categoryService;
	
	@ServiceActivator
	public VideoChannel videoChannel (VideoChannel videoChannel) throws Exception {
		LOGGER.info("Get only one channel by using splitter from list of channel");
	//   VideoCategory category =	categoryService.findByName("breef");
		
		
		return videoChannel;
	}
}
