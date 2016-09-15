package cn.com.service;

import cn.com.pojo.*;;
/**
 * 个人需求信息服务接口
 *@author 
 */
public interface IPersonNeedService {
  /**
   * 
   * 添加个人需求信息的服务
   *@return boolean 
   */
	public boolean addPersonNeed(Personneed personNeed);
  /**
   * 
   * 删除个人需求信息的服务
   *@return boolean 
   */
	public boolean deletePersonNeed(Personneed personNeed);
  /**
   * 
   * 获取个人需求信息的服务
   *@return PersonNeed
   */
	public Personneed getPerSonNeed(Personneed personNeed);
}
