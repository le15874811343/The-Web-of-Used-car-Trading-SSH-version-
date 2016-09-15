package cn.com.service.impl;

import java.util.List;
import java.util.Map;

import cn.com.pojo.*;
import cn.com.service.*;
import cn.com.dao.*;
import cn.com.dao.impl.*;
/**
 * 个人需求信息服务实现类
 *@author 
 */
public class PersonNeedServiceImpl implements IPersonNeedService,IPageDao{
	//个人需求操作接口的引用
private IPersonNeedDao personNeedDao=null;
//分页处理操作接口的引用
private IPageDao pagePersn=null;
	public IPersonNeedDao getPersonNeedDao() {
	return personNeedDao;
}
public void setPersonNeedDao(IPersonNeedDao personNeedDao) {
	this.personNeedDao = personNeedDao;
}
public IPageDao getPagePersn() {
	return pagePersn;
}
public void setPagePersn(IPageDao pagePersn) {
	this.pagePersn = pagePersn;
}

  /**
   * 
   * 添加个人需求信息的服务
   *@return boolean 
   */
	public boolean addPersonNeed(Personneed personNeed) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(personNeedDao.addPersonNeed(personNeed)>0){
			flag=true;
		}
		return flag;
	}
  /**
   * 
   * 删除个人需求信息的服务
   *@return boolean 
   */
	public boolean deletePersonNeed(Personneed personNeed) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(personNeedDao.deletePersonNeed(personNeed)>0){
			flag=true;
		}
		return flag;
	}
  /**
   * 
   * 获取个人需求信息的服务
   *@return PersonNeed
   */
	@Override
	public Personneed getPerSonNeed(Personneed personNeed) {
		// TODO Auto-generated method stub
		return personNeedDao.getPerSonNeed(personNeed);
	}
	@Override
	public Long queryMsgCount(Object object, int minPrice, int maxPrice,
			int minDis, int maxDis, int minAge, int maxAge) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Object> showMsgInfoList(int curPage, int rowsPrePage,
			Object object, String order, int minPrice, int maxPrice,
			int minDis, int maxDis, int minAge, int maxAge) {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * 获取个人需求总记录条数
	 * 
	 *@return int
	 */
	@Override
	public Long queryPersonCarCount(Object object) {
		// TODO Auto-generated method stub
		return pagePersn.queryPersonCarCount(object);
	}
	/**
	 * 分页获取个人需求信息
	 * @param curPage 当前页
	 * @param rowsPrePage 每页显示记录条数
	 * @return Map<Long,Object>
	 */
	@Override
	public Map<Long, Object> showPersonCarList(int curPage, int rowsPrePage,
			Object object) {
		// TODO Auto-generated method stub
		return pagePersn.showPersonCarList(curPage, rowsPrePage, object);
	}

}
