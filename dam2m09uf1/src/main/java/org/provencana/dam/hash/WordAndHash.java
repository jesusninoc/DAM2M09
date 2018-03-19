package org.provencana.dam.hash;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class WordAndHash {

    private int HASHLENTH = 20;
    private String word;
    private String hash;

    public WordAndHash(final String word) {
        this.setWord(word);
    }

    public String getWord() {
        return word;
    }

    public void setWord(final String word) {
        this.word = word;
        this.hash = this.generateHashCode(this.word);
    }

    public String getHash() {
        return hash;
    }

    public String generateHashCode(String word) {
        try {
            final MessageDigest m = MessageDigest.getInstance("MD5");
            final byte[] data = word.getBytes();
            m.update(data, 0, data.length);
            final String myHash = DatatypeConverter.printHexBinary(m.digest()).toUpperCase();
            return myHash.substring(0, Math.min(HASHLENTH, myHash.length()));

        } catch (final NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }


    @Override
    public String toString() {
        return "\n WordAndHash: {" +
                " word='" + word + '\'' +
                ", hash='" + hash + '\'' +
                " }";
    }
}
