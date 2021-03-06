package gotoagilevn.com.nguyenle.schedual;

import gotoagilevn.com.nguyenle.persistence.service.VideoChannelService;
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

	private final static Logger LOGGER = Logger
			.getLogger(CrawlerVideosJob.class.getName());

	@Autowired
	VideoChannelGateway videoChannelGateway;

	@Autowired
	VideoChannelService channelService;

	//@Scheduled(fixedRate = 4000)
	@Scheduled(cron = "0 51 15 * * *")
	public void scheduleVideoHandling() {
		Collection<VideoChannel> videoChannel = getAllVideoChannelsFromDatabase();
		videoChannelGateway.getAllVideoChanelsFromDB(videoChannel);
	}

	private List<VideoChannel> getAllVideoChannelsFromDatabase() {
		List<VideoChannel> channels = null;
		try {
			LOGGER.info("Get all channel from database and pass the channel to single youtube channel");
			channels = channelService.getAllActiveChannel();

		} catch (Exception e) {
			LOGGER.error(e);
		}
		return channels;
	}

}
