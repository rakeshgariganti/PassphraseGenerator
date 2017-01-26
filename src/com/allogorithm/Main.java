package com.allogorithm;

import java.util.Date;

public class Main {

    public static void main(String[] args) {
        long a = new Date().getTime();
	    PassphraseGeneratorConfig config = new PassphraseGeneratorConfig().setIsHintAllowed(Boolean.TRUE);
        PassphraseGenerator generator = new PassphraseGenerator(config);
        System.out.println(generator.nextPassphrase("rakesh"));
        System.out.println("Time taken : "+(new Date().getTime() - a));
    }
}
