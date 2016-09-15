package cn.com.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import cn.com.util.*;
import cn.com.pojo.*;
import cn.com.dao.*;

/**
 * 个人需求信息操作实现类
 *@author 
 */
public class PersonNeedDaoImpl extends BaseDao implements IPersonNeedDao,IPageDao{

  /**
   * 
   * 添加个人需求信息的方法
   *@return int 
   */
	public int addPersonNeed(Personneed personNeed) {
		// TODO Auto-generated method stub
	
		int count=0;
		try{
			super.getHibernateTemplate().save(personNeed); //加入
			count=1;
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return count;
	}
  /**
   * 
   * 删除个人需求信息的方法
   *@return int 
   */
	public int deletePersonNeed(Personneed personNeed) {
		// TODO Auto-generated method stub
		int count=0;
		try{
			super.getHibernateTemplate().delete(personNeed); //删除
			count=1;
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return count;
	}
  /**
   * 
   * 获取个人需求信息的方法
   *@return PersonNeed
   */
	@Override
	public Personneed getPerSonNeed(Personneed personNeed) {
		// TODO Auto-generated method stub
		
		Personneed _PersonNeed=null;
		StringBuffer sql=new StringBuffer(" from Personneed where 1=1 ");
		//动态准备参数并延伸HQL语句
		List<Object> parmas=new ArrayList<Object>();
		if(personNeed.getUId()!=null){
			sql.append(" and UId=? ");
			parmas.add(personNeed.getUId());
		}
		if(personNeed.getPBrand()!=null){
			sql.append(" and PBrand=? ");
			parmas.add(personNeed.getPBrand());
		}
if(personNeed.getPAge()!=null){
	sql.append(" and PAge=? ");
	parmas.add(personNeed.getPAge());
		}
if(personNeed.getPSeries()!=null){
	sql.append(" and PSeries=? ");
	parmas.add(personNeed.getPSeries());
}
if(personNeed.getPMiaoshu()!=null&&!personNeed.getPMiaoshu().equals("")){
	sql.append(" and PMiaoshu=? ");
	parmas.add(personNeed.getPMiaoshu());
}
if(personNeed.getPTime()!=null){
	sql.append(" and PTime=?");
	parmas.add(personNeed.getPTime());
}
if(personNeed.getPPrice()!=null){
	sql.append(" and PPrice=? ");
	parmas.add(personNeed.getPPrice());
}
if(personNeed.getPState()!=null){
	sql.append(" and PState=? ");
	parmas.add(personNeed.getPState());
}
//压入确定有的参数
Object[] o=new Object[parmas.size()];
for(int i=0;i<parmas.size();i++){
	o[i]=parmas.get(i);		
	}
       
		try {
			List<Personneed> plist=(List<Personneed>) super.getHibernateTemplate().find(sql.toString(),o);//获取结果集
			if(plist.size()>0){
				_PersonNeed=plist.get(0); //获取结果集对象
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       return _PersonNeed;
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
         * 获取个人需求记录总条数
         * 
         * @return int
         */
	@Override
	public Long queryPersonCarCount(Object object) {
		// TODO Auto-generated method stub
		Long count=null;
		Personneed personNeed=(Personneed) object;
		StringBuffer sql=new StringBuffer("select count(*) from Personneed where 1=1");
		//动态准备参数并延伸hql语句
		List<Object> parmas=new ArrayList<Object>();
		if(personNeed.getUId()!=0){
			sql.append(" and UId=?");
			parmas.add(personNeed.getUId());
		}
		//压入确定有的参数
		Object[] o=new Object[parmas.size()];
		for(int i=0;i<parmas.size();i++){
			o[i]=parmas.get(i);		
			}

	try {
		 count= (Long) super.getHibernateTemplate().find(sql.toString(),o).listIterator().next(); //获取结果
	
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return count;
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
		Personneed personNeed=(Personneed) object;
		 StringBuffer sql=new StringBuffer(" from Personneed  a  where 1=1");
		 Map<Long, Object> personNeedMap=new HashMap<Long, Object>();
		 	//动态准备参数并延伸hql语句
			List<Object> params=new ArrayList<Object>();
			if(personNeed.getUId()!=0){
				sql.append(" and UId=?");
				params.add(personNeed.getUId());
			}
			
			sql.append(" order by PTjtime desc ");
		
			
		    try {
		    	//获取指定行数区间符合条件的结果集
		   List<Personneed> plist= 	PageUtil.querylist(curPage, rowsPrePage, sql.toString(), params);
		   for(Personneed p:plist){
			   personNeedMap.put(p.getPId(), p);
		   }
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return personNeedMap;
	}

}
