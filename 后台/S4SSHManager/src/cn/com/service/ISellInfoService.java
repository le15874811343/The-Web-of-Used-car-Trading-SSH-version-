package cn.com.service;

import java.util.Map;

import cn.com.pojo.*;

public interface ISellInfoService {
	/**
	 * ��ȡ����������Ϣҵ��
	 */
	public Map<Long, Sellinfo> getAllSellInfo();
	/**
	 * ���ݳ���Ż�ȡ�������ҵ��
	 */
	public Sellinfo getSellInfoById(Carinfo carInfo);
	/**
	 * �����������ҵ��
	 */
	public boolean addSellInfo(Sellinfo sellInfo);
	/**
	 * ɾ���������ҵ��
	 */
	public int deleteSellInfo(Sellinfo sellInfo);
	public boolean updateSellInfo(Sellinfo sellInfo);
	public boolean deletesellinfouser(Sellinfo s);
	 public boolean deletecidsellinfouser(Sellinfo s);
	 public boolean checksellinfouser(Sellinfo s);
	 public boolean checkcidsellinfouser(Sellinfo s);
}
