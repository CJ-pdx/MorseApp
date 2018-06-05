package edu.pcc.chris.morseapp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MorseKeyboard extends AppCompatActivity {

    private ArrayList<MorseLetter> morseLetterList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_morse_keyboard);
        initMorseLetters();
        addMorseLetters();
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
                Toast.makeText(this, "About", Toast.LENGTH_SHORT).show();
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

    /**
     * Populate a list of morseLetter objects
     */
    private void initMorseLetters() {
        morseLetterList = new ArrayList<>();

        morseLetterList.add(new MorseLetter(this, R.drawable.a, R.raw.a,
                R.string.buttonText_A, R.string.labelText_A));

        morseLetterList.add(new MorseLetter(this, R.drawable.b, R.raw.b,
                R.string.buttonText_B, R.string.labelText_B));

        morseLetterList.add(new MorseLetter(this, R.drawable.c, R.raw.c,
                R.string.buttonText_C, R.string.labelText_C));

        morseLetterList.add(new MorseLetter(this, R.drawable.d, R.raw.d,
                R.string.buttonText_D, R.string.labelText_D));

        morseLetterList.add(new MorseLetter(this, R.drawable.e, R.raw.e,
                R.string.buttonText_E, R.string.labelText_E));

        morseLetterList.add(new MorseLetter(this, R.drawable.f, R.raw.f,
                R.string.buttonText_F, R.string.labelText_F));

        morseLetterList.add(new MorseLetter(this, R.drawable.g, R.raw.g,
                R.string.buttonText_G, R.string.labelText_G));

        morseLetterList.add(new MorseLetter(this, R.drawable.h, R.raw.h,
                R.string.buttonText_H, R.string.labelText_H));

        morseLetterList.add(new MorseLetter(this, R.drawable.i, R.raw.i,
                R.string.buttonText_I, R.string.labelText_I));

        morseLetterList.add(new MorseLetter(this, R.drawable.j, R.raw.j,
                R.string.buttonText_J, R.string.labelText_J));

        morseLetterList.add(new MorseLetter(this, R.drawable.k, R.raw.k,
                R.string.buttonText_K, R.string.labelText_K));

        morseLetterList.add(new MorseLetter(this, R.drawable.l, R.raw.l,
                R.string.buttonText_L, R.string.labelText_L));

        morseLetterList.add(new MorseLetter(this, R.drawable.m, R.raw.m,
                R.string.buttonText_M, R.string.labelText_M));

        morseLetterList.add(new MorseLetter(this, R.drawable.n, R.raw.n,
                R.string.buttonText_N, R.string.labelText_N));

        morseLetterList.add(new MorseLetter(this, R.drawable.o, R.raw.o,
                R.string.buttonText_O, R.string.labelText_O));

        morseLetterList.add(new MorseLetter(this, R.drawable.p, R.raw.p,
                R.string.buttonText_P, R.string.labelText_P));

        morseLetterList.add(new MorseLetter(this, R.drawable.q, R.raw.q,
                R.string.buttonText_Q, R.string.labelText_Q));

        morseLetterList.add(new MorseLetter(this, R.drawable.r, R.raw.r,
                R.string.buttonText_R, R.string.labelText_R));

        morseLetterList.add(new MorseLetter(this, R.drawable.s, R.raw.s,
                R.string.buttonText_S, R.string.labelText_S));

        morseLetterList.add(new MorseLetter(this, R.drawable.t, R.raw.t,
                R.string.buttonText_T, R.string.labelText_T));

        morseLetterList.add(new MorseLetter(this, R.drawable.u, R.raw.u,
                R.string.buttonText_U, R.string.labelText_U));

        morseLetterList.add(new MorseLetter(this, R.drawable.v, R.raw.v,
                R.string.buttonText_V, R.string.labelText_V));

        morseLetterList.add(new MorseLetter(this, R.drawable.w, R.raw.w,
                R.string.buttonText_W, R.string.labelText_W));

        morseLetterList.add(new MorseLetter(this, R.drawable.x, R.raw.x,
                R.string.buttonText_X, R.string.labelText_X));
        morseLetterList.add(new MorseLetter(this, R.drawable.y, R.raw.y,
                R.string.buttonText_Y, R.string.labelText_Y));

        morseLetterList.add(new MorseLetter(this, R.drawable.z, R.raw.z,
                R.string.buttonText_Z, R.string.labelText_Z));

        morseLetterList.add(new MorseLetter(this, R.drawable.num0, R.raw.num0,
                R.string.buttonText_0, R.string.labelText_0));

        morseLetterList.add(new MorseLetter(this, R.drawable.num1, R.raw.num1,
                R.string.buttonText_1, R.string.labelText_1));

        morseLetterList.add(new MorseLetter(this, R.drawable.num2, R.raw.num2,
                R.string.buttonText_2, R.string.labelText_2));

        morseLetterList.add(new MorseLetter(this, R.drawable.num3, R.raw.num3,
                R.string.buttonText_3, R.string.labelText_3));

        morseLetterList.add(new MorseLetter(this, R.drawable.num4, R.raw.num4,
                R.string.buttonText_4, R.string.labelText_4));

        morseLetterList.add(new MorseLetter(this, R.drawable.num5, R.raw.num5,
                R.string.buttonText_5, R.string.labelText_5));

        morseLetterList.add(new MorseLetter(this, R.drawable.num6, R.raw.num6,
                R.string.buttonText_6, R.string.labelText_6));

        morseLetterList.add(new MorseLetter(this, R.drawable.num7, R.raw.num7,
                R.string.buttonText_7, R.string.labelText_7));

        morseLetterList.add(new MorseLetter(this, R.drawable.num8, R.raw.num8,
                R.string.buttonText_8, R.string.labelText_8));

        morseLetterList.add(new MorseLetter(this, R.drawable.num9, R.raw.num9,
                R.string.buttonText_9, R.string.labelText_9));
    }

    /**
     * Populate the button grid with morse letters/numbers
     */
    public void addMorseLetters() {
        GridView buttonGrid = (GridView) findViewById(R.id.morse_buttons);
        buttonGrid.setAdapter(
                new ArrayAdapter<MorseLetter>(this, R.layout.morse_letter_cell,
                        R.id.morse_button_label, morseLetterList)
        );

        buttonGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                morseButtonClick(morseLetterList.get(i));
            }
        });
    }

    /**
     * onClick action, displays the morseLetter label (phonetic word), the morse image, and
     * the morseLetter's morse code sound.
     * @param morseLetter a MorseLetter object, assigned to a button in the button grid.
     */
    public void morseButtonClick(MorseLetter morseLetter) {
        ImageView displayImage = (ImageView) findViewById(R.id.display_image);
        TextView mainLabel = (TextView) findViewById(R.id.main_label);
        Integer imageId = 0;
        Integer soundId = 0;
        Integer labelId = 0;

        imageId = morseLetter.getImageId();
        soundId = morseLetter.getSoundId();
        labelId = morseLetter.getLabelId();

        displayImage.setImageResource(imageId);
        mainLabel.setText(labelId);

        if (soundId != 0) {
            MediaPlayer player = MediaPlayer.create(this, soundId);
            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    mediaPlayer.release();
                }
            });
            player.start();
        }
    }
}
