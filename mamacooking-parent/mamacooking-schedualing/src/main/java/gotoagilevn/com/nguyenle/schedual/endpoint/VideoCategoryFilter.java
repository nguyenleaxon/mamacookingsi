package gotoagilevn.com.nguyenle.schedual.endpoint;

import gotoagilevn.com.nguyenle.persistence.service.VideoNameKeywordService;
import gotoagilevn.com.nguyenle.persistence.vo.Video;
import gotoagilevn.com.nguyenle.persistence.vo.VideoNameKeyword;

import java.text.Normalizer;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.annotation.Filter;
import org.springframework.integration.annotation.MessageEndpoint;

@MessageEndpoint
public class VideoCategoryFilter {

	@Autowired
	VideoNameKeywordService keywordService;

	@Filter
	public boolean accept(Video video) {
		boolean isAccepted = false;
		String videoName = video.getName();
		List<VideoNameKeyword> videoNames = keywordService.listAllKeywords();
		for (VideoNameKeyword keyword : videoNames) {
			String videoNormalizer = Normalizer.normalize(videoName, Normalizer.Form.NFD);
			String unicodeVideoName = videoNormalizer.replaceAll("[^\\x00-\\x7F]", ""); 
			if (unicodeVideoName.toLowerCase().contains(keyword.getName())) {
				isAccepted = true;
				break;
			}
		}

		return isAccepted;
	}

}
