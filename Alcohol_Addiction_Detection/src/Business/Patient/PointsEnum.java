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
public enum PointsEnum {

    rad1_1("rad1_1", 0, 1),
    rad1_2("rad1_2", 1, 1),
    rad1_3("rad1_3", 2, 1),
    rad1_4("rad1_4", 3, 1),
    rad1_5("rad1_5", 4, 1),
    rad2_1("rad2_1", 0, 2),
    rad2_2("rad2_2", 1, 2),
    rad2_3("rad2_3", 2, 2),
    rad2_4("rad2_4", 3, 2),
    rad2_5("rad2_5", 4, 2),
    rad3_1("rad3_1", 0, 3),
    rad3_2("rad3_2", 1, 3),
    rad3_3("rad3_3", 2, 3),
    rad3_4("rad3_4", 3, 3),
    rad3_5("rad3_5", 4, 3),
    rad4_1("rad4_1", 0, 4),
    rad4_2("rad4_2", 1, 4),
    rad4_3("rad4_3", 2, 4),
    rad4_4("rad4_4", 3, 4),
    rad4_5("rad4_5", 4, 4),
    rad5_1("rad5_1", 0, 5),
    rad5_2("rad5_2", 1, 5),
    rad5_3("rad5_3", 2, 5),
    rad5_4("rad5_4", 3, 5),
    rad5_5("rad5_5", 4, 5),
    rad6_1("rad6_1", 0, 6),
    rad6_2("rad6_2", 1, 6),
    rad6_3("rad6_3", 2, 6),
    rad6_4("rad6_4", 3, 6),
    rad6_5("rad6_5", 4, 6),
    rad7_1("rad7_1", 0, 7),
    rad7_2("rad7_2", 1, 7),
    rad7_3("rad7_3", 2, 7),
    rad7_4("rad7_4", 3, 7),
    rad7_5("rad7_5", 4, 7),
    rad8_1("rad8_1", 0, 8),
    rad8_2("rad8_2", 1, 8),
    rad8_3("rad8_3", 2, 8),
    rad8_4("rad8_4", 3, 8),
    rad8_5("rad8_5", 4, 8),
    rad9_1("rad9_1", 0, 9),
    rad9_2("rad9_2", 2, 9),
    rad9_3("rad9_3", 4, 9),
    rad10_1("rad10_1", 0, 10),
    rad10_2("rad10_2", 2, 10),
    rad10_3("rad10_3", 4, 10);

    private String name;

    private int points;

    private int questionNumber;

    private PointsEnum(String name, int points, int questionNumber) {
        this.name = name;
        this.points = points;
        this.questionNumber = questionNumber;

    }

    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }

    public int getQuestionNumber() {
        return questionNumber;
    }

    public static int getPointsFromName(String name) {

        PointsEnum[] pointsValues = PointsEnum.values();

        for (PointsEnum question : pointsValues) {

            if (question.getName().equals(name)) {

                return question.getPoints();
            }
        }

        return 0;
    }

    public static int getQuestionNumberFromName(String name) {

        PointsEnum[] values = PointsEnum.values();

        for (PointsEnum pointEnum : values) {

            if (pointEnum.getName().equals(name)) {

                return pointEnum.getQuestionNumber();
            }

        }

        return 0;

    }

}
