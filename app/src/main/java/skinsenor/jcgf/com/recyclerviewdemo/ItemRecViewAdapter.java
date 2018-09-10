package skinsenor.jcgf.com.recyclerviewdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 作者：wenbaohe on 2017/3/22.
 */

public class ItemRecViewAdapter extends RecyclerView.Adapter<ItemRecViewAdapter.MyViewHolder> {

    private ItemClickListener itemClickListener;
    private ArrayList<ImageMsTest> listData;
    private Context context;
    private HashMap<Integer, Boolean> selects = new HashMap<>();


    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public ItemRecViewAdapter(Context context, ArrayList<ImageMsTest> listData) {
        this.context = context;
        this.listData = listData;
//        for (int i = 0; i < listData.size(); i++) {
//            selects.put(i, false);
//        }
    }

    /**
     * 初始化视图
     */
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recview_itemlayout1, null);
        MyViewHolder viewHolder = new MyViewHolder(view);
        Log.e("打印---", "创建次数");
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
//        holder.text.setText(listData.get(position).getName());
        if (isshow) {
            holder.checkbox.setVisibility(View.VISIBLE);
            holder.checkbox.setChecked(selects.get(position) == null ? false : selects.get(position));
        } else {
            holder.checkbox.setVisibility(View.GONE);
        }

    }

    /**
     * 返回总数大小
     */
    @Override
    public int getItemCount() {
        return listData.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        /**
         * 定义控件
         */
        public ImageView imageView;
        public TextView text;
        public CheckBox checkbox;

        public MyViewHolder(final View itemView) {
            super(itemView);
            /**初始化控件*/
            imageView = (ImageView) itemView.findViewById(R.id.imageview);
            text = (TextView) itemView.findViewById(R.id.text_tv);
            checkbox = (CheckBox) itemView.findViewById(R.id.checkbox);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (isshow) {
                        selects.put(getAdapterPosition(), selects.get(getAdapterPosition()) == null ? true : !selects.get(getAdapterPosition()));
                        notifyDataSetChanged();
                    }
                    if (itemClickListener != null) {
                        itemClickListener.onItemClick(itemView, getAdapterPosition());
                    }
                }
            });

        }
    }

    public ArrayList<ImageMsTest> getselect() {
        ArrayList<ImageMsTest> imageMsTests = new ArrayList<>();
        if (!selects.isEmpty()) {
            for (int n : selects.keySet()) {
                if (selects.get(n) && listData.get(n) != null) {
                    imageMsTests.add(listData.get(n));
                }
            }
        }
        return imageMsTests;
    }

    private boolean isshow;

    public void isshowSelect(boolean isshow) {
        this.isshow = isshow;
        if (!isshow) {
            selects.clear();
        }
        notifyDataSetChanged();
    }
}


