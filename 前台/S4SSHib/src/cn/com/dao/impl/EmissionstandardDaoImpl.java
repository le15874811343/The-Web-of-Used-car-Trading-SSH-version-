package cn.com.dao.impl;
import java.sql.*;
import java.util.*;

import cn.com.pojo.*;
import cn.com.dao.*;
import cn.com.util.*;
/**
 * 
 * 排放标准操作实现类
 *@author  lej
 */
public class EmissionstandardDaoImpl extends BaseDao implements IEmissionstandardDao {
        /**
	 * 按热度获取排放标准信息的方法
	 * @Map<Integer,Emissionstandard>
	 */
	@Override
	public Map<Integer, Emissionstandard> getEmissionstandardByCount() {
		// TODO Auto-generated method stub
		Map<Integer, Emissionstandard> emissionstandardMap=new HashMap<Integer, Emissionstandard>();
		
           String hql="from  Emissionstandard  order by ECount desc";
	try {
		List<Emissionstandard> dislist=	PageUtil.querylist(1, 5, hql, null); //获取指定行数区间的结果集
		//遍历结果集，加入map中
		for(Emissionstandard d: dislist){
			emissionstandardMap.put(d.getEId(), d);
			}
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return emissionstandardMap;
	}

}
