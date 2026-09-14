package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.*;
import java.lang.*;
import java.math.*;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import com.utils.ValidatorUtils;
import com.utils.DeSensUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.GongyihuodongEntity;
import com.entity.view.GongyihuodongView;

import com.service.GongyihuodongService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;
import com.service.StoreupService;
import com.entity.StoreupEntity;

/**
 * 公益活动
 * 后端接口
 * @author 
 * @email 
 * @date 2025-04-29 17:08:29
 */
@RestController
@RequestMapping("/gongyihuodong")
public class GongyihuodongController {
    @Autowired
    private GongyihuodongService gongyihuodongService;

    @Autowired
    private StoreupService storeupService;





    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,GongyihuodongEntity gongyihuodong,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("zhiyuanzhe")) {
			gongyihuodong.setZhiyuanzhezhanghao((String)request.getSession().getAttribute("username"));
		}
        //设置查询条件
        EntityWrapper<GongyihuodongEntity> ew = new EntityWrapper<GongyihuodongEntity>();


        //查询结果
		PageUtils page = gongyihuodongService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, gongyihuodong), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,GongyihuodongEntity gongyihuodong, 
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<GongyihuodongEntity> ew = new EntityWrapper<GongyihuodongEntity>();

        //查询结果
		PageUtils page = gongyihuodongService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, gongyihuodong), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( GongyihuodongEntity gongyihuodong){
       	EntityWrapper<GongyihuodongEntity> ew = new EntityWrapper<GongyihuodongEntity>();
      	ew.allEq(MPUtil.allEQMapPre( gongyihuodong, "gongyihuodong")); 
        return R.ok().put("data", gongyihuodongService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(GongyihuodongEntity gongyihuodong){
        EntityWrapper< GongyihuodongEntity> ew = new EntityWrapper< GongyihuodongEntity>();
 		ew.allEq(MPUtil.allEQMapPre( gongyihuodong, "gongyihuodong")); 
		GongyihuodongView gongyihuodongView =  gongyihuodongService.selectView(ew);
		return R.ok("查询公益活动成功").put("data", gongyihuodongView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        GongyihuodongEntity gongyihuodong = gongyihuodongService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(gongyihuodong,deSens);
        return R.ok().put("data", gongyihuodong);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        GongyihuodongEntity gongyihuodong = gongyihuodongService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(gongyihuodong,deSens);
        return R.ok().put("data", gongyihuodong);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody GongyihuodongEntity gongyihuodong, HttpServletRequest request){
        //ValidatorUtils.validateEntity(gongyihuodong);
        gongyihuodongService.insert(gongyihuodong);
        return R.ok().put("data",gongyihuodong.getId());
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody GongyihuodongEntity gongyihuodong, HttpServletRequest request){
        //ValidatorUtils.validateEntity(gongyihuodong);
        gongyihuodongService.insert(gongyihuodong);
        return R.ok().put("data",gongyihuodong.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody GongyihuodongEntity gongyihuodong, HttpServletRequest request){
        //ValidatorUtils.validateEntity(gongyihuodong);
        //全部更新
        gongyihuodongService.updateById(gongyihuodong);
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        gongyihuodongService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    








}
