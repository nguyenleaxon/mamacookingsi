package gotoagilevn.com.nguyenle.schedual.endpoint;

import gotoagilevn.com.nguyenle.persistence.vo.Video;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;

@MessageEndpoint
public class GettingAllVideosFromChannelServiceActivator {

	private final static Logger LOGGER = Logger.getLogger(GettingAllVideosFromChannelServiceActivator.class.getName());
	
	@ServiceActivator
	public List<Video> getAllVideosFromChannel(List<Video> videos) {
		LOGGER.info("##########3 Get ALL Video From SI ############");
		return videos;
		
	}
}
