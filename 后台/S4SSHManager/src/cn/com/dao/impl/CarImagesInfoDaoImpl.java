package cn.com.dao.impl;

import java.sql.*;
import java.util.*;

import cn.com.pojo.*;
import cn.com.dao.*;
import cn.com.util.*;
/**
 * 汽车图片信息操作实现类
 * @author lej
 */
public class CarImagesInfoDaoImpl extends BaseDao implements ICarImagesInfoDao {
  /**
   * 根据编号获取汽车照片的方法
   * @parma carInfo
   * @return Map<Integer,String>
   */
	@Override
	public Map<Integer, String> getCarImagesInfoByID(Carinfo carInfo) {
		// TODO Auto-generated method stub
		String sql = "from Imagesinfo where CId=? and UId=?";
		Map<Integer, String> imgMap = new HashMap<Integer, String>(); 
		
	
		
		try {
			Imagesinfo carImagesInfo = (Imagesinfo) super
					.getHibernateTemplate()
					.find(sql,
							new Object[] { carInfo.getCId(), carInfo.getUId() })
					.get(0); //获取结果
					//将对象的非空文件地址压入map中
				if (carImagesInfo.getImage1() != null
						&& !carImagesInfo.getImage1().equals("")) {
					imgMap.put(1, carImagesInfo.getImage1());
				}
				if (carImagesInfo.getImage2() != null
						&& !carImagesInfo.getImage2().equals("")) {
					imgMap.put(2, carImagesInfo.getImage2());
				}
				if (carImagesInfo.getImage3() != null
						&& !carImagesInfo.getImage3().equals("")) {
					imgMap.put(3, carImagesInfo.getImage3());
				}
				if (carImagesInfo.getImage4() != null
						&& !carImagesInfo.getImage4().equals("")) {
					imgMap.put(4, carImagesInfo.getImage4());
				}
				if (carImagesInfo.getImage5() != null
						&& !carImagesInfo.getImage5().equals("")) {
					imgMap.put(5, carImagesInfo.getImage5());
				}
				if (carImagesInfo.getImage6() != null
						&& !carImagesInfo.getImage6().equals("")) {
					imgMap.put(6, carImagesInfo.getImage6());
				}
				if (carImagesInfo.getImage7() != null
						&& !carImagesInfo.getImage7().equals("")) {
					imgMap.put(7, carImagesInfo.getImage7());
				}
				if (carImagesInfo.getImage8() != null
						&& !carImagesInfo.getImage8().equals("")) {
					imgMap.put(8, carImagesInfo.getImage8());
				}
				if (carImagesInfo.getImage9() != null
						&& !carImagesInfo.getImage9().equals("")) {
					imgMap.put(9, carImagesInfo.getImage9());
				}
				if (carImagesInfo.getImage10() != null
						&& !carImagesInfo.getImage10().equals("")) {
					imgMap.put(10, carImagesInfo.getImage10());
				}

			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return imgMap;
	}
/**
 * 添加照片信息的方法
 * @parma carImagesInfo
 *@reutn int 
 */
	@Override
	public int addCarImagesInfo(Imagesinfo carImagesInfo) {
		// TODO Auto-generated method stub
		int count = 0;
		try {
			super.getHibernateTemplate().save(carImagesInfo);//加入
			count = 1;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return count;
	}
/**
 *修改照片信息的方法 
 * @parmas
 * @return int
 */
	@Override
	public int updateCarImagesInfo(Imagesinfo carImagesInfo) {
		// TODO Auto-generated method stub

		StringBuffer sql = new StringBuffer(
				"update  Imagesinfo set image1=?,image2=?,image3=?,image4=?,image5=?,image6=?,image7=?,image8=?,image9=?,image10=? where u_id=? and c_id=?");
                     //返回受影响的行数
		return super.getHibernateTemplate().bulkUpdate(
				sql.toString(),
				new Object[] { carImagesInfo.getImage1(),
						carImagesInfo.getImage2(), carImagesInfo.getImage3(),
						carImagesInfo.getImage4(), carImagesInfo.getImage5(),
						carImagesInfo.getImage6(), carImagesInfo.getImage7(),
						carImagesInfo.getImage8(), carImagesInfo.getImage9(),
						carImagesInfo.getImage10(), carImagesInfo.getUId(),
						carImagesInfo.getCId() });
	}
/**
 * 根据车主编号删除汽车照片信息的方法
 *@return int  
 */
	@Override
	public int deleteimagesinfouser(Imagesinfo c) {
		// TODO Auto-generated method stub
		String hql="from  Imagesinfo where UId=?";
		int count=0;
	List<Imagesinfo> imageslist=	super.getHibernateTemplate().find(hql,c.getUId());//获取持久化对象
	try{
	for(Imagesinfo i:imageslist){
		super.getHibernateTemplate().delete(i); //删除
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
 * 根据车编号删除汽车照片信息的方法
 *@return int  
 */
	@Override
	public int deletecidimagesinfouser(Imagesinfo c) {
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
 * 
 * 检查是否还有与某车主编号关联的汽车照片信息
 * @return boolean
 */
	@Override
	public boolean checkimageinfouser(Imagesinfo c) {
		// TODO Auto-generated method stub
		boolean flag=false;
		String sql="from Imagesinfo where UId=?";
		try {
	List<Imagesinfo> imlist=	   super.getHibernateTemplate().find(sql,c.getUId()); //获取结果集
	if(imlist.size()>0){
		 flag=true; //若结果集元素个数大于0,则返回为真
	}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
/**
 * 
 * 检查是否还有与某车编号关联的汽车照片信息
 * @return boolean
 */
	@Override
	public boolean checkcidimageinfouser(Imagesinfo c) {
		// TODO Auto-generated method stub
		boolean flag=false;
		String sql="from Imagesinfo where CId=?";
		try {
	List<Imagesinfo> imlist=	   super.getHibernateTemplate().find(sql,c.getCId()); //获取结果集
	if(imlist.size()>0){
		 flag=true; //若结果集元素个数大于0,则返回为真
	}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

}
