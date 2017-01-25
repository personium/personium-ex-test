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

import org.json.simple.JSONObject;
import org.mozilla.javascript.EcmaError;
import org.mozilla.javascript.NativeObject;

import io.personium.engine.extension.support.AbstractExtensionScriptableObject;
import io.personium.engine.extension.support.ExtensionErrorConstructor;

@SuppressWarnings("serial")
public class Ext_TestExtension extends AbstractExtensionScriptableObject {

    @Override
    public String getClassName() {
        return "TestExtension";
    }

    public Ext_TestExtension() {
    }

    public void jsConstructor() {
    }

    public String jsFunction_process(String message) {
        getLogger().info(message + "←呼び出しました。");
        getLogger().debug("デバッグメッセージ");
        return message + "←呼び出しました。" + getProperties().getProperty("io.personium.engine.extension.test.TestExtension.prop");
    }

    public String jsFunction_abort(String message) throws EcmaError {
        throw ExtensionErrorConstructor.construct(message);
    }

    public String jsFunction_abort2(String message) throws Exception {
        throw new CloneNotSupportedException(message);
    }

    @SuppressWarnings("unchecked")
    public JSONObject jsFunction_requestWithJSON(String title, NativeObject json) {
        JSONObject result = new JSONObject();
        result.put("result", title + " " + json.get("FirstName") + " "
                + json.get("MiddleName") + " " + json.get("LastName"));
        return result;
    }
}
