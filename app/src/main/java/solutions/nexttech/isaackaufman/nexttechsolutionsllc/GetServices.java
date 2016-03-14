package solutions.nexttech.isaackaufman.nexttechsolutionsllc;

import android.os.AsyncTask;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Sweg on 3/13/2016.
 */
public class GetServices extends AsyncTask <String, String, String> {

    public interface AsyncResponse {
        void processFinish(String output);
    }

    public AsyncResponse delegate = null;

    public GetServices(AsyncResponse delegate){
        this.delegate = delegate;
    }

    @Override
    protected String doInBackground(String... uri) {
        String responseString = "";
        try {
            URL url = new URL(uri[0]);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            responseString = readStream(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return responseString;
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

    @Override
    protected void onPostExecute(String result) {
        delegate.processFinish(result);
    }
}
