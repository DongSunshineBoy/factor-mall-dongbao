package com.mall.generator;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.VelocityTemplateEngine;
import com.baomidou.mybatisplus.generator.fill.Column;
import com.baomidou.mybatisplus.generator.fill.Property;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: wenTaoDong
 * @Date: 2022/3/5 03-05 21:39
 * @Description: com.mall.generator
 * @Version 1.0
 */
public class MallCodeGenerator {

    private  static final String MODULE_ADDRESS = "\\factor-dongbao-common\\src\\main\\resources\\mapper";

    private  static final String MODULE = "\\factor-dongbao-common\\src\\main\\java";

    //这是一个main方法的程序入口
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入表名用,隔开");
        List<String> tables = getTables(scanner.nextLine());

        System.out.println("请输入作者名称:");
        String author = scanner.nextLine();

        System.out.println("请输入数据库的url:");
        String url = scanner.nextLine();

        System.out.println("请输入数据库用户:");
        String username = scanner.nextLine();

        System.out.println("请输入数据库密码:");
        String pwd = scanner.nextLine();


        FastAutoGenerator.create(url, username, pwd)
                .globalConfig(builder -> {
                    builder.author(author)               //作者
                            .outputDir(System.getProperty("user.dir") + MODULE)    //输出路径(写到java目录)
                            .enableSwagger()           //开启swagger
                            .commentDate("yyyy-MM-dd")
                            .fileOverride();            //开启覆盖之前生成的文件

                })
                .strategyConfig(builder -> {
                     builder.addInclude(tables)
                            .mapperBuilder()
                            .superClass(BaseMapper.class)
                            .enableMapperAnnotation()
                            .enableBaseResultMap()
                            .enableBaseColumnList()
                            .formatMapperFileName("%sDao")
                            .formatXmlFileName("%sXml")
                            .build();
                })
                .packageConfig((builder)->{
                     builder.parent("com.dwt")
                            .entity("entity")
                            .service("service")
                            .serviceImpl("service.impl")
                            .mapper("mapper")
                             .controller("controller")
                            .xml("mapper.xml")
                            .controller("com.controller")
                            .other("other")
                            .pathInfo(Collections.singletonMap(OutputFile.xml, System.getProperty("user.dir") +  MODULE_ADDRESS))
                            .build();
                })
                .strategyConfig(builder -> {
                     builder.addInclude(tables).entityBuilder()
                            .enableChainModel()
                            .enableLombok()
                            .enableRemoveIsPrefix()
                            .enableTableFieldAnnotation()
                            .enableActiveRecord()
                            .versionColumnName("version")
                            .versionPropertyName("version")
                            .logicDeleteColumnName("deleted")
                            .logicDeletePropertyName("deleteFlag")
//                            .naming(NamingStrategy.no_change)
//                            .columnNaming(NamingStrategy.underline_to_camel)
                            .addSuperEntityColumns("id", "created_by", "created_time", "updated_by", "updated_time")
                            .addIgnoreColumns("age")
                            .addTableFills(new Column("create_time", FieldFill.INSERT))
                            .addTableFills(new Property("updateTime", FieldFill.INSERT_UPDATE))
                            .idType(IdType.AUTO)
                            .formatFileName("%sEntity")
                            .build();
                })
                .strategyConfig(builder -> {
                     builder.addInclude(tables).controllerBuilder()
                            .enableHyphenStyle()
                            .enableRestStyle()
                            .formatFileName("%sAction")
                            .build();
                })
                .strategyConfig(builder -> {
                    builder.addInclude(tables).serviceBuilder()
                            .superServiceClass(IService.class)
                            .formatServiceFileName("%sService")
                            .formatServiceImplFileName("%sServiceImp")
                            .build();;
                })
                .templateEngine(new VelocityTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }



    // 处理 all 情况
    protected static List<String> getTables(String tables) {
        return "all".equals(tables) ? Collections.emptyList() : Arrays.asList(tables.split(","));
    }
}
