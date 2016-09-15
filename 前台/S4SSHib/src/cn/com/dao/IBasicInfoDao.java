package cn.com.dao;

import java.util.Map;

import cn.com.pojo.*;
/**
 * 汽车基本信息操作接口
 * @author lej
 */
public interface IBasicInfoDao {
/**
 * 获取所有基本信息的方法
 * @return Map<Long, BasicInfo>
*/
public Map<Long, Basicinfo> getAllBasic();
/**
 *根据编号获取汽车基本信息的方法 
 *@return BasicInfo
 */
public Basicinfo getAllBasicById(Carinfo carInfo);
/**
 * 添加汽车基本信息的方法
 * @return int
 */
public int addBasicInfo(Basicinfo basicInfo);
/**
 * 修改汽车基本信息的方法
 * @return int
 */
public int updateBasicInfo( Basicinfo basicInfo);
}
