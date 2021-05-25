package io.thorvalld.nativeandroidtest;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.gauravk.bubblenavigation.BubbleNavigationLinearView;
import com.gauravk.bubblenavigation.listener.BubbleNavigationChangeListener;

import io.thorvalld.nativeandroidtest.fragments.BlankFragment;
import io.thorvalld.nativeandroidtest.fragments.ControlFragment;
import io.thorvalld.nativeandroidtest.fragments.Dashboard;


public class Home extends AppCompatActivity {

    FragmentTransaction fragmentTransaction;
    BubbleNavigationLinearView bubbleNavigationLinearView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        bubbleNavigationLinearView = findViewById(R.id.bottom_navigation_view_linear);

        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragmentContainer, new Dashboard());
        fragmentTransaction.commit();

        bubbleNavigationLinearView.setNavigationChangeListener(new BubbleNavigationChangeListener() {
            @Override
            public void onNavigationChanged(View view, int position) {
                switch (position){
                    case 0:
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.fragmentContainer, new Dashboard());
                        fragmentTransaction.commit();
                        break;
                    case 2:
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.fragmentContainer, new ControlFragment());
                        fragmentTransaction.commit();
                        break;
                    default:
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.fragmentContainer, new BlankFragment());
                        fragmentTransaction.commit();
                        break;
                }
            }
        });

    }
}
