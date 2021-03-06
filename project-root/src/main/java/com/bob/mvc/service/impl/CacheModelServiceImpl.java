/**
 * Copyright(C) 2016 Fugle Technology Co. Ltd. All rights reserved.
 *
 */
package com.bob.mvc.service.impl;

import java.util.List;

import com.bob.mvc.mapper.CacheModelMapper;
import com.bob.config.mvc.model.CacheModel;
import com.bob.mvc.service.CacheModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @since 2016年12月6日 上午11:29:04
 * @version $Id$
 * @author JiangJibo
 *
 */
@Service
public class CacheModelServiceImpl implements CacheModelService {

	@Autowired
	private CacheModelMapper cacheModelMapper;

	/* (non-Javadoc)
	 * @see com.bob.service.StudentService#listAll()
	 */
	@Override
	public List<CacheModel> listAll() {
		return cacheModelMapper.selectAll();
	}

	/* (non-Javadoc)
	 * @see com.bob.service.StudentService#create(com.bob.model.Student)
	 */
	@Override
	public void create(CacheModel student) {
		cacheModelMapper.insert(student);
	}

	/* (non-Javadoc)
	 * @see com.bob.service.StudentService#listByAge(java.lang.Integer)
	 */
	@Override
	public List<CacheModel> listByAge(Integer age) {
		return cacheModelMapper.selectByAge(age);
	}

	/* (non-Javadoc)
	 * @see com.bob.service.StudentService#getById(java.lang.Integer)
	 */
	@Override
	public CacheModel getById(Integer id) {
		return cacheModelMapper.selectById(id);
	}

	/* (non-Javadoc)
	 * @see com.bob.service.StudentService#modify(com.bob.model.Student)
	 */
	@Override
	public Integer updateById(CacheModel student) {
		return cacheModelMapper.updateById(student);
	}
}
