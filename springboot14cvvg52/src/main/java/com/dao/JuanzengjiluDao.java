package com.dao;

import com.entity.JuanzengjiluEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.JuanzengjiluVO;
import com.entity.view.JuanzengjiluView;


/**
 * 捐赠记录
 * 
 * @author 
 * @email 
 * @date 2025-04-29 17:08:29
 */
public interface JuanzengjiluDao extends BaseMapper<JuanzengjiluEntity> {
	
	List<JuanzengjiluVO> selectListVO(@Param("ew") Wrapper<JuanzengjiluEntity> wrapper);
	
	JuanzengjiluVO selectVO(@Param("ew") Wrapper<JuanzengjiluEntity> wrapper);
	
	List<JuanzengjiluView> selectListView(@Param("ew") Wrapper<JuanzengjiluEntity> wrapper);

	List<JuanzengjiluView> selectListView(Pagination page,@Param("ew") Wrapper<JuanzengjiluEntity> wrapper);

	
	JuanzengjiluView selectView(@Param("ew") Wrapper<JuanzengjiluEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<JuanzengjiluEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<JuanzengjiluEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<JuanzengjiluEntity> wrapper);



}
