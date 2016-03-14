package solutions.nexttech.isaackaufman.nexttechsolutionsllc;

import android.app.Activity;
import android.app.Service;
import android.os.Bundle;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Sweg on 3/13/2016.
 */
public class BrowseServicesActivity extends Activity {

    private String html;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse_services);

        final ScrollView scrollView = (ScrollView) findViewById(R.id.scrollView);
        ArrayList<TextView> tvList = new ArrayList<TextView>();


        GetServices servicesTask = (GetServices) new GetServices(new GetServices.AsyncResponse(){
            @Override
            public void processFinish (String output)
            {
                // TODO process html into readable and formatted entries
                //for ()
                //scrollView.addView();
            }

        }).execute("http://nexttech.solutions/home.html");
    }

    private ArrayList<String> parseServices (String html)
    {
        ArrayList<String> services = new ArrayList<String>();
        String service = "";
        int startIndex;
        int endIndex;

        // keep track of where we are in the html document
        int curPos = 0;
        while ((startIndex = html.indexOf("<h2>", curPos)) != -1)
        {
            endIndex = html.indexOf("</h2", startIndex);
            curPos = endIndex;

            // trim off <h2> and </h2>
            service = html.substring(startIndex + 4, endIndex);
        }

        return services;
    }



}
