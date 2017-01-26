package com.allogorithm;

import com.sun.istack.internal.NotNull;

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
    private List<String> dictionary;
    private Map<Character, ArrayList<String>> charToWordMap;
    private Random random;

    PassphraseGenerator(@NotNull PassphraseGeneratorConfig passphraseGeneratorConfig){
        this.config = passphraseGeneratorConfig;
        this.random = new Random(new Date().getTime());
        initializeDict();
    }

    void setConfig(@NotNull PassphraseGeneratorConfig config){
        int oldWordLength = config.getWordLength();
        this.config = config;
        if(config.getWordLength() != oldWordLength){
            initializeDict();
        }
    }

    private void initializeDict(){
        dictionary = new ArrayList<String>();
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
                    if(this.config.getWordLength() > 0 && line.length() != this.config.getWordLength()){
                        continue;
                    }
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

    public String nextPassphrase(@NotNull String hint){
        return generagePassphrase(hint);
    }

    public String nextPassphrase(){
        return generagePassphrase(null);
    }

    /**
    Generates a random number between 5 to 7 inclusive
     */
    private int getRandomNumWords(){
        return this.random.nextInt(3)+5;
    }

    private String generagePassphrase(String hint){

        List<String> phrases = new ArrayList<String>();
        if(hint != null && charToWordMap == null){
            throw new RuntimeException("Configuration does not allow hints, update the configuration to allow hints");
        }
        if(hint != null){
            for(char _ : hint.toCharArray()){
                phrases.add(getRandomWord(this.charToWordMap.get(_)));
            }
        }
        else{
            int numWords = this.config.getNumWords() == 0 ? getRandomNumWords() : this.config.getNumWords();
            for (int i=0; i < numWords; i++){
                phrases.add(getRandomWord(dictionary));
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<phrases.size()-1; i++){
            sb.append(phrases.get(i));
            sb.append(this.config.getTokenSeperator());
        }
        sb.append(phrases.get(phrases.size()-1));
        return sb.toString();
    }

    private String getRandomWord(List<String> words){
        return words.get(random.nextInt(words.size()));
    }
}
