package solutions.nexttech.isaackaufman.nexttechsolutionsllc;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by Sweg on 4/27/2016.
 */
public class DisplayServiceActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_service);

        Bundle extras = getIntent().getExtras();

        TextView name = (TextView) findViewById(R.id.service_name);
        TextView desc = (TextView) findViewById(R.id.service_description);
        name.setText(extras.getString("name"));
        desc.setText(extras.getString("desc"));

    }
}
