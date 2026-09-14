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

import com.entity.FankuijuanzengEntity;
import com.entity.view.FankuijuanzengView;

import com.service.FankuijuanzengService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 反馈捐赠
 * 后端接口
 * @author 
 * @email 
 * @date 2025-04-29 17:08:29
 */
@RestController
@RequestMapping("/fankuijuanzeng")
public class FankuijuanzengController {
    @Autowired
    private FankuijuanzengService fankuijuanzengService;






    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,FankuijuanzengEntity fankuijuanzeng,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("shouzhuzhe")) {
			fankuijuanzeng.setShouzhuzhezhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("juanzengzhe")) {
			fankuijuanzeng.setJuanzengzhezhanghao((String)request.getSession().getAttribute("username"));
		}
        //设置查询条件
        EntityWrapper<FankuijuanzengEntity> ew = new EntityWrapper<FankuijuanzengEntity>();


        //查询结果
		PageUtils page = fankuijuanzengService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, fankuijuanzeng), params), params));
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
    public R list(@RequestParam Map<String, Object> params,FankuijuanzengEntity fankuijuanzeng, 
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<FankuijuanzengEntity> ew = new EntityWrapper<FankuijuanzengEntity>();

        //查询结果
		PageUtils page = fankuijuanzengService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, fankuijuanzeng), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( FankuijuanzengEntity fankuijuanzeng){
       	EntityWrapper<FankuijuanzengEntity> ew = new EntityWrapper<FankuijuanzengEntity>();
      	ew.allEq(MPUtil.allEQMapPre( fankuijuanzeng, "fankuijuanzeng")); 
        return R.ok().put("data", fankuijuanzengService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(FankuijuanzengEntity fankuijuanzeng){
        EntityWrapper< FankuijuanzengEntity> ew = new EntityWrapper< FankuijuanzengEntity>();
 		ew.allEq(MPUtil.allEQMapPre( fankuijuanzeng, "fankuijuanzeng")); 
		FankuijuanzengView fankuijuanzengView =  fankuijuanzengService.selectView(ew);
		return R.ok("查询反馈捐赠成功").put("data", fankuijuanzengView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        FankuijuanzengEntity fankuijuanzeng = fankuijuanzengService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(fankuijuanzeng,deSens);
        return R.ok().put("data", fankuijuanzeng);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        FankuijuanzengEntity fankuijuanzeng = fankuijuanzengService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(fankuijuanzeng,deSens);
        return R.ok().put("data", fankuijuanzeng);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody FankuijuanzengEntity fankuijuanzeng, HttpServletRequest request){
        //ValidatorUtils.validateEntity(fankuijuanzeng);
        fankuijuanzengService.insert(fankuijuanzeng);
        return R.ok().put("data",fankuijuanzeng.getId());
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody FankuijuanzengEntity fankuijuanzeng, HttpServletRequest request){
        //ValidatorUtils.validateEntity(fankuijuanzeng);
        fankuijuanzengService.insert(fankuijuanzeng);
        return R.ok().put("data",fankuijuanzeng.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody FankuijuanzengEntity fankuijuanzeng, HttpServletRequest request){
        //ValidatorUtils.validateEntity(fankuijuanzeng);
        //全部更新
        fankuijuanzengService.updateById(fankuijuanzeng);
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        fankuijuanzengService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    








}
