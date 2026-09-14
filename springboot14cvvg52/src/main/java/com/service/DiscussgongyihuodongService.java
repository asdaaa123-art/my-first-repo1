package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscussgongyihuodongEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscussgongyihuodongVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscussgongyihuodongView;


/**
 * 公益活动评论表
 *
 * @author 
 * @email 
 * @date 2025-04-29 17:08:31
 */
public interface DiscussgongyihuodongService extends IService<DiscussgongyihuodongEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussgongyihuodongVO> selectListVO(Wrapper<DiscussgongyihuodongEntity> wrapper);
   	
   	DiscussgongyihuodongVO selectVO(@Param("ew") Wrapper<DiscussgongyihuodongEntity> wrapper);
   	
   	List<DiscussgongyihuodongView> selectListView(Wrapper<DiscussgongyihuodongEntity> wrapper);
   	
   	DiscussgongyihuodongView selectView(@Param("ew") Wrapper<DiscussgongyihuodongEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussgongyihuodongEntity> wrapper);

   	

}

