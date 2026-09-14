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

import com.entity.JieshoujuanzengEntity;
import com.entity.view.JieshoujuanzengView;

import com.service.JieshoujuanzengService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 接受捐赠
 * 后端接口
 * @author 
 * @email 
 * @date 2025-04-29 17:08:29
 */
@RestController
@RequestMapping("/jieshoujuanzeng")
public class JieshoujuanzengController {
    @Autowired
    private JieshoujuanzengService jieshoujuanzengService;






    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JieshoujuanzengEntity jieshoujuanzeng,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date jieshoushijianstart,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date jieshoushijianend,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("shouzhuzhe")) {
			jieshoujuanzeng.setShouzhuzhezhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("juanzengzhe")) {
			jieshoujuanzeng.setJuanzengzhezhanghao((String)request.getSession().getAttribute("username"));
		}
        //设置查询条件
        EntityWrapper<JieshoujuanzengEntity> ew = new EntityWrapper<JieshoujuanzengEntity>();
        if(jieshoushijianstart!=null) ew.ge("jieshoushijian", jieshoushijianstart);
        if(jieshoushijianend!=null) ew.le("jieshoushijian", jieshoushijianend);


        //查询结果
		PageUtils page = jieshoujuanzengService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jieshoujuanzeng), params), params));
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
    public R list(@RequestParam Map<String, Object> params,JieshoujuanzengEntity jieshoujuanzeng, 
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date jieshoushijianstart,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date jieshoushijianend,
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<JieshoujuanzengEntity> ew = new EntityWrapper<JieshoujuanzengEntity>();
        if(jieshoushijianstart!=null) ew.ge("jieshoushijian", jieshoushijianstart);
        if(jieshoushijianend!=null) ew.le("jieshoushijian", jieshoushijianend);

        //查询结果
		PageUtils page = jieshoujuanzengService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jieshoujuanzeng), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JieshoujuanzengEntity jieshoujuanzeng){
       	EntityWrapper<JieshoujuanzengEntity> ew = new EntityWrapper<JieshoujuanzengEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jieshoujuanzeng, "jieshoujuanzeng")); 
        return R.ok().put("data", jieshoujuanzengService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JieshoujuanzengEntity jieshoujuanzeng){
        EntityWrapper< JieshoujuanzengEntity> ew = new EntityWrapper< JieshoujuanzengEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jieshoujuanzeng, "jieshoujuanzeng")); 
		JieshoujuanzengView jieshoujuanzengView =  jieshoujuanzengService.selectView(ew);
		return R.ok("查询接受捐赠成功").put("data", jieshoujuanzengView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JieshoujuanzengEntity jieshoujuanzeng = jieshoujuanzengService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(jieshoujuanzeng,deSens);
        return R.ok().put("data", jieshoujuanzeng);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JieshoujuanzengEntity jieshoujuanzeng = jieshoujuanzengService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(jieshoujuanzeng,deSens);
        return R.ok().put("data", jieshoujuanzeng);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody JieshoujuanzengEntity jieshoujuanzeng, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jieshoujuanzeng);
        jieshoujuanzengService.insert(jieshoujuanzeng);
        return R.ok().put("data",jieshoujuanzeng.getId());
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody JieshoujuanzengEntity jieshoujuanzeng, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jieshoujuanzeng);
        jieshoujuanzengService.insert(jieshoujuanzeng);
        return R.ok().put("data",jieshoujuanzeng.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody JieshoujuanzengEntity jieshoujuanzeng, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jieshoujuanzeng);
        //全部更新
        jieshoujuanzengService.updateById(jieshoujuanzeng);
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        jieshoujuanzengService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    








}
