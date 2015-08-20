package gotoagilevn.com.nguyenle.persistence.service;

import gotoagilevn.com.nguyenle.persistence.vo.VideoChannel;

import java.util.List;

public interface VideoChannelService {

	List<VideoChannel> getAllActiveChannel() throws Exception;
}
