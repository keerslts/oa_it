package com.buaa.oa.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.buaa.oa.bean.Position;
import com.buaa.oa.service.PositionService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

//@Controller   //交给容器管理
//@Scope("prototype")  //保证多例的形式
public class PositionAction extends ActionSupport implements ModelDriven<Position>{

	//@Resource
	private PositionService positionService;
	private long id;
	private Position model = new Position();
	private List<Position> positionList; 
	private String name;
	private String description;
	
	
	public List<Position> getPositionList() {
		return positionList;
	}

	public void setPositionList(List<Position> positionList) {
		this.positionList = positionList;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setPositionService(PositionService positionService) {
		this.positionService = positionService;
	}

	/** 列表 */
	public String list() {
		 positionList = positionService.findAll();
		//ActionContext.getContext().put("positionList", positionList);
		return "list";
	}
	
	/** 删除 */
	public String delete() {
		positionService.delete(model.getId());
		return "toList";
	}
	
	/** 添加页面 */
	public String addUI() {
		
		return "addUI";
	}
	
	/** 添加 */
	public String add() {
	//	Position position = new Position();
	//	position.setName(name);
		positionService.save(model);
		return "toList";
	}
	
	/** 修改页面 */
	public String editUI() {
		//准备回显的数据
		Position position = positionService.getById(model.getId());
	//	System.out.println(id + "  " + position.getId());
	//  把数据提交到栈顶
		ActionContext.getContext().getValueStack().push(position);
		return "editUI";
	}
	
	/** 修改 */
	public String edit() {
		//从数据库中获取源对象
		Position position = positionService.getById(model.getId());
		//设置要修改的属性
	//	System.out.println(model.getDescription());
		position.setDescription(model.getDescription());
	//	System.out.println(position.getDescription());
		position.setName(model.getName());
		// 更新到数据库
		positionService.update(position);
		return "toList";
	}

	public Position getModel() {
		// TODO Auto-generated method stub
		return model;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
