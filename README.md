# PassphraseGenerator
Java library to generate passphrases

Examples:
```
        PassphraseGeneratorConfig configWithHints = new PassphraseGeneratorConfig().setIsHintAllowed(Boolean.TRUE);
        PassphraseGenerator passphraseGenerator = new PassphraseGenerator(configWithHints);
        System.out.println(passphraseGenerator.nextPassphrase("apple"));

        PassphraseGeneratorConfig configWithWordLengthAndHints = new PassphraseGeneratorConfig().setwordLendth(5).setIsHintAllowed(Boolean.TRUE);
        passphraseGenerator.setConfig(configWithWordLengthAndHints);
        System.out.println(passphraseGenerator.nextPassphrase("beer"));

        PassphraseGeneratorConfig configWithWordLength = new PassphraseGeneratorConfig().setwordLendth(5);
        passphraseGenerator.setConfig(configWithWordLength);
        System.out.println(passphraseGenerator.nextPassphrase());

        PassphraseGeneratorConfig configWithNumWords = new PassphraseGeneratorConfig().setNumWords(6).settokenSeperator(":");
        passphraseGenerator.setConfig(configWithNumWords);
        System.out.println(passphraseGenerator.nextPassphrase());

```
