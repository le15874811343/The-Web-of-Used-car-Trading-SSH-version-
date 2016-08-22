package cn.com.dao.impl;

import java.sql.*;
import java.util.*;
import cn.com.pojo.*;
import cn.com.dao.*;
import cn.com.util.*;

public class PriceIntervalDaoImpl extends BaseDao implements IPriceIntervalDao{

	@Override
	public Map<Integer, Priceinterval> getPriceIntervalByCount() {
		// TODO Auto-generated method stub
		Map<Integer, Priceinterval> priceIntervalMap=new HashMap<Integer, Priceinterval>();
	
	      String hql="from Priceinterval  order by PCount desc";
	try {
	List<Priceinterval> plist=	PageUtil.querylist(1, 4, hql, null);
	for(Priceinterval p:plist){
		priceIntervalMap.put(p.getPId(), p);
	}
	
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return priceIntervalMap;
	}

}
