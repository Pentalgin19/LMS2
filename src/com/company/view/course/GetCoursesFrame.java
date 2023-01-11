package com.company.view.course;

import com.company.model.Course;
import com.company.model.Enrollment;
import com.company.model.Student;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GetCoursesFrame extends JFrame {
    public GetCoursesPanel panel;

    public GetCoursesFrame(Student student) {
        setTitle("Курсы студента: " + student.getName());
        setSize(500, 500);
        setLocation(1920 / 2 - 250, 1080 / 2 - 250);
        panel = new GetCoursesPanel(student);
        add(panel);
        setVisible(true);
    }
}



















