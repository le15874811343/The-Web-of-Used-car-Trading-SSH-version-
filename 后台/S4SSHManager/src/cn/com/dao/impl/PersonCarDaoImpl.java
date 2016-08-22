package cn.com.dao.impl;
import cn.com.pojo.*;
import cn.com.util.*;
import cn.com.dao.*;
import java.util.*;
import java.sql.*;
public class PersonCarDaoImpl extends BaseDao  implements IPersonCarDao,IPageDao {
    private ICarInfoDao carInfoDao=null;
    
	public ICarInfoDao getCarInfoDao() {
		return carInfoDao;
	}

	public void setCarInfoDao(ICarInfoDao carInfoDao) {
		this.carInfoDao = carInfoDao;
	}

	@Override
	public Long getCarCountByWhere(Personcar perSonCar) {
		// TODO Auto-generated method stub
		Long count=null;
		StringBuffer sql=new StringBuffer("select count(*) from Personcar where 1=1 and u_id<>c_uid");
		List<Object> params=new ArrayList<Object>();
		if(perSonCar.getUId()!=null){
			sql.append(" and UId=? ");
			params.add(perSonCar.getUId());
		}
		if(perSonCar.getPState()!=null){
			sql.append(" and PState=?");
			params.add(perSonCar.getPState());
		}
		Object[] o=new Object[params.size()];
		for(int i=0;i<params.size();i++){
			o[i]=params.get(i);		
			}
		

		try {
      count=(Long) super.getHibernateTemplate().find(sql.toString(),o).get(0);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public Map<Long, Personcar> getPerSonCarMapByWhere(Personcar perSonCar) {
		// TODO Auto-generated method stub
		StringBuffer sql=new StringBuffer("from Personcar where 1=1");
		List<Object> params=new ArrayList<Object>();
		Map<Long, Personcar> perSonMap=new HashMap<Long, Personcar>();
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
		Object[] o=new Object[params.size()];
		for(int i=0;i<params.size();i++){
			o[i]=params.get(i);		
			}
	
    try {
	
		List<Personcar>	plist= super.getHibernateTemplate().find(sql.toString(),o);
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

	@Override
	public Long queryPersonCarCount(Object object) {
		// TODO Auto-generated method stub
		Personcar perSonCar=(Personcar) object;
		return getCarCountByWhere(perSonCar);
	}

	@Override
	public Map<Long, Object> showPersonCarList(int curPage, int rowsPrePage,
			Object object) {
		
		// TODO Auto-generated method stub
		Personcar perSonCar=(Personcar) object;
		Map<Long, Object> carMap=new HashMap<Long, Object>();
   Map<Long, Personcar>	perSonMap=	getPersonList(curPage,rowsPrePage,perSonCar);
   for(Long key:perSonMap.keySet()){
	   Carinfo carInfo=new Carinfo();
	   carInfo.setCId(perSonMap.get(key).getCId());
	   carInfo.setUId(perSonMap.get(key).getCUid());
	   carMap.put(carInfo.getCId(), carInfoDao.getCarByWhere(carInfo).get(carInfo.getCId()));
   }
		return carMap;
	}

	public Map<Long, Personcar> getPersonList(int curPage, int rowsPrePage,Personcar perSonCar){
		 StringBuffer sql=new StringBuffer(" from Personcar where 1=1 and  u_id<>c_uid");
		 Map<Long, Personcar> perSonMap=new HashMap<Long, Personcar>();
			List<Object> params=new ArrayList<Object>();

			if(perSonCar.getUId()!=null){
				sql.append(" and UId=? ");
				params.add(perSonCar.getUId());
			}
			if(perSonCar.getPState()!=null){
				sql.append(" and PState=?");
				params.add(perSonCar.getPState());
			}
		
		
		    try {
		    List<Personcar> plist=	 PageUtil.querylist(curPage, rowsPrePage, sql.toString(), params);
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
	public int addPerSonCar(Personcar perSonCar) {
		// TODO Auto-generated method stub
		 int count=0;
		 try{
			 super.getHibernateTemplate().save(perSonCar);
			 count=1;
		 }
		 catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
		}
		return count;
	}

	@Override
	public int deletePerSoncar(Personcar perSonCar) {
		// TODO Auto-generated method stub
		 int count=0;
		 try{
			 super.getHibernateTemplate().delete(perSonCar);
			 count=1;
		 }
		 catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
		}
		return count;
	}

	@Override
	public int updatePerSoncar(Personcar perSonCar,String state) {
		// TODO Auto-generated method stub
		StringBuffer sql=new StringBuffer("update  Personcar set  PState=? where UId=? and CId=? and CUid=? and PState=?");
	
		
		return super.getHibernateTemplate().bulkUpdate(sql.toString(), new Object[]{state,perSonCar.getUId(),perSonCar.getCId(),perSonCar.getCUid(),perSonCar.getPState()});
	}

	@Override
	public int deletepersoncaruser(Personcar u) {
		// TODO Auto-generated method stub
		int count=0;
		String hql="from Personcar where UId=?";
	List<Personcar> blist=	 super.getHibernateTemplate().find(hql, u.getUId());
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

	@Override
	public int deletecidpersoncaruser(Personcar u) {
		// TODO Auto-generated method stub
		int count=0;
		try{
			super.getHibernateTemplate().delete(u);
			count=1;
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public boolean checkipersonuser(Personcar p) {
		// TODO Auto-generated method stub
		String hql="from Personcar where UId=?";
		boolean flag=false;
		List<Basicinfo> blist=	 super.getHibernateTemplate().find(hql, p.getUId());
		if(blist.size()>0){
			flag=true;
		}
		return flag;
	}

	@Override
	public boolean checkcidipersonuser(Personcar p) {
		// TODO Auto-generated method stub
		String hql="from Personcar where CId=?";
		boolean flag=false;
		List<Basicinfo> blist=	 super.getHibernateTemplate().find(hql, p.getCId());
		if(blist.size()>0){
			flag=true;
		}
		return flag;
	}

	@Override
	public int deletePersonByAll(Personcar perSonCar) {
		// TODO Auto-generated method stub
		int count=0;
		String hql="from Personcar where UId=? and CId=? and CUid=? and PState=?";
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

	
	@Override
	public Personcar getPersoncar(Personcar personcar) {
		// TODO Auto-generated method stub
		StringBuffer sql=new StringBuffer("from Personcar where 1=1");
		List<Object> params=new ArrayList<Object>();
		Personcar _Personcar=null;
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
		Object[] o=new Object[params.size()];
		for(int i=0;i<params.size();i++){
			o[i]=params.get(i);		
			}
	
    try {
	
		List<Personcar>	plist= super.getHibernateTemplate().find(sql.toString(),o);
	 if(plist.size()>0){
		 _Personcar=plist.get(0);
	 }
			
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return _Personcar;
	}

	@Override
	public boolean checkcuidperson(Personcar p) {
		// TODO Auto-generated method stub
		String hql="from Personcar where CUid=?";
		boolean flag=false;
		List<Basicinfo> blist=	 super.getHibernateTemplate().find(hql, p.getCUid());
		if(blist.size()>0){
			flag=true;
		}
		return flag;
	}

	@Override
	public int deletecuidperson(Personcar p) {
		// TODO Auto-generated method stub
		int count=0;
		String hql="from Personcar where CUid=?";
	List<Personcar> blist=	 super.getHibernateTemplate().find(hql, p.getCUid());
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

}
