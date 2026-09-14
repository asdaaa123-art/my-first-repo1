package com.entity.view;

import com.entity.JieshoujuanzengEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 接受捐赠
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2025-04-29 17:08:29
 */
@TableName("jieshoujuanzeng")
public class JieshoujuanzengView  extends JieshoujuanzengEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public JieshoujuanzengView(){
	}
 
 	public JieshoujuanzengView(JieshoujuanzengEntity jieshoujuanzengEntity){
 	try {
			BeanUtils.copyProperties(this, jieshoujuanzengEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
