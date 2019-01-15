package com.szt.common.utils;

import com.szt.common.Public.PublicEntity;

public class ExChangeUtils {
    public static void exChange(PublicEntity from,PublicEntity to){
        to.setRemarks(from.getRemarks());
        to.setSendTime(from.getSendTime());
        to.setType(from.getType());
        to.setTheme(from.getTheme());
        to.setState(from.getState());
        to.setSenderNo(from.getSenderNo());
        to.setRelevanceMainline(from.getRelevanceMainline());
        to.setReceiverNo(from.getReceiverNo());
        to.setReceiverEmail(from.getReceiverEmail());
        to.setIsReceipt(from.getIsReceipt());
        to.setFilePath(from.getFilePath());
        to.setFileName(from.getFileName());
        to.setCopyNo(from.getCopyNo());
        to.setCopyEmail(from.getCopyEmail());
        to.setCopier(from.getCopier());
        to.setContent(from.getContent());
        to.setBccerNo(from.getBccerNo());
        to.setBccEmail(from.getBccEmail());
    }
}
