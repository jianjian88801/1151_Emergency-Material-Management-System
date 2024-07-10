package com.entity.view;

import com.entity.WuziyunshuEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 物资运输
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("wuziyunshu")
public class WuziyunshuView extends WuziyunshuEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 当前状态的值
		*/
		private String wuziyunshuValue;



		//级联表 wuzi
			/**
			* 物资名称
			*/
			private String wuziName;
			/**
			* 物资照片
			*/
			private String wuziPhoto;
			/**
			* 物资类型
			*/
			private Integer wuziTypes;
				/**
				* 物资类型的值
				*/
				private String wuziValue;
			/**
			* 物资库存
			*/
			private Integer wuziKucunNumber;
			/**
			* 单位
			*/
			private String wuziDanwei;
			/**
			* 逻辑删除
			*/
			private Integer wuziDelete;
			/**
			* 物资介绍
			*/
			private String wuziContent;

	public WuziyunshuView() {

	}

	public WuziyunshuView(WuziyunshuEntity wuziyunshuEntity) {
		try {
			BeanUtils.copyProperties(this, wuziyunshuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 当前状态的值
			*/
			public String getWuziyunshuValue() {
				return wuziyunshuValue;
			}
			/**
			* 设置： 当前状态的值
			*/
			public void setWuziyunshuValue(String wuziyunshuValue) {
				this.wuziyunshuValue = wuziyunshuValue;
			}










				//级联表的get和set wuzi
					/**
					* 获取： 物资名称
					*/
					public String getWuziName() {
						return wuziName;
					}
					/**
					* 设置： 物资名称
					*/
					public void setWuziName(String wuziName) {
						this.wuziName = wuziName;
					}
					/**
					* 获取： 物资照片
					*/
					public String getWuziPhoto() {
						return wuziPhoto;
					}
					/**
					* 设置： 物资照片
					*/
					public void setWuziPhoto(String wuziPhoto) {
						this.wuziPhoto = wuziPhoto;
					}
					/**
					* 获取： 物资类型
					*/
					public Integer getWuziTypes() {
						return wuziTypes;
					}
					/**
					* 设置： 物资类型
					*/
					public void setWuziTypes(Integer wuziTypes) {
						this.wuziTypes = wuziTypes;
					}


						/**
						* 获取： 物资类型的值
						*/
						public String getWuziValue() {
							return wuziValue;
						}
						/**
						* 设置： 物资类型的值
						*/
						public void setWuziValue(String wuziValue) {
							this.wuziValue = wuziValue;
						}
					/**
					* 获取： 物资库存
					*/
					public Integer getWuziKucunNumber() {
						return wuziKucunNumber;
					}
					/**
					* 设置： 物资库存
					*/
					public void setWuziKucunNumber(Integer wuziKucunNumber) {
						this.wuziKucunNumber = wuziKucunNumber;
					}
					/**
					* 获取： 单位
					*/
					public String getWuziDanwei() {
						return wuziDanwei;
					}
					/**
					* 设置： 单位
					*/
					public void setWuziDanwei(String wuziDanwei) {
						this.wuziDanwei = wuziDanwei;
					}
					/**
					* 获取： 逻辑删除
					*/
					public Integer getWuziDelete() {
						return wuziDelete;
					}
					/**
					* 设置： 逻辑删除
					*/
					public void setWuziDelete(Integer wuziDelete) {
						this.wuziDelete = wuziDelete;
					}
					/**
					* 获取： 物资介绍
					*/
					public String getWuziContent() {
						return wuziContent;
					}
					/**
					* 设置： 物资介绍
					*/
					public void setWuziContent(String wuziContent) {
						this.wuziContent = wuziContent;
					}








}
