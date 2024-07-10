
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 物资申请
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/wuzishenqing")
public class WuzishenqingController {
    private static final Logger logger = LoggerFactory.getLogger(WuzishenqingController.class);

    @Autowired
    private WuzishenqingService wuzishenqingService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
    @Autowired
    private WuziService wuziService;
    @Autowired
    private YonghuService yonghuService;



    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = wuzishenqingService.queryPage(params);

        //字典表数据转换
        List<WuzishenqingView> list =(List<WuzishenqingView>)page.getList();
        for(WuzishenqingView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        WuzishenqingEntity wuzishenqing = wuzishenqingService.selectById(id);
        if(wuzishenqing !=null){
            //entity转view
            WuzishenqingView view = new WuzishenqingView();
            BeanUtils.copyProperties( wuzishenqing , view );//把实体数据重构到view中

                //级联表
                WuziEntity wuzi = wuziService.selectById(wuzishenqing.getWuziId());
                if(wuzi != null){
                    BeanUtils.copyProperties( wuzi , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setWuziId(wuzi.getId());
                }
                //级联表
                YonghuEntity yonghu = yonghuService.selectById(wuzishenqing.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody WuzishenqingEntity wuzishenqing, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,wuzishenqing:{}",this.getClass().getName(),wuzishenqing.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            wuzishenqing.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));


            wuzishenqing.setInsertTime(new Date());
            wuzishenqing.setWuzishenqingYesnoTypes(1);
            wuzishenqing.setCreateTime(new Date());
            wuzishenqingService.insert(wuzishenqing);
            return R.ok();

    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody WuzishenqingEntity wuzishenqing, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,wuzishenqing:{}",this.getClass().getName(),wuzishenqing.toString());

            wuzishenqingService.updateById(wuzishenqing);//根据id更新
            return R.ok();

    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        wuzishenqingService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        try {
            List<WuzishenqingEntity> wuzishenqingList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            WuzishenqingEntity wuzishenqingEntity = new WuzishenqingEntity();
//                            wuzishenqingEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            wuzishenqingEntity.setWuziId(Integer.valueOf(data.get(0)));   //物资 要改的
//                            wuzishenqingEntity.setWuzishenqingNumber(Integer.valueOf(data.get(0)));   //申请数量 要改的
//                            wuzishenqingEntity.setWuzishenqingContent("");//照片
//                            wuzishenqingEntity.setInsertTime(date);//时间
//                            wuzishenqingEntity.setWuzishenqingYesnoTypes(Integer.valueOf(data.get(0)));   //审核 要改的
//                            wuzishenqingEntity.setWuzishenqingYesnoText(data.get(0));                    //审核意见 要改的
//                            wuzishenqingEntity.setCreateTime(date);//时间
                            wuzishenqingList.add(wuzishenqingEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        wuzishenqingService.insertBatch(wuzishenqingList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }






}
