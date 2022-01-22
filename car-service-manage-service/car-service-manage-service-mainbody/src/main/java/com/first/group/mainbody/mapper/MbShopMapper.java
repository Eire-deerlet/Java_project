package com.first.group.mainbody.mapper;

import com.first.group.mainbody.dtos.FullShopDto;
import com.first.group.mainbody.dtos.ShortShopDto;
import com.first.group.mainbody.pojos.MbShop;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MbShopMapper {

    // 查询商户（汽修厂+配件厂）简页列表
    List<MbShop> findShortShop(@Param("dto") ShortShopDto dto);

    // 锁定或解锁商户主体
    @Update("UPDATE mb_shop SET status = #{status} WHERE id = #{id};")
    Integer updateStatus(@Param("id") Integer id, @Param("status") Integer status);

    // 点击编辑商家时,回显基本信息
    @Select("SELECT * FROM mb_shop WHERE id = #{id};")
    MbShop findShopById(@Param("id") Integer id);

    // 新增商户基础信息
    Integer addShop(@Param("shop") MbShop shop);
    // 修改汽修厂基础信息
    @Update("UPDATE mb_shop SET full_name = #{shop.fullName}, short_name = #{shop.shortName}, contacts = #{shop.contacts}, contact_number = #{shop.contactNumber}, district_id = #{shop.districtId}, address = #{shop.address}, chain = #{shop.chain}, tag = #{shop.tag}, lat = #{shop.lat}, lng = #{shop.lng}, images = #{shop.images} WHERE id = #{id};")
    Integer saveGarage(@Param("shop") MbShop shop);
    // 修改配件商基础信息
    @Update("UPDATE mb_shop SET full_name = #{shop.fullName}, short_name = #{shop.shortName}, contacts = #{shop.contacts}, contact_number = #{shop.contactNumber}, district_id = #{shop.districtId}, address = #{shop.address}, images = #{shop.images} WHERE id = #{id};")
    Integer saveParts(@Param("shop") MbShop shop);

    // =============================
    // 通过审核后，修改修改审核状态
    @Update("UPDATE mb_shop SET is_pass = #{isPass} WHERE id = #{shopId};")
    Integer updateIsPassById(Integer shopId, Integer isPass);
    @Delete("DELETE FROM mb_shop WHERE id = #{shopId};")
    Integer deleteShopById(Integer shopId);
}
