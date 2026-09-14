package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.*;
import java.lang.*;
import java.math.*;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import com.entity.TokenEntity;
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

import com.entity.KefurenyuanEntity;
import com.entity.view.KefurenyuanView;

import com.service.KefurenyuanService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 客服人员
 * 后端接口
 * @author 
 * @email 
 * @date 2025-04-29 17:08:29
 */
@RestController
@RequestMapping("/kefurenyuan")
public class KefurenyuanController {
    @Autowired
    private KefurenyuanService kefurenyuanService;






    
	@Autowired
	private TokenService tokenService;
	
	/**
	 * 登录
	 */
	@IgnoreAuth
	@RequestMapping(value = "/login")
	public R login(String username, String password, String captcha, HttpServletRequest request) {
		// 根据登录查询用户信息
        KefurenyuanEntity u = kefurenyuanService.selectOne(new EntityWrapper<KefurenyuanEntity>().eq("kefuzhanghao", username));
        // 当用户不存在或验证密码不通过时
		if(u==null || !u.getMima().equals(password)) {
            //账号或密码不正确提示
			return R.error("账号或密码不正确");
		}
		
        // 获取登录token
		String token = tokenService.generateToken(u.getId(), username,"kefurenyuan",  "管理员" );
        //返回token
		return R.ok().put("token", token);
	}


	
	/**
     * 注册
     */
	@IgnoreAuth
    @RequestMapping("/register")
    public R register(@RequestBody KefurenyuanEntity kefurenyuan){
    	//ValidatorUtils.validateEntity(kefurenyuan);
        //根据登录账号获取用户信息判断是否存在该用户，否则返回错误信息
    	KefurenyuanEntity u = kefurenyuanService.selectOne(new EntityWrapper<KefurenyuanEntity>().eq("kefuzhanghao", kefurenyuan.getKefuzhanghao()));
		if(u!=null) {
			return R.error("注册用户已存在");
		}
        //判断是否存在相同客服账号，否则返回错误信息
        if(kefurenyuanService.selectCount(new EntityWrapper<KefurenyuanEntity>().eq("kefuzhanghao", kefurenyuan.getKefuzhanghao()))>0) {
            return R.error("客服账号已存在");
        }
		Long uId = new Date().getTime();
		kefurenyuan.setId(uId);
        //保存用户
        kefurenyuanService.insert(kefurenyuan);
        return R.ok();
    }

	
	/**
	 * 退出
	 */
	@RequestMapping("/logout")
	public R logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return R.ok("退出成功");
	}
	
	/**
     * 获取用户的session用户信息
     */
    @RequestMapping("/session")
    public R getCurrUser(HttpServletRequest request){
    	Long id = (Long)request.getSession().getAttribute("userId");
        KefurenyuanEntity u = kefurenyuanService.selectById(id);
        return R.ok().put("data", u);
    }
    
    /**
     * 密码重置
     */
    @IgnoreAuth
	@RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request){
    	//根据登录账号判断是否存在用户信息，否则返回错误信息
        KefurenyuanEntity u = kefurenyuanService.selectOne(new EntityWrapper<KefurenyuanEntity>().eq("kefuzhanghao", username));
    	if(u==null) {
    		return R.error("账号不存在");
    	}
        //重置密码为123456
        u.setMima("123456");
        kefurenyuanService.updateById(u);
        return R.ok("密码已重置为：123456");
    }



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,KefurenyuanEntity kefurenyuan,
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<KefurenyuanEntity> ew = new EntityWrapper<KefurenyuanEntity>();


        //查询结果
		PageUtils page = kefurenyuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, kefurenyuan), params), params));
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
    public R list(@RequestParam Map<String, Object> params,KefurenyuanEntity kefurenyuan, 
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<KefurenyuanEntity> ew = new EntityWrapper<KefurenyuanEntity>();

        //查询结果
		PageUtils page = kefurenyuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, kefurenyuan), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( KefurenyuanEntity kefurenyuan){
       	EntityWrapper<KefurenyuanEntity> ew = new EntityWrapper<KefurenyuanEntity>();
      	ew.allEq(MPUtil.allEQMapPre( kefurenyuan, "kefurenyuan")); 
        return R.ok().put("data", kefurenyuanService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(KefurenyuanEntity kefurenyuan){
        EntityWrapper< KefurenyuanEntity> ew = new EntityWrapper< KefurenyuanEntity>();
 		ew.allEq(MPUtil.allEQMapPre( kefurenyuan, "kefurenyuan")); 
		KefurenyuanView kefurenyuanView =  kefurenyuanService.selectView(ew);
		return R.ok("查询客服人员成功").put("data", kefurenyuanView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        KefurenyuanEntity kefurenyuan = kefurenyuanService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(kefurenyuan,deSens);
        return R.ok().put("data", kefurenyuan);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        KefurenyuanEntity kefurenyuan = kefurenyuanService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(kefurenyuan,deSens);
        return R.ok().put("data", kefurenyuan);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody KefurenyuanEntity kefurenyuan, HttpServletRequest request){
        //验证字段唯一性，否则返回错误信息
        if(kefurenyuanService.selectCount(new EntityWrapper<KefurenyuanEntity>().eq("kefuzhanghao", kefurenyuan.getKefuzhanghao()))>0) {
            return R.error("客服账号已存在");
        }
        //ValidatorUtils.validateEntity(kefurenyuan);
        //验证账号唯一性，否则返回错误信息
        KefurenyuanEntity u = kefurenyuanService.selectOne(new EntityWrapper<KefurenyuanEntity>().eq("kefuzhanghao", kefurenyuan.getKefuzhanghao()));
        if(u!=null) {
            return R.error("用户已存在");
        }
    	kefurenyuan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
		kefurenyuan.setId(new Date().getTime());
        kefurenyuanService.insert(kefurenyuan);
        return R.ok().put("data",kefurenyuan.getId());
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody KefurenyuanEntity kefurenyuan, HttpServletRequest request){
        //验证字段唯一性，否则返回错误信息
        if(kefurenyuanService.selectCount(new EntityWrapper<KefurenyuanEntity>().eq("kefuzhanghao", kefurenyuan.getKefuzhanghao()))>0) {
            return R.error("客服账号已存在");
        }
        //ValidatorUtils.validateEntity(kefurenyuan);
        //验证账号唯一性，否则返回错误信息
        KefurenyuanEntity u = kefurenyuanService.selectOne(new EntityWrapper<KefurenyuanEntity>().eq("kefuzhanghao", kefurenyuan.getKefuzhanghao()));
        if(u!=null) {
            return R.error("用户已存在");
        }
    	kefurenyuan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
		kefurenyuan.setId(new Date().getTime());
        kefurenyuanService.insert(kefurenyuan);
        return R.ok().put("data",kefurenyuan.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody KefurenyuanEntity kefurenyuan, HttpServletRequest request){
        //ValidatorUtils.validateEntity(kefurenyuan);
        //验证字段唯一性，否则返回错误信息
        if(kefurenyuanService.selectCount(new EntityWrapper<KefurenyuanEntity>().ne("id", kefurenyuan.getId()).eq("kefuzhanghao", kefurenyuan.getKefuzhanghao()))>0) {
            return R.error("客服账号已存在");
        }
        //全部更新
        kefurenyuanService.updateById(kefurenyuan);
        if(null!=kefurenyuan.getKefuzhanghao())
        {
            // 修改token
            TokenEntity tokenEntity = new TokenEntity();
            tokenEntity.setUsername(kefurenyuan.getKefuzhanghao());
            tokenService.update(tokenEntity, new EntityWrapper<TokenEntity>().eq("userid", kefurenyuan.getId()));
        }
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        kefurenyuanService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    







    /**
     * 总数量
     */
    @RequestMapping("/count")
    public R count(@RequestParam Map<String, Object> params,KefurenyuanEntity kefurenyuan, HttpServletRequest request){
        EntityWrapper<KefurenyuanEntity> ew = new EntityWrapper<KefurenyuanEntity>();
        int count = kefurenyuanService.selectCount(MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, kefurenyuan), params), params));
        return R.ok().put("data", count);
    }

}
