package com.company.view.course;

import com.company.model.Course;
import com.company.model.Enrollment;
import com.company.model.Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EnrollCourseFrame extends JFrame {
    public static EnrollCoursePanel panel;
    public EnrollCourseFrame(Student student){
        panel = new EnrollCoursePanel(student);
        setTitle("Зачисление студента: " + student.getName());
        setSize(500, 500);
        setLayout(new FlowLayout());
        setLocation(1920 / 2 - 250, 1080 / 2 - 250);
        JButton ab = new JButton("Записать");
        ab.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int rowI = panel.table.getSelectedRow();
                int id = Integer.parseInt(panel.table.getValueAt(rowI, 0).toString());
                new Enrollment(student, Course.getCourseById(id));
            }
        });
        add(panel);
        add(ab);
        setVisible(true);
    }
}
