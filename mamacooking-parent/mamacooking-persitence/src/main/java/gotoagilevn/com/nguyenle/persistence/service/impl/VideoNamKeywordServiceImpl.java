package gotoagilevn.com.nguyenle.persistence.service.impl;

import java.util.List;

import gotoagilevn.com.nguyenle.persistence.repository.VideoNameKeywordRepository;
import gotoagilevn.com.nguyenle.persistence.service.VideoNameKeywordService;
import gotoagilevn.com.nguyenle.persistence.vo.VideoNameKeyword;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VideoNamKeywordServiceImpl implements VideoNameKeywordService{

	@Autowired
	VideoNameKeywordRepository keywordService;
	
	@Override
	public List<VideoNameKeyword> listAllKeywords() {
		return keywordService.findAll();
	}

	@Override
	public VideoNameKeyword findVideoNameKeyByName(String name)
			throws Exception {
		return keywordService.findVideoNameKeyByName(name);
	}

}
