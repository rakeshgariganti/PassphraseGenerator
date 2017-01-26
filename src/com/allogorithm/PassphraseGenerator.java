package com.allogorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * Created by garigant on 26/01/17.
 */
public class PassphraseGenerator {

    private static final String DICT_FILE = "dict.txt";
    private PassphraseGeneratorConfig config;
    private Set<String> dictionary;
    private Map<Character, ArrayList<String>> charToWordMap;

    PassphraseGenerator(PassphraseGeneratorConfig passphraseGeneratorConfig){
        this.config = passphraseGeneratorConfig;
        initializeDict();
    }

    void setConfig(PassphraseGeneratorConfig config){
        int oldWordLength = config.getWordLength();
        this.config = config;
        if(config.getWordLength() != oldWordLength){
            initializeDict();
        }
    }

    private void initializeDict(){
        dictionary = new HashSet<String>();
        charToWordMap = new HashMap<Character , ArrayList<String>>();
        try {
            BufferedReader br = Files.newBufferedReader(Paths.get(DICT_FILE), StandardCharsets.UTF_8);
            String line;
            while((line = br.readLine()) != null){
                line = line.trim();
                if(this.config.getWordLength() == 0 || line.length() == this.config.getWordLength()){
                    dictionary.add(line);
                }
                if(config.getIsHintAllowed()){
                    char _ = line.charAt(0);
                    if(charToWordMap.containsKey(_)){
                        charToWordMap.get(_).add(line);
                    }else{
                        charToWordMap.put(_ , new ArrayList<>(Arrays.asList(line)));
                    }
                }
            }
        }
        catch(IOException ex){
            throw new DictNotFoundException("Can't read Dictionary file");
        }
        System.out.println(String.format("Found %d words in the dictionary", dictionary.size()));
    }

    public String nextPassphrase(String hint){
        return null;
    }

}
