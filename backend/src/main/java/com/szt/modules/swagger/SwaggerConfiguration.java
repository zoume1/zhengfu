package com.szt.modules.swagger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
    @Value("${server.context-path}")
    private String serviceName;
    @Value("${server.port}")
    private String port;
    @Bean(value = "defaultApi")
    public Docket defaultApi() throws UnknownHostException {
        List<ResponseMessage> responseMessageList = new ArrayList<>();
        responseMessageList.add(new ResponseMessageBuilder().code(0).message("正常").responseModel(new ModelRef("ApiError")).build());
        responseMessageList.add(new ResponseMessageBuilder().code(1).message("业务异常").responseModel(new ModelRef("ApiError")).build());
        responseMessageList.add(new ResponseMessageBuilder().code(500).message("系统异常").responseModel(new ModelRef("ApiError")).build());
        return new Docket(DocumentationType.SWAGGER_2)
                .globalResponseMessage(RequestMethod.GET, responseMessageList)
                .globalResponseMessage(RequestMethod.POST, responseMessageList)
                .globalResponseMessage(RequestMethod.PUT, responseMessageList)
                .globalResponseMessage(RequestMethod.DELETE, responseMessageList)
                .apiInfo(new ApiInfoBuilder()
                        .title("官网api接口")
                        .description("官网api接口")
                        .termsOfServiceUrl("http://"+InetAddress.getLocalHost().getHostAddress()+":"+port+"/lp/"+serviceName+"/lppc")
                        .contact("group@qq.com")
                        .version("1.0")
                        .build())
                .groupName("官网api接口")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.szt.modules.lppc.controller"))
                .paths(PathSelectors.any())
                .build();
    }
    @Bean(value = "groupRestApi")
    public Docket groupRestApi() throws UnknownHostException {
        List<ResponseMessage> responseMessageList = new ArrayList<>();
        responseMessageList.add(new ResponseMessageBuilder().code(0).message("正常").responseModel(new ModelRef("ApiError")).build());
        responseMessageList.add(new ResponseMessageBuilder().code(1).message("业务异常").responseModel(new ModelRef("ApiError")).build());
        responseMessageList.add(new ResponseMessageBuilder().code(500).message("系统异常").responseModel(new ModelRef("ApiError")).build());
        return new Docket(DocumentationType.SWAGGER_2)
                .globalResponseMessage(RequestMethod.GET, responseMessageList)
                .globalResponseMessage(RequestMethod.POST, responseMessageList)
                .globalResponseMessage(RequestMethod.PUT, responseMessageList)
                .globalResponseMessage(RequestMethod.DELETE, responseMessageList)
                .apiInfo(new ApiInfoBuilder()
                        .title("lp公众号api")
                        .description("swagger-bootstrap-ui-demo RESTful APIs")
                        .termsOfServiceUrl("http://"+InetAddress.getLocalHost().getHostAddress()+":"+port+"/lp/"+serviceName+"/lpgzh")
                        .contact("group@qq.com")
                        .version("1.0")
                        .build())
                .groupName("lp公众号api")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.szt.modules.lpgzh.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    @Bean(value = "groupRestApi1")
    public Docket groupRestApi1() throws UnknownHostException {
        List<ResponseMessage> responseMessageList = new ArrayList<>();
        responseMessageList.add(new ResponseMessageBuilder().code(0).message("正常").responseModel(new ModelRef("ApiError")).build());
        responseMessageList.add(new ResponseMessageBuilder().code(1).message("业务异常").responseModel(new ModelRef("ApiError")).build());
        responseMessageList.add(new ResponseMessageBuilder().code(500).message("系统异常").responseModel(new ModelRef("ApiError")).build());
        return new Docket(DocumentationType.SWAGGER_2)
                .globalResponseMessage(RequestMethod.GET, responseMessageList)
                .globalResponseMessage(RequestMethod.POST, responseMessageList)
                .globalResponseMessage(RequestMethod.PUT, responseMessageList)
                .globalResponseMessage(RequestMethod.DELETE, responseMessageList)
                .apiInfo(new ApiInfoBuilder()
                        .title("系统字典api")
                        .description("swagger-bootstrap-ui-demo RESTful APIs")
                        .termsOfServiceUrl("http://"+InetAddress.getLocalHost().getHostAddress()+":"+port+"/lp/"+serviceName+"/sys")
                        .contact("group@qq.com")
                        .version("1.0")
                        .build())
                .groupName("系统字典api")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.szt.modules.generator.controller"))
                .paths(PathSelectors.any())
                .build();
    }

}