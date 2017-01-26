package com.allogorithm;

import java.util.Set;
import java.util.HashSet;

import com.allogorithm.PassphraseGeneratorConfig;

/**
 * Created by garigant on 26/01/17.
 */
public class PassphraseGenerator {

    private static final String DICT_FILE = "dict.txt";
    private PassphraseGeneratorConfig passphraseGeneratorConfig;


    PassphraseGenerator(PassphraseGeneratorConfig passphraseGeneratorConfig){
        this.passphraseGeneratorConfig = passphraseGeneratorConfig;
        initialize();
    }

    private void initialize(){
        //TODO initilize the dictionary

    }

}
