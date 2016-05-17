package com.buaa.oa.service;

import java.util.List;

import com.buaa.oa.bean.Position;

public interface PositionService {


	
	//查询所有*
	List<Position> findAll();
	//按id删除
	void delete(long id);
	

	void save(Position position);
	Position getById(long id);
	void update(Position position);

	
}