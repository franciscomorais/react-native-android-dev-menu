
package com.devmenu;

/**
 * Module dependencies.
 */

import android.app.Application;
import android.os.Handler;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

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
        final Application application = (Application) this.getReactApplicationContext().getApplicationContext();
        Handler mainHandler = new Handler(this.getReactApplicationContext().getMainLooper());
        Runnable myRunnable = new Runnable() {

            @Override
            public void run() {
                try {
                    Method getReactNativeHost = application.getClass().getMethod("getReactNativeHost");
                    Object nativeHost = getReactNativeHost.invoke(application);

                    Method getReactInstanceManager = nativeHost.getClass().getMethod("getReactInstanceManager");
                    Object instanceManager = getReactInstanceManager.invoke(nativeHost);

                    Method show = instanceManager.getClass().getMethod("showDevOptionsDialog");
                    show.invoke(instanceManager);

                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }

            }
        };


        mainHandler.post(myRunnable);
    }
}