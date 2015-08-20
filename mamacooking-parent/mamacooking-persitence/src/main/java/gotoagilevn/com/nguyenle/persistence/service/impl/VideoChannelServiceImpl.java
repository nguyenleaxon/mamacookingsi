package gotoagilevn.com.nguyenle.persistence.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gotoagilevn.com.nguyenle.persistence.repository.VideoChannelRepository;
import gotoagilevn.com.nguyenle.persistence.service.VideoChannelService;
import gotoagilevn.com.nguyenle.persistence.vo.VideoChannel;

@Service
public class VideoChannelServiceImpl implements VideoChannelService {

	@Autowired
	VideoChannelRepository channelRepository;
	
	@Override
	public List<VideoChannel> getAllActiveChannel() throws Exception {
		return channelRepository.findAllActiveChannel(true);
	}

}
