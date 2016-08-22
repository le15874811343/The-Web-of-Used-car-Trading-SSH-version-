package cn.com.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import cn.com.util.*;
import cn.com.pojo.*;
import cn.com.dao.*;


public class PersonNeedDaoImpl extends BaseDao implements IPersonNeedDao,IPageDao{

//	 private long p_id;
//	 private long u_id;
//	 private String p_brand;
//	 private String p_series;
//	 private String p_age;
//	 private String p_price;
//	 private String p_time;
//	 private String p_miaoshu;
	public int addPersonNeed(Personneed personNeed) {
		// TODO Auto-generated method stub
	
		int count=0;
		try{
			super.getHibernateTemplate().save(personNeed);
			count=1;
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return count;
	}

	public int deletePersonNeed(Personneed personNeed) {
		// TODO Auto-generated method stub
		int count=0;
		try{
			super.getHibernateTemplate().delete(personNeed);
			count=1;
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public Personneed getPerSonNeed(Personneed personNeed) {
		// TODO Auto-generated method stub
		Personneed _PersonNeed=null;
		StringBuffer sql=new StringBuffer(" from Personneed where 1=1 ");
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
Object[] o=new Object[parmas.size()];
for(int i=0;i<parmas.size();i++){
	o[i]=parmas.get(i);		
	}
       
		try {
			_PersonNeed=	(Personneed) super.getHibernateTemplate().find(sql.toString(),o).get(0);
			
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

	@Override
	public Long queryPersonCarCount(Object object) {
		// TODO Auto-generated method stub
		Long count=null;
		Personneed personNeed=(Personneed) object;
		StringBuffer sql=new StringBuffer("select count(*) from Personneed where 1=1");
		List<Object> parmas=new ArrayList<Object>();
		if(personNeed.getUId()!=null){
			sql.append(" and UId=?");
			parmas.add(personNeed.getUId());
		}
		if(personNeed.getPState()!=null){
			sql.append(" and PState=? ");
			parmas.add(personNeed.getPState());
		}
		Object[] o=new Object[parmas.size()];
		for(int i=0;i<parmas.size();i++){
			o[i]=parmas.get(i);		
			}

	try {
		 count= (Long) super.getHibernateTemplate().find(sql.toString(),o).listIterator().next();
	
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return count;
	}

	@Override
	public Map<Long, Object> showPersonCarList(int curPage, int rowsPrePage,
			Object object) {
		// TODO Auto-generated method stub
		Personneed personNeed=(Personneed) object;
		 StringBuffer sql=new StringBuffer(" from Personneed  a  where 1=1");
		 Map<Long, Object> personNeedMap=new HashMap<Long, Object>();
			List<Object> params=new ArrayList<Object>();
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

	@Override
	public int updatePersonNeed(Personneed personNeed) {
		// TODO Auto-generated method stub
		String sql="update Personneed set PState=? where PId=?";
		return super.getHibernateTemplate().bulkUpdate(sql, new Object[]{personNeed.getPState(),personNeed.getPId()});
	}

	@Override
	public boolean chekUidPerson(Personneed personneed) {
		// TODO Auto-generated method stub
		boolean flag=false;
		String sql="from Personneed where UId=?";
		if( super.getHibernateTemplate().find(sql,personneed.getUId()).size()>0){
			flag=true;
		}
		return flag;
	}

	@Override
	public int deleteUidPerson(Personneed personneed) {
		// TODO Auto-generated method stub
		int count=0;
		String hql="from Personneed where UId=?";
	List<Personneed> blist=	 super.getHibernateTemplate().find(hql, personneed.getUId());
		try{
			for(Personneed _b:blist){
				super.getHibernateTemplate().delete(_b);
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
