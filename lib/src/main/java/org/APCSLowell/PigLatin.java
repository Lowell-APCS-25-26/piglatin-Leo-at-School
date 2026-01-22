package org.APCSLowell;

public class PigLatin {
    private char[] vowels = {'a', 'e', 'i', 'o', 'u'};

    public int findFirstVowel(String sWord) {
        //precondition: sWord is a valid String of length greater than 0.
        if (sWord.length() == 0){
            return -1;
        }

        //postcondition: returns the position of the first vowel in sWord.  If there are no vowels, returns -1
	    for (int i = 0; i < sWord.length(); i++){
            if (charIsVowel(sWord.charAt(i))){
                return i;
            }
        }

        return -1;
    }

    public String pigLatin(String sWord) {
        //precondition: sWord is a valid String of length greater than 0
        if (sWord.length() <= 0){
            return "";
        }

        //postcondition: returns the pig latin equivalent of sWord

        if (charIsVowel(sWord.charAt(0))){ //Starts with vowel
            return sWord + "way";

        } else if (!stringAnyVowels(sWord)){ //All consonants
            return sWord + "ay";

        } else if (sWord.substring(0, 2).equals("qu")){ //Starts with "qu"
            return sWord.substring(2) + "quay";

        } else { //Starts with consonant, has vowels
            int firstVowelIndex = findFirstVowel(sWord);
            return sWord.substring(firstVowelIndex) + sWord.substring(0, firstVowelIndex) + "ay";
        }
    }

    private char charLower(char character){
        //Lowercase
        if ((int)character >= (int)'a' && (int)character <= 'z'){
            return character;
        }

        //Upcercase
        //32 is added because the lowercase letters are 32 positions above the uppercase letters in ascii
        return (char)((int)character + 32);
    }

    private boolean charIsVowel(char character){
        for (int i = 0; i < vowels.length; i++){
            if (charLower(character) == vowels[i]){
                return true;
            }
        }

        return false;
    }

    private boolean stringAnyVowels(String word){
        for (int i = 0; i < word.length(); i++){
            if (charIsVowel(word.charAt(i))){
                return true;
            }
        }

        return false;
    }
}
