package gotoagilevn.com.nguyenle.persistence.vo;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="videokeyword")
public class VideoNameKeyword implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	
	public VideoNameKeyword() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	
	
}
