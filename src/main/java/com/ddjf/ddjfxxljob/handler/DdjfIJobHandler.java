/**
 * <pre>
 *  Copyright © 2015~2018 深圳前海大道金融服务有限公司 粤ICP备15110793号
 * </pre>
 */
package com.ddjf.ddjfxxljob.handler;

import com.ddjf.ddjfxxljob.model.DdjfReturnT;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;

/**
 *  <pre>
 *  @description:
 *  @author: chenlu
 *  @email: chenlu@ddjf.com.cn 
 *  @date: 2019/1/7 20:44
 *  @project: ddjf-xxl-job 
 *  </pre>
 */
public abstract class DdjfIJobHandler extends IJobHandler {

    /** success */
    public static final DdjfReturnT<String> SUCCESS = new DdjfReturnT<String>(200, null);
    /** fail */
    public static final DdjfReturnT<String> FAIL = new DdjfReturnT<String>(500, null);
    /** fail timeout */
    public static final DdjfReturnT<String> FAIL_TIMEOUT = new DdjfReturnT<String>(502, null);


    /**
     * execute handler, invoked when executor receives a scheduling request
     *
     * @param param
     * @return
     * @throws Exception
     */
    @Override
    public abstract DdjfReturnT<String> execute(String param) throws Exception;


    /**
     * init handler, invoked when JobThread init
     */
    @Override
    public void init() {
        // TODO
    }


    /**
     * destroy handler, invoked when JobThread destroy
     */
    @Override
    public void destroy() {
        // TODO
    }

}
