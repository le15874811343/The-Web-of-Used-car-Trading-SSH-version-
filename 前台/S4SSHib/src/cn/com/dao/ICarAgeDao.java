package cn.com.dao;
import java.util.Map;

import cn.com.pojo.*;
/**
 * 车龄信息操作接口
 *@author  lej 
 */
public interface ICarAgeDao {
		
	/**
	 * 按热度获取车龄信息的方法
	 * @return Map<Integer,CarAge>
	 */
	public Map<Integer,Carage> getCarAgeByCount();
}
