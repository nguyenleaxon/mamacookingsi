package gotoagilevn.com.nguyenle.persistence.service;

import gotoagilevn.com.nguyenle.persistence.vo.VideoNameKeyword;

import java.util.List;

public interface VideoNameKeywordService {

	List<VideoNameKeyword> listAllKeywords();
	VideoNameKeyword findVideoNameKeyByName(String name) throws Exception;
}
