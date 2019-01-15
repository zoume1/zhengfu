package com.szt.common.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;  
import java.io.IOException;  
import java.io.ObjectInputStream;  
import java.io.ObjectOutputStream;  
  
/** 
 * 克隆操作类 
 * @author liguohui 
 * 
 */  
public class CloneOper {  
    /** 
     * 深度拷贝 
     * @param obj 
     * @return 
     */  
    @SuppressWarnings("unchecked")  
    public static <T> T deepCloneObject(T obj) {  
        try {  
            ByteArrayOutputStream byteOut = new ByteArrayOutputStream();  
            ObjectOutputStream out = new ObjectOutputStream(byteOut);  
            out.writeObject(obj);  
              
            ByteArrayInputStream byteIn = new ByteArrayInputStream(byteOut.toByteArray());   
            ObjectInputStream in =new ObjectInputStream(byteIn);  
              
            return (T)in.readObject();  
        } catch (IOException e) {  
            e.printStackTrace();  
        } catch (ClassNotFoundException e) {  
            e.printStackTrace();  
        }  
        return null;  
    }  
}  