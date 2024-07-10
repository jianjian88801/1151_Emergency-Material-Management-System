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
 * 物资申请
 *
 * @author 
 * @email
 */
@TableName("wuzishenqing")
public class WuzishenqingEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public WuzishenqingEntity() {

	}

	public WuzishenqingEntity(T t) {
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
     * 用户
     */
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 物资
     */
    @TableField(value = "wuzi_id")

    private Integer wuziId;


    /**
     * 申请数量
     */
    @TableField(value = "wuzishenqing_number")

    private Integer wuzishenqingNumber;


    /**
     * 申请详情
     */
    @TableField(value = "wuzishenqing_content")

    private String wuzishenqingContent;


    /**
     * 申请时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 审核
     */
    @TableField(value = "wuzishenqing_yesno_types")

    private Integer wuzishenqingYesnoTypes;


    /**
     * 审核意见
     */
    @TableField(value = "wuzishenqing_yesno_text")

    private String wuzishenqingYesnoText;


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
	 * 设置：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
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
	 * 设置：申请数量
	 */
    public Integer getWuzishenqingNumber() {
        return wuzishenqingNumber;
    }


    /**
	 * 获取：申请数量
	 */

    public void setWuzishenqingNumber(Integer wuzishenqingNumber) {
        this.wuzishenqingNumber = wuzishenqingNumber;
    }
    /**
	 * 设置：申请详情
	 */
    public String getWuzishenqingContent() {
        return wuzishenqingContent;
    }


    /**
	 * 获取：申请详情
	 */

    public void setWuzishenqingContent(String wuzishenqingContent) {
        this.wuzishenqingContent = wuzishenqingContent;
    }
    /**
	 * 设置：申请时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：申请时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：审核
	 */
    public Integer getWuzishenqingYesnoTypes() {
        return wuzishenqingYesnoTypes;
    }


    /**
	 * 获取：审核
	 */

    public void setWuzishenqingYesnoTypes(Integer wuzishenqingYesnoTypes) {
        this.wuzishenqingYesnoTypes = wuzishenqingYesnoTypes;
    }
    /**
	 * 设置：审核意见
	 */
    public String getWuzishenqingYesnoText() {
        return wuzishenqingYesnoText;
    }


    /**
	 * 获取：审核意见
	 */

    public void setWuzishenqingYesnoText(String wuzishenqingYesnoText) {
        this.wuzishenqingYesnoText = wuzishenqingYesnoText;
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
        return "Wuzishenqing{" +
            "id=" + id +
            ", yonghuId=" + yonghuId +
            ", wuziId=" + wuziId +
            ", wuzishenqingNumber=" + wuzishenqingNumber +
            ", wuzishenqingContent=" + wuzishenqingContent +
            ", insertTime=" + insertTime +
            ", wuzishenqingYesnoTypes=" + wuzishenqingYesnoTypes +
            ", wuzishenqingYesnoText=" + wuzishenqingYesnoText +
            ", createTime=" + createTime +
        "}";
    }
}
