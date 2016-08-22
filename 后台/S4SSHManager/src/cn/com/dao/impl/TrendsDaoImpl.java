package cn.com.dao.impl;
import cn.com.pojo.*;
import cn.com.util.*;
import cn.com.dao.*;
import java.util.*;
import java.sql.*;
public class TrendsDaoImpl extends BaseDao  implements ITrendsDao,IPageDao {

	@Override
	public List<Trends> getITrendsByTime(Trends trends,int rows) {
		// TODO Auto-generated method stub
		List<Trends> trendsMap=new ArrayList<Trends>();
	
		String hql="from Trends where trType=? order by trDate desc";
		List<Object> parmas=new ArrayList<Object>();
		parmas.add(trends.getTrType());
		try {
			trendsMap=PageUtil.querylist(1, rows, hql, parmas);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return trendsMap;
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
		Trends trends=(Trends) object;
		List<Object> parmas=new ArrayList<Object>();
		StringBuffer sql=new StringBuffer("select count(*) from Trends where 1=1");
		if(trends.getTrType()!=null){
			sql.append(" and trType=?");
			parmas.add(trends.getTrType());
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
		Trends trends=(Trends) object;
		 StringBuffer sql=new StringBuffer(" from Trends  a  where 1=1");
		 Map<Long, Object> trendsMap=new HashMap<Long, Object>();
			List<Object> params=new ArrayList<Object>();

			if(trends.getTrType()!=null){
				sql.append(" and trType=?");
				params.add(trends.getTrType());
			}
			sql.append(" order by trDate desc ");
		
			
		    try {
		    List<Trends> tlist=	PageUtil.querylist(curPage, rowsPrePage, sql.toString(), params);
		    for(Trends t:tlist){
		    	trendsMap.put(t.getTrId(), t);
		    }
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return trendsMap;
	}

	@Override
	public Trends getTrendsByWhere(Trends trends) {
		// TODO Auto-generated method stub
		Trends _Trends=null;
		
		StringBuffer sql=new StringBuffer(" from Trends  a  where 1=1 ");
		List<Object> parmas=new ArrayList<Object>();
		if(trends.getTrId()!=0){
			sql.append(" and trId=?");
			parmas.add(trends.getTrId());
		}
		Object[] o=new Object[parmas.size()];
		for(int i=0;i<parmas.size();i++){
			o[i]=parmas.get(i);		
			}
	
		try {
		_Trends=	(Trends) super.getHibernateTemplate().find(sql.toString(),o).get(0);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return _Trends;
	}

	@Override
	public int addTrends(Trends trends) {
		// TODO Auto-generated method stub
		int count = 0;
		try {
			super.getHibernateTemplate().save(trends);
			count = 1;
		} catch (Exception e) {
			// TODO: handle exception
			count = 0;
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public int deleteTrends(Trends trends) {
		// TODO Auto-generated method stub
		int count = 0;
		try {
			super.getHibernateTemplate().delete(trends);
			count = 1;
		} catch (Exception e) {
			// TODO: handle exception
			count = 0;
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public int updateTrends(Trends trends) {
		// TODO Auto-generated method stub
		String sql="update Trends set trTitle=?,trText=?,trType=?,trImg=? where trId=?";
		return super.getHibernateTemplate().bulkUpdate(sql, new Object[]{trends.getTrTitle(),trends.getTrText(),trends.getTrType(),trends.getTrImg(),trends.getTrId()});
	}

} 
