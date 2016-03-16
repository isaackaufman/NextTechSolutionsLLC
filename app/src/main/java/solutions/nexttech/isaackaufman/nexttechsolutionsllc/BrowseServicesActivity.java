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
                ArrayList<ArrayList<String>> services = parseServices(output);
                for (int i = 0; i < services.get(0).size(); i++)
                {
                    // Add textViews for each service
                }
                System.out.println(services.get(0).get(0) + ": " + services.get(1).get(0));
            }

        }).execute("http://nexttech.solutions/home.html");

    }

    private ArrayList<ArrayList<String>> parseServices (String html)
    {
        ArrayList<String> serviceNames = new ArrayList<String>();
        ArrayList<String> serviceDescriptions = new ArrayList<String>();
        String name = "";
        int nameStartIndex, nameEndIndex, ulStartIndex, ulEndIndex, liStartIndex, liEndIndex;

        // keep track of where we are in the html document
        int curPos = 0;

        while ((nameStartIndex = html.indexOf("<h2>", curPos)) != -1)
        {
            nameEndIndex = html.indexOf("</h2>", nameStartIndex);

            // grab service name and trim off <h2> and </h2>
            name = html.substring(nameStartIndex + 4, nameEndIndex);
            serviceNames.add(name);

            // grab service description
            ulStartIndex = html.indexOf("<ul", nameEndIndex);
            ulEndIndex = html.indexOf("</ul>", ulStartIndex);
            liEndIndex = ulStartIndex;
            StringBuilder service = new StringBuilder();
            while ((liStartIndex = html.indexOf("<li>", liEndIndex)) != -1 && liStartIndex < ulEndIndex)
            {
                liEndIndex = html.indexOf("</li>", liStartIndex);
                service.append(html.substring(liStartIndex + 4, liEndIndex) + "\n");
            }
            serviceDescriptions.add(service.toString());
            curPos = ulEndIndex;
        }
        ArrayList<ArrayList<String>> serv = new ArrayList<ArrayList<String>>(2);
        serv.add(serviceNames);
        serv.add(serviceDescriptions);
        return serv;
    }



}
