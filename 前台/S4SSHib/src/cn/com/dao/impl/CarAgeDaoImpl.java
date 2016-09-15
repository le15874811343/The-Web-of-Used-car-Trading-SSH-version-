package cn.com.dao.impl;
import cn.com.pojo.*;
import cn.com.util.*;
import cn.com.dao.*;
import java.util.*;
/**
 * 车龄信息操作实现类
 *@author  lej 
 */
public class CarAgeDaoImpl extends BaseDao implements ICarAgeDao{
  	/**
	 * 按热度获取车龄信息的方法
	 * @return Map<Integer,Carage>
	 */
	@Override
	public Map<Integer, Carage> getCarAgeByCount() {
		// TODO Auto-generated method stub
		Map<Integer, Carage> carAgeMap=new HashMap<Integer, Carage>();
	
	 String hql="from Carage  order by ACount desc";
	List<Carage> caglist= PageUtil.querylist(1, 5, hql, null); //获取结果集
	//遍历结果集并加入到map中
	for(Carage c:caglist){
		carAgeMap.put(c.getAId(), c);
	}
	
		return carAgeMap;
	}

}
