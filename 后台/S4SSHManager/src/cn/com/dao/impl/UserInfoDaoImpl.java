package cn.com.dao.impl;

import java.sql.*;
import java.util.*;

import cn.com.pojo.*;
import cn.com.dao.*;
import cn.com.util.*;
/**
 * 用户信息操作实现类
 * @author
 */
public class UserInfoDaoImpl extends BaseDao implements IUserInfoDao, IPageDao {
  /**
   * 登录的方法
   * @return UserInfo
   */
	@Override
	public Userinfo3 login(Userinfo3 userInfo) {
		// TODO Auto-generated method stub
		Userinfo3 _userInfo = null;
		StringBuffer sql = new StringBuffer(" from Userinfo3 ");
		sql.append("where UTel=? and UPwd=?");

		try {
		List<Userinfo3>	_userlist = super.getHibernateTemplate().find(
					sql.toString(),
					new Object[] { userInfo.getUTel(), userInfo.getUPwd() });//获取结果集
		if(_userlist.size()>0){
			_userInfo=_userlist.get(0);//获取结果
		}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return _userInfo;
	}
  /**
   * 按唯一条件获取用户信息的方法
   *@return UserInfo 
   */
	@Override
	public Userinfo3 getUserInfoByUnique(Userinfo3 userInfo) {
		// TODO Auto-generated method stub
		Userinfo3 _userInfo = null;
		StringBuffer sql = new StringBuffer("from Userinfo3 ");
		sql.append("where 1=1 ");
		//动态准备参数和延伸HQL语句
		List<Object> parmas = new ArrayList<Object>();
		if (userInfo.getUTel() != null) {
			sql.append(" and UTel=? ");
			parmas.add(userInfo.getUTel());
		}
		if (userInfo.getUId() != null) {
			sql.append(" and UId=? ");
			parmas.add(userInfo.getUId());
		}
		//压入确定有的参数
		Object[] o = new Object[parmas.size()];
		for (int i = 0; i < parmas.size(); i++) {
			o[i] = parmas.get(i);
		}

		try {
			List<Userinfo3> userlist = super.getHibernateTemplate()
					.find(sql.toString(), o);//获取结果集
			if(userlist.size()>0){
				_userInfo=userlist.get(0); //获取结果
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return _userInfo;
	}
  /**
   * 添加用户信息的方法
   *@return int 
   */
	@Override
	public int addUserInfo(Userinfo3 userInfo) {
		// TODO Auto-generated method stub
		int count = 0;
		try {
			super.getHibernateTemplate().save(userInfo); //加入
			count = 1;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return count;
	}
  /**
   * 修改用户信息的方法
   *@return int 
   */
	@Override
	public int updateUserInfo(Userinfo3 userInfo) {
		// TODO Auto-generated method stub
		StringBuffer sql = new StringBuffer("update  Userinfo3 set UId=? ");
		List<Object> params = new ArrayList<Object>();
		//动态准备参数并延伸HQL语句
		params.add(userInfo.getUId());
		if (userInfo.getUName() != null) {
			sql.append(" , UName=?");
			params.add(userInfo.getUName());
		}
		if (userInfo.getUSex() != null) {
			sql.append(" , USex=?");
			params.add(userInfo.getUSex());
		}
		if (userInfo.getUCard() != null) {
			sql.append(" , UCard=?");
			params.add(userInfo.getUCard());
		}
		if (userInfo.getUAdr() != null) {
			sql.append(" , UAdr=?");
			params.add(userInfo.getUAdr());
		}
		if (userInfo.getUQq() != null) {
			sql.append(" , UQq=?");
			params.add(userInfo.getUQq());
		}
		if (userInfo.getUEmail() != null) {
			sql.append(" , UEmail=?");
			params.add(userInfo.getUEmail());
		}

		sql.append(" where UId=?");
		params.add(userInfo.getUId());
		//压入确定有的参数
		Object[] o = new Object[params.size()];
		for (int i = 0; i < params.size(); i++) {
			o[i] = params.get(i);
		}
                 //返回受影响的行数
		return super.getHibernateTemplate().bulkUpdate(sql.toString(), o);
	}
 /**
   * 修改用户密码的方法
   *@return int 
   */
	@Override
	public int updateUserPwd(Userinfo3 userInfo) {
		// TODO Auto-generated method stub
		StringBuffer sql = new StringBuffer(
				"update Userinfo3 set UPwd=? where UId=?");

		return super.getHibernateTemplate().bulkUpdate(sql.toString(),
				new Object[] { userInfo.getUPwd(), userInfo.getUId() });
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
     * 获取用户记录条数
     * 
     * @return Long
     */
	@Override
	public Long queryPersonCarCount(Object object) {
		// TODO Auto-generated method stub
		Long count = null;
		Userinfo3 userInfo = (Userinfo3) object;
		//动态准备参数并延伸HQL语句
		List<Object> parmas = new ArrayList<Object>();
		StringBuffer sql = new StringBuffer(
				"select count(*) from Userinfo3 where 1=1");
		if (userInfo.getUAdmin() != null) {
			sql.append(" and UAdmin=?");
			parmas.add(userInfo.getUAdmin());
		}
		//压入确定有的参数
		Object[] o = new Object[parmas.size()];
		for (int i = 0; i < parmas.size(); i++) {
			o[i] = parmas.get(i);
		}

		try {
			count = (Long) super.getHibernateTemplate()
					.find(sql.toString(), o).listIterator().next();//获取结果

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
/**
 * 分页获取用户信息
 * @param curPage 当前页
 * @param rowsPrePage 每页显示记录条数
 * 
 * @return Map<Long,Object>
 */
	@Override
	public Map<Long, Object> showPersonCarList(int curPage, int rowsPrePage,
			Object object) {
		// TODO Auto-generated method stub
		Userinfo3 userInfo = (Userinfo3) object;
		StringBuffer sql = new StringBuffer(
				" from Userinfo3  a  where 1=1");
		Map<Long, Object> userMap = new HashMap<Long, Object>();
		List<Object> params = new ArrayList<Object>();
                //动态准备参数并延伸HQL语句
		if (userInfo.getUAdmin() != null) {
			sql.append(" and UAdmin=?");
			params.add(userInfo.getUAdmin());
		}
	   
		
		try {
			//获取指定行数区间符合条件的结果集
			List<Userinfo3> ulist = PageUtil.querylist(curPage, rowsPrePage, sql.toString(), params);
			//遍历结果集加入map中
			for (Userinfo3 u : ulist) {
				userMap.put(u.getUId(), u);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userMap;
	}
  /**
   * 删除用户信息的方法
   *@return int 
   */
	@Override
	public int deleteuserinfouser(Userinfo3 u) {
		// TODO Auto-generated method stub
		int count = 0;
		try {
			super.getHibernateTemplate().delete(u);//删除
			count = 1;
		} catch (Exception e) {
			// TODO: handle exception
			count = 0;
			e.printStackTrace();
		}
		return count;
	}

}
