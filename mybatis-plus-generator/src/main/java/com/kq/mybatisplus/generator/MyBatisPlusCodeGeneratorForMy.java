package com.kq.mybatisplus.generator;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kq
 * @date 2022-03-11 8:35
 * @since 2020-0630
 */
public class MyBatisPlusCodeGeneratorForMy {
    /**
     * 包名
     */
    public static final String PACKAGE_NAME = "com.kq";

    /**
     * 工程模块，和数据库模块不同
     */
//    private static final String MODULE_NAME = "digistu-platformmanagement-core";
    private static final String MODULE_NAME = "mybatis-plus-generator-code";
    private static final String DB_TYPE = DbType.MYSQL.getDb();


    public static void main(String[] args) {
        //表名数组 ConfigBuilder 中需要修改，现在是in语句
		/*String[] tables = new String[]{"au_dict", "au_dict_type", "au_language", "au_business_scope",
				"au_application", "au_business_scope_app", "au_app_manager", "au_user_group",
				"au_role", "au_role_resource", "au_resource", "au_role_app", "au_app_tn_user", "au_user_app"
				, "au_user_usable_app_rec"};*/
//        String[] tables = new String[]{"pm_admin","pm_application_category","pm_application","pm_role","pm_application_user_type","pm_app_func","pm_scene","pm_scene_app","pm_scene_func"};

        String[] tables = new String[]{"application"};
        String[] tablePrefixs = new String[]{};
        executeCode(PACKAGE_NAME, tables, tablePrefixs);
    }

    private static void executeCode(String pack, String[] tables, String[] tablePrefixs) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        // 是否覆盖已有文件
        gc.setFileOverride(true);
        // 生成文件的输出目录
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + "/" + MODULE_NAME + "/src/main/java");
        //设置bean命名规范
        gc.setEntityName("%s");
        // 开发人员
        gc.setAuthor("hzsun");
        // 是否打开输出目录
        gc.setOpen(false);
        // 开启 BaseResultMap
        gc.setBaseResultMap(true);
        // 指定生成的主键的ID类型
//        gc.setIdType(IdType.AUTO);
        // 时间类型对应策略: 只使用 java.util.date 代替
        gc.setDateType(DateType.ONLY_DATE);

        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig config = new DataSourceConfig();

        // 172.16.5.148:6006
//        config.setUsername("admin");
//        config.setPassword("26f696b8");
        // 172.16.6.202:3306/mybatis_plus
        String server = "172.16.6.202:3306/mybatis_plus";
        String username = "root";
        String password = "123456";

        if (DbType.MYSQL.getDb().equals(DB_TYPE)) {
            //mysql
            config.setDbType(DbType.MYSQL);
            config.setUrl("jdbc:mysql://"+server+"?allowMultiQueries=true&useUnicode=true" +
                    "&characterEncoding=utf-8&serverTimezone=GMT");
            config.setDriverName("com.mysql.cj.jdbc.Driver");
            config.setUsername(username);
            config.setPassword(password);
        } else if (DbType.ORACLE.getDb().equals(DB_TYPE)) {
            //oracle
            config.setDbType(DbType.ORACLE);
            config.setUrl("jdbc:oracle:thin:@172.16.1.7:1521/ORCLPDB1");
            config.setDriverName("oracle.jdbc.driver.OracleDriver");
            config.setUsername("CMP_UIAS_MANAGER");
            config.setPassword("310012");
        } else {
            return ;
        }
        mpg.setDataSource(config);

        // 包配置
        PackageConfig pc = new PackageConfig();
        // 父包名。如果为空，将下面子包名必须写全部， 否则就只需写子包名
        pc.setParent(pack);
        // Entity包名
        pc.setEntity("entity");
        //模块名称
        pc.setModuleName("");

        pc.setMapper("mapper");

        mpg.setPackageInfo(pc);

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };

        List<FileOutConfig> focList = new ArrayList<>();

        getFcList(focList, projectPath, pc, gc);

        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);
        mpg.setTemplate(new TemplateConfig().setXml(null).setService(null).setServiceImpl(null).setController(null)
                .setEntity(null).setMapper(null));

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        // 数据库表映射到实体的命名策略: 下划线转驼峰命名
        strategy.setNaming(NamingStrategy.underline_to_camel);
        // 数据库表字段映射到实体的命名策略: 下划线转驼峰命名
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        // 【实体】是否为lombok模型（默认 false）
        strategy.setEntityLombokModel(true);
        // 需要包含的表名，允许正则表达式（与exclude二选一配置）
        strategy.setInclude(tables);
        // 驼峰转连字符
        strategy.setControllerMappingHyphenStyle(true);
        // 表前缀
        strategy.setTablePrefix(tablePrefixs);
        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }

    /**
     * 针对模版进行路径处理
     * @param focList
     * @param projectPath
     * @param pc
     * @param gc
     */
    private static void getFcList(List<FileOutConfig> focList, String projectPath, final PackageConfig pc,
                                  GlobalConfig gc) {
        StringBuilder mapperXmlBuilder = new StringBuilder();
        mapperXmlBuilder.append(projectPath).append("/").append(MODULE_NAME).append("/src/main/resources/mapper/")
                .append(DB_TYPE).append("/");
        final String mapperXmlPath = mapperXmlBuilder.toString();

        //拷贝mapper.xml文件路径
        focList.add(new FileOutConfig("/templates/mapper.xml.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输入文件名称
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(mapperXmlPath);
                if (StringUtils.isNotBlank(pc.getModuleName())) {
                    stringBuilder.append(pc.getModuleName()).append("/");
                }
                stringBuilder.append(tableInfo.getXmlName()).append(StringPool.DOT_XML);
                return stringBuilder.toString();
            }
        });

        addJavaFile(focList, pc, gc);
    }

    private static void addJavaFile(List<FileOutConfig> focList, final PackageConfig pc,
                                    GlobalConfig gc) {

        StringBuilder javaBuilder = new StringBuilder();
        javaBuilder.append(gc.getOutputDir()).append("/com/kq/");
        final String javaFilePath = javaBuilder.toString();
        focList.add(new FileOutConfig("/templates/entity.java.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {// 自定义输入文件名称
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(javaFilePath).append(pc.getEntity()).append("/");
                if (StringUtils.isNotBlank(pc.getModuleName())) {
                    stringBuilder.append(pc.getModuleName()).append("/");
                }
                stringBuilder.append(tableInfo.getEntityName()).append(StringPool.DOT_JAVA);
                return stringBuilder.toString();
            }
        });

        focList.add(new FileOutConfig("/templates/mapper.java.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {// 自定义输入文件名称
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(javaFilePath).append(pc.getMapper()).append("/");
                if (StringUtils.isNotBlank(pc.getModuleName())) {
                    stringBuilder.append(pc.getModuleName()).append("/");
                }
                stringBuilder.append(tableInfo.getMapperName()).append(StringPool.DOT_JAVA);
                return stringBuilder.toString();
            }
        });

        focList.add(new FileOutConfig("/templates/service.java.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {// 自定义输入文件名称
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(javaFilePath).append(pc.getService()).append("/");
                if (StringUtils.isNotBlank(pc.getModuleName())) {
                    stringBuilder.append(pc.getModuleName()).append("/");
                }
                stringBuilder.append(tableInfo.getServiceName()).append(StringPool.DOT_JAVA);
                return stringBuilder.toString();
            }
        });

        focList.add(new FileOutConfig("/templates/serviceImpl.java.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {// 自定义输入文件名称
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(javaFilePath).append(pc.getService()).append("/");
                if (StringUtils.isNotBlank(pc.getModuleName())) {
                    stringBuilder.append(pc.getModuleName()).append("/");
                }
                stringBuilder.append("impl/");
                stringBuilder.append(tableInfo.getServiceImplName()).append(StringPool.DOT_JAVA);
                return stringBuilder.toString();
            }
        });

        focList.add(new FileOutConfig("/templates/controller.java.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {// 自定义输入文件名称
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(javaFilePath).append(pc.getController()).append("/");
                if (StringUtils.isNotBlank(pc.getModuleName())) {
                    stringBuilder.append(pc.getModuleName()).append("/");
                }
                stringBuilder.append(tableInfo.getControllerName()).append(StringPool.DOT_JAVA);
                return stringBuilder.toString();
            }
        });
    }
}