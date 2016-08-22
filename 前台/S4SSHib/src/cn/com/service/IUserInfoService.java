package cn.com.service;


import cn.com.pojo.*;




public interface IUserInfoService {
	public Userinfo3 login(Userinfo3 userInfo);
	public Userinfo3 getUserInfoByUnique(Userinfo3 userInfo);
	public boolean addUserInfo(Userinfo3 userInfo);
	public boolean updateUserInfo(Userinfo3 userInfo);
	public boolean updateUserPwd(Userinfo3 userInfo);
}
