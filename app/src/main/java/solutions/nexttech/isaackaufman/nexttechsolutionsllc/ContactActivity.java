package solutions.nexttech.isaackaufman.nexttechsolutionsllc;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by Sweg on 5/15/2016.
 */
public class ContactActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
    }

    public void onCallButtonClicked(View view) {
        Intent call = new Intent(Intent.ACTION_DIAL);
        call.setData(Uri.parse("tel:8603337834"));
        startActivity(call);
    }

    public void onEmailButtonClicked(View view) {
        Intent email = new Intent(Intent.ACTION_SEND, Uri.parse("mailto:"));
        email.putExtra(Intent.EXTRA_EMAIL, "info@nexttech.solutions");
        email.setType("message/rfc822");
        startActivity(Intent.createChooser(email, "Send Email"));
    }
}
