/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Patient;

/**
 *
 * @author anubhavgupta
 */
public enum ViolenceEnum {

    NA("NA"),
    HOMICIDE("Homicide"),
    MOTORCRASH("Motor Vehicle Traffic Crash"),
    FIREARM("Firearm Injuries"),
    OTHER("OTHER");

    private String value;

    private ViolenceEnum(String value) {

        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }

}
