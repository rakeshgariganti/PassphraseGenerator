package com.allogorithm;

/**
 * PassPhrase Generator configuration class.
 * Configuration settings:
 * 1. numWords = number of words to use in the passphrase
 * 2. wordLength = word length of each word in the passphrase
 * 3. tokenSeperator = separator to separate words in the phrase. default is SPACE
 *
 * Created by garigant on 26/01/17.
 *
 */
public class PassphraseGeneratorConfig {

    private int numWords;
    private int wordLength;
    private String tokenSeperator = " ";

    PassphraseGeneratorConfig(int numWords, int wordLendth){
        this.numWords = numWords;
        this.wordLength = wordLendth;
    }

    PassphraseGeneratorConfig(int numWords, int wordLendth, String tokenSeperator){
        this.numWords = numWords;
        this.wordLength = wordLendth;
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

    public int getNumWords(){
        return numWords;
    }

    public int getWordLength(){
        return wordLength;
    }

    public String getTokenSeperator(){
        return tokenSeperator;
    }
}
