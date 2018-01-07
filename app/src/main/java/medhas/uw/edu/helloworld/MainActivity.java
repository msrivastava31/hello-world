package medhas.uw.edu.helloworld;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            return setTextViewMessage(item.getItemId());
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        setTextViewMessage(navigation.getSelectedItemId());
    }

    private boolean setTextViewMessage(int itemId) {
        switch (itemId) {
            case R.id.navigation_sports:
                mTextMessage.setText(Html.fromHtml(ApplicationConstants.SPORTS_HTML));
                return true;
            case R.id.navigation_music:
                mTextMessage.setText(Html.fromHtml(ApplicationConstants.MUSIC_HTML));
                return true;
            case R.id.navigation_books:
                mTextMessage.setText(Html.fromHtml(ApplicationConstants.BOOKS_HTML));
                return true;
        }

        return false;
    }
}
