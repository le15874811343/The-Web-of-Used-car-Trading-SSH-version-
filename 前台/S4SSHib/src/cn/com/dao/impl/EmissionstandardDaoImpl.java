package cn.com.dao.impl;
import java.sql.*;
import java.util.*;

import cn.com.pojo.*;
import cn.com.dao.*;
import cn.com.util.*;
public class EmissionstandardDaoImpl extends BaseDao implements IEmissionstandardDao {

	@Override
	public Map<Integer, Emissionstandard> getEmissionstandardByCount() {
		// TODO Auto-generated method stub
		Map<Integer, Emissionstandard> emissionstandardMap=new HashMap<Integer, Emissionstandard>();
		
           String hql="from  Emissionstandard  order by ECount desc";
	try {
		List<Emissionstandard> dislist=	PageUtil.querylist(1, 5, hql, null);
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
