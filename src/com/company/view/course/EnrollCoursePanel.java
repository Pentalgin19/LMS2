package com.company.view.course;

import com.company.model.Course;
import com.company.model.Student;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class EnrollCoursePanel extends JPanel {
    public static JTable table = new JTable();
    public DefaultTableModel model = new DefaultTableModel();

    public EnrollCoursePanel(Student student){
        model.setColumnIdentifiers(new String[]{"ID", "Title", "Description"});
        for (Course course :student.getToEnrollCourses()){
            model.addRow(new Object[]{course.getId(), course.getTitle(), course.getDesc()});
        }
        table.setModel(model);
        add(new JScrollPane(table));
    }
}
