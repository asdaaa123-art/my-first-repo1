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


import com.dao.DiscussgongyihuodongDao;
import com.entity.DiscussgongyihuodongEntity;
import com.service.DiscussgongyihuodongService;
import com.entity.vo.DiscussgongyihuodongVO;
import com.entity.view.DiscussgongyihuodongView;

@Service("discussgongyihuodongService")
public class DiscussgongyihuodongServiceImpl extends ServiceImpl<DiscussgongyihuodongDao, DiscussgongyihuodongEntity> implements DiscussgongyihuodongService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussgongyihuodongEntity> page = this.selectPage(
                new Query<DiscussgongyihuodongEntity>(params).getPage(),
                new EntityWrapper<DiscussgongyihuodongEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussgongyihuodongEntity> wrapper) {
		  Page<DiscussgongyihuodongView> page =new Query<DiscussgongyihuodongView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<DiscussgongyihuodongVO> selectListVO(Wrapper<DiscussgongyihuodongEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussgongyihuodongVO selectVO(Wrapper<DiscussgongyihuodongEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussgongyihuodongView> selectListView(Wrapper<DiscussgongyihuodongEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussgongyihuodongView selectView(Wrapper<DiscussgongyihuodongEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
