/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import javax.swing.JOptionPane;

/**
 *
 * @author anubhavgupta
 */
public class RegexUtils {

    public static boolean isEmpty(String value, String message) {

        if (value.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, message);
            return true;
        } else {
            return false;
        }

    }

    public static boolean isInteger(String value, String message) {
        String intRegex = "^\\d+";
        if (value.matches(intRegex)) {
            return true;

        } else {
            JOptionPane.showMessageDialog(null, message);
            return false;

        }

    }

    public static boolean isDouble(String value, String message) {

        String doubleRegex = "^\\d+(\\.\\d+)?";
        if (value.matches(doubleRegex)) {
            return true;

        } else {
            JOptionPane.showMessageDialog(null, message);
            return false;

        }
    }

    public static boolean isValidDate(String value, String message) {

        String dateRegex = "^(1[0-2]|0[1-9])/(3[01]|[12][0-9]|0[1-9])/[0-9]{4}$";
        if (value.matches(dateRegex)) {
            return true;

        } else {
            JOptionPane.showMessageDialog(null, message);
            return false;

        }
    }

    public static boolean isValidTime(String value, String message) {

        String timeRegex = "([01]?[0-9]|2[0-3]):[0-5][0-9]";
        if (value.matches(timeRegex)) {
            return true;

        } else {
            JOptionPane.showMessageDialog(null, message);
            return false;

        }
    }

    public static boolean isAlphaNumeric(String value, String message) {

        String alphaNumerixExp = "[a-zA-Z0-9]+";
        if (value.matches(alphaNumerixExp)) {
            return true;

        } else {
            JOptionPane.showMessageDialog(null, message);
            return false;

        }
    }
    
     public static boolean isValidCompanyName(String value, String message) {

        String alphaNumerixExp = "^[a-zA-Z ]*$";
        if (value.matches(alphaNumerixExp)) {
            return true;

        } else {
            JOptionPane.showMessageDialog(null, message);
            return false;

        }
    }

    public static boolean isText(String value, String message) {

        String textRegex = "[a-zA-Z]+";
        if (value.matches(textRegex)) {
            return true;

        } else {
            JOptionPane.showMessageDialog(null, message);
            return false;

        }
    }

    public static boolean isValidYear(String value, String message) {

        String textRegex = "^\\d{4}$";
        if (value.matches(textRegex)) {
            return true;

        } else {
            JOptionPane.showMessageDialog(null, message);
            return false;

        }
    }

}
