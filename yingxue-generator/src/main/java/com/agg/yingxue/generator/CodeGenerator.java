package com.agg.yingxue.generator;

import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.apache.commons.lang3.StringUtils;

import java.util.Scanner;

public class CodeGenerator {
    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://192.168.10.12:3306/yingxue?useUnicode=true&characterEncoding=utf-8&useSSL=false");
        // dsc.setSchemaName("public");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("1111");
        mpg.setDataSource(dsc);

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setAuthor("agg");
        //是否在代码生成后自动打开目录
        gc.setOpen(false);
//        gc.setServiceName("%sService");//去除service接口前的I
        mpg.setGlobalConfig(gc);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.agg.yingxue.generator");
        pc.setEntity("entity");
        pc.setMapper("dao");
        pc.setService("service");
        pc.setServiceImpl("service.impl");
        pc.setController("controller");
        mpg.setPackageInfo(pc);

        // 生成策略配置
        StrategyConfig sc = new StrategyConfig();
        //哪些表进行自动生成,需要用户输入
        sc.setInclude(scanner("表名，多个英文逗号分割").split(","));
        sc.setEntityLombokModel(true);
        //数据库表映射到实体的命名策略
        sc.setNaming(NamingStrategy.underline_to_camel);
        //数据库表字段映射到实体的命名策略
        sc.setColumnNaming(NamingStrategy.underline_to_camel);
        //设置RestController
        sc.setRestControllerStyle(true);
        //设置表的前缀，比如t_person的前缀是t_
        sc.setTablePrefix("t_");
        mpg.setStrategy(sc);
        //开始生成
        mpg.execute();

    }

    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            //MybatisPlus提供的工具类，做非空判断
            if (StringUtils.isNotEmpty(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }
}