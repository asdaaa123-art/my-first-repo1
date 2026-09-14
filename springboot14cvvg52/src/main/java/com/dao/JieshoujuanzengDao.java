package com.dao;

import com.entity.JieshoujuanzengEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.JieshoujuanzengVO;
import com.entity.view.JieshoujuanzengView;


/**
 * 接受捐赠
 * 
 * @author 
 * @email 
 * @date 2025-04-29 17:08:29
 */
public interface JieshoujuanzengDao extends BaseMapper<JieshoujuanzengEntity> {
	
	List<JieshoujuanzengVO> selectListVO(@Param("ew") Wrapper<JieshoujuanzengEntity> wrapper);
	
	JieshoujuanzengVO selectVO(@Param("ew") Wrapper<JieshoujuanzengEntity> wrapper);
	
	List<JieshoujuanzengView> selectListView(@Param("ew") Wrapper<JieshoujuanzengEntity> wrapper);

	List<JieshoujuanzengView> selectListView(Pagination page,@Param("ew") Wrapper<JieshoujuanzengEntity> wrapper);

	
	JieshoujuanzengView selectView(@Param("ew") Wrapper<JieshoujuanzengEntity> wrapper);
	

}
