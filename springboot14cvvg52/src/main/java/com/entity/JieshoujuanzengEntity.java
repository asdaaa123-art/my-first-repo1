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
 * 接受捐赠
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2025-04-29 17:08:29
 */
@TableName("jieshoujuanzeng")
public class JieshoujuanzengEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public JieshoujuanzengEntity() {
		
	}
	
	public JieshoujuanzengEntity(T t) {
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
	 * 所需物资
	 */
					
	private String suoxuwuzi;
	
	/**
	 * 收货地址
	 */
					
	private String shouhuodizhi;
	
	/**
	 * 捐赠者账号
	 */
					
	private String juanzengzhezhanghao;
	
	/**
	 * 捐赠者姓名
	 */
					
	private String juanzengzhexingming;
	
	/**
	 * 捐赠照片
	 */
					
	private String juanzengzhaopian;
	
	/**
	 * 捐赠时间
	 */
					
	private String juanzengshijian;
	
	/**
	 * 收到物品清单
	 */
					
	private String shoudaowupinqingdan;
	
	/**
	 * 接收时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date jieshoushijian;
	
	
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
	 * 设置：所需物资
	 */
	public void setSuoxuwuzi(String suoxuwuzi) {
		this.suoxuwuzi = suoxuwuzi;
	}
	/**
	 * 获取：所需物资
	 */
	public String getSuoxuwuzi() {
		return suoxuwuzi;
	}
	/**
	 * 设置：收货地址
	 */
	public void setShouhuodizhi(String shouhuodizhi) {
		this.shouhuodizhi = shouhuodizhi;
	}
	/**
	 * 获取：收货地址
	 */
	public String getShouhuodizhi() {
		return shouhuodizhi;
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
	 * 设置：捐赠照片
	 */
	public void setJuanzengzhaopian(String juanzengzhaopian) {
		this.juanzengzhaopian = juanzengzhaopian;
	}
	/**
	 * 获取：捐赠照片
	 */
	public String getJuanzengzhaopian() {
		return juanzengzhaopian;
	}
	/**
	 * 设置：捐赠时间
	 */
	public void setJuanzengshijian(String juanzengshijian) {
		this.juanzengshijian = juanzengshijian;
	}
	/**
	 * 获取：捐赠时间
	 */
	public String getJuanzengshijian() {
		return juanzengshijian;
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
	 * 设置：接收时间
	 */
	public void setJieshoushijian(Date jieshoushijian) {
		this.jieshoushijian = jieshoushijian;
	}
	/**
	 * 获取：接收时间
	 */
	public Date getJieshoushijian() {
		return jieshoushijian;
	}

}
