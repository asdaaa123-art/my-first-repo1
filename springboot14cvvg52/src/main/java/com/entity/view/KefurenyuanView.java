package com.entity.view;

import com.entity.KefurenyuanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 客服人员
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2025-04-29 17:08:29
 */
@TableName("kefurenyuan")
public class KefurenyuanView  extends KefurenyuanEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public KefurenyuanView(){
	}
 
 	public KefurenyuanView(KefurenyuanEntity kefurenyuanEntity){
 	try {
			BeanUtils.copyProperties(this, kefurenyuanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
