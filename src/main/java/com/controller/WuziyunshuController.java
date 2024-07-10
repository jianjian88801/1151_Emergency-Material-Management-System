
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
 * 物资运输
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/wuziyunshu")
public class WuziyunshuController {
    private static final Logger logger = LoggerFactory.getLogger(WuziyunshuController.class);

    @Autowired
    private WuziyunshuService wuziyunshuService;


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
        PageUtils page = wuziyunshuService.queryPage(params);

        //字典表数据转换
        List<WuziyunshuView> list =(List<WuziyunshuView>)page.getList();
        for(WuziyunshuView c:list){
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
        WuziyunshuEntity wuziyunshu = wuziyunshuService.selectById(id);
        if(wuziyunshu !=null){
            //entity转view
            WuziyunshuView view = new WuziyunshuView();
            BeanUtils.copyProperties( wuziyunshu , view );//把实体数据重构到view中

                //级联表
                WuziEntity wuzi = wuziService.selectById(wuziyunshu.getWuziId());
                if(wuzi != null){
                    BeanUtils.copyProperties( wuzi , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setWuziId(wuzi.getId());
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
    public R save(@RequestBody WuziyunshuEntity wuziyunshu, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,wuziyunshu:{}",this.getClass().getName(),wuziyunshu.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");


            wuziyunshu.setUpdateTime(new Date());
            wuziyunshu.setInsertTime(new Date());
            wuziyunshu.setCreateTime(new Date());
            wuziyunshuService.insert(wuziyunshu);
            return R.ok();

    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody WuziyunshuEntity wuziyunshu, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,wuziyunshu:{}",this.getClass().getName(),wuziyunshu.toString());

        wuziyunshu.setUpdateTime(new Date());
            wuziyunshuService.updateById(wuziyunshu);//根据id更新
            return R.ok();
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        wuziyunshuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        try {
            List<WuziyunshuEntity> wuziyunshuList = new ArrayList<>();//上传的东西
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
                            WuziyunshuEntity wuziyunshuEntity = new WuziyunshuEntity();
//                            wuziyunshuEntity.setWuziId(Integer.valueOf(data.get(0)));   //物资 要改的
//                            wuziyunshuEntity.setWuziyunshuUuidNumber(data.get(0));                    //运输唯一编号 要改的
//                            wuziyunshuEntity.setWuziyunshuQuxiang(data.get(0));                    //去向 要改的
//                            wuziyunshuEntity.setWuziyunshuNumber(Integer.valueOf(data.get(0)));   //运输数量 要改的
//                            wuziyunshuEntity.setWuziyunshuContent("");//照片
//                            wuziyunshuEntity.setWuziyunshuTypes(Integer.valueOf(data.get(0)));   //当前状态 要改的
//                            wuziyunshuEntity.setInsertTime(date);//时间
//                            wuziyunshuEntity.setUpdateTime(new Date(data.get(0)));          //最后更新时间 要改的
//                            wuziyunshuEntity.setCreateTime(date);//时间
                            wuziyunshuList.add(wuziyunshuEntity);


                            //把要查询是否重复的字段放入map中
                                //运输唯一编号
                                if(seachFields.containsKey("wuziyunshuUuidNumber")){
                                    List<String> wuziyunshuUuidNumber = seachFields.get("wuziyunshuUuidNumber");
                                    wuziyunshuUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> wuziyunshuUuidNumber = new ArrayList<>();
                                    wuziyunshuUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("wuziyunshuUuidNumber",wuziyunshuUuidNumber);
                                }
                        }

                        //查询是否重复
                         //运输唯一编号
                        List<WuziyunshuEntity> wuziyunshuEntities_wuziyunshuUuidNumber = wuziyunshuService.selectList(new EntityWrapper<WuziyunshuEntity>().in("wuziyunshu_uuid_number", seachFields.get("wuziyunshuUuidNumber")));
                        if(wuziyunshuEntities_wuziyunshuUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(WuziyunshuEntity s:wuziyunshuEntities_wuziyunshuUuidNumber){
                                repeatFields.add(s.getWuziyunshuUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [运输唯一编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        wuziyunshuService.insertBatch(wuziyunshuList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }






}
