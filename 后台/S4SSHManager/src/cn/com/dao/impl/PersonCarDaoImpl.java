package cn.com.dao.impl;
import cn.com.pojo.*;
import cn.com.util.*;
import cn.com.dao.*;
import java.util.*;
import java.sql.*;
/**
 * 个人汽车订单信息操作实现类
 * @author lej
 */
public class PersonCarDaoImpl extends BaseDao  implements IPersonCarDao,IPageDao {
    private ICarInfoDao carInfoDao=null; //汽车概要信息操作接口的引用
    
	public ICarInfoDao getCarInfoDao() {
		return carInfoDao;
	}

	public void setCarInfoDao(ICarInfoDao carInfoDao) {
		this.carInfoDao = carInfoDao;
	}
       /**
        * 根据条件获取用户订单信息数量
        * @return int
        */
	@Override
	public Long getCarCountByWhere(Personcar perSonCar) {
		// TODO Auto-generated method stub
		Long count=null;
		StringBuffer sql=new StringBuffer("select count(*) from Personcar where 1=1 and u_id<>c_uid");
		List<Object> params=new ArrayList<Object>();
		//动态参数准备并延伸HQL语句
		if(perSonCar.getUId()!=null){
			sql.append(" and UId=? ");
			params.add(perSonCar.getUId());
		}
		if(perSonCar.getPState()!=null){
			sql.append(" and PState=?");
			params.add(perSonCar.getPState());
		}
		//压入确定有的参数
		Object[] o=new Object[params.size()];
		for(int i=0;i<params.size();i++){
			o[i]=params.get(i);		
			}
		

		try {
      count=(Long) super.getHibernateTemplate().find(sql.toString(),o).get(0);//获取结果
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
       /**
        * 根据条件获取用户订单信息集合
        * @return  Map<Long, PerSonCar>
        */
	@Override
	public Map<Long, Personcar> getPerSonCarMapByWhere(Personcar perSonCar) {
		// TODO Auto-generated method stub
		StringBuffer sql=new StringBuffer("from Personcar where 1=1");
		List<Object> params=new ArrayList<Object>();
		Map<Long, Personcar> perSonMap=new HashMap<Long, Personcar>();
		//动态参数准备并延伸HQL语句
		if(perSonCar.getUId()!=null){
			sql.append(" and UId=? ");
			params.add(perSonCar.getUId());
		}
		if(perSonCar.getPState()!=null){
			sql.append(" and PState=?");
			params.add(perSonCar.getPState());
		}
		if(perSonCar.getCUid()!=0){
			sql.append(" and CUid=? ");
			params.add(perSonCar.getCUid());
		}
		if(perSonCar.getCId()!=0){
			sql.append(" and CId=? ");
			params.add(perSonCar.getCId());
		}
		//压入确定有的参数
		Object[] o=new Object[params.size()];
		for(int i=0;i<params.size();i++){
			o[i]=params.get(i);		
			}
	
    try {
	
		List<Personcar>	plist= super.getHibernateTemplate().find(sql.toString(),o); //获取结果集
		//遍历结果集并压入map中
		for(Personcar p:plist){
			perSonMap.put(p.getPId(), p);
		}
			
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return perSonMap;
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
        * 根据条件获取用户订单信息数量
        * @return int
        */
	@Override
	public Long queryPersonCarCount(Object object) {
		// TODO Auto-generated method stub
		Personcar perSonCar=(Personcar) object; //强制转型
		return getCarCountByWhere(perSonCar); //调用getCarCountByWhere(perSonCar) 方法
	}
        /**
	 * 根据条件分页获取用户订车详情集合
	 * @param curPage 当前页
	 * @param rowsPrePage 每页面记录数
	 * @return Map<Long,Object>
	 */
	@Override
	public Map<Long, Object> showPersonCarList(int curPage, int rowsPrePage,
			Object object) {
		
		// TODO Auto-generated method stub
		Personcar perSonCar=(Personcar) object;
		Map<Long, Object> carMap=new HashMap<Long, Object>();
   Map<Long, Personcar>	perSonMap=	getPersonList(curPage,rowsPrePage,perSonCar);  //获取个人汽车订单集合
   //获取该用户所订车的详细信息
   for(Long key:perSonMap.keySet()){
	   Carinfo carInfo=new Carinfo();
	   carInfo.setCId(perSonMap.get(key).getCId());
	   carInfo.setUId(perSonMap.get(key).getCUid());
	   carMap.put(carInfo.getCId(), carInfoDao.getCarByWhere(carInfo).get(carInfo.getCId()));
   }
		return carMap;
	}
/**
 * 分页获取个人汽车订单信息
 * @param curPage当前页
 * @param rowsPrePage 每页显示条数
 * @return Map<Long,PerSonCar>
 */
	public Map<Long, Personcar> getPersonList(int curPage, int rowsPrePage,Personcar perSonCar){
		 StringBuffer sql=new StringBuffer(" from Personcar where 1=1 and  u_id<>c_uid");
		 Map<Long, Personcar> perSonMap=new HashMap<Long, Personcar>();
			List<Object> params=new ArrayList<Object>();
//动态参数准备并延伸HQL语句
			if(perSonCar.getUId()!=null){
				sql.append(" and UId=? ");
				params.add(perSonCar.getUId());
			}
			if(perSonCar.getPState()!=null){
				sql.append(" and PState=?");
				params.add(perSonCar.getPState());
			}
		
		
		    try {
		    	//获取指定行数区间的符合条件的结果集
		    List<Personcar> plist=	 PageUtil.querylist(curPage, rowsPrePage, sql.toString(), params);
		    //遍历结果集，加入map中
		    for(Personcar p:plist){
		    	perSonMap.put(p.getPId(), p);
		    }
			
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return perSonMap;
	}
       /**
        *  添加用户订单信息
        * @return int
        */
	@Override
	public int addPerSonCar(Personcar perSonCar) {
		// TODO Auto-generated method stub
		 int count=0;
		 try{
			 super.getHibernateTemplate().save(perSonCar); //加入
			 count=1;
		 }
		 catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
		}
		return count;
	}
       /**
        *  删除用户订单信息
        * @return int
        */
	@Override
	public int deletePerSoncar(Personcar perSonCar) {
		// TODO Auto-generated method stub
		 int count=0;
		 try{
			 super.getHibernateTemplate().delete(perSonCar);  //删除
			 count=1;
		 }
		 catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
		}
		return count;
	}
       /**
        *  修改用户订单信息
        * @return int
        */
	@Override
	public int updatePerSoncar(Personcar perSonCar,String state) {
		// TODO Auto-generated method stub
		StringBuffer sql=new StringBuffer("update  Personcar set  PState=? where UId=? and CId=? and CUid=? and PState=?");
	
		 //返回受影响的行数
		return super.getHibernateTemplate().bulkUpdate(sql.toString(), new Object[]{state,perSonCar.getUId(),perSonCar.getCId(),perSonCar.getCUid(),perSonCar.getPState()});
	}
/**
 * 根据用户编号删除用户订单信息的方法
 *@return int  
 */
	@Override
	public int deletepersoncaruser(Personcar u) {
		// TODO Auto-generated method stub
		int count=0;
		String hql="from Personcar where UId=?";
	List<Personcar> blist=	 super.getHibernateTemplate().find(hql, u.getUId());//获取持久化对象集合
		try{
			for(Personcar _b:blist){
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
/**
 * 根据车编号删除用户订单信息的方法
 *@return int  
 */
	@Override
	public int deletecidpersoncaruser(Personcar u) {
		// TODO Auto-generated method stub
		int count=0;
		try{
			super.getHibernateTemplate().delete(u);//删除
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
 * 检查是否还有与某用户编号关联的用户订单信息
 * @return boolean
 */
	@Override
	public boolean checkipersonuser(Personcar p) {
		// TODO Auto-generated method stub
		String hql="from Personcar where UId=?";
		boolean flag=false;
		List<Basicinfo> blist=	 super.getHibernateTemplate().find(hql, p.getUId());//获取结果集
		if(blist.size()>0){
			flag=true;//若结果集元素个数大于0 ，则返回为真
		}
		return flag;
	}
 /**
 * 
 * 检查是否还有与某车编号关联的用户订单信息
 * @return boolean
 */
	@Override
	public boolean checkcidipersonuser(Personcar p) {
		// TODO Auto-generated method stub
		String hql="from Personcar where CId=?";
		boolean flag=false;
		List<Basicinfo> blist=	 super.getHibernateTemplate().find(hql, p.getCId());//获取结果集
		if(blist.size()>0){
			flag=true;//若结果集元素个数大于0 ，则返回为真
		}
		return flag;
	}
/**
 * 根据所有字段删除用户订单信息的方法
 *@return int  
 */
	@Override
	public int deletePersonByAll(Personcar perSonCar) {
		// TODO Auto-generated method stub
		int count=0;
		String hql="from Personcar where UId=? and CId=? and CUid=? and PState=?";
		//获取持久化对象集合
	List<Personcar> blist=	 super.getHibernateTemplate().find(hql, new Object[]{perSonCar.getUId(),perSonCar.getCId(),perSonCar.getCUid(),perSonCar.getPState()});
		try{
			for(Personcar _b:blist){
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

   /**
    * 获取个人汽车订单信息的方法
    * @return Personcar
    */
	@Override
	public Personcar getPersoncar(Personcar personcar) {
		// TODO Auto-generated method stub
		StringBuffer sql=new StringBuffer("from Personcar where 1=1");
		List<Object> params=new ArrayList<Object>();
		Personcar _Personcar=null;
		//动态参数准备并延伸HQL语句
		if(personcar.getUId()!=null){
			sql.append(" and UId=? ");
			params.add(personcar.getUId());
		}
		if(personcar.getPState()!=null){
			sql.append(" and PState=?");
			params.add(personcar.getPState());
		}
		if(personcar.getCUid()!=0){
			sql.append(" and CUid=? ");
			params.add(personcar.getCUid());
		}
		if(personcar.getCId()!=0){
			sql.append(" and CId=? ");
			params.add(personcar.getCId());
		}
		//压入确定有的参数
		Object[] o=new Object[params.size()];
		for(int i=0;i<params.size();i++){
			o[i]=params.get(i);		
			}
	
    try {
	
		List<Personcar>	plist= super.getHibernateTemplate().find(sql.toString(),o);//获取结果集
	 if(plist.size()>0){
		 _Personcar=plist.get(0);//获取结果
	 }
			
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return _Personcar;
	}
/**
 * 
 * 检查是否还有与某车主编号关联的用户订单信息
 * @return boolean
 */
	@Override
	public boolean checkcuidperson(Personcar p) {
		// TODO Auto-generated method stub
		String hql="from Personcar where CUid=?";
		boolean flag=false;
		List<Basicinfo> blist=	 super.getHibernateTemplate().find(hql, p.getCUid());//获取结果集
		if(blist.size()>0){
			flag=true;//若结果集元素个数大于0，则返回为真
		}
		return flag;
	}
/**
 * 根据车主编号删除用户订单信息的方法
 *@return int  
 */
	@Override
	public int deletecuidperson(Personcar p) {
		// TODO Auto-generated method stub
		int count=0;
		String hql="from Personcar where CUid=?";
		//获取持久化对象集合
	List<Personcar> blist=	 super.getHibernateTemplate().find(hql, p.getCUid());
		try{
			for(Personcar _b:blist){
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
