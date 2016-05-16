package solutions.nexttech.isaackaufman.nexttechsolutionsllc;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by Sweg on 3/13/2016.
 */
public class DiscoverToolsActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discover_tools);
    }

    public void onMbamButtonClicked(View view) {
        String url = "https://www.malwarebytes.org/mwb-download/";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }

    public void onCcleanerButtonClicked(View view) {
        String url = "https://www.piriform.com/ccleaner/download";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }

    public void onAdwcleanerButtonClicked(View view) {
        String url = "http://www.bleepingcomputer.com/download/adwcleaner/";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }

    public void onSpeccyButtonClicked(View view) {
        String url = "https://www.piriform.com/speccy";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }

    public void onRecuvaButtonClicked(View view) {
        String url = "https://www.piriform.com/recuva";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }
}
