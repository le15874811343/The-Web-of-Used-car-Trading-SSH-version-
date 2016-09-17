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
			super.getHibernateTemplate().delete(personNeed);  //删除
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
		List<Object> parmas=new ArrayList<Object>();
		//动态准备参数并延伸HQL语句
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
	sql.append(" and PTime=to_date(?,'yyyy-mm') ");
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
			_PersonNeed=	(Personneed) super.getHibernateTemplate().find(sql.toString(),o).get(0);//获取结果
			
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
		List<Object> parmas=new ArrayList<Object>();
		//动态准备参数并延伸hql语句
		if(personNeed.getUId()!=null){
			sql.append(" and UId=?");
			parmas.add(personNeed.getUId());
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
		 count= (Long) super.getHibernateTemplate().find(sql.toString(),o).listIterator().next();//获取结果
	
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
			List<Object> params=new ArrayList<Object>();
			//动态准备参数并延伸hql语句
			if(personNeed.getUId()!=null){
				sql.append(" and UId=?");
				params.add(personNeed.getUId());
			}
			if(personNeed.getPState()!=null){
				sql.append(" and PState=? ");
				params.add(personNeed.getPState());
			}
			sql.append(" order by PTjtime desc ");
		
			
		    try {
		    	//获取指定行数区间符合条件的结果集
		   List<Personneed> plist= 	PageUtil.querylist(curPage, rowsPrePage, sql.toString(), params);
		   //遍历结果集，压入map中
		   for(Personneed p:plist){
			   personNeedMap.put(p.getPId(), p);
		   }
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return personNeedMap;
	}
    /**
   * 
   * 修改个人需求信息的方法
   *@return int 
   */
	@Override
	public int updatePersonNeed(Personneed personNeed) {
		// TODO Auto-generated method stub
		String sql="update Personneed set PState=? where PId=?";
		//返回受影响的行数
		return super.getHibernateTemplate().bulkUpdate(sql, new Object[]{personNeed.getPState(),personNeed.getPId()});
	}
/**
 * 
 * 检查是否还有与某用户编号关联的个人需求信息
 * @return boolean
 */
	@Override
	public boolean chekUidPerson(Personneed personneed) {
		// TODO Auto-generated method stub
		boolean flag=false;
		String sql="from Personneed where UId=?";
		//获取结果集，并判断结果集的元素个数是否大于0，是则返回为真
		if( super.getHibernateTemplate().find(sql,personneed.getUId()).size()>0){
			flag=true;
		}
		return flag;
	}
/**
 * 根据用户编号删除个人需求信息的方法
 *@return int  
 */
	@Override
	public int deleteUidPerson(Personneed personneed) {
		// TODO Auto-generated method stub
		int count=0;
		String hql="from Personneed where UId=?";
		//获取持久化对象集合
	List<Personneed> blist=	 super.getHibernateTemplate().find(hql, personneed.getUId());
		try{
			for(Personneed _b:blist){
				super.getHibernateTemplate().delete(_b);//删除
			}
			
			count=1;
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return count;
	}

}
