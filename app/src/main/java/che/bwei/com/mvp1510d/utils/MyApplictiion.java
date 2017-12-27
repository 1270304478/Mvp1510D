package che.bwei.com.mvp1510d.utils;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * 此类的作用：
 *
 * @author: forever
 * @date: 2017/12/27 14:41
 */
public class MyApplictiion extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}
