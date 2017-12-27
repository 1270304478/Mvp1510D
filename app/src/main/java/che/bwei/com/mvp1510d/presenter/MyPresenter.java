package che.bwei.com.mvp1510d.presenter;

import android.content.Context;

import com.google.gson.Gson;

import java.io.IOException;

import che.bwei.com.mvp1510d.bean.Bean;
import che.bwei.com.mvp1510d.model.Model;
import che.bwei.com.mvp1510d.view.Ivv;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * 此类的作用：
 *
 * @author: forever
 * @date: 2017/12/27 14:24
 */
public class MyPresenter {
    //上下文 M层的model V层的接口
    private Context context;
   private  Model mm;
    private Ivv vv;
    public MyPresenter(Context context,Ivv vv){
        this.context=context;
        this.vv=vv;
        //实例化model类
         mm = new Model();
    }
    //创建方法
    public void getokhttp(){
          mm.shuju(new Callback() {
              @Override
              public void onFailure(Call call, IOException e) {
              }
              @Override
              public void onResponse(Call call, Response response) throws IOException {
                  Gson gson = new Gson();
                  String json=response.body().string();
                  Bean bean=gson.fromJson(json,Bean.class);
                  //view层调用方法传bean
                  vv.zhanshi(bean);
              }
          });
    }
}
