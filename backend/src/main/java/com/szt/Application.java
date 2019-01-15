package com.szt;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

//@ComponentScan(basePackages = {
//        "com.szt.modules.oss",
//   //     "com.szt.modules.swagger",
//        "com.szt.common",
//        "com.szt.config",
//        "com.szt.datasources",
//        "com.szt.modules.bbgl",
//        "com.szt.modules.lpgzh",
//        "com.szt.modules.lppc",
//        "com.szt.modules.lp",
//        "com.szt.modules.sys",
//        "com.szt.modules.test",
//       "com.szt.modules.generator"
//})
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
@EnableAutoConfiguration
@MapperScan("com.szt.modules.*.dao")
@EnableAsync//异步线程池
@Slf4j
public class Application extends WebMvcConfigurerAdapter {

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        super.configureMessageConverters(converters);
        /*
         * 1、需要先定义一个 convert 转换消息对象；
         * 2、添加 fastJson 的配置信息，比如: 是否要格式化返回的Json数据；
         * 3、在 Convert 中添加配置信息;
         * 4、将 convert 添加到 converts 中;
         */
        //1、需要先定义一个 convert 转换消息对象；
        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
        //2、添加 fastJson 的配置信息，比如: 是否要格式化返回的Json数据；
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(
                SerializerFeature.PrettyFormat,
                SerializerFeature.WriteDateUseDateFormat
        );
        //3、在 Convert 中添加配置信息;
        fastConverter.setFastJsonConfig(fastJsonConfig);
        //4、将 convert 添加到 converts 中;
        converters.add(fastConverter);
    }

    public static void main(String[] args) throws UnknownHostException {
        ConfigurableApplicationContext application = SpringApplication.run(Application.class, args);
        Environment env = application.getEnvironment();
//        log.info("\n----------------------------------------------------------\n\t" +
//                        "后台管理系统: \t\thttp://localhost:{}{}/admin/index.html\n\t" +
//                        "接口文档: \thttp://{}:{}{}/doc.html\n" +
//                        "----------------------------------------------------------",
//                env.getProperty("server.port"),
//                env.getProperty("server.context-path"),
//                InetAddress.getLocalHost().getHostAddress(),
//                env.getProperty("server.port"),
//                env.getProperty("server.context-path"),
//                InetAddress.getLocalHost().getHostAddress(),
//                env.getProperty("server.port"),
//                env.getProperty("server.context-path"));
    }


}
