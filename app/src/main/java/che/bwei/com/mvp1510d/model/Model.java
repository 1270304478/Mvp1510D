package che.bwei.com.mvp1510d.model;

import che.bwei.com.mvp1510d.okhttp.OkHttp3Utils;
import okhttp3.Callback;
import okhttp3.OkHttpClient;

/**
 * 此类的作用：
 *
 * @author: forever
 * @date: 2017/12/27 14:16
 */
public class Model implements IMm{

    @Override
    public void shuju(Callback callback) {
        OkHttp3Utils.doGet("http://m.yunifang.com/yunifang/mobile/home",callback);
    }
}
