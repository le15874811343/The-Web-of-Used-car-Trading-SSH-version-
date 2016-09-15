package cn.com.service;
import java.util.Map;

import cn.com.pojo.*;
/**
 * 车龄信息服务接口
 *@author  lej 
 */
public interface ICarAgeService {
	/**
	 * 按热度获取车龄信息的服务
	 * @return Map<Integer,CarAge>
	 */
	public Map<Integer,Carage> getCarAgeByCount();
}
