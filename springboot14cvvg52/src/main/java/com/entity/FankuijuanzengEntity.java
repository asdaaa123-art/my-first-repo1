package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 反馈捐赠
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2025-04-29 17:08:29
 */
@TableName("fankuijuanzeng")
public class FankuijuanzengEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public FankuijuanzengEntity() {
		
	}
	
	public FankuijuanzengEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
    @TableId(type = IdType.AUTO)
	private Long id;
	/**
	 * 捐赠编号
	 */
					
	private String juanzengbianhao;
	
	/**
	 * 受助者账号
	 */
					
	private String shouzhuzhezhanghao;
	
	/**
	 * 受助者姓名
	 */
					
	private String shouzhuzhexingming;
	
	/**
	 * 头像
	 */
					
	private String touxiang;
	
	/**
	 * 捐赠者账号
	 */
					
	private String juanzengzhezhanghao;
	
	/**
	 * 捐赠者姓名
	 */
					
	private String juanzengzhexingming;
	
	/**
	 * 收到物品清单
	 */
					
	private String shoudaowupinqingdan;
	
	/**
	 * 感想
	 */
					
	private String ganxiang;
	
	/**
	 * 评价
	 */
					
	private String pingjia;
	
	/**
	 * 发布时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date fabushijian;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：捐赠编号
	 */
	public void setJuanzengbianhao(String juanzengbianhao) {
		this.juanzengbianhao = juanzengbianhao;
	}
	/**
	 * 获取：捐赠编号
	 */
	public String getJuanzengbianhao() {
		return juanzengbianhao;
	}
	/**
	 * 设置：受助者账号
	 */
	public void setShouzhuzhezhanghao(String shouzhuzhezhanghao) {
		this.shouzhuzhezhanghao = shouzhuzhezhanghao;
	}
	/**
	 * 获取：受助者账号
	 */
	public String getShouzhuzhezhanghao() {
		return shouzhuzhezhanghao;
	}
	/**
	 * 设置：受助者姓名
	 */
	public void setShouzhuzhexingming(String shouzhuzhexingming) {
		this.shouzhuzhexingming = shouzhuzhexingming;
	}
	/**
	 * 获取：受助者姓名
	 */
	public String getShouzhuzhexingming() {
		return shouzhuzhexingming;
	}
	/**
	 * 设置：头像
	 */
	public void setTouxiang(String touxiang) {
		this.touxiang = touxiang;
	}
	/**
	 * 获取：头像
	 */
	public String getTouxiang() {
		return touxiang;
	}
	/**
	 * 设置：捐赠者账号
	 */
	public void setJuanzengzhezhanghao(String juanzengzhezhanghao) {
		this.juanzengzhezhanghao = juanzengzhezhanghao;
	}
	/**
	 * 获取：捐赠者账号
	 */
	public String getJuanzengzhezhanghao() {
		return juanzengzhezhanghao;
	}
	/**
	 * 设置：捐赠者姓名
	 */
	public void setJuanzengzhexingming(String juanzengzhexingming) {
		this.juanzengzhexingming = juanzengzhexingming;
	}
	/**
	 * 获取：捐赠者姓名
	 */
	public String getJuanzengzhexingming() {
		return juanzengzhexingming;
	}
	/**
	 * 设置：收到物品清单
	 */
	public void setShoudaowupinqingdan(String shoudaowupinqingdan) {
		this.shoudaowupinqingdan = shoudaowupinqingdan;
	}
	/**
	 * 获取：收到物品清单
	 */
	public String getShoudaowupinqingdan() {
		return shoudaowupinqingdan;
	}
	/**
	 * 设置：感想
	 */
	public void setGanxiang(String ganxiang) {
		this.ganxiang = ganxiang;
	}
	/**
	 * 获取：感想
	 */
	public String getGanxiang() {
		return ganxiang;
	}
	/**
	 * 设置：评价
	 */
	public void setPingjia(String pingjia) {
		this.pingjia = pingjia;
	}
	/**
	 * 获取：评价
	 */
	public String getPingjia() {
		return pingjia;
	}
	/**
	 * 设置：发布时间
	 */
	public void setFabushijian(Date fabushijian) {
		this.fabushijian = fabushijian;
	}
	/**
	 * 获取：发布时间
	 */
	public Date getFabushijian() {
		return fabushijian;
	}

}
