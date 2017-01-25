/**
 * Personium
 * Copyright 2017 FUJITSU LIMITED
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
package io.personium.engine.extension.test;

import org.mozilla.javascript.ScriptableObject;

@SuppressWarnings("serial")
public class ExtSample extends ScriptableObject {

    private int count;

    public ExtSample() {
        count = 0;
    }

    public void jsConstructor() {
        count = 0;
    }

    public String getClassName() {
        return "Sample";
    }

    public int jsFunction_add(int delta) {
        count += delta;
        return count;
    }
    
    public int jsGet_count() {
        return count;
    }

    public void jsSet_count(int val) {
        count = val;
    }
    
    
    public void jsFunction_passAsObject(Object target) {
        String clazzType = target.getClass().getName();
        System.out.println( clazzType);
    }

    public void jsFunction_passNumber(Double arg) {
        String clazzType = arg.getClass().getName();
        System.out.println( clazzType);
    }

    public void jsFunction_passString(String arg) {
        String clazzType = arg.getClass().getName();
        System.out.println( clazzType);
    }
  
}