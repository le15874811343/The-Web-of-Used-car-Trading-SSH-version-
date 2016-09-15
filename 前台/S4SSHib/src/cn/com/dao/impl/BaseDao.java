package cn.com.dao.impl;

import org.springframework.orm.hibernate3.HibernateTemplate;
/**
 * 
 * hibernate模板基类
 */
public class BaseDao {
    private HibernateTemplate hibernateTemplate=null;
       //hibernate模板类的引用
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
}
