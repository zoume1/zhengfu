export const DIC = {
    VAILD: [{
        label: '真',
        value: true,
        color: 'green'
    }, {
        label: '假',
        value: false,
        color: 'red'
    }],
    SEX: [{
        label: '男',
        value: 0,
        color: 'green'
    }, {
        label: '女',
        value: 1,
        color: 'red'
    }],
    POSTIONDATA: [{
        label: '左对齐',
        value: 'left'
    }, {
        label: '居中',
        value: 'center'
    }, {
        label: '右对齐',
        value: 'right'
    }],
    TYPE: [{
            label: '一级1',
            value: 0,
            children: [{
                label: '一级1二级1',
                value: 2,
            }]
        }, {
            label: '一级2',
            value: 1,
            children: [{
                label: '一级2二级1',
                value: 2,
            }]
        }

    ],
    STATE: [{
        label: '有效',
        value: 0
    }, {
        label: '无效',
        value: 1
    }],
    GRADE: [{
            label: "管理员",
            value: 0
        },
        {
            label: "二级管理员",
            value: 1
        }
    ],
    VAILDATA: [{
            label: "激活",
            value: true,
            color: 'green'
        },
        {
            label: "禁用",
            value: false,
            color: 'red',
        }
    ],
    CRUDTYPE: [{
            label: "选择框",
            value: 'select'
        },
        {
            label: "文本框",
            value: 'text'
        },
        {
            label: "多行文本框",
            value: 'textarea'
        },
        {
            label: "单选框",
            value: 'radio'
        },
        {
            label: "多选框",
            value: 'checkbox'
        },
        {
            label: "日期框",
            value: 'date'
        }
    ],
    DATALIST: [{
        label: 'SEX',
        value: 'SEX',
    }, {
        label: 'STATE',
        value: 'STATE',
    }, {
        label: 'GRADE',
        value: 'GRADE',
    }]
}