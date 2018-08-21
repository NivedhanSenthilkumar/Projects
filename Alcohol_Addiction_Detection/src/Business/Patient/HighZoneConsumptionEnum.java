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
public enum HighZoneConsumptionEnum {

    Question1(1, "High Drinking Frequency"),
    Question2(2, "High Quantity"),
    Question3(3, "More than 6 drinks"),
    Question4(4, "Uncontrolled Drinking"),
    Question5(5, "Failed Expectation"),
    Question6(6, "Morning Drinking"),
    Question7(7, "Guilt after Drinking "),
    Question8(8, "Blackouts"),
    Question9(9, "Alcohol related injuries"),
    Question10(10, "Others concerned about drinking");

    private int question;

    private String value;

    private HighZoneConsumptionEnum(int question, String value) {

        this.question = question;
        this.value = value;

    }

    public int getQuestion() {
        return question;
    }

    public String getValue() {
        return value;
    }

    public static String getValueFromQuestion(int question) {

        HighZoneConsumptionEnum[] values = HighZoneConsumptionEnum.values();

        for (HighZoneConsumptionEnum q : values) {

            if (q.getQuestion() == question) {

                return q.getValue();

            }
        }
        return null;
    }

}
