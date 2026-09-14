package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.KefurenyuanEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.KefurenyuanVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.KefurenyuanView;


/**
 * 客服人员
 *
 * @author 
 * @email 
 * @date 2025-04-29 17:08:29
 */
public interface KefurenyuanService extends IService<KefurenyuanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<KefurenyuanVO> selectListVO(Wrapper<KefurenyuanEntity> wrapper);
   	
   	KefurenyuanVO selectVO(@Param("ew") Wrapper<KefurenyuanEntity> wrapper);
   	
   	List<KefurenyuanView> selectListView(Wrapper<KefurenyuanEntity> wrapper);
   	
   	KefurenyuanView selectView(@Param("ew") Wrapper<KefurenyuanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<KefurenyuanEntity> wrapper);

   	

}

