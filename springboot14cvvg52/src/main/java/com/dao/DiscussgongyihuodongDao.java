package com.dao;

import com.entity.DiscussgongyihuodongEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussgongyihuodongVO;
import com.entity.view.DiscussgongyihuodongView;


/**
 * 公益活动评论表
 * 
 * @author 
 * @email 
 * @date 2025-04-29 17:08:31
 */
public interface DiscussgongyihuodongDao extends BaseMapper<DiscussgongyihuodongEntity> {
	
	List<DiscussgongyihuodongVO> selectListVO(@Param("ew") Wrapper<DiscussgongyihuodongEntity> wrapper);
	
	DiscussgongyihuodongVO selectVO(@Param("ew") Wrapper<DiscussgongyihuodongEntity> wrapper);
	
	List<DiscussgongyihuodongView> selectListView(@Param("ew") Wrapper<DiscussgongyihuodongEntity> wrapper);

	List<DiscussgongyihuodongView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussgongyihuodongEntity> wrapper);

	
	DiscussgongyihuodongView selectView(@Param("ew") Wrapper<DiscussgongyihuodongEntity> wrapper);
	

}
