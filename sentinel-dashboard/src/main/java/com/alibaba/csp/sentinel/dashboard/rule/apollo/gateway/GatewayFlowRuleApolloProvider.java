/**
 * coder4j.cn
 * Copyright (C) 2013-2019 All Rights Reserved.
 */
package com.alibaba.csp.sentinel.dashboard.rule.apollo.gateway;

import com.alibaba.csp.sentinel.dashboard.datasource.entity.gateway.GatewayFlowRuleEntity;
import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.FlowRuleEntity;
import com.alibaba.csp.sentinel.dashboard.rule.DynamicRuleProvider;
import com.alibaba.csp.sentinel.dashboard.rule.apollo.ApolloCommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author xdcui
 * @version GatewayFlowRuleApolloProvider.java, v 0.1 2019-11-11 10:57 xdcui
 */
@Component("gatewayFlowRuleApolloProvider")
public class GatewayFlowRuleApolloProvider implements DynamicRuleProvider<List<GatewayFlowRuleEntity>> {

    @Autowired
    private ApolloCommonService apolloCommonService;
    @Value("${gw-flow.key.suffix:gw-flow}")
    private String gatewayFlowataIdSuffix;

    @Override
    public List<GatewayFlowRuleEntity> getRules(String appName) throws Exception {
        return apolloCommonService.getRules(appName, gatewayFlowataIdSuffix, GatewayFlowRuleEntity.class);
    }
}