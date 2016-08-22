package cn.com.dao.impl;
import cn.com.pojo.*;
import cn.com.util.*;
import cn.com.dao.*;
import java.util.*;
import java.sql.*;
public class ModelDaoImpl extends BaseDao implements IModelDao {

	@Override
	public List<Model> getModelByWhere(Model model) {
		// TODO Auto-generated method stub
		List<Model> modelMap=new ArrayList<Model>();
		StringBuffer sql=new StringBuffer(" from Model where 1=1 ");
		List<Object> parmas=new ArrayList<Object>();
		
		if(model.getBId()!=0){
			sql.append("and BId=?");
			parmas.add(model.getBId());
		}
		if(model.getMId()!=0){
			sql.append("and MId=?");
			parmas.add(model.getMId());
		}
		if(model.getMName()!=null){
			sql.append("and MName=?");
			parmas.add(model.getMName());
		}
		Object[] o=new Object[parmas.size()];
		for(int i=0;i<parmas.size();i++){
			o[i]=parmas.get(i);		
			}
		

	try {
		modelMap=	super.getHibernateTemplate().find(sql.toString(),o);

	
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return modelMap;
	}

	@Override
	public int addModel(Model model) {
		// TODO Auto-generated method stub
		int count = 0;
		try {
			super.getHibernateTemplate().save(model);
			count = 1;
		} catch (Exception e) {
			// TODO: handle exception
			count = 0;
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public int updateModel(Model model) {
		// TODO Auto-generated method stub
		String sql="update Model set BId=? ,MName=? where MId=?";
		return super.getHibernateTemplate().bulkUpdate(sql, new Object[]{model.getBId(),model.getMName(),model.getMId()});
	}

	@Override
	public int deleteModel(Model model) {
		// TODO Auto-generated method stub
		int count = 0;
		try {
			super.getHibernateTemplate().delete(model);
			count = 1;
		} catch (Exception e) {
			// TODO: handle exception
			count = 0;
			e.printStackTrace();
		}
		return count;
	}

}
