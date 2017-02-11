package com.allogorithm.passphrase;

import com.sun.istack.internal.NotNull;

/**
 * Created by garigant on 26/01/17.
 */
public class Passphrase {
    private String passphrase;
    private double strength;

    Passphrase(@NotNull String passphrase){
        this.passphrase = passphrase;
        calculateStrength();
    }

    /*
    Calculates the passphrase strength
    Strength formula : N * Log(M)
    where N is the length of the passphrase and M is the number of possible chars in passphrase
     */
    private void calculateStrength(){
        //Currently our dict contains words in small letters only, so M is 26
        Integer M = 26;
        int N = this.passphrase.length();
        this.strength = N * ( Math.log(M) / Math.log(2));
    }

    String getPassphrase(){
        return this.passphrase;
    }

    double getStrength(){
        return this.strength;
    }

    public String toString(){
        return this.passphrase;
    }
}
