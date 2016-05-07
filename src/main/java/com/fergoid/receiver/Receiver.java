package com.fergoid.receiver;

import java.io.UnsupportedEncodingException;

/**
 * Created by markferguson on 27/04/2016.
 */
public class Receiver {
    public void receiveMessage(byte[] body) {
        String message = null;
        try {
            message = new String(body, "UTF-8");
            System.out.println("Received <" + message + ">");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

}
