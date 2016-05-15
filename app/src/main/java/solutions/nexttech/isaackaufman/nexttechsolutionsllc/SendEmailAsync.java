package solutions.nexttech.isaackaufman.nexttechsolutionsllc;

import android.os.AsyncTask;

/**
 * Created by Sweg on 5/14/2016.
 */
public class SendEmailAsync extends AsyncTask<String, String, String> {

    protected String doInBackground (String... uri)
    {
        try {
            GMailSender sender = new GMailSender("nexttechbot@gmail.com", "Westorbit23$");
            sender.sendMail(uri[0] + " Request for Appt",
                    "Issue: " + uri[4] + "\n" + uri[5] + ": " + uri[1] + "\nPreferred Date/Time: " + uri[2] + " @ " + uri[3],
                    "nexttechbot@gmail.com",
                    "info@nexttech.solutions");
        }
        catch (Exception e)
        {
            return "failure";
        }
    return "success";
    }
}
