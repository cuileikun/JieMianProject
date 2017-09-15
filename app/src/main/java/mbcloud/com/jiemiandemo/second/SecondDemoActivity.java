package mbcloud.com.jiemiandemo.second;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import mbcloud.com.jiemiandemo.R;
import mbcloud.com.jiemiandemo.fragment.BorrowFragment;
import mbcloud.com.jiemiandemo.fragment.FragmentTabHost;
import mbcloud.com.jiemiandemo.fragment.HelpFragment;
import mbcloud.com.jiemiandemo.fragment.StoreFragment;

public class SecondDemoActivity extends AppCompatActivity {
    @BindView(android.R.id.tabhost)
    FragmentTabHost mTabHost;
    private String[] mTextViewArray = {"约球", "球队", "发现", "我"};
    private Class fragmentArray[] = {BorrowFragment.class, StoreFragment.class, BorrowFragment.class, HelpFragment.class};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_demo);
        ButterKnife.bind(this);
        mTabHost.setup(this, getSupportFragmentManager(), R.id.real_content);
        for (int i = 0; i < 4; i++) {
            TabHost.TabSpec spec = mTabHost.newTabSpec(mTextViewArray[i]).setIndicator(getTabItemView(i));
            mTabHost.addTab(spec, fragmentArray[i], null);
        }
        mTabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String s) {
                for (int i = 0; i < 4; i++) {
                    if (((String) mViews[i].getTag()).equals(s)) {
                        ((ImageView) mViews[i].findViewById(R.id.img)).setImageResource(R.drawable.tab_bq_icon_selected);
                        ((TextView) mViews[i].findViewById(R.id.text)).setTextColor(0xff288bf0);
                    } else {
                        ((ImageView) mViews[i].findViewById(R.id.img)).setImageResource(R.drawable.tab_bq_icon_unselected);
                        ((TextView) mViews[i].findViewById(R.id.text)).setTextColor(0xff666666);
                    }
                }
            }
        });
    }

    private View mViews[] = new View[4];

    private View getTabItemView(int i) {
        View view = LayoutInflater.from(this).inflate(R.layout.activity_main_tab_itme, null);
        if (i == 0) {
            ((ImageView) view.findViewById(R.id.img)).setImageResource(R.drawable.tab_bq_icon_selected);
            ((TextView) view.findViewById(R.id.text)).setTextColor(0xff288bf0);
        } else {
            ((ImageView) view.findViewById(R.id.img)).setImageResource(R.drawable.tab_bq_icon_unselected);
            ((TextView) view.findViewById(R.id.text)).setTextColor(0xff666666);
        }
        view.setTag(mTextViewArray[i]);
        mViews[i] = view;
        ((TextView) view.findViewById(R.id.text)).setText(mTextViewArray[i]);
        return view;
    }


}
