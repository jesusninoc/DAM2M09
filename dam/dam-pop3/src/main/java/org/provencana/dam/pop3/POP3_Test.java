package org.provencana.dam.pop3;


import org.apache.commons.net.pop3.POP3Client;
import org.apache.commons.net.pop3.POP3MessageInfo;
import org.provencana.dam.exception.DamPop3Exception;
import org.provencana.dam.exception.code.enums.DamPop3ErrorCode;
import org.provencana.dam.exception.type.enums.ErrorSeverity;

import java.io.BufferedReader;
import java.io.IOException;


public class POP3_Test {

    private final static String SERVER = "pop.server.com";
    private final static Integer PORT = 110;
    private final static String USERNAME = "user";
    private final static String PASSWORD = "password";
    private final static Integer TIMEOUT = 60000;
    private POP3Client pop3;
    private POP3MessageInfo[] messages;


    public POP3_Test() {
        pop3 = new POP3Client();
        pop3.setDefaultTimeout(TIMEOUT);
    }

    public POP3MessageInfo[] getMessages() {
        return messages;
    }

    public void setMessages(final POP3MessageInfo[] messages) {
        this.messages = messages;
    }

    public void connectPop3Server() throws Exception {
        try {
            pop3.connect(SERVER, PORT);
        } catch (final Exception e) {
            throw new DamPop3Exception(e
                    , "Error on connect POP3 Server "
                    , DamPop3ErrorCode.ERROR_CONNECTING_SERVER
                    , ErrorSeverity.ERROR);
        }
    }

    public void loginPop3Server() throws Exception {
        if (!pop3.login(USERNAME, PASSWORD)) {
            throw new DamPop3Exception(new Exception()
                    , "Error on login POP3 Server [{}] with credentials userid: [{}] password: [{}] "
                    , DamPop3ErrorCode.ERROR_LOGIN_SERVER
                    , ErrorSeverity.ERROR
                    , SERVER, USERNAME, PASSWORD);
        }
    }

    public void getMessagesFromPop3Server() throws Exception {
        messages = pop3.listMessages();

        if (messages == null) {
            throw new DamPop3Exception(new Exception()
                    , "Error on retrieve message list from POP3 Server [{}]"
                    , DamPop3ErrorCode.ERROR_RETRIEVE_MESSAGES
                    , ErrorSeverity.ERROR
                    , SERVER);
        }

        if (messages.length == 0) {
            throw new DamPop3Exception(new Exception()
                    , "Warning no messages on POP3 Server [{}]"
                    , DamPop3ErrorCode.ERROR_NO_MESSAGES
                    , ErrorSeverity.WARNING
                    , SERVER);
        }
    }

    public void printMessages() throws Exception {
        for (POP3MessageInfo msginfo : messages) {
            final BufferedReader reader = (BufferedReader) pop3.retrieveMessage(msginfo.number);
            if (reader == null) {
                throw new DamPop3Exception(new Exception()
                        , "Error on get message from POP3 Server [{}]"
                        , DamPop3ErrorCode.ERROR_ON_GET_MESSAGE
                        , ErrorSeverity.ERROR
                        , SERVER);
            }
            showMessage(reader);
        }
    }

    private void showMessage(final BufferedReader reader) throws IOException {
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
    }


    private void logoutPop3Server() throws Exception {
        try {
            pop3.logout();
        } catch (IOException e) {
            throw new DamPop3Exception(e
                    , "Error on logout from POP3 Server [{}] "
                    , DamPop3ErrorCode.ERROR_LOGOUT_SERVER
                    , ErrorSeverity.ERROR
                    , SERVER);
        }
    }

    private void disconnectPop3Server() throws Exception {
        try {
            pop3.disconnect();
        } catch (IOException e) {
            throw new DamPop3Exception(e
                    , "Error on disconnect from POP3 Server [{}] "
                    , DamPop3ErrorCode.ERROR_CONNECTING_SERVER
                    , ErrorSeverity.ERROR
                    , SERVER);
        }
    }

    private void logout() {
        try {
            logoutPop3Server();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void disconnect() {
        try {
            disconnectPop3Server();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {

        final POP3_Test pop3Test = new POP3_Test();

        try {

            pop3Test.connectPop3Server();
            pop3Test.loginPop3Server();
            pop3Test.getMessagesFromPop3Server();
            pop3Test.printMessages();

        } catch (Exception e) {

            e.printStackTrace();

        } finally {

            pop3Test.logout();
            pop3Test.disconnect();
        }
    }
}
