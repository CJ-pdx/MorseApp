package edu.pcc.chris.morseapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.util.Log;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class TextToMorse extends AppCompatActivity {

    private static final int DEFAULT_VOLUME_PROGRESS = 75;
    private static final int DEFAULT_PITCH_PROGRESS = 0;

    private static final String LOG_TAG = "TextToMorse.class: ";
    private MorseTranslator translator;
    private int currentPitchValue;
    private int currentVolumeValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_text_to_morse);

        translator = new MorseTranslator();

        currentPitchValue = DEFAULT_PITCH_PROGRESS;
        SeekBar pitchSeekBar = findViewById(R.id.pitch_seekbar);
        TextView pitchLabel = findViewById(R.id.pitch_label);
        pitchSeekBar.setProgress(DEFAULT_PITCH_PROGRESS);
        pitchLabel.setText(R.string.pitch_level_one);

        currentVolumeValue = DEFAULT_VOLUME_PROGRESS;
        SeekBar volumeSeekBar = findViewById(R.id.volume_seekbar);
        volumeSeekBar.setProgress(DEFAULT_VOLUME_PROGRESS);
        TextView volumeLabel = findViewById(R.id.volume_label);
        volumeLabel.setText(String.format(getString(R.string.volume_label_value), DEFAULT_VOLUME_PROGRESS));

        pitchSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar pitchSeekBar, int progress, boolean fromUser) {

                TextView pitchLabel = findViewById(R.id.pitch_label);

                switch(progress) {

                    case 0:
                        pitchLabel.setText(R.string.pitch_level_one);
                        currentPitchValue = progress;
                        break;
                    case 1:
                        pitchLabel.setText(R.string.pitch_level_two);
                        currentPitchValue = progress;
                        break;
                    case 2:
                        pitchLabel.setText(R.string.pitch_level_three);
                        currentPitchValue = progress;
                        break;
                    case 3:
                        pitchLabel.setText(R.string.pitch_level_four);
                        currentPitchValue = progress;
                        break;
                    case 4:
                        pitchLabel.setText(R.string.pitch_level_five);
                        currentPitchValue = progress;
                        break;
                    case 5:
                        pitchLabel.setText(R.string.pitch_level_six);
                        currentPitchValue = progress;
                        break;
                    case 6:
                        pitchLabel.setText(R.string.pitch_level_seven);
                        currentPitchValue = progress;
                        break;
                    default:
                        pitchLabel.setText(R.string.pitch_level_one);
                        currentPitchValue = progress;
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) { }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) { }
        });

        volumeSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                TextView volumeLabel = findViewById(R.id.volume_label);
                volumeLabel.setText(String.format(getString(R.string.volume_label_value), progress));
                currentVolumeValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menu_about:
                startActivity(new Intent(this, About.class));
                return true;
            case R.id.menu_settings:
                Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menu_morse_keyboard_activity:
                startActivity(new Intent(this, MorseKeyboard.class));
            case R.id.menu_text_to_morse_activity:
                startActivity(new Intent(this, TextToMorse.class));
        }

        return super.onOptionsItemSelected(item);
    }

    public void playMorse(View view) throws InterruptedException {

        MorsePlayer player = new MorsePlayer(getVolumeSeekValue());

        EditText userInputView = findViewById(R.id.input_text);
        String inputString = userInputView.getText().toString();
        inputString = inputString.toUpperCase();

        ArrayList morseArray = translator.translateToMorse(inputString);

        if(morseArray != null) {
            Log.d(LOG_TAG, "Beginning morseArray playback");
            player.playMorse(morseArray, getPitchSeekValue());
        }
        else {
            Toast.makeText(this, "Invalid input: Only letters, numbers, and spaces" +
                    " are permitted.", Toast.LENGTH_SHORT).show();
            player.releasePlayer();
        }
    }

    public int getPitchSeekValue() {
        return currentPitchValue;
    }
    public int getVolumeSeekValue() {
        return currentVolumeValue;
    }

}

