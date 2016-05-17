package com.buaa.oa.base;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.buaa.oa.bean.Position;

@SuppressWarnings("unchecked")
public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {

	//@Resource
	//private SessionFactory sessionFactory;
	private Class<T> clazz; 

	public BaseDaoImpl() {
		//使用反射技术得到T的真实类型
		
		//获取当前new的对象的泛型的父类类型
		ParameterizedType  pt = (ParameterizedType)this.getClass().getGenericSuperclass();
		//获取第一个类型参数的真实类型
		this.clazz = (Class<T>) pt.getActualTypeArguments()[0];
		//System.out.println("clazz ----> " + clazz);
	}
	
	/**
	 * 获取当前可用的Session
	 * 
	 * @return
	 */
//	protected Session getSession() {
//		return sessionFactory.getCurrentSession();
//	}

	public void save(T entity) {
		this.getSession().save(entity);
	}

	public void update(T entity) {
		getSession().update(entity);
	}

	public void delete(long id) {
		Object obj = getById(id);
		if (obj != null) {
			Session session = getSession();
			session.delete(obj);
		//	getSession().delete(getSession().get(Position.class, id));
			System.out.println("here " + id );
			//session.beginTransaction().commit();
		}
		
	}

	public T getById(Long id) {
		//System.out.println(id + "basedaoimpl.id");
		//System.out.println((T)getSession().get(clazz, id));
		return (T) getSession().get(clazz, id);
		
	}

	public List<T> getByIds(Long[] ids) {
		return getSession().createQuery(//
				"from User where id in (:ids)")//
				.setParameterList("ids", ids)//
				.list();
	}

	public List<T> findAll() {
		return getSession().createQuery(//
				"from " + clazz.getSimpleName())//
				.list();
	}

}
