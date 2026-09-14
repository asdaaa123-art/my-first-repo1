package com.dao;

import com.entity.JuanzengwupinshenqingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.JuanzengwupinshenqingVO;
import com.entity.view.JuanzengwupinshenqingView;


/**
 * 捐赠物品申请
 * 
 * @author 
 * @email 
 * @date 2025-04-29 17:08:29
 */
public interface JuanzengwupinshenqingDao extends BaseMapper<JuanzengwupinshenqingEntity> {
	
	List<JuanzengwupinshenqingVO> selectListVO(@Param("ew") Wrapper<JuanzengwupinshenqingEntity> wrapper);
	
	JuanzengwupinshenqingVO selectVO(@Param("ew") Wrapper<JuanzengwupinshenqingEntity> wrapper);
	
	List<JuanzengwupinshenqingView> selectListView(@Param("ew") Wrapper<JuanzengwupinshenqingEntity> wrapper);

	List<JuanzengwupinshenqingView> selectListView(Pagination page,@Param("ew") Wrapper<JuanzengwupinshenqingEntity> wrapper);

	
	JuanzengwupinshenqingView selectView(@Param("ew") Wrapper<JuanzengwupinshenqingEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<JuanzengwupinshenqingEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<JuanzengwupinshenqingEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<JuanzengwupinshenqingEntity> wrapper);



}
