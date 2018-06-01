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

import static android.media.ToneGenerator.TONE_DTMF_1;

public class TextToMorse extends AppCompatActivity {

    private static final String LOG_TAG = "TextToMorse.class: ";
    ToneGenerator toneGenerator;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_text_to_morse);
    }


    public void convertTextToMorseArray(View view) throws InterruptedException {

        ArrayList<String> morseArray = new ArrayList<String>();
        MorseTranslator translator = new MorseTranslator();

        EditText userInputView = (EditText) findViewById(R.id.input_text);
        String inputString = userInputView.getText().toString();
        //add input validation later (accept numbers and letters only,
        // and limit number of characters)
        inputString = inputString.toUpperCase();

        Log.d(LOG_TAG, "input string: " + inputString);

        for (Integer i = 0; i < inputString.length(); i++) {
            char inputChar = inputString.charAt(i);

            if (Character.toString(inputChar).equals(" ")) {
                morseArray.add("|");
            }

            else if (translator.hasKey(inputChar)) {
                morseArray.add(translator.getKeyValue(inputChar));
            }

            else {
                Log.d(LOG_TAG, "Unvalidated input was accepted by TextToMorse.convertTextToMorseArray()");
            }
        }

        for (int i = 0; i < morseArray.size(); i++) {
            String morseOutput = morseArray.get(i);
            Log.d(LOG_TAG, morseOutput);
        }

        playMorse(morseArray);
    }

    private void playMorse(ArrayList morseArray) throws InterruptedException {

        toneGenerator = new ToneGenerator(AudioManager.STREAM_SYSTEM, 100);
        int pitch = TONE_DTMF_1; //slider bar to select pitch will go here

        for (int i = 0; i < morseArray.size(); i++) {
            String morseLetterString = morseArray.get(i).toString();

            if (morseLetterString.charAt(0) == '|') {
                Thread.sleep(700);
                continue;
            }

            for (int ii = 0; ii < morseLetterString.length(); ii++) {

                if (morseLetterString.charAt(ii) == '.') {
                    toneGenerator.startTone(pitch, 100);
                    Log.d(LOG_TAG, "Attempted to play dit sound");
                    Thread.sleep(400);

                } else if (morseLetterString.charAt(ii) == '-') {
                    toneGenerator.startTone(pitch, 300);
                    Log.d(LOG_TAG, "Attempted to play dah sound");
                    Thread.sleep(600);

                } else {
                    Log.d(LOG_TAG, "Unidentified character found in TextToMorse.playMorse()");
                }
            }
        }

        toneGenerator.release();
    }
}

