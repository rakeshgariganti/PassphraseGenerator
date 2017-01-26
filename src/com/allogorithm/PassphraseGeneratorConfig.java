package com.allogorithm;

/**
 * PassPhrase Generator configuration class.
 * Configuration settings:
 * 1. numWords = number of words to use in the passphrase
 * 2. wordLength = word length of each word in the passphrase
 * 3. hint = password phrase will contain a word starting with each char present in the hint. ("cat" may result in "coffee apple table")
 *           When hint is supplied, hint will override numWords setting.
 * 4. tokenSeperator = separator to separate words in the phrase. default is SPACE
 *
 * Created by garigant on 26/01/17.
 *
 */
public class PassphraseGeneratorConfig {

    private int numWords;
    private int wordLength;
    private String hint;
    private String tokenSeperator = " ";

    PassphraseGeneratorConfig(int numWords, int wordLendth, String hint){
        this.numWords = numWords;
        this.wordLength = wordLendth;
        this.hint = hint;
    }

    PassphraseGeneratorConfig(int numWords, int wordLendth, String hint, String tokenSeperator){
        this.numWords = numWords;
        this.wordLength = wordLendth;
        this.hint = hint;
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

    PassphraseGeneratorConfig sethint(String hint){
        this.hint = hint;
        return this;
    }

    PassphraseGeneratorConfig settokenSeperator(String tokenSeperator){
        this.tokenSeperator = tokenSeperator;
        return this;
    }
}
