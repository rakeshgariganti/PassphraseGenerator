package com.allogorithm;

import java.util.Set;
import java.util.HashSet;

import com.allogorithm.PassphraseGeneratorConfig;

/**
 * Created by garigant on 26/01/17.
 */
public class PassphraseGenerator {

    private static final String DICT_FILE = "dict.txt";
    private PassphraseGeneratorConfig config;

    PassphraseGenerator(PassphraseGeneratorConfig passphraseGeneratorConfig){
        this.config = passphraseGeneratorConfig;
        initialize();
    }

    void setConfig(PassphraseGeneratorConfig config){
        int oldWordLength = config.getWordLength();
        this.config = config;
        if(config.getWordLength() != oldWordLength){
            initialize();
        }
    }

    private void initialize(){
        //TODO initilize the dictionary

    }


}
