package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.JuanzengwupinshenqingEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.JuanzengwupinshenqingVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.JuanzengwupinshenqingView;


/**
 * 捐赠物品申请
 *
 * @author 
 * @email 
 * @date 2025-04-29 17:08:29
 */
public interface JuanzengwupinshenqingService extends IService<JuanzengwupinshenqingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JuanzengwupinshenqingVO> selectListVO(Wrapper<JuanzengwupinshenqingEntity> wrapper);
   	
   	JuanzengwupinshenqingVO selectVO(@Param("ew") Wrapper<JuanzengwupinshenqingEntity> wrapper);
   	
   	List<JuanzengwupinshenqingView> selectListView(Wrapper<JuanzengwupinshenqingEntity> wrapper);
   	
   	JuanzengwupinshenqingView selectView(@Param("ew") Wrapper<JuanzengwupinshenqingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JuanzengwupinshenqingEntity> wrapper);

   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<JuanzengwupinshenqingEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<JuanzengwupinshenqingEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<JuanzengwupinshenqingEntity> wrapper);



}

