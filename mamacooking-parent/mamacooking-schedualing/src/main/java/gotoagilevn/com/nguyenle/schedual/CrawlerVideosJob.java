package gotoagilevn.com.nguyenle.schedual;

import gotoagilevn.com.nguyenle.persistence.vo.VideoChannel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class CrawlerVideosJob {

	private final static Logger LOGGER = Logger.getLogger(CrawlerVideosJob.class.getName()); 
	
	@Autowired
	VideoChannelGateway videoChannelGateway;
	

	
	
	@Scheduled(fixedRate = 4000)
	public void scheduleVideoHandling() {
		Collection<VideoChannel> videoChannel = getAllVideoChannelsFromDatabase();
		videoChannelGateway.getAllVideoChanelsFromDB(videoChannel);
		 
	}
	
	private List<VideoChannel> getAllVideoChannelsFromDatabase() {
		LOGGER.info("Get all channel from database and pass the channel to single youtube channel");
		/*run clawer4j*/
		List<VideoChannel> videoChannels = new ArrayList<>();
		VideoChannel channel1 = new VideoChannel("Am thuc viet nam","https://www.youtube.com/channel/UCxmlfcxN_K2JPbhbN8dB8RQ");
	//	VideoChannel channel2 = new VideoChannel("Am thuc han quoc","https://www.youtube.com/channel/UCxmlfcxN_K2JPbhbN8dB8RQ");
	//	videoChannels.add(channel2);
		videoChannels.add(channel1);
		return videoChannels;
	}
	
}
