/*
 * Sakuli - Testing and Monitoring-Tool for Websites and common UIs.
 *
 * Copyright 2013 - 2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.sakuli.services.forwarder.gearman.model;

/**
 * @author Christoph Deppisch
 */
public class NagiosCachedCheckResult extends NagiosCheckResult {

    private String cachedResult;

    public NagiosCachedCheckResult(String queueName, String uuid, String cachedResult) {
        super(queueName, uuid);
        this.cachedResult = cachedResult;
    }

    @Override
    public String getPayloadString() {
        return cachedResult;
    }
}
