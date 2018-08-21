/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Patient;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dell
 */
public class PatientDirectory {

    private List<Patient> patientlist;

    public PatientDirectory() {
        this.patientlist = new ArrayList<>();
    }

    public List<Patient> getPatientlist() {
        return patientlist;
    }

    public Patient addPatient() {

        Patient p = new Patient();
        patientlist.add(p);
        return p;

    }

}
