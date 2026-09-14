package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.KefurenyuanDao;
import com.entity.KefurenyuanEntity;
import com.service.KefurenyuanService;
import com.entity.vo.KefurenyuanVO;
import com.entity.view.KefurenyuanView;

@Service("kefurenyuanService")
public class KefurenyuanServiceImpl extends ServiceImpl<KefurenyuanDao, KefurenyuanEntity> implements KefurenyuanService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<KefurenyuanEntity> page = this.selectPage(
                new Query<KefurenyuanEntity>(params).getPage(),
                new EntityWrapper<KefurenyuanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<KefurenyuanEntity> wrapper) {
		  Page<KefurenyuanView> page =new Query<KefurenyuanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<KefurenyuanVO> selectListVO(Wrapper<KefurenyuanEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public KefurenyuanVO selectVO(Wrapper<KefurenyuanEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<KefurenyuanView> selectListView(Wrapper<KefurenyuanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public KefurenyuanView selectView(Wrapper<KefurenyuanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
