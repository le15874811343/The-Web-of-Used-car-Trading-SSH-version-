package cn.com.service;

import java.util.Map;

import cn.com.pojo.*;
/**
 * 行驶距离服务接口
 *@author lej 
 */
public interface IDistanceService {
   /**
    * 
    * 按热度获取行驶距离信息的服务
    *@return Map<Integer,Distance> 
    */
	public Map<Integer, Distance> getDistanceByCount();
}
