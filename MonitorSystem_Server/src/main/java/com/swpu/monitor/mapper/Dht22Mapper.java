package com.swpu.monitor.mapper;

import com.swpu.monitor.entity.Dht22;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author YSXCC
 */
@Mapper
@Repository
public interface Dht22Mapper {

    Dht22 getNewDht22();

    int addDht22Data(@Param("inTime") String inTime,@Param("temperature") String temperature,@Param("humidity") String humidity);

}
