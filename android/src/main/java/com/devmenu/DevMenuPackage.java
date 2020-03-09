
package com.devmenu;

/**
 * Module dependencies.
 */

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;
import com.facebook.react.bridge.JavaScriptModule;

/**
 * `DevMenuPackage` package.
 */

public class DevMenuPackage implements ReactPackage {

    /**
     * Create native modules.
     */

    @Override
    public List<NativeModule> createNativeModules(ReactApplicationContext reactContext) {
      return Arrays.<NativeModule>asList(new DevMenuModule(reactContext));
    }

    /**
     * Create JS modules.
     */

    // Deprecated from RN 0.47
    public List<Class<? extends JavaScriptModule>> createJSModules() {
      return Collections.emptyList();
    }

    /**
     * Create view managers.
     */

    @Override
    public List<ViewManager> createViewManagers(ReactApplicationContext reactContext) {
      return Collections.emptyList();
    }
}