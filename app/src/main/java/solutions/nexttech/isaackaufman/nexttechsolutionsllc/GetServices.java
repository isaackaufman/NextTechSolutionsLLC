package solutions.nexttech.isaackaufman.nexttechsolutionsllc;

import android.os.AsyncTask;
import android.widget.TextView;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by Sweg on 3/13/2016.
 */
public class GetServices extends AsyncTask <String, String, ArrayList<ArrayList<String>>> {

    public TextView[] views;

    @Override
    protected ArrayList<ArrayList<String>> doInBackground(String... uri) {
        String responseString = "";
        try {
            URL url = new URL(uri[0]);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            responseString = readStream(in);
        } catch (IOException e) {
            e.printStackTrace();
        }

        ArrayList<ArrayList<String>> services = parseServices(responseString);

        return services;
    }

    private String readStream(InputStream is) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader r = new BufferedReader(new InputStreamReader(is),1000);
        for (String line = r.readLine(); line != null; line =r.readLine()){
            sb.append(line);
        }
        is.close();
        return sb.toString();
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

            // build the plaintext String for the service description
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

    @Override
    protected void onPreExecute() {}

    @Override
    protected void onPostExecute(ArrayList<ArrayList<String>> result) {


    }

    @Override
    protected void onProgressUpdate(String... values) {

    }
}
