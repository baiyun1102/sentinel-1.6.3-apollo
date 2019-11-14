/**
 * coder4j.cn
 * Copyright (C) 2013-2019 All Rights Reserved.
 */
package com.alibaba.csp.sentinel.dashboard.rule.apollo.gateway;

import com.alibaba.csp.sentinel.dashboard.datasource.entity.gateway.ApiDefinitionEntity;
import com.alibaba.csp.sentinel.dashboard.datasource.entity.gateway.GatewayFlowRuleEntity;
import com.alibaba.csp.sentinel.dashboard.rule.DynamicRulePublisher;
import com.alibaba.csp.sentinel.dashboard.rule.apollo.ApolloCommonService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author xdcui
 * @version GateWayApiGroupApolloPublisher.java, v 0.1 2019-11-11 16:01 xdcui
 */
@Component("gatewayApiGroupApolloPublisher")
public class GatewayApiGroupApolloPublisher implements DynamicRulePublisher<List<ApiDefinitionEntity>> {

    @Autowired
    private ApolloCommonService apolloCommonService;
    @Value("${gw-api-group.key.suffix:gw-api-group}")
    private String gatewayApiGroupSuffix;

    @Override
    public void publish(String app, List<ApiDefinitionEntity> rules) throws Exception {
        apolloCommonService.publishRules(app, gatewayApiGroupSuffix, JSON.toJSONString(rules));
    }
}