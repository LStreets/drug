package com.javaclimb.drug.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author laojie
 * @create 2021-04-08 0:46
 */

// 演示例子，执行 main 方法控制台输入模块表名回车自动生成对应项目目录中
public class GeneratorApp {

    public static void main(String[] args) {
        //需要构建一个 代码自动生成器 对象
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();
        //配置策略

        //1、全局配置
        GlobalConfig gc = new GlobalConfig();
        //获取当前项目的路径
        String projectPath = System.getProperty("user.dir");
        //设置生成路径
        gc.setOutputDir(projectPath + "/src/main/java");
        //作者
        gc.setAuthor("LaoJie");
        //生成后是否打开所在文件夹
        gc.setOpen(false);
        //生成setSwagger2注解
        gc.setSwagger2(true);
        //会在mapper.xml生成一个基础的<ResultMap>映射所有的字段
        gc.setBaseResultMap(true);
        //是否覆盖原来生成的
        gc.setFileOverride(false);

        gc.setIdType(IdType.ASSIGN_UUID);
        //只有日期
        gc.setDateType(DateType.ONLY_DATE);

        //直接用表名  %s=表名
        gc.setEntityName("%s");
        gc.setMapperName("%sMapper");
        gc.setXmlName("%sMapper");
        gc.setServiceName("%sService");
        gc.setServiceImplName("%sServiceImpl");
        mpg.setGlobalConfig(gc);


        //2、设置数据源
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://localhost:3306/drug?useSSL=false&useUnicode=true&characterEncoding=UTF-8");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("123456");
        dsc.setDbType(DbType.MYSQL);
        mpg.setDataSource(dsc);

        //3、包的配置
        PackageConfig pc = new PackageConfig();
        //pc.setModuleName("blog");
        pc.setParent("com.javaclimb.drug");
        mpg.setPackageInfo(pc);

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };

        // 如果模板引擎是 velocity
        String templatePath = "/templates/mapper.xml.vm";
        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return projectPath + "/src/main/resources/mapper/" + pc.getModuleName()
                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });

        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);

        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();

        // 把已有的xml生成置空
        templateConfig.setXml(null);
        mpg.setTemplate(templateConfig);



        //4、策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setInclude("bill_info");    //设置要映射的表名
        //表名驼峰
        strategy.setNaming(NamingStrategy.underline_to_camel);
        //列名驼峰
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setEntityLombokModel(true);    //自动lombok
        //逻辑删除
        strategy.setLogicDeleteFieldName("status");
//        //自动填充配置
        TableFill createTime = new TableFill("create_time", FieldFill.INSERT);
        TableFill updateTime = new TableFill("update_time", FieldFill.INSERT_UPDATE);
        ArrayList<TableFill> tableFills = new ArrayList<>();
        tableFills.add(createTime);
        tableFills.add(updateTime);
        strategy.setTableFillList(tableFills);
        //乐观锁
//        strategy.setVersionFieldName("version");
        strategy.setRestControllerStyle(true);
//        strategy.setControllerMappingHyphenStyle(true);     //localhost:8080/hello_id_2
        mpg.setStrategy(strategy);

        mpg.execute();  //执行代码构造器
    }


}

