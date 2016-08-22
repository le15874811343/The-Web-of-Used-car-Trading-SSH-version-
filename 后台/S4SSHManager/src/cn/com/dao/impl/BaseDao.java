package cn.com.dao.impl;

import org.springframework.orm.hibernate3.HibernateTemplate;

public class BaseDao {
    private HibernateTemplate hibernateTemplate=null;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
}
