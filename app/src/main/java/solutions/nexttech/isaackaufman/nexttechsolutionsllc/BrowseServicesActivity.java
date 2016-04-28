package solutions.nexttech.isaackaufman.nexttechsolutionsllc;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Service;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

/**
 * Created by Sweg on 3/13/2016.
 */
public class BrowseServicesActivity extends Activity {

    public ArrayList<ArrayList<String>> services;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse_services);

        final ScrollView scrollView = (ScrollView) findViewById(R.id.scrollView);
        ViewGroup linLay = (ViewGroup) findViewById(R.id.linLay);

        try {
            services = new GetServices().execute("http://nexttech.solutions/home.html").get();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        float scale = getResources().getDisplayMetrics().density;
        int dpImgHeight = (int) (75 * scale + 0.5f);
        int dpHeight = (int) (50 * scale + 0.5f);
        int dpWidth = (int) (300 * scale + 0.5f);

        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(dpWidth, LinearLayout.LayoutParams.WRAP_CONTENT);
        lp.setMargins(0, 0, 0, dpHeight / 2);
        lp.gravity = Gravity.CENTER;

        for (int i = 0; i < services.get(0).size(); i++)
        {
            final String name = services.get(0).get(i);
            final String desc = services.get(1).get(i);
            final Button btn = new Button(this);

            btn.setText(name);
            btn.setTextColor(0xFFFFFFFF);
            linLay.addView(btn);
            btn.setLayoutParams(lp);
            btn.setBackgroundColor(0xFF0064c1);

            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getBaseContext(), DisplayServiceActivity.class);
                    intent.putExtra("name", name);
                    intent.putExtra("desc", desc);
                    startActivity(intent);
                }
            });
        }

    }
}
