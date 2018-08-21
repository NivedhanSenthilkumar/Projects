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
public enum ZonesEnum {

    ZONE1("Zone 1"),
    ZONE2("Zone 2"),
    ZONE3("Zone 3"),
    ZONE4("Zone 4");

    private String value;

    private ZonesEnum(String value) {
        this.value = value;

    }

    public String getValue() {
        return value;
    }

}
