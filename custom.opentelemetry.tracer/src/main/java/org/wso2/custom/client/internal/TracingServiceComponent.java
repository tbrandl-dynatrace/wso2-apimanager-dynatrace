/*
 * Copyright (c) 2021 WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.wso2.custom.client.internal;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.ComponentContext;
import org.osgi.service.component.annotations.*;
import org.wso2.carbon.apimgt.tracing.*;
import org.wso2.custom.client.OpenTelemetryTracer;

@Component(
         name = "org.wso2.custom.client.TracingServiceComponent",
        immediate = true)
public class TracingServiceComponent {

    private static final Log log = LogFactory.getLog(TracingServiceComponent.class);

    private ServiceRegistration registration;

    @Activate
    protected void activate(ComponentContext componentContext) {
		log.warn("OpenTelemetryTracer activated");
        try {
            BundleContext bundleContext = componentContext.getBundleContext();
            registration = bundleContext.registerService(OpenTracer.class, new OpenTelemetryTracer(),null);

        } catch (Exception e) {
            log.error("Error occured in tracing component activation", e);
        }
    }

    @Deactivate
    protected void deactivate(ComponentContext componentContext) {

        log.warn("OpenTelemetryTracer deactivated");
        registration.unregister();
    }
}

