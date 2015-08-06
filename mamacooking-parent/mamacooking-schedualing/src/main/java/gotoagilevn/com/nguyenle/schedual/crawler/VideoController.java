package gotoagilevn.com.nguyenle.schedual.crawler;

import edu.uci.ics.crawler4j.crawler.CrawlController;
import gotoagilevn.com.nguyenle.persistence.vo.Video;
import gotoagilevn.com.nguyenle.schedual.util.VideoConstrainsUtil;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class VideoController {

	private VideoConfigureSingleton videoConfig = VideoConfigureSingleton
			.getInstance();

	public List<Video> startClawringChannel(String channel) throws Exception {
		List<Video> listVideo = null;
		CrawlController controller = videoConfig.createCrawlController();
		controller.addSeed(channel);
		controller.start(MyCrawler.class, VideoConstrainsUtil.NUMBER_OF_CRAWLER);
		List<Object> crawlersLocalData = controller.getCrawlersLocalData();
		listVideo = (List<Video>) crawlersLocalData.get(0);
		if (controller.isFinished()) {
			System.out.println("Get all video");
		}
//		for (Video video : listVideo) {
//			System.out.println(video.getName());
//		}
		return listVideo;
	}

}
