package org.provencana.dam.hash;

import java.util.ArrayList;

public class Hash {

    private String[] user = {"maria", "juan", "olga", "pablo"};
    private String[] passwd = {"1111", "qwstn834r", "biasufy", "111."};

    private ArrayList<UserPassword> users;
    private ArrayList<WordAndHash> wordAndHashes;

    public Hash() {
        users = new ArrayList<>();
        wordAndHashes = new ArrayList<>();
    }

    public static void main(final String[] args) {

        Hash hash = new Hash();

        UserPassword user1 = new UserPassword(hash.user[0], hash.passwd[0]);
        UserPassword user2 = new UserPassword(hash.user[1], hash.passwd[1]);
        UserPassword user3 = new UserPassword(hash.user[2], hash.passwd[2]);
        UserPassword user4 = new UserPassword(hash.user[3], hash.passwd[3]);

        WordAndHash wordAndHash1 = new WordAndHash(hash.passwd[0]);
        WordAndHash wordAndHash2 = new WordAndHash(hash.passwd[1]);
        WordAndHash wordAndHash3 = new WordAndHash(hash.passwd[2]);
        WordAndHash wordAndHash4 = new WordAndHash(hash.passwd[3]);

        hash.users.add(user1);
        hash.users.add(user2);
        hash.users.add(user3);
        hash.users.add(user4);

        hash.wordAndHashes.add(wordAndHash1);
        hash.wordAndHashes.add(wordAndHash2);
        hash.wordAndHashes.add(wordAndHash3);
        hash.wordAndHashes.add(wordAndHash4);


        System.out.println(hash.toString());
    }


    @Override
    public String toString() {
        return "Hash{" +
                "users=" + userPasswordToString(users) +
                ",\n wordAndHashes=" + wordAndHashesToString(wordAndHashes) +
                '}';
    }

    private String userPasswordToString(final ArrayList<UserPassword> arrayList) {
        String result = "{";
        for (UserPassword up : arrayList) {
            result = result + up.toString();
        }
        result = result + "}";
        return result;
    }

    private String wordAndHashesToString(final ArrayList<WordAndHash> arrayList) {
        String result = "{";
        for (WordAndHash wh : arrayList) {
            result = result + wh.toString();
        }
        result = result + "}";
        return result;
    }


}
