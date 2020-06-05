package com.yubuqi;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.HashMap;
import java.util.Map;

public class CodeGenerator {
    // 表名
    static String tableName = "user";
    // 表前缀
    static String tablePrefix = "yu_";
    static String url = "jdbc:mysql://localhost:3306/demo?useUnicode=true&characterEncoding=utf-8&useSSL=true&serverTimezone=UTC";
    // 项目的父包名
    static String projectParent = "soa";
    static String outputDir = "C:\\Users\\DELL\\IdeaProjects";
    static String username = "root";
    static String password = "123";

    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        // String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(outputDir);
        gc.setAuthor("wenhd");
        gc.setOpen(false)
                .setServiceName("%sService") //设置生成的service接口名首字母是否为I
                .setIdType(IdType.AUTO) //主键策略
                .setBaseResultMap(true);
        gc.setSwagger2(true); //实体属性 Swagger2 注解
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl(url);
        // dsc.setSchemaName("public");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername(username);
        dsc.setPassword(password);
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent("timo")//父包名
                .setController(projectParent + ".src.main.java.com.yubuqi.controller")
                .setEntity("model.src.main.java.com.yubuqi.model")
                .setService("dao.src.main.java.com.yubuqi.dao.service")
                .setServiceImpl("dao.src.main.java.com.yubuqi.dao.service.impl")
                .setMapper("dao.src.main.java.com.yubuqi.dao.mapper")
                .setXml("dao.src.main.resources.mapper");
        mpg.setPackageInfo(pc);

  /*    String templatePath = "/templates/mapper.xml.vm";
        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return projectPath + "/src/main/java/model/vo/" + pc.getModuleName()
                        + "/" + tableInfo.getEntityName() + "Vo" + StringPool.DOT_JAVA;
            }
        });*/

        //配置自定义属性注入
        InjectionConfig cfg = new InjectionConfig() {
            //.vm模板中，通过${cfg.abc}获取属性
            @Override
            public void initMap() {
                Map<String, Object> map = new HashMap<>();
                map.put("abc", "自定义属性描述");
                this.setMap(map);
            }
        };
        mpg.setCfg(cfg);

        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();

        // 配置自定义输出模板
        //指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
        //templateConfig.setEntity("templates/entity2.java.vm");
        mpg.setTemplate(templateConfig);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        //  strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
        // 写于父类中的公共字段
        strategy.setSuperEntityColumns("is_deleted", "create_time", "create_user_id", "update_time", "update_user_id");
        strategy.setInclude(tableName); //生成的表
        strategy.setTablePrefix(tablePrefix);
        strategy.setControllerMappingHyphenStyle(true);
        //strategy.setTablePrefix(pc.getModuleName() + "_");
        mpg.setStrategy(strategy);
        mpg.execute();
    }

}
