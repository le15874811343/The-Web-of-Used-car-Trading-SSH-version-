package cn.com.dao.impl;
import cn.com.pojo.*;
import cn.com.util.*;
import cn.com.dao.*;
import java.util.*;

public class CarAgeDaoImpl extends BaseDao implements ICarAgeDao{
  
	@Override
	public Map<Integer, Carage> getCarAgeByCount() {
		// TODO Auto-generated method stub
		Map<Integer, Carage> carAgeMap=new HashMap<Integer, Carage>();
	
	 String hql="from Carage  order by ACount desc";
	List<Carage> caglist= PageUtil.querylist(1, 5, hql, null);
	for(Carage c:caglist){
		carAgeMap.put(c.getAId(), c);
	}
	
		return carAgeMap;
	}

}
