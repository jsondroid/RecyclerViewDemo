package skinsenor.jcgf.com.recyclerviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ItemRecViewAdapter itemRecViewAdapter;

    private ArrayList<ImageMsTest> listData;
    private GridLayoutManager gridLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);


        listData = new ArrayList<>();
//        for (int i = 0; i < 68; i++) {
//            ImageMsTest imageMsTest = new ImageMsTest();
//            imageMsTest.setName("第"+i);
//            listData.add(imageMsTest);
//        }
        gridLayoutManager = new GridLayoutManager(this, 4);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        //设置分割线
        recyclerView.addItemDecoration(new GridDecoration((int) 20));
        itemRecViewAdapter = new ItemRecViewAdapter(this, listData);
        recyclerView.setAdapter(itemRecViewAdapter);

        ArrayList<ImageMsTest> listData2 = new ArrayList<>();
        for (int i = 0; i < 68; i++) {
            ImageMsTest imageMsTest = new ImageMsTest();
            imageMsTest.setName("第"+i);
            listData2.add(imageMsTest);
        }
        listData.addAll(listData2);
        itemRecViewAdapter.notifyDataSetChanged();


        //在加载数据之前配置
//        recyclerView.setLayoutManager(gridLayoutManager);
//        //创建一个适配器
//        myAdapter = new MyAdapter();
//        recyclerView.setAdapter(myAdapter);
    }

    MyAdapter myAdapter;

    public void btnAll(View view) {
        ArrayList<ImageMsTest> imgs=itemRecViewAdapter.getselect();
        for(ImageMsTest img:imgs){
            Log.e("选择--->",""+img.getName() );
        }
    }

    boolean ishsow;
    public void btnner(View view) {
        if(!ishsow){
            ishsow=true;
        }else  ishsow=false;
        itemRecViewAdapter.isshowSelect(ishsow);
    }
}
