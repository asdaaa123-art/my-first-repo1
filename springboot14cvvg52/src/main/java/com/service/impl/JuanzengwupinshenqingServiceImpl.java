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


import com.dao.JuanzengwupinshenqingDao;
import com.entity.JuanzengwupinshenqingEntity;
import com.service.JuanzengwupinshenqingService;
import com.entity.vo.JuanzengwupinshenqingVO;
import com.entity.view.JuanzengwupinshenqingView;

@Service("juanzengwupinshenqingService")
public class JuanzengwupinshenqingServiceImpl extends ServiceImpl<JuanzengwupinshenqingDao, JuanzengwupinshenqingEntity> implements JuanzengwupinshenqingService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JuanzengwupinshenqingEntity> page = this.selectPage(
                new Query<JuanzengwupinshenqingEntity>(params).getPage(),
                new EntityWrapper<JuanzengwupinshenqingEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JuanzengwupinshenqingEntity> wrapper) {
		  Page<JuanzengwupinshenqingView> page =new Query<JuanzengwupinshenqingView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<JuanzengwupinshenqingVO> selectListVO(Wrapper<JuanzengwupinshenqingEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public JuanzengwupinshenqingVO selectVO(Wrapper<JuanzengwupinshenqingEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<JuanzengwupinshenqingView> selectListView(Wrapper<JuanzengwupinshenqingEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JuanzengwupinshenqingView selectView(Wrapper<JuanzengwupinshenqingEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, Wrapper<JuanzengwupinshenqingEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, Wrapper<JuanzengwupinshenqingEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, Wrapper<JuanzengwupinshenqingEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }




}
