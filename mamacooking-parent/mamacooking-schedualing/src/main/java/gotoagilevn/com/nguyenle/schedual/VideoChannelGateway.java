package gotoagilevn.com.nguyenle.schedual;

import gotoagilevn.com.nguyenle.persistence.vo.VideoChannel;

import java.util.Collection;

public interface VideoChannelGateway {

	void getAllVideoChanelsFromDB(Collection<VideoChannel> videochannels);
}
