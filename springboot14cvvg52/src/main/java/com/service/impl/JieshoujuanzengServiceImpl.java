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


import com.dao.JieshoujuanzengDao;
import com.entity.JieshoujuanzengEntity;
import com.service.JieshoujuanzengService;
import com.entity.vo.JieshoujuanzengVO;
import com.entity.view.JieshoujuanzengView;

@Service("jieshoujuanzengService")
public class JieshoujuanzengServiceImpl extends ServiceImpl<JieshoujuanzengDao, JieshoujuanzengEntity> implements JieshoujuanzengService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JieshoujuanzengEntity> page = this.selectPage(
                new Query<JieshoujuanzengEntity>(params).getPage(),
                new EntityWrapper<JieshoujuanzengEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JieshoujuanzengEntity> wrapper) {
		  Page<JieshoujuanzengView> page =new Query<JieshoujuanzengView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<JieshoujuanzengVO> selectListVO(Wrapper<JieshoujuanzengEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public JieshoujuanzengVO selectVO(Wrapper<JieshoujuanzengEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<JieshoujuanzengView> selectListView(Wrapper<JieshoujuanzengEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JieshoujuanzengView selectView(Wrapper<JieshoujuanzengEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
