package com.entity.model;

import com.entity.WuziyunshuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 物资运输
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class WuziyunshuModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 物资
     */
    private Integer wuziId;


    /**
     * 运输唯一编号
     */
    private String wuziyunshuUuidNumber;


    /**
     * 去向
     */
    private String wuziyunshuQuxiang;


    /**
     * 运输数量
     */
    private Integer wuziyunshuNumber;


    /**
     * 运输详情
     */
    private String wuziyunshuContent;


    /**
     * 当前状态
     */
    private Integer wuziyunshuTypes;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 最后更新时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date updateTime;


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
	 * 获取：运输唯一编号
	 */
    public String getWuziyunshuUuidNumber() {
        return wuziyunshuUuidNumber;
    }


    /**
	 * 设置：运输唯一编号
	 */
    public void setWuziyunshuUuidNumber(String wuziyunshuUuidNumber) {
        this.wuziyunshuUuidNumber = wuziyunshuUuidNumber;
    }
    /**
	 * 获取：去向
	 */
    public String getWuziyunshuQuxiang() {
        return wuziyunshuQuxiang;
    }


    /**
	 * 设置：去向
	 */
    public void setWuziyunshuQuxiang(String wuziyunshuQuxiang) {
        this.wuziyunshuQuxiang = wuziyunshuQuxiang;
    }
    /**
	 * 获取：运输数量
	 */
    public Integer getWuziyunshuNumber() {
        return wuziyunshuNumber;
    }


    /**
	 * 设置：运输数量
	 */
    public void setWuziyunshuNumber(Integer wuziyunshuNumber) {
        this.wuziyunshuNumber = wuziyunshuNumber;
    }
    /**
	 * 获取：运输详情
	 */
    public String getWuziyunshuContent() {
        return wuziyunshuContent;
    }


    /**
	 * 设置：运输详情
	 */
    public void setWuziyunshuContent(String wuziyunshuContent) {
        this.wuziyunshuContent = wuziyunshuContent;
    }
    /**
	 * 获取：当前状态
	 */
    public Integer getWuziyunshuTypes() {
        return wuziyunshuTypes;
    }


    /**
	 * 设置：当前状态
	 */
    public void setWuziyunshuTypes(Integer wuziyunshuTypes) {
        this.wuziyunshuTypes = wuziyunshuTypes;
    }
    /**
	 * 获取：添加时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：添加时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：最后更新时间
	 */
    public Date getUpdateTime() {
        return updateTime;
    }


    /**
	 * 设置：最后更新时间
	 */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
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
