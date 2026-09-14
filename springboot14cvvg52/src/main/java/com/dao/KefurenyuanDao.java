package com.dao;

import com.entity.KefurenyuanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.KefurenyuanVO;
import com.entity.view.KefurenyuanView;


/**
 * 客服人员
 * 
 * @author 
 * @email 
 * @date 2025-04-29 17:08:29
 */
public interface KefurenyuanDao extends BaseMapper<KefurenyuanEntity> {
	
	List<KefurenyuanVO> selectListVO(@Param("ew") Wrapper<KefurenyuanEntity> wrapper);
	
	KefurenyuanVO selectVO(@Param("ew") Wrapper<KefurenyuanEntity> wrapper);
	
	List<KefurenyuanView> selectListView(@Param("ew") Wrapper<KefurenyuanEntity> wrapper);

	List<KefurenyuanView> selectListView(Pagination page,@Param("ew") Wrapper<KefurenyuanEntity> wrapper);

	
	KefurenyuanView selectView(@Param("ew") Wrapper<KefurenyuanEntity> wrapper);
	

}
