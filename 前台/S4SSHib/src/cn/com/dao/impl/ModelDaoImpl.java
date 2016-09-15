package cn.com.dao.impl;
import cn.com.pojo.*;
import cn.com.util.*;
import cn.com.dao.*;
import java.util.*;
import java.sql.*;
/**
 * 车系信息操作实现类
 * @author lej
 */
public class ModelDaoImpl extends BaseDao implements IModelDao {
      /**
       * 按条件获取车系信息的方法
       * @parma model
       *@return List<Model> 
       */
	@Override
	public List<Model> getModelByWhere(Model model) {
		// TODO Auto-generated method stub
		List<Model> modelMap=new ArrayList<Model>();
		StringBuffer sql=new StringBuffer(" from Model where 1=1 ");
		List<Object> parmas=new ArrayList<Object>();
		 //动态参数准备并延伸HQL语句
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
		modelMap=	super.getHibernateTemplate().find(sql.toString(),o);  //获取结果集

	
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return modelMap;
	}

}
