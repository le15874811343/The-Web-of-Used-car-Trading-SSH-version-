package cn.com.dao;
import java.util.Map;

import cn.com.pojo.*;
/**
 * 用户信息操作接口
 * @author
 */
public interface IUserInfoDao {
  /**
   * 登录的方法
   * @return Userinfo3
   */
  public Userinfo3 login(Userinfo3 userInfo);
  /**
   * 按唯一条件获取用户信息的方法
   *@return Userinfo3 
   */
  public Userinfo3 getUserInfoByUnique(Userinfo3 userInfo);
  /**
   * 添加用户信息的方法
   *@return int 
   */
  public int addUserInfo(Userinfo3 userInfo);
  /**
   * 修改用户信息的方法
   *@return int 
   */
  public int updateUserInfo(Userinfo3 userInfo);
  /**
   * 修改用户密码的方法
   *@return int 
   */
  public int updateUserPwd(Userinfo3 userInfo);
}
