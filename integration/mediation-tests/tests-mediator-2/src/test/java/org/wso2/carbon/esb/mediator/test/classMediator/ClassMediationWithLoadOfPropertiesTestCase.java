/*
 * Copyright (c) 2005-2010, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
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

package org.wso2.carbon.esb.mediator.test.classMediator;

import org.apache.axiom.om.OMElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.wso2.carbon.automation.engine.annotations.ExecutionEnvironment;
import org.wso2.carbon.automation.engine.annotations.SetEnvironment;
import org.wso2.carbon.registry.properties.stub.PropertiesAdminServiceRegistryExceptionException;
import org.wso2.carbon.registry.resource.stub.ResourceAdminServiceExceptionException;
import org.wso2.esb.integration.common.utils.ESBIntegrationTest;
import org.wso2.esb.integration.common.utils.ESBTestConstant;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamException;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

/**
 * Class mediator jar : SimpleClassMediator-1.0.0.jar
 * Class mediator name : org.wso2.integration.test.mediator.SimpleClassMediator
 */

public class ClassMediationWithLoadOfPropertiesTestCase extends ESBIntegrationTest {

    @BeforeClass(alwaysRun = true)
    public void setEnvironment() throws Exception {
        super.init();
    }

    @SetEnvironment(executionEnvironments = { ExecutionEnvironment.STANDALONE })
    @Test(groups = { "wso2.esb", "localOnly" }, description = "Class Mediator "
            + " -Class mediator which has a load of properties to be passed and mediation")
    public void testMediationWithLoadOfProperties()
            throws Exception, PropertiesAdminServiceRegistryExceptionException,
                   ResourceAdminServiceExceptionException, XMLStreamException, InterruptedException {

        OMElement response = axis2Client.sendSimpleStockQuoteRequest(getProxyServiceURLHttp(
                "classMediatorWithLoadOfPropertiesTestCase_main_sequence"),
                getBackEndServiceUrl(ESBTestConstant.SIMPLE_STOCK_QUOTE_SERVICE), "WSO2");

        String lastPrice = response.getFirstElement()
                .getFirstChildWithName(new QName("http://services.samples/xsd", "last")).getText();
        assertNotNull(lastPrice, "Fault: response message 'last' price null");

        String symbol = response.getFirstElement()
                .getFirstChildWithName(new QName("http://services.samples/xsd", "symbol")).getText();
        assertEquals(symbol, "WSO2", "Fault: value 'symbol' mismatched");

        //TODO Log Assertion
        /*
        INFO - SimpleClassMediator Starting Mediation -SimpleClassMediator
        INFO - SimpleClassMediator Initialized with User:[esb user]
        INFO - SimpleClassMediator E-MAIL:[user@wso2.org]
        INFO - SimpleClassMediator Massage Id:
        INFO - SimpleClassMediator Original price:
        INFO - SimpleClassMediator Discounted price:
        INFO - SimpleClassMediator Final price:
        INFO - SimpleClassMediator ----------Added properties----------
        *********log added details in synapse config************
        INFO - SimpleClassMediator -------------------------------------
        INFO - SimpleClassMediator Logged....
        refer https://wso2.org/jira/browse/TA-508
         */

    }
}
