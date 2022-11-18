package com.kq.config.mybatis;

/**
 * @author kq
 * @date 2022-11-17 10:41
 * @since 2020-0630
 */
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.kq.exception.BusinessException;
import org.apache.ibatis.reflection.MetaObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

//@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyMetaObjectHandler.class);

    @Autowired
    @Qualifier("oracleJdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    @Override
    public void insertFill(MetaObject metaObject) {
        LOGGER.info("start insert fill ....");
        this.setFieldValByName("version", 0, metaObject);//version 默认为0
        //this.setInsertFieldValByName("operator", "Jerry", metaObject);//@since 快照：3.0.7.2-SNAPSHOT， @since 正式版暂未发布3.0.7
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        LOGGER.info("start update fill ....");
        boolean status = versionCheck(metaObject);
        if(!status){
            throw new BusinessException(500,"数据版本不一致，数据更新失败");
        }
        //this.setFieldValByName("operator", "Tom", metaObject);
        //this.setUpdateFieldValByName("operator", "Tom", metaObject);//@since 快照：3.0.7.2-SNAPSHOT， @since 正式版暂未发布3.0.7
    }


    /**
     * 如果数据实体存在version则更新数据时需要验证versio是否一致
     * @param metaObject
     * @return
     */
    public boolean versionCheck(MetaObject metaObject){
        //如果不存在version 默认返回true
        boolean isVersionEqual = true;
        String fieldName = "version";
        if(metaObject.hasGetter("param1." + fieldName)){
            //获取更新前数据版本（版本未加1之前）
            String oVersionStr  = metaObject.getValue("param1." + fieldName)+"";
            Object id = metaObject.getValue("param1." + "id");
            /**
             * 获取当前数据库中的版本
             */
            Object tableName = metaObject.getValue("param1." + "sysTableName");
            if(tableName == null){
                return false;
            }
            String sql = "select count(1) from " + tableName + " where id = '" + id + "' and version = '" + oVersionStr + "'" ;
            int count = this.jdbcTemplate.queryForObject(sql,Integer.class);
            System.out.println(count);
            if(count < 1 ){
                return false;
            }
        }
        return isVersionEqual;
    }

}