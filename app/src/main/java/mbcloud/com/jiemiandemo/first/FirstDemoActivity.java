package mbcloud.com.jiemiandemo.first;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import mbcloud.com.jiemiandemo.R;
import mbcloud.com.jiemiandemo.adapter.CustomViewPagerAdapter;
import mbcloud.com.jiemiandemo.fragment.BorrowFragment;
import mbcloud.com.jiemiandemo.fragment.HelpFragment;
import mbcloud.com.jiemiandemo.fragment.SearchFragment;
import mbcloud.com.jiemiandemo.fragment.StoreFragment;

import static mbcloud.com.jiemiandemo.R.id.test_viewpager;

public class FirstDemoActivity extends AppCompatActivity {
    @BindView(R.id.rb_search)
    RadioButton rb_search;//约球按钮
    @BindView(R.id.rb_store)
    RadioButton rb_store;//球队按钮
    @BindView(R.id.rb_borrowed)
    RadioButton rb_borrowed;//发现按钮rb_borrowed
    @BindView(R.id.rb_help)
    RadioButton rb_help;//我的按钮
    @BindView(test_viewpager)
    ViewPager mViewPager;

    private List<Fragment> fragments = new ArrayList<>();
    private SearchFragment mSearchFragment;//约球fragment
    private StoreFragment mStoreFragment;//球队fragment
    private BorrowFragment mBorrowedFragment;//发现fragment
    private HelpFragment mHelpFragment;//我的fragment

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_demo);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        mSearchFragment = new SearchFragment();
        mStoreFragment = new StoreFragment();
        mBorrowedFragment = new BorrowFragment();
        mHelpFragment = new HelpFragment();
        fragments.add(mSearchFragment);
        fragments.add(mStoreFragment);
        fragments.add(mBorrowedFragment);
        fragments.add(mHelpFragment);
        mViewPager.setAdapter(new CustomViewPagerAdapter(getSupportFragmentManager(), fragments));
        mViewPager.setOffscreenPageLimit(1);
        mViewPager.setCurrentItem(0);
        rb_search.setChecked(Boolean.TRUE);
        mViewPager.addOnPageChangeListener(new viewPagerPageChangeListener());
    }

    @OnClick({
            R.id.rb_search, R.id.rb_store, R.id.rb_borrowed, R.id.rb_help})
    void click(View view) {
        switch (view.getId()) {
            case R.id.rb_search:
                mViewPager.setCurrentItem(0);
                break;
            case R.id.rb_store:
                mViewPager.setCurrentItem(1);
                break;
            case R.id.rb_borrowed:
                mViewPager.setCurrentItem(2);
                break;
            case R.id.rb_help:
                mViewPager.setCurrentItem(3);
                break;

        }
    }

    class viewPagerPageChangeListener extends ViewPager.SimpleOnPageChangeListener {

        @Override
        public void onPageSelected(int position) {
            switch (position) {
                case 0:
                    rb_search.setChecked(Boolean.TRUE);
                    break;
                case 1:
                    rb_store.setChecked(Boolean.TRUE);
                    break;
                case 2:
                    rb_borrowed.setChecked(Boolean.TRUE);
                    break;
                case 3:
                    rb_help.setChecked(Boolean.TRUE);
                    break;
            }
        }

    }

}
