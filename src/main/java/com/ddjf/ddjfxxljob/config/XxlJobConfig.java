/**
 * <pre>
 *  Copyright © 2015~2018 深圳前海大道金融服务有限公司 粤ICP备15110793号
 * </pre>
 */
package com.ddjf.ddjfxxljob.config;

import com.ddjf.ddjfxxljob.executor.DdjfXxlJobSpringExecutor;
import com.xxl.job.core.executor.impl.XxlJobSpringExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 *  <pre>
 *  @description:
 *  @author: chenlu
 *  @email: chenlu@ddjf.com.cn 
 *  @date: 2018/12/19 14:14
 *  @project: base-service-platform 
 *  </pre>
 */
@Configuration
public class XxlJobConfig {
    private Logger logger = LoggerFactory.getLogger(XxlJobConfig.class);

    @Value("${xxl.job.admin.addresses}")
    private String adminAddresses;

    @Value("${xxl.job.executor.appname}")
    private String appName;

    @Value("${xxl.job.executor.ip}")
    private String ip;

    @Value("${xxl.job.executor.port}")
    private int port;

    @Value("${xxl.job.accessToken}")
    private String accessToken;

    @Value("${xxl.job.executor.logpath}")
    private String logPath;

    @Value("${xxl.job.executor.logretentiondays}")
    private int logRetentionDays;


    @Bean(initMethod = "start", destroyMethod = "destroy")
    public DdjfXxlJobSpringExecutor xxlJobExecutor() {
        logger.info(">>>>>>>>>>> xxl-job config init.");
        logger.info("adminAddresses={}",adminAddresses);
        logger.info("appName={}",appName);
        logger.info("ip={}",ip);
        logger.info("port={}",port);
        logger.info("accessToken={}",accessToken);
        logger.info("logPath={}",logPath);
        logger.info("logRetentionDays={}",logRetentionDays);
        DdjfXxlJobSpringExecutor xxlJobExecutor = new DdjfXxlJobSpringExecutor();
        xxlJobExecutor.setAdminAddresses(adminAddresses);
        xxlJobExecutor.setAppName(appName);
        xxlJobExecutor.setIp(ip);
        xxlJobExecutor.setPort(port);
        xxlJobExecutor.setAccessToken(accessToken);
        xxlJobExecutor.setLogPath(logPath);
        xxlJobExecutor.setLogRetentionDays(logRetentionDays);
        return xxlJobExecutor;
    }

}