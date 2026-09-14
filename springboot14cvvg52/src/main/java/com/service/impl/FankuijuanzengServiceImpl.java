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


import com.dao.FankuijuanzengDao;
import com.entity.FankuijuanzengEntity;
import com.service.FankuijuanzengService;
import com.entity.vo.FankuijuanzengVO;
import com.entity.view.FankuijuanzengView;

@Service("fankuijuanzengService")
public class FankuijuanzengServiceImpl extends ServiceImpl<FankuijuanzengDao, FankuijuanzengEntity> implements FankuijuanzengService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<FankuijuanzengEntity> page = this.selectPage(
                new Query<FankuijuanzengEntity>(params).getPage(),
                new EntityWrapper<FankuijuanzengEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<FankuijuanzengEntity> wrapper) {
		  Page<FankuijuanzengView> page =new Query<FankuijuanzengView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<FankuijuanzengVO> selectListVO(Wrapper<FankuijuanzengEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public FankuijuanzengVO selectVO(Wrapper<FankuijuanzengEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<FankuijuanzengView> selectListView(Wrapper<FankuijuanzengEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public FankuijuanzengView selectView(Wrapper<FankuijuanzengEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
