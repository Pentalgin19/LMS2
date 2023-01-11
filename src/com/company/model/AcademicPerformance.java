package com.company.model;

import java.util.ArrayList;

public class AcademicPerformance {
    private final int id;
    int mark;
    Enrollment courseEnrollment;

    private static int lastId;
    static ArrayList<AcademicPerformance> allAP = new ArrayList<>();

    public AcademicPerformance(int mark, Enrollment ce){
        this.id = ++lastId;
        this.mark = mark;
        this.courseEnrollment = ce;
        allAP.add(this);
    }

    public static int getMarkByStudentAndCourse(Student st, Course c){
        Enrollment ce = Enrollment.getEnrollment(st, c);
        for (AcademicPerformance ap : allAP){
            if (ce.getId() == ap.courseEnrollment.getId()){

                return ap.mark;
            }
        }
        System.out.println("Оценки за курс нет:(");
        return 0;
    }
}
