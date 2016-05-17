package com.buaa.oa.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.buaa.oa.bean.Position;
import com.buaa.oa.dao.PositionDao;
import com.buaa.oa.service.PositionService;

public class PositionServiceImpl implements PositionService {


	private PositionDao positionDao;
	
	public void setPositionDao(PositionDao positionDao) {
		this.positionDao = positionDao;
	}

	public List<Position> findAll() {
		// TODO Auto-generated method stub
		return positionDao.findAll();
	}

	public void delete(long id) {
		positionDao.delete(id);
	}

	public void save(Position position) {
		// TODO Auto-generated method stub
		positionDao.save(position);
	}

	public Position getById(long id) {
		
		return positionDao.getById(id);
	}

	public void update(Position position) {

		positionDao.update(position);
	}

}
