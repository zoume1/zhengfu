package com.szt.modules.generator.constant;

/**
 * 字段管理常量
 *
 * @author liao
 * @email 1171964050@qq.com
 * @date 2018-09-22 16:29:41
 */
public interface  GeneratorTableFieldConstant{
    /**
     * 正则校验&0-手机号,1-非空,2-身份证,3-邮箱,4-数字,5-小数 - generator_table_field_checkout
     */
    //手机号
    String GENERATOR_TABLE_FIELD_CHECKOUT_0 = "0";
    //非空
    String GENERATOR_TABLE_FIELD_CHECKOUT_1 = "1";
    //身份证
    String GENERATOR_TABLE_FIELD_CHECKOUT_2 = "2";
    //邮箱
    String GENERATOR_TABLE_FIELD_CHECKOUT_3 = "3";
    //数字
    String GENERATOR_TABLE_FIELD_CHECKOUT_4 = "4";
    //小数
    String GENERATOR_TABLE_FIELD_CHECKOUT_5 = "5";
    /**
     * 逻辑删除@0-存在,1-隐藏,2-删除,3-停用 - generator_table_field_delete_flag
     */
    //存在
    String GENERATOR_TABLE_FIELD_DELETE_FLAG_0 = "0";
    //隐藏
    String GENERATOR_TABLE_FIELD_DELETE_FLAG_1 = "1";
    //删除
    String GENERATOR_TABLE_FIELD_DELETE_FLAG_2 = "2";
    //停用
    String GENERATOR_TABLE_FIELD_DELETE_FLAG_3 = "3";
    /**
     * 是否导出@0-导出,1-非导出 - generator_table_field_is_export
     */
    //导出
    String GENERATOR_TABLE_FIELD_IS_EXPORT_0 = "0";
    //非导出
    String GENERATOR_TABLE_FIELD_IS_EXPORT_1 = "1";
    /**
     * 是否主键@0-是,1-否 - generator_table_field_column_key
     */
    //是
    String GENERATOR_TABLE_FIELD_COLUMN_KEY_0 = "0";
    //否
    String GENERATOR_TABLE_FIELD_COLUMN_KEY_1 = "1";
    /**
     * 字段类型@0-varchar,1-bigint,2-datetime,3-date,4-int,5-decimal - generator_table_field_field_type
     */
    //varchar
    String GENERATOR_TABLE_FIELD_FIELD_TYPE_0 = "0";
    //bigint
    String GENERATOR_TABLE_FIELD_FIELD_TYPE_1 = "1";
    //datetime
    String GENERATOR_TABLE_FIELD_FIELD_TYPE_2 = "2";
    //date
    String GENERATOR_TABLE_FIELD_FIELD_TYPE_3 = "3";
    //int
    String GENERATOR_TABLE_FIELD_FIELD_TYPE_4 = "4";
    //decimal
    String GENERATOR_TABLE_FIELD_FIELD_TYPE_5 = "5";
    /**
     * 是否为空@0-可以空,1-非空 - generator_table_field_is_null
     */
    //可以空
    String GENERATOR_TABLE_FIELD_IS_NULL_0 = "0";
    //非空
    String GENERATOR_TABLE_FIELD_IS_NULL_1 = "1";
    /**
     * 是否允许修改@0-是,1-否 - generator_table_field_is_update
     */
    //是
    String GENERATOR_TABLE_FIELD_IS_UPDATE_0 = "0";
    //否
    String GENERATOR_TABLE_FIELD_IS_UPDATE_1 = "1";
    /**
     * 是否搜索@0-搜索,1-非搜索 - generator_table_field_is_seek
     */
    //搜索
    String GENERATOR_TABLE_FIELD_IS_SEEK_0 = "0";
    //非搜索
    String GENERATOR_TABLE_FIELD_IS_SEEK_1 = "1";
    /**
     * 表格中字段是否显示@0-是,1-否 - generator_table_field_table_set
     */
    //是
    String GENERATOR_TABLE_FIELD_TABLE_SET_0 = "0";
    //否
    String GENERATOR_TABLE_FIELD_TABLE_SET_1 = "1";
    /**
     * 是否数据库字段@0-是,1-否 - generator_table_field_is_data_base
     */
    //是
    String GENERATOR_TABLE_FIELD_IS_DATA_BASE_0 = "0";
    //否
    String GENERATOR_TABLE_FIELD_IS_DATA_BASE_1 = "1";
    /**
     * 修改时是否显示@0-是,1-否 - generator_table_field_is_set
     */
    //是
    String GENERATOR_TABLE_FIELD_IS_SET_0 = "0";
    //否
    String GENERATOR_TABLE_FIELD_IS_SET_1 = "1";
    /**
     * 输入框类型@0-普通文本,1-数字框,2-日期,3-时间,4-下拉选,5-复选框,6-富文本,7-文本域,8-上传单图像 - generator_table_field_input_type
     */
    //普通文本
    String GENERATOR_TABLE_FIELD_INPUT_TYPE_0 = "0";
    //数字框
    String GENERATOR_TABLE_FIELD_INPUT_TYPE_1 = "1";
    //日期
    String GENERATOR_TABLE_FIELD_INPUT_TYPE_2 = "2";
    //时间
    String GENERATOR_TABLE_FIELD_INPUT_TYPE_3 = "3";
    //下拉选
    String GENERATOR_TABLE_FIELD_INPUT_TYPE_4 = "4";
    //复选框
    String GENERATOR_TABLE_FIELD_INPUT_TYPE_5 = "5";
    //富文本
    String GENERATOR_TABLE_FIELD_INPUT_TYPE_6 = "6";
    //文本域
    String GENERATOR_TABLE_FIELD_INPUT_TYPE_7 = "7";
    //上传单图像
    String GENERATOR_TABLE_FIELD_INPUT_TYPE_8 = "8";
}
