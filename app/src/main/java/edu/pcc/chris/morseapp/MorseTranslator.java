package edu.pcc.chris.morseapp;

import java.util.Set;
import java.util.TreeMap;

public class MorseTranslator {

    private static final String morse_A = ".-"; private static final String morse_B = "-...";
    private static final String morse_C = "-.-."; private static final String morse_D = "-..";
    private static final String morse_E = "."; private static final String morse_F = "..-.";
    private static final String morse_G = "--."; private static final String morse_H = "....";
    private static final String morse_I = ".."; private static final String morse_J = ".---";
    private static final String morse_K = "-.-"; private static final String morse_L = ".-..";
    private static final String morse_M = "--"; private static final String morse_N = "-.";
    private static final String morse_O = "---"; private static final String morse_P = ".--.";
    private static final String morse_Q = "--.-"; private static final String morse_R = ".-.";
    private static final String morse_S = "..."; private static final String morse_T = "-";
    private static final String morse_U = "..-"; private static final String morse_V = "...-";
    private static final String morse_W = ".--"; private static final String morse_X = "-..-";
    private static final String morse_Y = "-.--"; private static final String morse_Z = "--..";
    private static final String morse_0 = "-----"; private static final String morse_1 = ".----";
    private static final String morse_2 = "..---"; private static final String morse_3 = "...--";
    private static final String morse_4 = "....-"; private static final String morse_5 = ".....";
    private static final String morse_6 = "-...."; private static final String morse_7 = "--...";
    private static final String morse_8 = "---.."; private static final String morse_9 = "----.";

    private TreeMap<String, String> morseTreeMap;

    public MorseTranslator() {
        morseTreeMap = new TreeMap<>();
        populateMorseMap();
    }

    private void populateMorseMap() {
        morseTreeMap.put("A", morse_A); morseTreeMap.put("B", morse_B); morseTreeMap.put("C", morse_C);
        morseTreeMap.put("D", morse_D); morseTreeMap.put("E", morse_E); morseTreeMap.put("F", morse_F);
        morseTreeMap.put("G", morse_G); morseTreeMap.put("H", morse_H); morseTreeMap.put("I", morse_I);
        morseTreeMap.put("J", morse_J); morseTreeMap.put("K", morse_K); morseTreeMap.put("L", morse_L);
        morseTreeMap.put("M", morse_M); morseTreeMap.put("N", morse_N); morseTreeMap.put("O", morse_O);
        morseTreeMap.put("P", morse_P); morseTreeMap.put("Q", morse_Q); morseTreeMap.put("R", morse_R);
        morseTreeMap.put("S", morse_S); morseTreeMap.put("T", morse_T); morseTreeMap.put("U", morse_U);
        morseTreeMap.put("V", morse_V); morseTreeMap.put("W", morse_W); morseTreeMap.put("X", morse_X);
        morseTreeMap.put("Y", morse_Y); morseTreeMap.put("Z", morse_Z); morseTreeMap.put("0", morse_0);
        morseTreeMap.put("1", morse_1); morseTreeMap.put("2", morse_2); morseTreeMap.put("3", morse_3);
        morseTreeMap.put("4", morse_4); morseTreeMap.put("5", morse_5); morseTreeMap.put("6", morse_6);
        morseTreeMap.put("7", morse_7); morseTreeMap.put("8", morse_8); morseTreeMap.put("9", morse_9);
    }
    //Accessors
    public String getKeyValue(char inputKey) {
        return morseTreeMap.get(Character.toString(inputKey)); }

    public Boolean hasKey(char inputKey) {
        return morseTreeMap.containsKey(Character.toString(inputKey)); }

    public Boolean doesValueExist(String inputValue) { // might use this later on
        return morseTreeMap.containsValue(inputValue);
    }

    public Set getKeySet() { // might use this later on
        return morseTreeMap.keySet();
    }




}

