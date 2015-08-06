package gotoagilevn.com.nguyenle.persistence.service;

import gotoagilevn.com.nguyenle.persistence.vo.Category;

public interface VideoCategoryService {

	Category findByName(String name) throws Exception;
	Category saveCategory(Category category) throws Exception;
}
