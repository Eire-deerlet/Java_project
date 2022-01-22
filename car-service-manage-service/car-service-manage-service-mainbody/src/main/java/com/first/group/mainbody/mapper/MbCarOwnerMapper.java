package com.first.group.mainbody.mapper;

import com.first.group.mainbody.dtos.CarOwnerDto;
import com.first.group.mainbody.pojos.MbCarOwner;
import com.first.group.mainbody.pojos.MbCars;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface MbCarOwnerMapper {
    //  条件查询车主主体列表
    List<MbCarOwner> findCarOwner(@Param("dto") CarOwnerDto dto);

    //  锁定或解锁车主状态
    @Update("UPDATE mb_car_owner SET status = #{status} WHERE id = #{id};")
    Integer updateStatus(@Param("id") Integer id, @Param("status") Integer status);

    //  查询某位车主的所有车辆
    @Select("SELECT * FROM mb_cars WHERE car_owner_id = #{carOwnerId};")
    List<MbCars> findCars(@Param("carOwnerId") Integer carOwnerId);

}
