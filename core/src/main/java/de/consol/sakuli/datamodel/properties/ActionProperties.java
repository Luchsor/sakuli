/*
 * Sakuli - Testing and Monitoring-Tool for Websites and common UIs.
 *
 * Copyright 2013 - 2014 the original author or authors.
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

package de.consol.sakuli.datamodel.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author tschneck Date: 14.05.14
 */
@Component
public class ActionProperties {

    public static final String TAKE_SCREENSHOTS = "sakuli.takeScreenShots.onErrors";
    public static final String AUTO_HIGHLIGHT_ENABLED = "sakuli.autoHighlight.enabled";
    public static final String AUTO_HIGHLIGHT_SEC = "sakuli.autoHighlight.seconds";
    public static final String TYPE_DELAY_PROPERTY = "sakuli.screenbased.typeDelay";
    public static final String CLICK_DELAY_PROPERTY = "sakuli.screenbased.clickDelay";
    public static final String ENCRYPTION_INTERFACE = "sakuli.encryption.interface";
    protected static final String ENCRYPTION_INTERFACE_DEFAULT = "null";
    public static final String ENCRYPTION_INTERFACE_TEST_MODE = "sakuli.encryption.interface.testmode";
    protected static final String ENCRYPTION_INTERFACE_TEST_MODE_DEFAULT = "false";

    @Value("${" + TAKE_SCREENSHOTS + "}")
    private boolean takeScreenshots;
    @Value("${" + AUTO_HIGHLIGHT_ENABLED + "}")
    private boolean autoHighlightEnabled;
    @Value("${" + AUTO_HIGHLIGHT_SEC + "}")
    private float autoHighlightSeconds;
    @Value("${" + CLICK_DELAY_PROPERTY + "}")
    private double clickDelay;
    @Value("${" + TYPE_DELAY_PROPERTY + "}")
    private double typeDelay;
    @Value("${" + ENCRYPTION_INTERFACE + ":" + ENCRYPTION_INTERFACE_DEFAULT + "}")
    private String encryptionInterface;
    @Value("${" + ENCRYPTION_INTERFACE_TEST_MODE + ":" + ENCRYPTION_INTERFACE_TEST_MODE_DEFAULT + "}")
    private boolean encryptionInterfaceTestMode;

    public boolean isTakeScreenshots() {
        return takeScreenshots;
    }

    public void setTakeScreenshots(boolean takeScreenshots) {
        this.takeScreenshots = takeScreenshots;
    }

    public boolean isAutoHighlightEnabled() {
        return autoHighlightEnabled;
    }

    public void setAutoHighlightEnabled(boolean autoHighlightEnabled) {
        this.autoHighlightEnabled = autoHighlightEnabled;
    }

    public float getAutoHighlightSeconds() {
        return autoHighlightSeconds;
    }

    public void setAutoHighlightSeconds(float autoHighlightSeconds) {
        this.autoHighlightSeconds = autoHighlightSeconds;
    }

    public double getClickDelay() {
        return clickDelay;
    }

    public void setClickDelay(double clickDelay) {
        this.clickDelay = clickDelay;
    }

    public double getTypeDelay() {
        return typeDelay;
    }

    public void setTypeDelay(double typeDelay) {
        this.typeDelay = typeDelay;
    }

    public String getEncryptionInterface() {
        return encryptionInterface;
    }

    public void setEncryptionInterface(String encryptionInterface) {
        this.encryptionInterface = encryptionInterface;
    }

    public boolean isEncryptionInterfaceTestMode() {
        return encryptionInterfaceTestMode;
    }

    public void setEncryptionInterfaceTestMode(boolean encryptionInterfaceTestMode) {
        this.encryptionInterfaceTestMode = encryptionInterfaceTestMode;
    }

}
