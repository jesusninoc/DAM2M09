package org.provencana.dam.hash;

public class UserPassword {


    private String user;
    private String hashpasswd;

    public UserPassword(final String user, final String passwd) {
        WordAndHash wordAndHash = new WordAndHash(passwd);
        this.user = user;
        this.hashpasswd = wordAndHash.getHash();
    }

    public String getUser() {
        return user;
    }

    public String getHashpasswd() {
        return hashpasswd;
    }

    @Override
    public String toString() {
        return "\n UserPassword: {" +
                "user='" + user + '\'' +
                ", hashpasswd='" + hashpasswd + '\'' +
                "} ";
    }
}
