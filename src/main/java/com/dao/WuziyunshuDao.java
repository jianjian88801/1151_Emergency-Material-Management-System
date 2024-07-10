package com.dao;

import com.entity.WuziyunshuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.WuziyunshuView;

/**
 * 物资运输 Dao 接口
 *
 * @author 
 */
public interface WuziyunshuDao extends BaseMapper<WuziyunshuEntity> {

   List<WuziyunshuView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
