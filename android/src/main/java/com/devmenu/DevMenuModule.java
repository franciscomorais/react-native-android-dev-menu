
package com.devmenu;

/**
 * Module dependencies.
 */

import android.os.Handler;
import com.facebook.react.ReactApplication;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

/**
 * `DevMenuModule`.
 */

public class DevMenuModule extends ReactContextBaseJavaModule {

    /**
     * Name.
     */

    static final String NAME = "DevMenu";


    /**
     * Constructor.
     */

    public DevMenuModule(ReactApplicationContext context) {
        super(context);
    }

    /**
     * Get name.
     */

    @Override
    public String getName() {
        return DevMenuModule.NAME;
    }

    /**
     * Open dev menu.
     */

    @ReactMethod
    public void show() {
        final ReactApplication application = (ReactApplication) getReactApplicationContext()
                .getCurrentActivity()
                .getApplication();

        Handler mainHandler = new Handler(this.getReactApplicationContext().getMainLooper());
        Runnable myRunnable = new Runnable() {

            @Override
            public void run() {
                try {
                    application
                        .getReactNativeHost()
                        .getReactInstanceManager()
                        .getDevSupportManager()
                        .showDevOptionsDialog();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };


        mainHandler.post(myRunnable);
    }
}