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
 * 问题反馈
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2025-04-29 17:08:30
 */
@TableName("wentifankui")
public class WentifankuiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public WentifankuiEntity() {
		
	}
	
	public WentifankuiEntity(T t) {
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
	 * 反馈编号
	 */
					
	private String fankuibianhao;
	
	/**
	 * 反馈名称
	 */
					
	private String fankuimingcheng;
	
	/**
	 * 图片
	 */
					
	private String tupian;
	
	/**
	 * 反馈时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date fankuishijian;
	
	/**
	 * 反馈内容
	 */
					
	private String fankuineirong;
	
	/**
	 * 客服账号
	 */
					
	private String kefuzhanghao;
	
	/**
	 * 客服姓名
	 */
					
	private String kefuxingming;
	
	/**
	 * 是否审核
	 */
					
	private String sfsh;
	
	/**
	 * 审核回复
	 */
					
	private String shhf;
	
	
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
	 * 设置：反馈编号
	 */
	public void setFankuibianhao(String fankuibianhao) {
		this.fankuibianhao = fankuibianhao;
	}
	/**
	 * 获取：反馈编号
	 */
	public String getFankuibianhao() {
		return fankuibianhao;
	}
	/**
	 * 设置：反馈名称
	 */
	public void setFankuimingcheng(String fankuimingcheng) {
		this.fankuimingcheng = fankuimingcheng;
	}
	/**
	 * 获取：反馈名称
	 */
	public String getFankuimingcheng() {
		return fankuimingcheng;
	}
	/**
	 * 设置：图片
	 */
	public void setTupian(String tupian) {
		this.tupian = tupian;
	}
	/**
	 * 获取：图片
	 */
	public String getTupian() {
		return tupian;
	}
	/**
	 * 设置：反馈时间
	 */
	public void setFankuishijian(Date fankuishijian) {
		this.fankuishijian = fankuishijian;
	}
	/**
	 * 获取：反馈时间
	 */
	public Date getFankuishijian() {
		return fankuishijian;
	}
	/**
	 * 设置：反馈内容
	 */
	public void setFankuineirong(String fankuineirong) {
		this.fankuineirong = fankuineirong;
	}
	/**
	 * 获取：反馈内容
	 */
	public String getFankuineirong() {
		return fankuineirong;
	}
	/**
	 * 设置：客服账号
	 */
	public void setKefuzhanghao(String kefuzhanghao) {
		this.kefuzhanghao = kefuzhanghao;
	}
	/**
	 * 获取：客服账号
	 */
	public String getKefuzhanghao() {
		return kefuzhanghao;
	}
	/**
	 * 设置：客服姓名
	 */
	public void setKefuxingming(String kefuxingming) {
		this.kefuxingming = kefuxingming;
	}
	/**
	 * 获取：客服姓名
	 */
	public String getKefuxingming() {
		return kefuxingming;
	}
	/**
	 * 设置：是否审核
	 */
	public void setSfsh(String sfsh) {
		this.sfsh = sfsh;
	}
	/**
	 * 获取：是否审核
	 */
	public String getSfsh() {
		return sfsh;
	}
	/**
	 * 设置：审核回复
	 */
	public void setShhf(String shhf) {
		this.shhf = shhf;
	}
	/**
	 * 获取：审核回复
	 */
	public String getShhf() {
		return shhf;
	}

}
