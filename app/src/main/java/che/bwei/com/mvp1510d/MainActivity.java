package che.bwei.com.mvp1510d;
import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;
import che.bwei.com.mvp1510d.adapter.Myadapter;
import che.bwei.com.mvp1510d.bean.Bean;
import che.bwei.com.mvp1510d.presenter.MyPresenter;
import che.bwei.com.mvp1510d.view.Ivv;
public class MainActivity extends Activity implements Ivv {

    @BindView(R.id.rv)
    RecyclerView rv;
    private MyPresenter presenter;
    private Myadapter myadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        //自创的方法
        initData();
        presenter = new MyPresenter(this,this);
        presenter.getokhttp();
    }

    private void initData() {
        //线性管理器
        LinearLayoutManager manager = new LinearLayoutManager(this);
        rv.setLayoutManager(manager);
        rv.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.HORIZONTAL));
    }


    @Override
    public void zhanshi(Bean bean) {

        //实例化适配器传参
        myadapter = new Myadapter(this,bean);
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                rv.setAdapter(myadapter);
            }
        });
    }
}
