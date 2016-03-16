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

    private ArrayList<ArrayList<String>> parseServices (String html)
    {
        ArrayList<String> serviceNames = new ArrayList<String>();
        ArrayList<String> serviceDescriptions = new ArrayList<String>();
        String service = "";
        String name = "";
        int startIndex;
        int endIndex;

        // keep track of where we are in the html document
        int curPos = 0;
        while ((startIndex = html.indexOf("<h2>", curPos)) != -1)
        {
            endIndex = html.indexOf("</h2>", startIndex);

            // grab service name and trim off <h2> and </h2>
            name = html.substring(startIndex + 4, endIndex);
            serviceNames.add(name);

            // grab service description
            // TODO figure out the best way to get text from between <ul> tags



        }

        ArrayList<ArrayList<String>> services = new ArrayList<ArrayList<String>>(2);
        services.add(serviceNames);
        services.add(serviceDescriptions);
        return services;
    }



}
