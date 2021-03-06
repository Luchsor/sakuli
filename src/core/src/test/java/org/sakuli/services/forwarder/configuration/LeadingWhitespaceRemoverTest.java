/*
 * Sakuli - Testing and Monitoring-Tool for Websites and common UIs.
 *
 * Copyright 2013 - 2017 the original author or authors.
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

package org.sakuli.services.forwarder.configuration;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author Georgi Todorov
 */
public class LeadingWhitespaceRemoverTest {

    @DataProvider
    public Object[][] removeSpacesDP() {
        return new Object[][] {
                { "test test test.", "test test test."}, // nothing to remove or replace here
                { "$whitespace$test", " test"}, // to render leading spaces, the place holder $whitespace$ has to be used
                { "            test ", "test "}, // only leading spaces are removed
                { "\ntest\n", "test"}, // leading and trailing newlines are removed
                { "\ttest\t", "test\t"}, // only leading tabs are removed
                { "$newline$ test", "\n test"}, // to render a new line, the place holder $newline$ has to be used
        };
    }

    @Test(dataProvider = "removeSpacesDP")
    public void removeSpaces(String input, String expectedOutput) {
        LeadingWhitespaceRemover lwr = new LeadingWhitespaceRemover();
        assertEquals(lwr.removeSpaces(input), expectedOutput);
    }

    @Test
    public void testMultiline() throws Exception {
        String multilineCRLF = "\r\n" +
                "\r\n" +
                "    <<<local>>>$newline$\r\n" +
                "\r\n" +
                "2 service_description suite__state=2;;;;\r\n" +
                "|suite__warning=300s;;;;|suite__critical=400s;;;;|suite_example_xfce=46.96s;300;400;;\r\n" +
                "\r\n";
        String multilineLF = "\n" +
                "\n" +
                "    <<<local>>>$newline$\n" +
                "\n" +
                "2 service_description suite__state=2;;;;\n" +
                "|suite__warning=300s;;;;|suite__critical=400s;;;;|suite_example_xfce=46.96s;300;400;;\n" +
                "\n";
        String expected = "<<<local>>>\n" +
                "2 service_description suite__state=2;;;;|suite__warning=300s;;;;|suite__critical=400s;;;;|suite_example_xfce=46.96s;300;400;;";
        assertEquals(new LeadingWhitespaceRemover().removeSpaces(multilineLF), expected);
        assertEquals(new LeadingWhitespaceRemover().removeSpaces(multilineCRLF), expected);
    }
}
