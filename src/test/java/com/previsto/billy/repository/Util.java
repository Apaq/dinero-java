package com.previsto.billy.repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class Util {

    public static String readResourceFromFile(String name) {
        InputStream is = Util.class.getResourceAsStream(name);
        try (BufferedReader buffer = new BufferedReader(new InputStreamReader(is))) {
            return buffer.lines().collect(Collectors.joining("\n"));
        }
        catch (IOException ex) {
            Logger.getLogger(ResourceTestBase.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
