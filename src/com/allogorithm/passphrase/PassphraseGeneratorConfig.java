package com.allogorithm.passphrase;

/**
 * PassPhrase Generator configuration class.
 * Configuration settings:
 * 1. numWords = number of words to use in the passphrase. default is a random number between 5-7 inclusive.
 * 2. wordLength = word length of each word in the passphrase
 * 3. tokenSeperator = separator to separate words in the phrase. default is SPACE
 * 4. isHintAllowed = password phrase will contain a word starting with each char present in the isHintAllowed supplied while generating passphrases. ("cat" may result in "coffee apple table")
 *          When isHintAllowed is supplied, numWords setting will not take effect.
 * Created by garigant on 26/01/17.
 *
 */
public class PassphraseGeneratorConfig {

    private int numWords;
    private int wordLength;
    private String tokenSeperator = " ";
    private Boolean isHintAllowed = Boolean.FALSE;

    PassphraseGeneratorConfig(){
    }

    PassphraseGeneratorConfig(int numWords, int wordLendth, Boolean isHintAllowed){
        this.numWords = numWords;
        this.wordLength = wordLendth;
        this.isHintAllowed = isHintAllowed;
    }

    PassphraseGeneratorConfig(int numWords, int wordLendth, Boolean isHintAllowed, String tokenSeperator){
        this.numWords = numWords;
        this.wordLength = wordLendth;
        this.isHintAllowed = isHintAllowed;
        this.tokenSeperator = tokenSeperator;
    }

    PassphraseGeneratorConfig setNumWords(int numWords){
        this.numWords = numWords;
        return this;
    }

    PassphraseGeneratorConfig setwordLendth(int wordLendth){
        this.wordLength = wordLendth;
        return this;
    }

    PassphraseGeneratorConfig settokenSeperator(String tokenSeperator){
        this.tokenSeperator = tokenSeperator;
        return this;
    }

    PassphraseGeneratorConfig setIsHintAllowed(Boolean isHintAllowed){
        this.isHintAllowed = isHintAllowed;
        return this;
    }

    public int getNumWords(){
        return this.numWords;
    }

    public int getWordLength(){
        return this.wordLength;
    }

    public String getTokenSeperator(){
        return this.tokenSeperator;
    }

    public Boolean getIsHintAllowed(){
        return this.isHintAllowed;
    }
}
