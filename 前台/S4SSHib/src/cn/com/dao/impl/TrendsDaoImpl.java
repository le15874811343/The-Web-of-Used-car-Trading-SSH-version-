package cn.com.dao.impl;
import cn.com.pojo.*;
import cn.com.util.*;
import cn.com.dao.*;
import java.util.*;
import java.sql.*;
/**
 * 公司动态消息操作实现类
 * @author
 */
public class TrendsDaoImpl extends BaseDao  implements ITrendsDao,IPageDao {
       /**
        * 获取指定条数的最新的动态消息集合
        * @param  rows 获取记录的条数
        * @return List<Trends> 
        */
	@Override
	public List<Trends> getITrendsByTime(Trends trends,int rows) {
		// TODO Auto-generated method stub
		List<Trends> trendsMap=new ArrayList<Trends>();
	
		String hql="from Trends where trType=? order by trDate desc";
		List<Object> parmas=new ArrayList<Object>();
		parmas.add(trends.getTrType());
		try {
			trendsMap=PageUtil.querylist(1, rows, hql, parmas); //获取指定行数区间的结果集
			
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
/**
 * 获取公司动态消息记录的总条数
 * 
 * @return Long
 */
	@Override
	public Long queryPersonCarCount(Object object) {
		// TODO Auto-generated method stub
		Long count=null;
		Trends trends=(Trends) object;
		List<Object> parmas=new ArrayList<Object>();
		StringBuffer sql=new StringBuffer("select count(*) from Trends where 1=1");
		//动态准备参数并延伸HQL语句
		if(trends.getTrType()!=null){
			sql.append(" and trType=?");
			parmas.add(trends.getTrType());
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
   * 分页获取公司动态消息
   * @param curPage 当前页
   * @param rowsPrePage 每页显示记录条数
   * @return Map<Long,Object>
   */
	@Override
	public Map<Long, Object> showPersonCarList(int curPage, int rowsPrePage,
			Object object) {
		// TODO Auto-generated method stub
		Trends trends=(Trends) object;
		 StringBuffer sql=new StringBuffer(" from Trends  a  where 1=1");
		 Map<Long, Object> trendsMap=new HashMap<Long, Object>();
			List<Object> params=new ArrayList<Object>();
                	//动态准备参数并延伸HQL语句
			if(trends.getTrType()!=null){
				sql.append(" and trType=?");
				params.add(trends.getTrType());
			}
			sql.append(" order by trDate desc ");
		
			
		    try {
		    List<Trends> tlist=	PageUtil.querylist(curPage, rowsPrePage, sql.toString(), params); //获取指定行数区间符合条件的结果集
		    //遍历结果集加入Map中
		    for(Trends t:tlist){
		    	trendsMap.put(t.getTrId(), t);
		    }
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return trendsMap;
	}
       /**
        * 按条件获取动态消息
        * @return Trends
        */
	@Override
	public Trends getTrendsByWhere(Trends trends) {
		// TODO Auto-generated method stub
		Trends _Trends=null;
		
		StringBuffer sql=new StringBuffer(" from Trends  a  where 1=1 ");
		//动态准备参数并延伸HQL语句
		List<Object> parmas=new ArrayList<Object>();
		if(trends.getTrId()!=0){
			sql.append(" and trId=?");
			parmas.add(trends.getTrId());
		}
		Object[] o=new Object[parmas.size()];
		//压入确定有的参数
		for(int i=0;i<parmas.size();i++){
			o[i]=parmas.get(i);		
			}
	
		try {
		_Trends=	(Trends) super.getHibernateTemplate().find(sql.toString(),o).get(0);//获取结果
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return _Trends;
	}

} 
