package com.szt.modules.generator.entity;

/**
 * select分类
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年12月20日 上午12:01:45
 */
public class ColumnListEntity {
	private String key;
	private String MapKey;
	private String MapValue;
	private String comments;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getMapKey() {
		return MapKey;
	}

	public void setMapKey(String mapKey) {
		MapKey = mapKey;
	}

	public String getMapValue() {
		return MapValue;
	}

	public void setMapValue(String mapValue) {
		MapValue = mapValue;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}
}
