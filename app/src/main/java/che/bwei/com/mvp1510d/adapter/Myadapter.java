package che.bwei.com.mvp1510d.adapter;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import butterknife.BindView;
import butterknife.ButterKnife;
import che.bwei.com.mvp1510d.R;
import che.bwei.com.mvp1510d.bean.Bean;
/**
 * 此类的作用：
 *
 * @author: forever
 * @date: 2017/12/27 15:03
 */
public class Myadapter extends RecyclerView.Adapter<Myadapter.MyViewHolder> {
    Context context;
    Bean bean;
    public Myadapter(Context context, Bean bean) {
        this.context = context;
        this.bean = bean;
    }
    @Override
    public Myadapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.rv_item, null);
        return new MyViewHolder(view);
    }
    @Override
    public void onBindViewHolder(Myadapter.MyViewHolder holder, int position) {
        //Fresco的解析加载图片
      /*  DraweeController dc= Fresco.newDraweeControllerBuilder()
                //网址的存放
                .setUri(bean.getData().getDefaultGoodsList().get(position).getGoods_img())
                .setAutoPlayAnimations(true)
                .build();*/
        //控件的赋值
     //   holder.simpledraweeview.setController(dc);
        holder.simpledraweeview.setImageURI(bean.getData().getAd1().get(position).getImage());
        holder.textView.setText(bean.getData().getAd1().get(position).getTitle());
    }
    @Override
    public int getItemCount() {
        return bean==null ? 0 :bean.getData().getAd1().size();
    }
    static class MyViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.simpledraweeview)
        SimpleDraweeView simpledraweeview;
        @BindView(R.id.text_view)
        TextView textView;
        MyViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
