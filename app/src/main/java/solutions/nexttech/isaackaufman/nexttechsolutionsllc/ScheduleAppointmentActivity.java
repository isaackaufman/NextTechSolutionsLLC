package solutions.nexttech.isaackaufman.nexttechsolutionsllc;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Sweg on 3/13/2016.
 */
public class ScheduleAppointmentActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_appointment);
        Button btn = (Button) findViewById(R.id.submit);
        final Spinner spin = (Spinner) findViewById(R.id.spinner);

        spin.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {

            EditText contactView = (EditText) findViewById(R.id.contact);

            public void onNothingSelected(AdapterView<?> parent){}


            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id)
            {
                if (id == 2)
                {
                    contactView.setHint("Email Address");
                    contactView.setInputType(InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);
                }
                else
                {
                    contactView.setHint("Phone number");
                    contactView.setInputType(InputType.TYPE_CLASS_PHONE);
                }
            }

        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView nameView = (TextView) findViewById(R.id.name);
                TextView contactView = (TextView) findViewById(R.id.contact);
                TextView dateView = (TextView) findViewById(R.id.date);
                TextView timeView = (TextView) findViewById(R.id.time);
                TextView descView = (TextView) findViewById(R.id.description);

                String name, date, contact, time, desc, method;
                name = nameView.getText().toString();
                contact = contactView.getText().toString();
                date = dateView.getText().toString();
                time = timeView.getText().toString();
                desc = descView.getText().toString();
                switch (spin.getId()){
                    case (0):
                        method = "Call";
                        break;
                    case (1):
                        method = "Text";
                        break;
                    case (2):
                        method = "Email";
                        break;
                    default:
                        method = "Call";
                }



                if (name.equals("") || contact.equals("") || date.equals("") || time.equals("") || desc.equals("")) {
                    Toast.makeText(getApplicationContext(), "Please fill out all fields", Toast.LENGTH_SHORT).show();
                } else {
                    try {
                        String result = new SendEmailAsync().execute(name, contact, date, time, desc, method).get();
                        if (result == "success") {
                            Toast.makeText(getApplicationContext(), "Success! Expect a confirmation within 24 hours!", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(getApplicationContext(), "Error connecting with the server.", Toast.LENGTH_LONG).show();
                        }


                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }
}
