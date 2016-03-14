package solutions.nexttech.isaackaufman.nexttechsolutionsllc;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by Sweg on 3/13/2016.
 */
public class BrowseServicesActivity extends Activity {

    private String html;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse_services);

        final TextView textView = (TextView) findViewById(R.id.htmlText);
        GetServices servicesTask = (GetServices) new GetServices(new GetServices.AsyncResponse(){
            @Override
            public void processFinish (String output)
            {
                // TODO process html into readable and formatted entries
                textView.setText(output);
            }

        }).execute("http://nexttech.solutions/home.html");
    }




}
