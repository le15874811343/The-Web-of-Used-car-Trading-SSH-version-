package cn.com.service;

import java.util.Map;
import cn.com.pojo.*;
public interface IHardwareConfigService {
	public Map<Long, Hardwareconfig> getAllHardwareConfig();
	public Hardwareconfig getHardwareConfigById(Carinfo carInfo);
	public boolean addHardwareConfig(Hardwareconfig hardwareConfig);
	public boolean updateHardwareConfig(Hardwareconfig hardwareConfig);
}
