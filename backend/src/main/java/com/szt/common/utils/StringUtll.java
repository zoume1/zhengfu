package com.szt.common.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.WordUtils;

@Slf4j
public class StringUtll {
    /**
     * 移除多余空行和空格
     */
    public static String dealRedundantSpaceAndBlankLine(String content) {
        if (content == null || content.length() == 0) {
            return "";
        }
        StringBuilder strAfterRemoveCRSB = new StringBuilder();
        for (int i = 0; i < content.length(); i++) {
            if (content.charAt(i) != '\r')
                strAfterRemoveCRSB.append(content.charAt(i));
        }
        String strAfterRemoveCR = strAfterRemoveCRSB.toString();
        if (strAfterRemoveCR == null || strAfterRemoveCR.length() == 0) {
            return "";
        }
        StringBuilder resultSB = new StringBuilder();
        String[] lines = strAfterRemoveCR.split("\n");
        int blankCount = 0;
        for (String line : lines) {
            if (line == null) {
                continue;
            }
            String lineTrim = line.trim();
            if ("".equals(lineTrim)) {
                blankCount++;
                if (blankCount <= 2) {
                    resultSB.append("\n");
                }
            } else {
                blankCount = 0;
                resultSB.append(dealSpace4OneLine(line)).append("\n");
            }
        }
        resultSB.deleteCharAt(resultSB.length() - 1);
        return resultSB.toString();
    }

    /**
     * 移除1行中的多余空格
     */
    public static String dealSpace4OneLine(String line) {
        return line;

    }

    /**
     * 去掉空行
     */
    public static String delKongHang(String str) {
        if (str.trim() != null && !str.trim().equals("")) {
            return str;
        } else {
            return "";
        }
    }

    /**
     * 去掉行后注释
     * //和/*和<!--
     */
    public String delHangHouZhuShi(String str) {
        if (str.contains("//")) {
            return str.substring(0, str.indexOf("//"));
        } else if (str.contains("/*")) {
            return str.substring(0, str.indexOf("/*"));
        } else if (str.contains("<!--")) {
            return str.substring(0, str.indexOf("<!--"));
        } else {
            return str;
        }
    }

    /**
     * 列名转换成Java属性名
     */
    public static String columnToJava(String columnName) {
        return WordUtils.capitalizeFully(columnName, new char[]{'_'}).replace("_", "");
    }
    //首字母大写
    public static String captureName(String name) {
        //     name = name.substring(0, 1).toUpperCase() + name.substring(1);
//        return  name;
        char[] cs=name.toCharArray();
        cs[0]-=32;
        return String.valueOf(cs);

    }


    public static String parseJavaBeanField(String str) {
        return StringUtils.uncapitalize(columnToJava(str));
    }

}
