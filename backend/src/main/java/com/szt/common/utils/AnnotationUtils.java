package com.szt.common.utils;

import javassist.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.javassist.ClassPool;
import org.apache.ibatis.javassist.CtClass;
import org.apache.ibatis.javassist.CtMethod;
import org.apache.ibatis.javassist.bytecode.AnnotationsAttribute;
import org.apache.ibatis.javassist.bytecode.ConstPool;
import org.apache.ibatis.javassist.bytecode.MethodInfo;
import org.apache.ibatis.javassist.bytecode.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

/**
 * 注解工具类
 * Created by 陈梓平 on 2017/9/11.
 */
@Slf4j
public class AnnotationUtils {

    private static AnnotationUtils mInstance;

    public AnnotationUtils() {
    }

    public static AnnotationUtils get() {
        if (mInstance == null) {
            synchronized (AnnotationUtils.class) {
                if (mInstance == null) {
                    mInstance = new AnnotationUtils();
                }
            }
        }
        return mInstance;
    }

    /**
     * 获取注解属性值信息
     * @param className 类名
     * @param methodName 方法名
     * @param annotationClass 注解类
     * @param attrName 注解属性名
     * @throws NotFoundException
     */
    public static Object getAnnotationAttr(String className,String methodName,Class<?> annotationClass,String attrName) throws NotFoundException, NoSuchMethodException, org.apache.ibatis.javassist.NotFoundException {

        Object value = null;
        if (StringUtils.isBlank(className))
            return value;
        if (StringUtils.isBlank(methodName))
            return value;
        if (annotationClass==null)
            return value;
        if (StringUtils.isBlank(attrName))
            return value;

        ClassPool pool = ClassPool.getDefault();
        //获取要修改的类的所有信息
        CtClass ct = pool.get(className);
        CtMethod ctMethod = ct.getDeclaredMethod(methodName);
        MethodInfo methodInfo = ctMethod.getMethodInfo();
        //获取注解属性
        AnnotationsAttribute attribute = (AnnotationsAttribute) methodInfo.getAttribute(AnnotationsAttribute.visibleTag);

        String annotationName = annotationClass.getName();
        Method operationType = annotationClass.getDeclaredMethod(attrName);
        Class<?> returnType = operationType.getReturnType();

        if (attribute!=null){
            //获取注解
            Annotation annotation = attribute.getAnnotation(annotationName);
            if (annotation!=null){
                //获取注解的值
                if (int.class.isAssignableFrom(returnType)){
                    IntegerMemberValue memberValue = (IntegerMemberValue) annotation.getMemberValue(attrName);
                    if (memberValue!=null)
                        value =  memberValue.getValue() ;
                }
                if (String.class.isAssignableFrom(returnType)){
                    StringMemberValue memberValue = (StringMemberValue) annotation.getMemberValue(attrName);
                    if (memberValue!=null)
                        value = memberValue .getValue() ;
                }
                if (boolean.class.isAssignableFrom(returnType)){
                    BooleanMemberValue memberValue = (BooleanMemberValue) annotation.getMemberValue(attrName);
                    if (memberValue!=null)
                         value = memberValue.getValue() ;
                }
                if (String[].class.isAssignableFrom(returnType)){
                    ArrayMemberValue memberValue = (ArrayMemberValue) annotation.getMemberValue(attrName);
                    if (memberValue!=null){
                        MemberValue[] strValueArray = memberValue.getValue();
                        String[] strValueA = new String[strValueArray.length];
                        for (int i = 0;i<strValueArray.length;i++){
                            StringMemberValue  stringMemberValue = (StringMemberValue) strValueArray[i];
                            strValueA[i] = stringMemberValue.getValue();
                        }
                        value = strValueA;
                    }
                }
            }
        }
        return value;
    }

    /**
     * 修改注解属性
     * @param className 类名
     * @param methodName 方法名
     * @param annotationClass 注解名
     * @param attrName 属性名
     * @param value 修改值
     * @throws NotFoundException
     */
    public static boolean updateAnnotationAttr(String className,String methodName,Class<?> annotationClass,String attrName,Object value) throws NotFoundException, NoSuchMethodException, org.apache.ibatis.javassist.NotFoundException {
        if (StringUtils.isBlank(className))
            return false;
        if (StringUtils.isBlank(methodName))
            return false;
        if (annotationClass==null)
            return false;
        if (StringUtils.isBlank(attrName))
            return false;
        if (value==null)
            return false;
        ClassPool pool = ClassPool.getDefault();
        //获取需要修改的类
        CtClass ct = pool.get(className);
        CtMethod minInfo = ct.getDeclaredMethod(methodName);
        MethodInfo methodInfo = minInfo.getMethodInfo();

        ConstPool cp = methodInfo.getConstPool();
        AnnotationsAttribute attribute = new AnnotationsAttribute(cp, AnnotationsAttribute.visibleTag);

        String annotationName = annotationClass.getName();
        Method operationType = annotationClass.getDeclaredMethod(attrName);
        Class<?> returnType = operationType.getReturnType();
        Annotation annotation = new Annotation(annotationName, cp);
        //修改名称为unitName的注解
        if (annotation != null) {

            if (String.class.isAssignableFrom(returnType))
                annotation.addMemberValue(attrName, new StringMemberValue((String) value, cp));
            else if (int.class.isAssignableFrom(returnType))
                annotation.addMemberValue(attrName, new IntegerMemberValue(cp,(Integer)value));
            else if (boolean.class.isAssignableFrom(returnType))
                annotation.addMemberValue(attrName, new BooleanMemberValue((boolean) value, cp));
            else if (String[].class.isAssignableFrom(returnType)){
                String[] stres = (String[])value;
                StringMemberValue[] elements = new StringMemberValue[stres.length];
                for(int i=0;i<stres.length;i++)
                    elements[i] = new StringMemberValue(stres[i],cp);
                ArrayMemberValue amv = new ArrayMemberValue(cp);
                amv.setValue(elements);
                annotation.addMemberValue(attrName,amv);
            }else
                return false;

            attribute.setAnnotation(annotation);
            methodInfo.addAttribute(attribute);
            return true;
        }
        return false;
    }
}