package gotoagilevn.com.nguyenle.schedual.endpoint;

import gotoagilevn.com.nguyenle.persistence.service.VideoCategoryService;
import gotoagilevn.com.nguyenle.persistence.service.VideoNameKeywordService;
import gotoagilevn.com.nguyenle.persistence.vo.Video;
import gotoagilevn.com.nguyenle.persistence.vo.Category;
import gotoagilevn.com.nguyenle.persistence.vo.VideoNameKeyword;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.Transformer;

@MessageEndpoint
public class AddCategoryPropertiesTransform {

	private final static Logger LOGGER = Logger
			.getLogger(AddCategoryPropertiesTransform.class.getName());

	@Autowired
	VideoCategoryService categoryService;

	@Autowired
	VideoNameKeywordService keywordService;

	@Transformer
	public Video addCategoryProperties(Video video) {
		try {
		String videoName = video.getName();
		List<VideoNameKeyword> keywords = keywordService.listAllKeywords();
		for (VideoNameKeyword keyword : keywords) {
			if (videoName.toLowerCase().contains(keyword.getName())) {
				Category category = categoryService.findByName(keyword.getName());
				if (category == null) {
				   category = createCategory(keyword.getName());
				   categoryService.saveCategory(category);
				}
				video.setVideoCategory(category);
				LOGGER.info("Video Name " + videoName + " Category " + category.getName());
			}
		}
		//
		// VideoCategory unknowCategory = new VideoCategory("unknow");
		// unknowCategory.set_id(new ObjectId());
		// video.setVideoCategory(unknowCategory);
		}catch (Exception ex) {
			LOGGER.error("DATABASE EXCEPTION");
		}
		return video;
	}
	
	private Category createCategory(String categoryName) {
		Category category = new Category(categoryName);
		category.setDescription(categoryName);
		return category;
	}

}
