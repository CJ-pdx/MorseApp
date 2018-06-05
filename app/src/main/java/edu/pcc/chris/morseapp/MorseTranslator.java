package edu.pcc.chris.morseapp;

import android.util.Log;
import java.util.ArrayList;
import java.util.TreeMap;

public class MorseTranslator {

    private static final String LOG_TAG = "MorseTranslator.class: ";

    private static final String MORSE_A = ".-"; private static final String MORSE_B = "-...";
    private static final String MORSE_C = "-.-."; private static final String MORSE_D = "-..";
    private static final String MORSE_E = "."; private static final String MORSE_F = "..-.";
    private static final String MORSE_G = "--."; private static final String MORSE_H = "....";
    private static final String MORSE_I = ".."; private static final String MORSE_J = ".---";
    private static final String MORSE_K = "-.-"; private static final String MORSE_L = ".-..";
    private static final String MORSE_M = "--"; private static final String MORSE_N = "-.";
    private static final String MORSE_O = "---"; private static final String morse_P = ".--.";
    private static final String morse_Q = "--.-"; private static final String MORSE_R = ".-.";
    private static final String MORSE_S = "..."; private static final String MORSE_T = "-";
    private static final String MORSE_U = "..-"; private static final String MORSE_V = "...-";
    private static final String MORSE_W = ".--"; private static final String MORSE_X = "-..-";
    private static final String MORSE_Y = "-.--"; private static final String MORSE_Z = "--..";
    private static final String MORSE_0 = "-----"; private static final String MORSE_1 = ".----";
    private static final String MORSE_2 = "..---"; private static final String MORSE_3 = "...--";
    private static final String MORSE_4 = "....-"; private static final String MORSE_5 = ".....";
    private static final String MORSE_6 = "-...."; private static final String MORSE_7 = "--...";
    private static final String MORSE_8 = "---.."; private static final String MORSE_9 = "----.";
    private static final String MORSE_SPACE = "|";

    private TreeMap<String, String> morseTreeMap;


    MorseTranslator() {
        morseTreeMap = new TreeMap<>();
        populateMorseMap();
    }

    private void populateMorseMap() {
        morseTreeMap.put("A", MORSE_A); morseTreeMap.put("B", MORSE_B); morseTreeMap.put("C", MORSE_C);
        morseTreeMap.put("D", MORSE_D); morseTreeMap.put("E", MORSE_E); morseTreeMap.put("F", MORSE_F);
        morseTreeMap.put("G", MORSE_G); morseTreeMap.put("H", MORSE_H); morseTreeMap.put("I", MORSE_I);
        morseTreeMap.put("J", MORSE_J); morseTreeMap.put("K", MORSE_K); morseTreeMap.put("L", MORSE_L);
        morseTreeMap.put("M", MORSE_M); morseTreeMap.put("N", MORSE_N); morseTreeMap.put("O", MORSE_O);
        morseTreeMap.put("P", morse_P); morseTreeMap.put("Q", morse_Q); morseTreeMap.put("R", MORSE_R);
        morseTreeMap.put("S", MORSE_S); morseTreeMap.put("T", MORSE_T); morseTreeMap.put("U", MORSE_U);
        morseTreeMap.put("V", MORSE_V); morseTreeMap.put("W", MORSE_W); morseTreeMap.put("X", MORSE_X);
        morseTreeMap.put("Y", MORSE_Y); morseTreeMap.put("Z", MORSE_Z); morseTreeMap.put("0", MORSE_0);
        morseTreeMap.put("1", MORSE_1); morseTreeMap.put("2", MORSE_2); morseTreeMap.put("3", MORSE_3);
        morseTreeMap.put("4", MORSE_4); morseTreeMap.put("5", MORSE_5); morseTreeMap.put("6", MORSE_6);
        morseTreeMap.put("7", MORSE_7); morseTreeMap.put("8", MORSE_8); morseTreeMap.put("9", MORSE_9);

        morseTreeMap.put(" ", MORSE_SPACE);
    }

    private String getKeyValue(String inputKey) {
        return morseTreeMap.get(inputKey); }

    private Boolean hasKey(String inputKey) {
        return morseTreeMap.containsKey(inputKey); }

    public ArrayList translateToMorse(String inputString) {

        ArrayList<String> morseArray = new ArrayList<>();
        String inputLetter;

        for (Integer i = 0; i < inputString.length(); i++) {

            inputLetter = Character.toString(inputString.charAt(i));

            if(hasKey(inputLetter)) {
                morseArray.add(getKeyValue(inputLetter));
            }

            else {
                Log.d(LOG_TAG, "translateToMorse() returned null ArrayList");
                return null;
            }
        }

        return morseArray;
    }

}

