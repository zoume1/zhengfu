package com.szt.datasources.aspect;


import com.szt.datasources.DataSourceNames;
import com.szt.datasources.DynamicDataSource;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 多数据源切面处理类
 * zl 2018-06-02
 */
@Aspect
@Component
public class SourceClassAspect {

    /**
     * 使用空方法定义切点表达式
     */
    @Pointcut("execution(* com.szt.modules.*.dao.*.*(..))")
    public void declareJointPointExpression() {
    }

    /**
     * 使用定义切点表达式的方法进行切点表达式的引入
     */
    @Before("declareJointPointExpression()")
    public void setDataSourceKey(JoinPoint point) {
        // 连接点所属的类实例是ShopDao
//        if (point.getTarget() instanceof ElwlManufacturersDao) {
//            DynamicDataSource.setDataSource(DataSourceNames.FIRST);/**对应数据源名称*/
//        } else {// 连接点所属的类实例是UserDao（当然，这一步也可以不写，因为defaultTargertDataSource就是该类所用的FIRST）
            DynamicDataSource.setDataSource(DataSourceNames.FIRST);
 //       }
    }

}
