package com.example.myfirstapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    /*  An Intent can carry data types as key-value pairs called extras. Your key is a public
        constant EXTRA_MESSAGE because the next activity uses the key to retrive the text value.
        It's a good practice to define keys for intent extras using your app's package name as a
        prefix. This ensures the keys are unique, in case your app interacts with other apps.*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    /* This method is called when a user clicks the Send Button attribute in activity_main.xml */
    public void sendMessage(View view){
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.edit_message);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message); /* We need an EXTRA_MESSAGE public constant -KP */
        /* The putExtra() method adds the EditText's value to the intent. */
        startActivity(intent); /* calls a new activity, in this case the DisplayMessageActivity as
        initially defined in the Intent intent declaration. -KP */
    }

}
    /*

An Intent is an object that provides runtime binding between separate components (such as two
activities). The Intent represents an app’s "intent to do something." You can use intents for a
wide variety of tasks, but in this lesson, your intent starts another activity.

An error remains for DisplayMessageActivity, but that's okay; you'll fix that in the next section.

There’s a lot going on in sendMessage(), so let’s explain what's going on.

The Intent constructor takes two parameters:

A Context as its first parameter (this is used because the Activity class is a subclass of Context)
The Class of the app component to which the system should deliver the Intent (in this case, the
activity that should be started). Note: The reference to DisplayMessageActivity will raise an error
in Android Studio because the class doesn’t exist yet. Ignore the error for now; you’ll create the
class soon.

The startActivity() method starts an instance of the DisplayMessageActivity specified by the Intent.
 Now you need to create the class.

*/

