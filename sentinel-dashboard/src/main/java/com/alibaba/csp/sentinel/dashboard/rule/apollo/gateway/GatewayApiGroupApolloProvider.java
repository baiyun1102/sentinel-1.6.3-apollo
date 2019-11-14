/**
 * coder4j.cn
 * Copyright (C) 2013-2019 All Rights Reserved.
 */
package com.alibaba.csp.sentinel.dashboard.rule.apollo.gateway;

import com.alibaba.csp.sentinel.dashboard.datasource.entity.gateway.ApiDefinitionEntity;
import com.alibaba.csp.sentinel.dashboard.datasource.entity.gateway.GatewayFlowRuleEntity;
import com.alibaba.csp.sentinel.dashboard.rule.DynamicRuleProvider;
import com.alibaba.csp.sentinel.dashboard.rule.apollo.ApolloCommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author xdcui
 * @version GatewayApiGroupApolloProvider.java, v 0.1 2019-11-11 16:05 xdcui
 */
@Component("gatewayApiGroupApolloProvider")
public class GatewayApiGroupApolloProvider implements DynamicRuleProvider<List<ApiDefinitionEntity>> {

    @Autowired
    private ApolloCommonService apolloCommonService;
    @Value("${gw-api-group.key.suffix:gw-api-group}")
    private String gatewayApiGroupSuffix;

    @Override
    public List<ApiDefinitionEntity> getRules(String appName) throws Exception {
        return apolloCommonService.getRules(appName, gatewayApiGroupSuffix, ApiDefinitionEntity.class);
    }
}