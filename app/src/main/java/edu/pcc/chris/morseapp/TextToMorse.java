package edu.pcc.chris.morseapp;

import android.media.AudioManager;
import android.media.ToneGenerator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

public class TextToMorse extends AppCompatActivity {

    private static final String LOG_TAG = "TextToMorse.class: ";
    ToneGenerator toneGenerator;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_text_to_morse);
        toneGenerator = new ToneGenerator(AudioManager.STREAM_SYSTEM, 75);
    }


    public void convertTextToMorseArray(View view) {

        ArrayList<String> morseArray = new ArrayList<String>();
        StringBuilder tempString = new StringBuilder();
        MorseTranslator translator = new MorseTranslator();
        EditText userInputView = (EditText) findViewById(R.id.input_text);

        String inputString = userInputView.getText().toString();
        inputString = inputString.toUpperCase();

        Log.d(LOG_TAG, "input string: " + inputString);

        for (Integer i = 0; i < inputString.length(); i++) {
            char inputChar = inputString.charAt(i);

            if (Character.toString(inputChar).equals(" ")) {
                morseArray.add(tempString.toString());
                tempString.delete(0, tempString.length());
            } else if (translator.hasKey(inputChar)) {
                tempString.append(translator.getKeyValue(inputChar));

                if (i == inputString.length() - 1) {
                    morseArray.add(tempString.toString());
                    tempString.delete(0, tempString.length());
                }
            } else {
                Log.d(LOG_TAG, "Unvalidated input was accepted by TextToMorse.convertTextToMorseArray()");
            }
        }

        for (int i = 0; i < morseArray.size(); i++) {
            String morseOutput = morseArray.get(i);
            Log.d(LOG_TAG, morseOutput);
        }
    }

    private void playMorse(ArrayList morseArray) {
        
    }
}
