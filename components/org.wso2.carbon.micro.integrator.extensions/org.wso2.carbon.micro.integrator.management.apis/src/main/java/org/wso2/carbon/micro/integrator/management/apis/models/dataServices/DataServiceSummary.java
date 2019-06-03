/*
 * Copyright (c) 2019, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.wso2.carbon.micro.integrator.management.apis.models.dataServices;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DataServiceSummary {
    @JsonProperty("name")
    private String serviceName;

    @JsonProperty("wsdl1_1")
    private String wsdl11;

    @JsonProperty("wsdl2_0")
    private String wsdl20;

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public void setWsdl11(String wsdl11) {
        this.wsdl11 = wsdl11;
    }

    public void setWsdl20(String wsdl20) {
        this.wsdl20 = wsdl20;
    }
}
