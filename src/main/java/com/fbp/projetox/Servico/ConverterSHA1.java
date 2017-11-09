/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fbp.projetox.Servico;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author F.Belmonte
 */
/**
 * @author Diego Arantes
 * @description Algoritmo para converter Strings para SHA1.
 */
public class ConverterSHA1 {

    public static String cipher(String value) {
        byte[] buffer = value.getBytes();

        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            md.update(buffer);
            byte[] digest = md.digest();
            String hexValue = "";
            for (int i = 0; i < digest.length; i++) {
                int b = digest[i] & 0xff;
                if (Integer.toHexString(b).length() == 1) {
                    hexValue = hexValue + "0";
                }
                hexValue = hexValue + Integer.toHexString(b);
            }
            return hexValue;
        } catch (NoSuchAlgorithmException ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }
}
