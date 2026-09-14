package com.entity.vo;

import com.entity.JuanzengwupinshenqingEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 捐赠物品申请
 * @author 
 * @email 
 * @date 2025-04-29 17:08:29
 */
public class JuanzengwupinshenqingVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 受助者姓名
	 */
	
	private String shouzhuzhexingming;
		
	/**
	 * 性别
	 */
	
	private String xingbie;
		
	/**
	 * 手机
	 */
	
	private String shouji;
		
	/**
	 * 头像
	 */
	
	private String touxiang;
		
	/**
	 * 申请时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date shenqingshijian;
		
	/**
	 * 所需物资
	 */
	
	private String suoxuwuzi;
		
	/**
	 * 情况说明
	 */
	
	private String qingkuangshuoming;
		
	/**
	 * 收货地址
	 */
	
	private String shouhuodizhi;
		
	/**
	 * 是否审核
	 */
	
	private String sfsh;
		
	/**
	 * 审核回复
	 */
	
	private String shhf;
				
	
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
	 * 设置：性别
	 */
	 
	public void setXingbie(String xingbie) {
		this.xingbie = xingbie;
	}
	
	/**
	 * 获取：性别
	 */
	public String getXingbie() {
		return xingbie;
	}
				
	
	/**
	 * 设置：手机
	 */
	 
	public void setShouji(String shouji) {
		this.shouji = shouji;
	}
	
	/**
	 * 获取：手机
	 */
	public String getShouji() {
		return shouji;
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
	 * 设置：申请时间
	 */
	 
	public void setShenqingshijian(Date shenqingshijian) {
		this.shenqingshijian = shenqingshijian;
	}
	
	/**
	 * 获取：申请时间
	 */
	public Date getShenqingshijian() {
		return shenqingshijian;
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
	 * 设置：情况说明
	 */
	 
	public void setQingkuangshuoming(String qingkuangshuoming) {
		this.qingkuangshuoming = qingkuangshuoming;
	}
	
	/**
	 * 获取：情况说明
	 */
	public String getQingkuangshuoming() {
		return qingkuangshuoming;
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
