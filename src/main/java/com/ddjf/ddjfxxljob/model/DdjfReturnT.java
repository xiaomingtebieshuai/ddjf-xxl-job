/**
 * <pre>
 *  Copyright © 2015~2018 深圳前海大道金融服务有限公司 粤ICP备15110793号
 * </pre>
 */
package com.ddjf.ddjfxxljob.model;

import com.xxl.job.core.biz.model.ReturnT;

/**
 *  <pre>
 *  @description:
 *  @author: chenlu
 *  @email: chenlu@ddjf.com.cn 
 *  @date: 2019/1/7 20:58
 *  @project: ddjf-xxl-job 
 *  </pre>
 */
public class DdjfReturnT<T> extends ReturnT<T> {
    public static final long serialVersionUID = 42L;

    public static final int SUCCESS_CODE = 200;
    public static final int FAIL_CODE = 500;
    public static final DdjfReturnT<String> SUCCESS = new DdjfReturnT<String>(null);
    public static final DdjfReturnT<String> FAIL = new DdjfReturnT<String>(FAIL_CODE, null);

    public DdjfReturnT(){}
    public DdjfReturnT(int code, String msg) {
        super(code,msg);
    }
    public DdjfReturnT(T content) {
        super(content);
    }

    @Override
    public String toString() {
        return "DdjfReturnT [code=" + super.getCode() + ", msg=" + super.getMsg() + ", content=" + super.getContent() + "]";
    }
}
