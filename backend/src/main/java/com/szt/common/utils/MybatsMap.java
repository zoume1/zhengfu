package com.szt.common.utils;

import com.sun.tools.internal.ws.processor.generator.GeneratorUtil;
import org.apache.commons.lang.StringUtils;

import java.util.HashMap;

public class MybatsMap  extends HashMap {
    @Override
    public Object put(Object key, Object value) {
        return super.put(StringUtils.uncapitalize(StringUtll.columnToJava(key.toString())), value);
    }
}
