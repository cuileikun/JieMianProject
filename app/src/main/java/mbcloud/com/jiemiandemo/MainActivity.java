package mbcloud.com.jiemiandemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import mbcloud.com.jiemiandemo.first.FirstDemoActivity;
import mbcloud.com.jiemiandemo.fouth.FouthDemoActivity;
import mbcloud.com.jiemiandemo.second.SecondDemoActivity;
import mbcloud.com.jiemiandemo.third.ThirdDemoActivity;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.btn_first_method)
    Button btn_first_method;
    @BindView(R.id.btn_second_method)
    Button btn_second_method;
    @BindView(R.id.btn_third_method)
    Button btn_third_method;
    @BindView(R.id.btn_fouth_method)
    Button btn_fouth_method;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({
            R.id.btn_first_method, R.id.btn_second_method, R.id.btn_third_method,R.id.btn_fouth_method})
    void click(View view) {
        switch (view.getId()) {
            case R.id.btn_first_method:
                startActivity(new Intent(MainActivity.this, FirstDemoActivity.class));
                break;
            case R.id.btn_second_method:
                startActivity(new Intent(MainActivity.this, SecondDemoActivity.class));
                break;
            case R.id.btn_third_method:
                startActivity(new Intent(MainActivity.this, ThirdDemoActivity.class));
                break;
            case R.id.btn_fouth_method:
                startActivity(new Intent(MainActivity.this, FouthDemoActivity.class));
                break;
        }
    }


}
