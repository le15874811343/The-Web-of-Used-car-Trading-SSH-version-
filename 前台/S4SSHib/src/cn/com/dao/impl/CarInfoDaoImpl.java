package cn.com.dao.impl;
import cn.com.pojo.*;
import cn.com.util.*;
import cn.com.dao.*;

import java.util.*;
import java.sql.*;

/**
 * 汽车概要信息操作实现类
 * @author lej
 */
public class CarInfoDaoImpl extends BaseDao implements ICarInfoDao,IPageDao{
/**
 * 按热度获取汽车概要信息的方法
 * @parma carInfo
 * @return   Map<Long, CarInfo>
 */
	public Map<Long, Carinfo> getCarInfoByCountDesc(Carinfo _carInfo) {
		// TODO Auto-generated method stub
		Map<Long, Carinfo> carInfoMap=new HashMap<Long, Carinfo>();

		String hql="from Carinfo  order by CCount desc"; 
		List<Carinfo> clist=	PageUtil.querylist(1, 4, hql,null);   //获取指定行数区间的汽车概要信息结果集
	//遍历结果集 加入Map中
		for(Carinfo c:clist){
			carInfoMap.put(c.getCId(), c);
		}
		
		 return carInfoMap;
	}

/**
 * 按热度和品牌获取汽车概要信息的方法
 * @parma carInfo
 * @return   Map<Long, CarInfo>
 */
	public Map<Long, Carinfo> getCarInfoByBrandCountDesc(Carinfo carInfo) {
		// TODO Auto-generated method stub
		Map<Long, Carinfo> carInfoMap=new HashMap<Long, Carinfo>();
		String hql="from Carinfo where CBrand=? and CState=? order by CCount desc";
		//参数准备
		List<Object> parmas=new ArrayList<Object>();
		parmas.add(carInfo.getCBrand());
		parmas.add(carInfo.getCState());
		
		List<Carinfo> clist= PageUtil.querylist(1, 4, hql, parmas);  //获取指定行数区间符合条件的汽车概要信息结果集
		//遍历结果集 加入Map中
		for(Carinfo c:clist){
			carInfoMap.put(c.getCId(), c);
		}
		
		 return carInfoMap;
	}

 /**
 * 按上架时间获取汽车概要信息的方法
 * @parma carInfo
 * @return   Map<Long, CarInfo>
 */
	public Map<Long, Carinfo> getCarInfoBySjTime(Carinfo carInfo) {
		// TODO Auto-generated method stub
		Map<Long, Carinfo> carInfoMap=new HashMap<Long, Carinfo>();
              String hql="from Carinfo where CState=? order by CSjtime desc";
              //参数准备
              List<Object> parmas=new ArrayList<Object>();
              parmas.add(carInfo.getCState()); 
		List<Carinfo> clist=	PageUtil.querylist(1, 3, hql, parmas);   //获取指定行数区间符合条件的汽车概要信息结果集
			//遍历结果集 加入Map中
		for(Carinfo c:clist){
			carInfoMap.put(c.getCId(), c);
		}
	
		 return carInfoMap;
	}

/**
 * 获取四辆最新上架的汽车概要信息的方法
 * @parma carInfo
 * @return   Map<Long, CarInfo>
 */
	public Map<Long, Carinfo> getFourthCarInfoBySjTime(Carinfo carInfo) {
		// TODO Auto-generated method stub
		Map<Long, Carinfo> carInfoMap=new HashMap<Long, Carinfo>();
		
		String hql="from Carinfo where CState=? order by CSjtime desc  ";
		//参数准备
		  List<Object> parmas=new ArrayList<Object>();
          parmas.add(carInfo.getCState());
	
		List<Carinfo> clist=	PageUtil.querylist(5, 1, hql, parmas); //获取指定行数区间符合条件的汽车概要信息结果集
	    	//遍历结果集 加入Map中
		for(Carinfo c:clist){
			carInfoMap.put(c.getCId(), c);
		}
		 return carInfoMap;
	}

 /**
 * 按热度和车型获取汽车概要信息的方法
 * @parma carInfo
 * @return   Map<Long, CarInfo>
 */
	public Map<Long, Carinfo> getCarInfoByTypeCountDesc(Carinfo carInfo) {
		// TODO Auto-generated method stub
		Map<Long, Carinfo> carInfoMap=new HashMap<Long, Carinfo>();
	
		 String hql="from Carinfo where CType=? and CState=? order by CCount desc";
		 //参数准备
		List<Object> params=new ArrayList<Object>();
			params.add(carInfo.getCType());
			params.add(carInfo.getCState());
			List<Carinfo> clist=	PageUtil.querylist(1, 4, hql, params);  //获取指定行数区间符合条件的汽车概要信息结果集
		//遍历结果集 加入Map中
		for(Carinfo c:clist){
			carInfoMap.put(c.getCId(), c);
		}
		 return carInfoMap;
	}

/**
 * 按品牌获取汽车概要信息的方法
 * @parma carInfo
 * @return   Map<Long, CarInfo>
 */
	public Map<Long, Carinfo> getCarInfoByBrand(Carinfo carInfo) {
		// TODO Auto-generated method stub
		Map<Long, Carinfo> carInfoMap=new HashMap<Long, Carinfo>();
	
			String hql="from Carinfo where CBrand=? ";
			//获取结果集
		List<Carinfo> clist=super.getHibernateTemplate().find(hql,new Object[]{carInfo.getCBrand()});
			//遍历结果集 加入Map中
		for(Carinfo c:clist){
			carInfoMap.put(c.getCId(), c);
		}
		 return carInfoMap;
	}

	
/**
 * 按车型获取汽车概要信息的方法
 * @parma carInfo
 * @return   Map<Long, CarInfo>
 */
	public Map<Long, Carinfo> getCarInfoByType(Carinfo carInfo) {
		// TODO Auto-generated method stub
		Map<Long, Carinfo> carInfoMap=new HashMap<Long, Carinfo>();
		
		String hql="from Carinfo where CType=? ";
			//获取结果集
		List<Carinfo> clist=super.getHibernateTemplate().find(hql,new Object[]{carInfo.getCType()});
			//遍历结果集 加入Map中
		for(Carinfo c:clist){
			carInfoMap.put(c.getCId(), c);
		}
		 return carInfoMap;
	}

/**
 * 按条件获取汽车概要信息的方法
 * @parma carInfo
 * @return   Map<Long, CarInfo>
 */
	public Map<Long, Carinfo> getCarByWhere(Carinfo carInfo) {
		// TODO Auto-generated method stub
		Map<Long, Carinfo> carInfoMap=new HashMap<Long, Carinfo>();

		StringBuffer sql=new StringBuffer("from Carinfo a where 1=1 ");
		//动态参数准备并延伸HQL语句
		List<Object> params=new ArrayList<Object>();
		if(carInfo.getCBrand()!=null){
			sql.append("and CBrand=?");
			params.add(carInfo.getCBrand());
		}
		if(carInfo.getCSeries()!=null){
			sql.append("and CSeries=?");
			params.add(carInfo.getCSeries());
		}
		if(carInfo.getCId()!=0){
			sql.append("and CId=?");
			params.add(carInfo.getCId());
		}
		if(carInfo.getUId()!=0){
			sql.append("and UId=?");
			params.add(carInfo.getUId());
		}
		if(carInfo.getCState()!=null){
			sql.append(" and CState=?");
			params.add(carInfo.getCState());
		}
		//压入确定有的参数
		Object[] o=new Object[params.size()];
		for(int i=0;i<params.size();i++){
			o[i]=params.get(i);		
			}
	   //获取结果集
		List<Carinfo> clist=	super.getHibernateTemplate().find(sql.toString(),o);
		//遍历结果集 ，加入map中
		for(Carinfo c:clist){
			carInfoMap.put(c.getCId(), c);
		}
	
		 return carInfoMap;
	}

/**
 * 获取符合条件的汽车概要信息记录条数
 * @parma minPrice   最小价格
 * @parma maxPrice  最大价格
 * @parma minDis   最小距离
 * @parma maxDis  最大距离
 * @parma minAge  最小车龄
 * @parma maxAge  最大车龄
 * @return   Map<Long, CarInfo>
 */
	public Long queryMsgCount(Object object,int minPrice,int maxPrice,int minDis,int maxDis,int minAge,int maxAge) {
		// TODO Auto-generated method stub
		Long count=null;
		Carinfo carInfo=(Carinfo)object;
		StringBuffer sql=new StringBuffer("select count(*) from Carinfo where 1=1 ");
			//动态参数准备并延伸HQL语句
		List<Object> params=new ArrayList<Object>();
		if(carInfo.getCBrand()!=null){
			sql.append("and CBrand=?");
			params.add(carInfo.getCBrand());
		}
		if(carInfo.getCSeries()!=null){
			sql.append("and CSeries=?");
			params.add(carInfo.getCSeries());
		}
		if(carInfo.getCType()!=null){
			sql.append("and CType=?");
			params.add(carInfo.getCType());
		}
		if(carInfo.getCState()!=null){
			sql.append(" and CState=?");
			params.add(carInfo.getCState());
		}
		if(carInfo.getCEmissionstandard()!=null){
			sql.append(" and CEmissionstandard=? ");
			params.add(carInfo.getCEmissionstandard());
		}
		if(minPrice!=0){
			sql.append(" and CPrice>"+minPrice+"");
		}
		if(maxPrice!=0){
			sql.append(" and CPrice<"+maxPrice+"");
		}
		if(minDis!=0){
			sql.append(" and CDistance>"+minDis+"");
		}
		if(maxDis!=0){
			sql.append(" and CDistance<"+maxDis+"");
		}
		if(minAge!=0){
			sql.append(" and to_number(to_char(sysdate,'yyyy.mm'))-to_number(to_char(CLicencetime,'yyyy.mm'))>"+minAge+"");
		}
		if(maxAge!=0){
			sql.append(" and to_number(to_char(sysdate,'yyyy.mm'))-to_number(to_char(CLicencetime,'yyyy.mm'))<"+maxAge+"");

		}
			//压入确定有的参数
		Object[] o=new Object[params.size()];
		for(int i=0;i<params.size();i++){
			o[i]=params.get(i);		
			}
	    //获取结果 （迭代器listIterator中的next()方法）
		count=	(Long) super.getHibernateTemplate().find(sql.toString(),o).listIterator().next();
	return count;
	}

/**
 * 获取符合条件的汽车概要信息
 * @parma minPrice   最小价格
 * @parma maxPrice  最大价格
 * @parma minDis   最小距离
 * @parma maxDis  最大距离
 * @parma minAge  最小车龄
 * @parma maxAge  最大车龄
 * @parma curPage   当前页
 * @parma rowsPrePage   页面展示条数
 * @return   Map<Long, CarInfo>
 */
	public List<Object> showMsgInfoList(int curPage, int rowsPrePage,Object object,String order,int minPrice,int maxPrice,int minDis,int maxDis,int minAge,int maxAge) {
		List<Object>  carMap=new ArrayList<Object>();
		Carinfo carInfo=(Carinfo) object;
		// TODO Auto-generated method stub
		StringBuffer sql=new StringBuffer("from Carinfo where 1=1 ");
		//动态参数准备并延伸HQL语句
		List<Object> params=new ArrayList<Object>();
		if(carInfo.getCBrand()!=null){
			sql.append(" and CBrand=?");
			params.add(carInfo.getCBrand());
		}
		if(carInfo.getCSeries()!=null){
			sql.append(" and CSeries=?");
			params.add(carInfo.getCSeries());
		}
		if(carInfo.getCType()!=null){
			sql.append(" and CType=?");
			params.add(carInfo.getCType());
		}
		if(carInfo.getCState()!=null){
			sql.append(" and CState=?");
			params.add(carInfo.getCState());
		}
		if(carInfo.getCEmissionstandard()!=null){
			sql.append(" and CEmissionstandard=? ");
			params.add(carInfo.getCEmissionstandard());
		}
		if(minPrice!=0){
			sql.append(" and CPrice>"+minPrice+"");
		}
		if(maxPrice!=0){
			sql.append(" and CPrice<"+maxPrice+"");
		}
		if(minDis!=0){
			sql.append(" and CDistance>"+minDis+"");
		}
		if(maxDis!=0){
			sql.append(" and CDistance<"+maxDis+"");
		}
		if(minAge!=0){
			sql.append(" and to_number(to_char(sysdate,'yyyy.mm'))-to_number(to_char(CLicencetime,'yyyy.mm'))>"+minAge+"");
		}
		if(maxAge!=0){
			sql.append(" and to_number(to_char(sysdate,'yyyy.mm'))-to_number(to_char(CLicencetime,'yyyy.mm'))<"+maxAge+"");

		}
		if(order!=null){
			sql.append(" order by "+order+" ");
			if(order.equals("CCount")){
				sql.append(" desc");
			}
			if(order.equals("CSccount")){
				sql.append(" desc");
			}
		}
	  carMap= PageUtil.querylist(curPage, rowsPrePage, sql.toString(), params);//分页获取符合条件的结果集
		
	
		return carMap;
	}

	
	public Long queryPersonCarCount(Object object) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public Map<Long, Object> showPersonCarList(int curPage, int rowsPrePage,
			Object object) {
		// TODO Auto-generated method stub
		return null;
	}

  /**
   * 修改汽车概要信息的方法
   * @parma carInfo
   * @return int
   */
	public int updateCarInfo(Carinfo carInfo) {
		// TODO Auto-generated method stub
	
		StringBuffer sql=new StringBuffer("update Carinfo set CId=? ");
		//动态参数准备和延伸hql语句
		List<Object> parmas=new ArrayList<Object>();
		parmas.add(carInfo.getCId());
		if(carInfo.getCCount()!=null){
			sql.append(" ,CCount=?");
			parmas.add(carInfo.getCCount());
		}
		if(carInfo.getCSccount()!=null){
			sql.append(" ,CSccount=?");
			parmas.add(carInfo.getCSccount());
		}
		if(carInfo.getCState()!=null){
			sql.append(" ,CState=?");
			parmas.add(carInfo.getCState());
		}
		if(carInfo.getCMcsj()!=null){
			sql.append(" , CMcsj=?");
			parmas.add(carInfo.getCMcsj());
		}
		sql.append("where CId=? ");
		parmas.add(carInfo.getCId());
		//压入确定的参数
		Object[] o=new Object[parmas.size()];
		for(int i=0;i<parmas.size();i++){
			o[i]=parmas.get(i);		
			}
		
		return super.getHibernateTemplate().bulkUpdate(sql.toString(), o); //返回受影响的行数
	}

  /**
   * 添加汽车概要信息的方法
   * @parma carInfo
   * @return int
   */
	public int addCarInfo(Carinfo carInfo) {
		// TODO Auto-generated method stub
		int count=0;
	   try{
		   super.getHibernateTemplate().save(carInfo);//加入
		   count=1;
	   }
	   catch (Exception e) {
		// TODO: handle exception
	}
		
		return count;
	}

	
	public Carinfo getCarInfoByUMN(Carinfo carInfo) {
		// TODO Auto-generated method stub
/**
 * 按唯一条件获取汽车概要信息的方法
 * @parma carInfo
 * @return   CarInfo
 */
		String hql="from Carinfo where UId=?  order by CSjtime desc";
		Carinfo _carInfo=null;
		//参数准备
		List<Object> parmas=new ArrayList<Object>();
		parmas.add(carInfo.getUId());
		try{
			 _carInfo=	(Carinfo) PageUtil.querylist(1, 1, hql, parmas).get(0); //获取指定行数区间的符合条件的结果
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return _carInfo;
	}

  /**
   * 修改汽车所有概要信息的方法
   * @parma carInfo
   * @return int
   */
	public int updateCarAll(Carinfo carInfo) {
		// TODO Auto-generated method stub
		StringBuffer sql=new StringBuffer("update Carinfo set CBrand=?,CSeries=?,CReleaseyear=?,CVolume=?,CGeartype=?,CCode=?,CModel=?,CLicencetime=?,CDistance=?,CEmissionstandard=?,CPrice=?,CImg=?,CType=?,CCzzx=? where CId=?");
		//参数准备
		List<Object> parmas=new ArrayList<Object>();
		
		parmas.add(carInfo.getCBrand());
		parmas.add(carInfo.getCSeries());
		parmas.add(carInfo.getCReleaseyear());
		parmas.add(carInfo.getCVolume());
		parmas.add(carInfo.getCGeartype());
		parmas.add(carInfo.getCCode());
		parmas.add(carInfo.getCModel());
		parmas.add(carInfo.getCLicencetime());
		
		parmas.add(carInfo.getCDistance());
		parmas.add(carInfo.getCEmissionstandard());
		parmas.add(carInfo.getCPrice());
		parmas.add(carInfo.getCImg());
		
		parmas.add(carInfo.getCType());
		parmas.add(carInfo.getCCzzx());
		parmas.add(carInfo.getCId());
		//压入已有的参数
		Object[] o=new Object[parmas.size()];
		for(int i=0;i<parmas.size();i++){
			o[i]=parmas.get(i);		
			}
		
		return super.getHibernateTemplate().bulkUpdate(sql.toString(), o); //返回受影响的行数
	}

	
 /**
   * 根据用户编号删除汽车概要信息
   * @parma carInfo
   * @return int
   */
	public int deletecarinfouser(Carinfo u) {
		// TODO Auto-generated method stub
		
	 int count=0;
	 try{
		 super.getHibernateTemplate().delete(u); //删除
		 count=1;
	 }
	 catch (Exception e) {
		// TODO: handle exception
	}
		return count;
	}

 /**
   * 根据汽车编号删除汽车概要信息
   * @parma carInfo
   * @return int
   */	
	public int deletecarinfo(Carinfo c) {
		// TODO Auto-generated method stub
		 int count=0;
		 try{
			 super.getHibernateTemplate().delete(c); //删除
			 count=1;
		 }
		 catch (Exception e) {
			// TODO: handle exception
		}
			return count;
	}

  /**
   * 检查某用户编号是否有与其相关的汽车概要信息
   * @parma carInfo
   * @return int
   */
	public boolean checkcarinfouser(Carinfo c) {
		// TODO Auto-generated method stub
		boolean flag=false;
		String sql=" from Carinfo where UId=?";
	
	 if(	super.getHibernateTemplate().find(sql.toString(),new Object[]{c.getUId()}).size()>0){
	 	//若返回结果集合size大于0.则返回为真
		 flag=true;
	 }
	 
		return flag;
	}


  /**
   * 获取热度最高的10辆车
   * @parma carInfo
   * @return List<CarInfo>
   */
	@Override
	public List<Carinfo> getTenBrandCar(Carinfo carInfo) {
		// TODO Auto-generated method stub
	
		String hql="select count(*) as CCount,CBrand  from Carinfo a where CState='在售' group by CBrand";
		List<Object[]> carMap=new ArrayList<Object[]>(); 
	    carMap=PageUtil.querylist(1, 10, hql, null); //获取指定行数区间的车辆概要信息
	    List<Carinfo> _carMap=new ArrayList<Carinfo>();
	    //遍历结果集，加入map中
	   for(Object[] o:carMap){
		   Carinfo _carinfo=new Carinfo();
		   _carinfo.setCCount((Long)o[0]);
		   _carinfo.setCBrand(o[1].toString());
		   _carMap.add(_carinfo);
	   }
			return _carMap;
	}

  /**
   * 获取销量最高10个品牌
   * @parma carInfo
   * @return List<CarInfo>
   */
	@Override
	public List<Carinfo> getTenCount(Carinfo carInfo) {
		// TODO Auto-generated method stub
		String hql="from Carinfo where CState='交易完成' order by CCount desc";
		List<Carinfo> carMap=new ArrayList<Carinfo>(); 
	      carMap=PageUtil.querylist(1, 10, hql, null); //获取指定行数区间的车辆概要信息
		return carMap; 
	}
  
}
