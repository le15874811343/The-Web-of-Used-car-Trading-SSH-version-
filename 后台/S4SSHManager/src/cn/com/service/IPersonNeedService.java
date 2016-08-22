package cn.com.service;

import cn.com.pojo.*;;

public interface IPersonNeedService {
	public boolean addPersonNeed(Personneed personNeed);
	public boolean deletePersonNeed(Personneed personNeed);
	public Personneed getPerSonNeed(Personneed personNeed);
	public boolean updatePersonNeed(Personneed personNeed);
	public boolean chekUidPerson(Personneed personneed);
	public boolean deleteUidPerson(Personneed personneed);
}
