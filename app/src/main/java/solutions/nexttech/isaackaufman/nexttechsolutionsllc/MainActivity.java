package solutions.nexttech.isaackaufman.nexttechsolutionsllc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onBrowseButtonClicked(View view) {
        Intent i = new Intent(MainActivity.this, BrowseServicesActivity.class);
        startActivity(i);
    }

    public void onScheduleButtonClicked(View view) {
        Intent i = new Intent(MainActivity.this, ScheduleAppointmentActivity.class);
        startActivity(i);
    }

    public void onQuoteButtonClicked(View view) {
        Intent i = new Intent(MainActivity.this, QuoteActivity.class);
        startActivity(i);
    }

    public void onDiscoverButtonClicked(View view) {
        Intent i = new Intent(MainActivity.this, DiscoverToolsActivity.class);
        startActivity(i);
    }


    public void onContactButtonClicked(View view) {
        Intent i = new Intent(MainActivity.this, ContactActivity.class);
        startActivity(i);
    }
}
