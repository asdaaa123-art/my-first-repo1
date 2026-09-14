package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.JieshoujuanzengEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.JieshoujuanzengVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.JieshoujuanzengView;


/**
 * 接受捐赠
 *
 * @author 
 * @email 
 * @date 2025-04-29 17:08:29
 */
public interface JieshoujuanzengService extends IService<JieshoujuanzengEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JieshoujuanzengVO> selectListVO(Wrapper<JieshoujuanzengEntity> wrapper);
   	
   	JieshoujuanzengVO selectVO(@Param("ew") Wrapper<JieshoujuanzengEntity> wrapper);
   	
   	List<JieshoujuanzengView> selectListView(Wrapper<JieshoujuanzengEntity> wrapper);
   	
   	JieshoujuanzengView selectView(@Param("ew") Wrapper<JieshoujuanzengEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JieshoujuanzengEntity> wrapper);

   	

}

