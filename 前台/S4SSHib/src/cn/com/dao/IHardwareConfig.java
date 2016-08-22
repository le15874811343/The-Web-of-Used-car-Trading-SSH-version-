package cn.com.dao;

import java.util.Map;
import cn.com.pojo.*;

public interface IHardwareConfig {
public Map<Long, Hardwareconfig> getAllHardwareConfig();
public Hardwareconfig getHardwareConfigById(Carinfo carInfo);
public int addHardwareConfig(Hardwareconfig hardwareConfig);
public int updateHardwareConfig(Hardwareconfig hardwareConfig);
}
