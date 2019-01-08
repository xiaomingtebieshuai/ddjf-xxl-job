/**
 * <pre>
 *  Copyright © 2015~2018 深圳前海大道金融服务有限公司 粤ICP备15110793号
 * </pre>
 */
package com.ddjf.ddjfxxljob.executor;

import com.ddjf.ddjfxxljob.handler.DdjfIJobHandler;
import com.ddjf.ddjfxxljob.handler.annotation.DdjfJobHandler;
import com.xxl.job.core.executor.impl.XxlJobSpringExecutor;
import com.xxl.job.core.glue.GlueFactory;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;

import java.util.Map;

/**
 *  <pre>
 *  @description:
 *  @author: chenlu
 *  @email: chenlu@ddjf.com.cn 
 *  @date: 2019/1/8 17:52
 *  @project: ddjf-xxl-job 
 *  </pre>
 */
public class DdjfXxlJobSpringExecutor extends XxlJobSpringExecutor {


    @Override
    public void start() throws Exception {

        // init JobHandler Repository
        initJobHandlerRepository(applicationContext);

        // refresh GlueFactory
        GlueFactory.refreshInstance(1);


        // super start
        super.start();
    }
    private void initJobHandlerRepository(ApplicationContext applicationContext){
        if (applicationContext == null) {
            return;
        }

        // init job handler action
        Map<String, Object> serviceBeanMap = applicationContext.getBeansWithAnnotation(DdjfJobHandler.class);

        if (serviceBeanMap!=null && serviceBeanMap.size()>0) {
            for (Object serviceBean : serviceBeanMap.values()) {
                if (serviceBean instanceof DdjfIJobHandler){
                    String name = serviceBean.getClass().getAnnotation(DdjfJobHandler.class).value();
                    IJobHandler handler = (IJobHandler) serviceBean;
                    if (loadJobHandler(name) != null) {
                        throw new RuntimeException("xxl-job jobhandler naming conflicts.");
                    }
                    registJobHandler(name, handler);
                }
            }
        }
    }

    // ---------------------- applicationContext ----------------------
    private static ApplicationContext applicationContext;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

}
