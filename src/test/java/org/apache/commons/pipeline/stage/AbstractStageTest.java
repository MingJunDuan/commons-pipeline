/*
 * Copyright 2005 The Apache Software Foundation
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

package org.apache.commons.pipeline.stage;

import org.apache.commons.pipeline.AbstractLoggingTestCase;
import org.apache.commons.pipeline.Stage;
import org.apache.commons.pipeline.testFramework.TestFeeder;
import org.apache.commons.pipeline.testFramework.TestStageContext;

/**
 * Simple abstract base class for stage tests.
 *
 * @author kjn
 */
public class AbstractStageTest extends AbstractLoggingTestCase {
    
    //initialize the testing context
    protected TestStageContext testContext;
    protected TestFeeder testFeeder;
    
    public AbstractStageTest(String testName) {
        super(testName);
    }
    
    protected void setUp() throws Exception {
        this.testContext = new TestStageContext();
        this.testFeeder = new TestFeeder();
    }
    
    protected void tearDown() throws Exception {
        this.testContext = null;
        this.testFeeder = null;
    }
    
    protected void init(Stage stage) {
        testContext.registerDownstreamFeeder(stage, testFeeder);
        stage.init(testContext);        
    }
}