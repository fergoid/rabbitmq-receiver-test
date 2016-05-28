package com.fergoid.receiver;

import java.io.UnsupportedEncodingException;
import java.util.logging.Logger;

/**
 * Created by markferguson on 27/04/2016.
 */
public class Receiver {
    private final static Logger log = Logger.getLogger("Receiver");
    public void receiveMessage(byte[] body) {
        String message = null;
        try {
            message = new String(body, "UTF-8");
            log.info("Received <" + message + ">");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

}
