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
 * 物资运输
 *
 * @author 
 * @email
 */
@TableName("wuziyunshu")
public class WuziyunshuEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public WuziyunshuEntity() {

	}

	public WuziyunshuEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @TableField(value = "id")

    private Integer id;


    /**
     * 物资
     */
    @TableField(value = "wuzi_id")

    private Integer wuziId;


    /**
     * 运输唯一编号
     */
    @TableField(value = "wuziyunshu_uuid_number")

    private String wuziyunshuUuidNumber;


    /**
     * 去向
     */
    @TableField(value = "wuziyunshu_quxiang")

    private String wuziyunshuQuxiang;


    /**
     * 运输数量
     */
    @TableField(value = "wuziyunshu_number")

    private Integer wuziyunshuNumber;


    /**
     * 运输详情
     */
    @TableField(value = "wuziyunshu_content")

    private String wuziyunshuContent;


    /**
     * 当前状态
     */
    @TableField(value = "wuziyunshu_types")

    private Integer wuziyunshuTypes;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 最后更新时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "update_time",fill = FieldFill.UPDATE)

    private Date updateTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：物资
	 */
    public Integer getWuziId() {
        return wuziId;
    }


    /**
	 * 获取：物资
	 */

    public void setWuziId(Integer wuziId) {
        this.wuziId = wuziId;
    }
    /**
	 * 设置：运输唯一编号
	 */
    public String getWuziyunshuUuidNumber() {
        return wuziyunshuUuidNumber;
    }


    /**
	 * 获取：运输唯一编号
	 */

    public void setWuziyunshuUuidNumber(String wuziyunshuUuidNumber) {
        this.wuziyunshuUuidNumber = wuziyunshuUuidNumber;
    }
    /**
	 * 设置：去向
	 */
    public String getWuziyunshuQuxiang() {
        return wuziyunshuQuxiang;
    }


    /**
	 * 获取：去向
	 */

    public void setWuziyunshuQuxiang(String wuziyunshuQuxiang) {
        this.wuziyunshuQuxiang = wuziyunshuQuxiang;
    }
    /**
	 * 设置：运输数量
	 */
    public Integer getWuziyunshuNumber() {
        return wuziyunshuNumber;
    }


    /**
	 * 获取：运输数量
	 */

    public void setWuziyunshuNumber(Integer wuziyunshuNumber) {
        this.wuziyunshuNumber = wuziyunshuNumber;
    }
    /**
	 * 设置：运输详情
	 */
    public String getWuziyunshuContent() {
        return wuziyunshuContent;
    }


    /**
	 * 获取：运输详情
	 */

    public void setWuziyunshuContent(String wuziyunshuContent) {
        this.wuziyunshuContent = wuziyunshuContent;
    }
    /**
	 * 设置：当前状态
	 */
    public Integer getWuziyunshuTypes() {
        return wuziyunshuTypes;
    }


    /**
	 * 获取：当前状态
	 */

    public void setWuziyunshuTypes(Integer wuziyunshuTypes) {
        this.wuziyunshuTypes = wuziyunshuTypes;
    }
    /**
	 * 设置：添加时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：添加时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：最后更新时间
	 */
    public Date getUpdateTime() {
        return updateTime;
    }


    /**
	 * 获取：最后更新时间
	 */

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Wuziyunshu{" +
            "id=" + id +
            ", wuziId=" + wuziId +
            ", wuziyunshuUuidNumber=" + wuziyunshuUuidNumber +
            ", wuziyunshuQuxiang=" + wuziyunshuQuxiang +
            ", wuziyunshuNumber=" + wuziyunshuNumber +
            ", wuziyunshuContent=" + wuziyunshuContent +
            ", wuziyunshuTypes=" + wuziyunshuTypes +
            ", insertTime=" + insertTime +
            ", updateTime=" + updateTime +
            ", createTime=" + createTime +
        "}";
    }
}
