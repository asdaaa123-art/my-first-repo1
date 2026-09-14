package com.entity.model;

import com.entity.JuanzengjiluEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 捐赠记录
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2025-04-29 17:08:29
 */
public class JuanzengjiluModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
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
	 * 受助者账号
	 */
	
	private String shouzhuzhezhanghao;
		
	/**
	 * 受助者姓名
	 */
	
	private String shouzhuzhexingming;
		
	/**
	 * 捐赠列表
	 */
	
	private String juanzengliebiao;
		
	/**
	 * 捐赠时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date juanzengshijian;
		
	/**
	 * 备注
	 */
	
	private String beizhu;
		
	/**
	 * 捐赠状态
	 */
	
	private String juanzengzhuangtai;
		
	/**
	 * 是否审核
	 */
	
	private String sfsh;
		
	/**
	 * 审核回复
	 */
	
	private String shhf;
				
	
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
	 * 设置：捐赠列表
	 */
	 
	public void setJuanzengliebiao(String juanzengliebiao) {
		this.juanzengliebiao = juanzengliebiao;
	}
	
	/**
	 * 获取：捐赠列表
	 */
	public String getJuanzengliebiao() {
		return juanzengliebiao;
	}
				
	
	/**
	 * 设置：捐赠时间
	 */
	 
	public void setJuanzengshijian(Date juanzengshijian) {
		this.juanzengshijian = juanzengshijian;
	}
	
	/**
	 * 获取：捐赠时间
	 */
	public Date getJuanzengshijian() {
		return juanzengshijian;
	}
				
	
	/**
	 * 设置：备注
	 */
	 
	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}
	
	/**
	 * 获取：备注
	 */
	public String getBeizhu() {
		return beizhu;
	}
				
	
	/**
	 * 设置：捐赠状态
	 */
	 
	public void setJuanzengzhuangtai(String juanzengzhuangtai) {
		this.juanzengzhuangtai = juanzengzhuangtai;
	}
	
	/**
	 * 获取：捐赠状态
	 */
	public String getJuanzengzhuangtai() {
		return juanzengzhuangtai;
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
