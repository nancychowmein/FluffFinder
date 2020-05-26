package com.example.android.flufffinder;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the Find Your Fluff button is clicked and the quiz is submitted.
     */
    public void submitQuiz(View view) {
        // Get the user's name they have input into the field
        EditText nameField = findViewById(R.id.name);
        String name = nameField.getText().toString();

        // Figure out if user wants a small fluff
        CheckBox smallCheckBox = (CheckBox) findViewById(R.id.small_checkbox);
            boolean wantsSmall = smallCheckBox.isChecked();

        // Figure out if user wants a medium fluff
        CheckBox mediumCheckBox = (CheckBox) findViewById(R.id.medium_checkbox);
        boolean wantsMedium = mediumCheckBox.isChecked();

        // Figure out if user wants a large fluff
        CheckBox largeCheckBox = (CheckBox) findViewById(R.id.large_checkbox);
        boolean wantsLarge = largeCheckBox.isChecked();

        String message = createQuizResult(wantsSmall, wantsMedium, wantsLarge, name);

        displayMessage(message);

    }

    /**
     *
     * @param name displays name of user
     * @param wantsSmall if user wants small fluff
     * @param wantsMedium if user wants medium fluff
     * @param wantsLarge if user wants large fluff
     * @return text summary of the quiz result
     */
    private String createQuizResult(boolean wantsSmall, boolean wantsMedium, boolean wantsLarge, String name){
        String message = "Name: ";
        message += name;
        message += "\nSmall fluff? " + wantsSmall;
        message += "\nMedium fluff? " + wantsMedium;
        message += "\nLarge fluff? " + wantsLarge;
        // Toast.makeText(this, "Name " + name, Toast.LENGTH_SHORT).show();
        return message;
    }

    /**
     * This determines the response to the home type question.
     */
    public void homeRadioButtonClicked(View view) {
        // Check if radio button is clicked for Home group
        boolean checked = ((RadioButton)view).isChecked();

        // Check which radio button was clicked in Home group
        switch (view.getId()) {
            case R.id.home_apartment:
                if (checked)
                    // Lives in apartment or condo
                    Toast.makeText(this, "You live in an apartment or condo", Toast.LENGTH_SHORT).show();
                break;
            case R.id.home_no_yard:
                if (checked)
                    // Lives in home with no yard
                    Toast.makeText(this, "You live in a house without a yard", Toast.LENGTH_SHORT).show();
                break;
            case R.id.home_yard:
                if (checked)
                    // Lives in home with yard
                    Toast.makeText(this, "You live in a house with a yard", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    /**
     * This method displays the summary of the quiz results.
     */
    private void displayMessage(String message){
        TextView quizSummaryTextView = (TextView) findViewById(R.id.quiz_summary);
              quizSummaryTextView.setText(message);
    }


}

