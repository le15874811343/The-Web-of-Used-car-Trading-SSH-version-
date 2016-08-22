package cn.com.dao;

import java.util.Map;

import cn.com.pojo.*;

public interface ISellInfoDao {
	/**
	 * ��ȡ����������Ϣ
	 * @return
	 */
public Map<Long, Sellinfo> getAllSellInfo();
/**
 * ���ݳ���Ż�ȡ�������
 * @return
 */
public Sellinfo getSellInfoById(Carinfo carInfo);
/**
 * �����������
 * @param sellInfo
 * @return
 */
public int addSellInfo(Sellinfo sellInfo);
/**
 * ɾ���������
 * @param sellInfo
 * @return
 */
public int deleteSellInfo(Sellinfo sellInfo);
public int updateSellInfo(Sellinfo sellInfo);
public int deletesellinfouser(Sellinfo s);
public int deletecidsellinfouser(Sellinfo s);
public boolean checksellinfouser(Sellinfo s);
public boolean checkcidsellinfouser(Sellinfo s);

}
