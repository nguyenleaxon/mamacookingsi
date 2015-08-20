package gotoagilevn.com.nguyenle.persistence.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gotoagilevn.com.nguyenle.persistence.repository.VideoCategoryRepository;
import gotoagilevn.com.nguyenle.persistence.service.VideoCategoryService;
import gotoagilevn.com.nguyenle.persistence.vo.Category;

@Service
public class VideoCategoryServiceImpl implements VideoCategoryService{

	@Autowired
	private VideoCategoryRepository categoryRepository;
	
	@Override
	public Category findByName(String name) throws Exception {
			Category test = categoryRepository.findByName(name);
			return test ;
	}

	@Override
	public Category saveCategory(Category category) throws Exception {
		return categoryRepository.save(category);
	}

}
