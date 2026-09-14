package com.entity.view;

import com.entity.DiscussgongyihuodongEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 公益活动评论表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2025-04-29 17:08:31
 */
@TableName("discussgongyihuodong")
public class DiscussgongyihuodongView  extends DiscussgongyihuodongEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscussgongyihuodongView(){
	}
 
 	public DiscussgongyihuodongView(DiscussgongyihuodongEntity discussgongyihuodongEntity){
 	try {
			BeanUtils.copyProperties(this, discussgongyihuodongEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
