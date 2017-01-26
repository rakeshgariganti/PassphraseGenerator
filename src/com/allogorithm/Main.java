package com.allogorithm;


public class Main {

    public static void main(String[] args) {
	    PassphraseGeneratorConfig config = new PassphraseGeneratorConfig().setNumWords(6).setIsHintAllowed(Boolean.TRUE);
        PassphraseGenerator generator = new PassphraseGenerator(config);
    }
}
