package edu.pcc.chris.morseapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/**
 * An app that plays back morse sounds for letters and numbers. The app also displays image of the
 * morse code (dots and dashes), as well as displaying a phonetic word label (alpha, charlie, delta).
 * Spanish language is supported, as well as portrait and landscape views. LDPI is supported (in
 * portrait mode only).
 */

public class MorseApp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        startActivity(new Intent(this, MorseKeyboard.class));
    }
}

