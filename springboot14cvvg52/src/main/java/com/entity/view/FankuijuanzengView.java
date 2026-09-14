package com.entity.view;

import com.entity.FankuijuanzengEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 反馈捐赠
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2025-04-29 17:08:29
 */
@TableName("fankuijuanzeng")
public class FankuijuanzengView  extends FankuijuanzengEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public FankuijuanzengView(){
	}
 
 	public FankuijuanzengView(FankuijuanzengEntity fankuijuanzengEntity){
 	try {
			BeanUtils.copyProperties(this, fankuijuanzengEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
