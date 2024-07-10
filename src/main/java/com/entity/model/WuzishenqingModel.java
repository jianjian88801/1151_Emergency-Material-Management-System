package com.entity.model;

import com.entity.WuzishenqingEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 物资申请
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class WuzishenqingModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 物资
     */
    private Integer wuziId;


    /**
     * 申请数量
     */
    private Integer wuzishenqingNumber;


    /**
     * 申请详情
     */
    private String wuzishenqingContent;


    /**
     * 申请时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 审核
     */
    private Integer wuzishenqingYesnoTypes;


    /**
     * 审核意见
     */
    private String wuzishenqingYesnoText;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 设置：用户
	 */
    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：物资
	 */
    public Integer getWuziId() {
        return wuziId;
    }


    /**
	 * 设置：物资
	 */
    public void setWuziId(Integer wuziId) {
        this.wuziId = wuziId;
    }
    /**
	 * 获取：申请数量
	 */
    public Integer getWuzishenqingNumber() {
        return wuzishenqingNumber;
    }


    /**
	 * 设置：申请数量
	 */
    public void setWuzishenqingNumber(Integer wuzishenqingNumber) {
        this.wuzishenqingNumber = wuzishenqingNumber;
    }
    /**
	 * 获取：申请详情
	 */
    public String getWuzishenqingContent() {
        return wuzishenqingContent;
    }


    /**
	 * 设置：申请详情
	 */
    public void setWuzishenqingContent(String wuzishenqingContent) {
        this.wuzishenqingContent = wuzishenqingContent;
    }
    /**
	 * 获取：申请时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：申请时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：审核
	 */
    public Integer getWuzishenqingYesnoTypes() {
        return wuzishenqingYesnoTypes;
    }


    /**
	 * 设置：审核
	 */
    public void setWuzishenqingYesnoTypes(Integer wuzishenqingYesnoTypes) {
        this.wuzishenqingYesnoTypes = wuzishenqingYesnoTypes;
    }
    /**
	 * 获取：审核意见
	 */
    public String getWuzishenqingYesnoText() {
        return wuzishenqingYesnoText;
    }


    /**
	 * 设置：审核意见
	 */
    public void setWuzishenqingYesnoText(String wuzishenqingYesnoText) {
        this.wuzishenqingYesnoText = wuzishenqingYesnoText;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
