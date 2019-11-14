/**
 * coder4j.cn
 * Copyright (C) 2013-2019 All Rights Reserved.
 */
package com.alibaba.csp.sentinel.dashboard.rule.apollo.gateway;

import com.alibaba.csp.sentinel.dashboard.datasource.entity.gateway.ApiDefinitionEntity;
import com.alibaba.csp.sentinel.dashboard.datasource.entity.gateway.GatewayFlowRuleEntity;
import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.FlowRuleEntity;
import com.alibaba.csp.sentinel.dashboard.rule.DynamicRulePublisher;
import com.alibaba.csp.sentinel.dashboard.rule.apollo.ApolloCommonService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author xdcui
 * @version GateWayFlowRuleApolloPublisher.java, v 0.1 2019-09-06 11:06 xdcui
 */
@Component("gatewayFlowRuleApolloPublisher")
public class GatewayFlowRuleApolloPublisher implements DynamicRulePublisher<List<GatewayFlowRuleEntity>> {

    @Autowired
    private ApolloCommonService apolloCommonService;
    @Value("${gw-flow.key.suffix:gw-flow}")
    private String gatewayFlowataIdSuffix;

    @Override
    public void publish(String app, List<GatewayFlowRuleEntity> rules) throws Exception {
        apolloCommonService.publishRules(app, gatewayFlowataIdSuffix, JSON.toJSONString(rules));
    }
}