package com.first.group.mainbody.mapper;

import com.first.group.mainbody.dtos.MainBodyDto;
import com.first.group.mainbody.dtos.MainCheckDto;
import com.first.group.mainbody.dtos.MainUserDto;
import com.first.group.mainbody.pojos.MbMainBody;
import com.first.group.mainbody.pojos.MbMainUser;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MbMainBodyMapper {

    // 条件查询主体列表
    List<MbMainBody> findMainBody(@Param("dto") MainBodyDto dto);

    // 查询该主体是否已经有管理员
    @Select("SELECT is_admin FROM mb_main_body WHERE id = #{bodyId}")
    Boolean findAdminByBodyId(@Param("bodyId") Integer bodyId);

    // 创建主体用户管理员
    @Insert("INSERT INTO mb_main_user VALUES (null, #{dto.bodyId}, #{dto.username}, #{dto.name}, #{dto.password}, #{dto.phoneNumber}, 1, 0);")
    Integer addAdmin(@Param("dto") MainUserDto dto);

    // 新增管理员后，修改is_admin
    @Update("UPDATE mb_main_body SET is_admin = 1 WHERE id = #{bodyId};")
    Integer updateIsAdmin(@Param("bodyId") Integer bodyId);

    // 条件查询主体用户列表
    List<MbMainUser> findMainUser(@Param("dto") MainUserDto dto);

    // 用户密码重置
    @Update("UPDATE mb_main_user SET password = '0616' WHERE id = #{id}")
    Integer remarkPassword(@Param("id") Integer id);

    // 锁定或解锁主体用户
    @Update("UPDATE mb_main_user SET status = #{status} WHERE id = #{id};")
    Integer updateUserStatus(@Param("id") Integer id, @Param("status") Integer status);

    // 条件查询需要审核的主体列表
    List<MbMainBody> findCheckBody(@Param("dto") MainCheckDto dto);

    // 主体通过审核或拒绝通过
    @Update("UPDATE mb_main_body SET is_check = #{isPass} WHERE shop_id = #{shopId};")
    Integer isPassBody(@Param("shopId") Integer shopId, @Param("isPass") Integer isPass);

    // 条件查询审核不通过的主体列表
    List<MbMainBody> findRefuseBody(@Param("dto") MainCheckDto dto);

    // =======================
    // 添加商家时，同步新增主体
    @Insert("INSERT INTO mb_main_body VALUES (null, #{mainBody.shopId}, #{mainBody.shortName}, #{mainBody.type}, #{mainBody.status}, #{mainBody.districtId}, #{mainBody.isAdmin}, #{mainBody.registerTime}, #{mainBody.source}, #{mainBody.isCheck});")
    Integer addMainBody(@Param("mainBody") MbMainBody mainBody);
    // 修改商家时，同步修改主体
    @Update("UPDATE mb_main_body SET short_name = #{mainBody.shortName}, district_id = #{mainBody.districtId} WHERE shop_id = #{mainBody.shopId};")
    Integer putMainBody(@Param("mainBody") MbMainBody mainBody);
    // 锁定或解锁主体
    @Update("UPDATE mb_main_body SET status = #{status} WHERE shop_id = #{id};")
    Integer updateBodyStatus(@Param("id") Integer id, @Param("status") Integer status);

}
