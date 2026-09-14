package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.FankuijuanzengEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.FankuijuanzengVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.FankuijuanzengView;


/**
 * 反馈捐赠
 *
 * @author 
 * @email 
 * @date 2025-04-29 17:08:29
 */
public interface FankuijuanzengService extends IService<FankuijuanzengEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<FankuijuanzengVO> selectListVO(Wrapper<FankuijuanzengEntity> wrapper);
   	
   	FankuijuanzengVO selectVO(@Param("ew") Wrapper<FankuijuanzengEntity> wrapper);
   	
   	List<FankuijuanzengView> selectListView(Wrapper<FankuijuanzengEntity> wrapper);
   	
   	FankuijuanzengView selectView(@Param("ew") Wrapper<FankuijuanzengEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<FankuijuanzengEntity> wrapper);

   	

}

