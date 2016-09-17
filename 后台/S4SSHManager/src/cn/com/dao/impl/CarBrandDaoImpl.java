package cn.com.dao.impl;
import cn.com.pojo.*;
import cn.com.util.*;
import cn.com.dao.*;
import java.util.*;
/**
 * 品牌信息操作实现类
 * @author lej
 */
public class CarBrandDaoImpl extends BaseDao implements ICarBrandDao,IPageDao {
 /**
   * 按热度获取品牌信息的方法
   * @return  Map<Integer, Carbrand>
   */
	@Override
	public Map<Integer, Carbrand> getCarBrandByCount() {
		// TODO Auto-generated method stub
	   Map<Integer, Carbrand> carBrandMap=new HashMap<Integer, Carbrand>();
	
	   String hql="from Carbrand order by BCount desc";
	 try{
	List<Carbrand> cablist=  PageUtil.querylist(1, 7, hql, null);   //获取结果集
	//遍历结果集 将结果加入map中
	for(Carbrand c:cablist){
		carBrandMap.put(c.getBId(), c);
	}
	 }
	 catch (Exception e) {
		// TODO: handle exception
		 e.printStackTrace();
	}
	  return carBrandMap;
	}
  /**
   * 获取所有品牌信息的方法
   * @return Map<Integer,Carbrand>
   */
	@Override
	public Map<Integer, Carbrand> getAllBrand() {
		// TODO Auto-generated method stub
		 Map<Integer, Carbrand> carBrandMap=new HashMap<Integer, Carbrand>();
		   String sql= " from Carbrand";
		   try{
				List<Carbrand> cablist=  super.getHibernateTemplate().find(sql); //获取结果集
				//遍历结果集 将结果加入map中
				for(Carbrand c:cablist){
					carBrandMap.put(c.getBId(), c);
				}
				 }
				 catch (Exception e) {
					// TODO: handle exception
					 e.printStackTrace();
				}
		  return carBrandMap;
	}
  /**
   * 根据品牌编号获取品牌信息的方法
   * @param carBrand
   * @return Carbrand
   */
	@Override
	public Carbrand getBrandByID(Carbrand carBrand) {
		// TODO Auto-generated method stub
		Carbrand _carBrand=null;
		   String sql= " from Carbrand where BId=? ";
		try{
			 //获取结果
		_carBrand=  (Carbrand) super.getHibernateTemplate().find(sql.toString(), new Object[]{carBrand.getBId()}).get(0);
		}
		catch (Exception e) {
			
			// TODO: handle exception
		e.printStackTrace();
		}
		  return _carBrand;
	}
        /**
	 * 添加品牌信息的方法
	 * @return   int
	 */
	@Override
	public int addCarBrand(Carbrand carBrand) {
		// TODO Auto-generated method stub
		int count=0;
		try{
			super.getHibernateTemplate().save(carBrand);//加入
			count=1;
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return count;
	}
        /**
	 * 修改品牌信息的方法
	 * @return   int
	 */
	@Override
	public int updateCarBrand(Carbrand carBrand) {
		// TODO Auto-generated method stub
		String sql="update Carbrand set BName=?,BCount=?,BImg=?,BSzm=? where BId=?";
		//返回受影响的行数
		return super.getHibernateTemplate().bulkUpdate(sql, new Object[]{carBrand.getBName(),carBrand.getBCount(),carBrand.getBImg(),carBrand.getBSzm(),carBrand.getBId()});
	}
        /**
	 * 删除品牌信息的方法
	 * @return   int
	 */
	@Override
	public int deleteCarBrand(Carbrand carBrand) {
		// TODO Auto-generated method stub
		int count=0;
		try{
			super.getHibernateTemplate().delete(carBrand); //删除
			count=1;
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return count;
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
     * 获取品牌信息的记录总条数
     * @return int
     */	
	@Override
	public Long queryPersonCarCount(Object object) {
		// TODO Auto-generated method stub
		Long count=null;
		try{
		StringBuffer sql=new StringBuffer("select count(*) from Carbrand where 1=1");
	count=	(Long) super.getHibernateTemplate().find(sql.toString()).iterator().next(); //获取结果
		}
		catch (Exception e) {
			// TODO: handle exception
			count=(long) 0;
		}
		return count;
	}
/**
 * 分页获取品牌信息
 * @param curPage 当前页数
 * @param rowsPrePage
 * @return Map<Long,Object>
 */	
	@Override
	public Map<Long, Object> showPersonCarList(int curPage, int rowsPrePage,
			Object object) {
		// TODO Auto-generated method stub
		String hql="from Carbrand  a  where 1=1 order by BCount desc";
		Map<Long, Object> carBrandMap=new HashMap<Long, Object>();
	List<Carbrand> carBrandlist=	PageUtil.querylist(curPage, rowsPrePage, hql, null);//获取指定行数区间的结果集
	//遍历结果集，加入map中
	for(Carbrand c:carBrandlist){
		carBrandMap.put((long) c.getBId(), c);
	}
		return carBrandMap;
	}
  /**
   * 根据品牌名称获取品牌的方法
   *@return Carbrand 
   */
	@Override
	public Carbrand getBrandByName(Carbrand carBrand) {
		// TODO Auto-generated method stub
		Carbrand _carBrand=null;
		   String sql= " from Carbrand where BName=? ";
		try{
			//获取结果
		_carBrand=  (Carbrand) super.getHibernateTemplate().find(sql.toString(), new Object[]{carBrand.getBName()}).get(0);
		}
		catch (Exception e) {
			
			// TODO: handle exception
		e.printStackTrace();
		}
		  return _carBrand;
	}
 
}
