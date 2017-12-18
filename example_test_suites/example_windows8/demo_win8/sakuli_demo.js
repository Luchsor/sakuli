/*
 * Sakuli - Testing and Monitoring-Tool for Websites and common UIs.
 *
 * Copyright 2013 - 2015 the original author or authors.
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

_dynamicInclude($includeFolder);
var testCase = new TestCase(60, 70);
var env = new Environment();
var screen = new Region();
var appNotepad = new Application("notepad.exe");
var appCalc = new Application("calc.exe");

try {
    _highlight(_link("SSL Manager"));
    _highlight(_link("Logs"));
    _highlight(_link("Online Documentation"));
    _highlight(_link("Test Pages"));
    _highlight(_link("Sample Application"));
    testCase.endOfStep("Test Sahi landing page", 30);

    appCalc.open();
    var calcRegion = appCalc.getRegion().highlight();
    calcRegion.waitForImage("calculator.png", 10).highlight();
    calcRegion.type("525").sleep(1);

    calcRegion.find("plus.png").highlight().click().type("100");
    calcRegion.find("result.png").highlight().click();
    calcRegion.waitForImage("625", 5).highlight();

    testCase.endOfStep("Calculation", 30);

    appNotepad.open();
    appNotepad.getRegion().waitForImage("notepad.png", 10).highlight();
    env.paste("Initial test passed. Sakuli, Sahi and Sikuli seem to work fine. Exiting...");
    testCase.endOfStep("Editor", 30);

} catch (e) {
    testCase.handleException(e);
} finally {
    appCalc.close(true);      //silent
    appNotepad.kill(true);   //silent, hard kill
    testCase.saveResult();
}
