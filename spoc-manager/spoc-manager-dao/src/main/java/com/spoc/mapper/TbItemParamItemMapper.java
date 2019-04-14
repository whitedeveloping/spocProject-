package com.spoc.mapper;

import com.spoc.pojo.TbItemParamItem;
import com.spoc.pojo.TbItemParamItemExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbItemParamItemMapper {
    int countByExample(TbItemParamItemExample example);

    int deleteByExample(TbItemParamItemExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TbItemParamItem record);

    int insertSelective(TbItemParamItem record);

    List<TbItemParamItem> selectByExampleWithBLOBs(TbItemParamItemExample example);

    List<TbItemParamItem> selectByExample(TbItemParamItemExample example);

    TbItemParamItem selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbItemParamItem record, @Param("example") TbItemParamItemExample example);

    int updateByExampleWithBLOBs(@Param("record") TbItemParamItem record, @Param("example") TbItemParamItemExample example);

    int updateByExample(@Param("record") TbItemParamItem record, @Param("example") TbItemParamItemExample example);

    int updateByPrimaryKeySelective(TbItemParamItem record);

    int updateByPrimaryKeyWithBLOBs(TbItemParamItem record);

    int updateByPrimaryKey(TbItemParamItem record);
}