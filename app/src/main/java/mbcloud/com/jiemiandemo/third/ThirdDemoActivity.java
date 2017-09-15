package mbcloud.com.jiemiandemo.third;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import mbcloud.com.jiemiandemo.R;
import mbcloud.com.jiemiandemo.fragment.BorrowFragment;
import mbcloud.com.jiemiandemo.fragment.HelpFragment;
import mbcloud.com.jiemiandemo.fragment.SearchFragment;
import mbcloud.com.jiemiandemo.fragment.StoreFragment;

/**
 * http://www.mamicode.com/info-detail-1563393.html
 */
public class ThirdDemoActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    private List<Fragment> list;
    private MyAdapter adapter;
    private String[] titles = {"主页", "群组", "搜索", "消息", "更多"};
    private int images[] = {R.drawable.home_selector, R.drawable.home_selector, R.drawable.home_selector, R.drawable.home_selector, R.drawable.home_selector};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_demo);
        //实例化
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        tabLayout = (TabLayout) findViewById(R.id.tablayout);
        //页面，数据源
        list = new ArrayList<>();
        list.add(new SearchFragment());
        list.add(new StoreFragment());
        list.add(new BorrowFragment());
        list.add(new HelpFragment());
        list.add(new HelpFragment());
        //ViewPager的适配器
        adapter = new MyAdapter(getSupportFragmentManager(), this);
        viewPager.setAdapter(adapter);
        //绑定
        tabLayout.setupWithViewPager(viewPager);
        //设置自定义视图
        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            TabLayout.Tab tab = tabLayout.getTabAt(i);
            tab.setCustomView(adapter.getTabView(i));
        }
    }

    class MyAdapter extends FragmentPagerAdapter {

        private Context context;

        public MyAdapter(FragmentManager fm, Context context) {
            super(fm);
            this.context = context;
        }

        @Override
        public Fragment getItem(int position) {
            return list.get(position);
        }

        @Override
        public int getCount() {
            return list.size();
        }

        /**
         * 自定义方法，提供自定义Tab
         *
         * @param position 位置
         * @return 返回Tab的View
         */
        public View getTabView(int position) {
            View v = LayoutInflater.from(context).inflate(R.layout.tab_custom, null);
            TextView textView = (TextView) v.findViewById(R.id.tv_title);
            ImageView imageView = (ImageView) v.findViewById(R.id.iv_icon);
            textView.setText(titles[position]);
            imageView.setImageResource(images[position]);
            //添加一行，设置颜色
            textView.setTextColor(tabLayout.getTabTextColors());//
            return v;
        }

    }

}
