package edu.pcc.chris.morseapp;

import android.media.AudioManager;
import android.media.ToneGenerator;
import android.util.Log;
import java.util.ArrayList;
import static android.media.ToneGenerator.TONE_DTMF_1;
import static android.media.ToneGenerator.TONE_DTMF_2;
import static android.media.ToneGenerator.TONE_DTMF_5;
import static android.media.ToneGenerator.TONE_DTMF_6;
import static android.media.ToneGenerator.TONE_DTMF_9;
import static android.media.ToneGenerator.TONE_DTMF_C;
import static android.media.ToneGenerator.TONE_DTMF_D;

public class MorsePlayer extends TextToMorse {

    private static final String LOG_TAG = "MorsePlayer.class: ";
    private ToneGenerator toneGenerator;
    private boolean isPlaying;
    private boolean isPaused;

    MorsePlayer(int volumeSeekValue) {
        toneGenerator = new ToneGenerator(AudioManager.STREAM_SYSTEM, volumeSeekValue);
    }

    public void playMorse(ArrayList morseArray, int pitchSeekProgress) throws InterruptedException {

        int toneValue = chooseTone(pitchSeekProgress);
        String morseLetter;
        String nextValue;
        boolean isDot;

        for (Object index:morseArray) {

            nextValue = "";
            morseLetter = index.toString();

            for (int ii = 0; ii < morseLetter.length(); ii++) {

                isDot = false;
                if(ii < morseLetter.length()-1) {
                    nextValue = Character.toString(morseLetter.charAt(ii + 1));
                }

                switch (Character.toString(morseLetter.charAt(ii))) {

                    case "|":
                        Thread.sleep(250);
                        isDot = false;
                        break;

                    case ".":
                        toneGenerator.startTone(toneValue, 50);
                        isDot = true;
                        break;

                    case "-":
                        toneGenerator.startTone(toneValue, 250);
                        break;
                }

                if (isDot && nextValue.equals("-")) {
                Thread.sleep(250);
                }
                else {
                Thread.sleep(350);
                }
            }

        Thread.sleep(350);
        }

    releasePlayer();
    }

    private int chooseTone(int pitchSeekProgress) {

        int tone;

        switch(pitchSeekProgress) {

            case 0:
                tone = TONE_DTMF_1;
                break;
            case 1:
                tone = TONE_DTMF_2;
                break;
            case 2:
                tone = TONE_DTMF_5;
                break;
            case 3:
                tone = TONE_DTMF_6;
                break;
            case 4:
                tone = TONE_DTMF_9;
                break;
            case 5:
                tone = TONE_DTMF_C;
                break;
            case 6:
                tone = TONE_DTMF_D;
                break;
            default:
                tone = TONE_DTMF_1;
        }
        return tone;
    }

    public void playMorsePlayer() {
        isPlaying = true;
        isPaused = false;
    }

    public void pauseMorsePlayer() {
        isPlaying = false;
        isPaused = true;
    }

    public void releasePlayer() {
        toneGenerator.release();
        Log.d(LOG_TAG, "ToneGenerator resources released");
    }

}


