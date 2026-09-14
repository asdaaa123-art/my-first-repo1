package com.dao;

import com.entity.FankuijuanzengEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.FankuijuanzengVO;
import com.entity.view.FankuijuanzengView;


/**
 * 反馈捐赠
 * 
 * @author 
 * @email 
 * @date 2025-04-29 17:08:29
 */
public interface FankuijuanzengDao extends BaseMapper<FankuijuanzengEntity> {
	
	List<FankuijuanzengVO> selectListVO(@Param("ew") Wrapper<FankuijuanzengEntity> wrapper);
	
	FankuijuanzengVO selectVO(@Param("ew") Wrapper<FankuijuanzengEntity> wrapper);
	
	List<FankuijuanzengView> selectListView(@Param("ew") Wrapper<FankuijuanzengEntity> wrapper);

	List<FankuijuanzengView> selectListView(Pagination page,@Param("ew") Wrapper<FankuijuanzengEntity> wrapper);

	
	FankuijuanzengView selectView(@Param("ew") Wrapper<FankuijuanzengEntity> wrapper);
	

}
