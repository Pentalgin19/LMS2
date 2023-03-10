package com.company.view.student;

import com.company.model.Course;
import com.company.model.Student;
import com.company.repository.StudentRepository;
import com.company.view.course.GetCoursesFrame;
//import com.company.view.enroll.EnrollFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class StudentPopupMenu extends JPopupMenu {
    public static MenuActionListener menuActionListener = new MenuActionListener();

    public StudentPopupMenu() {
        add(item("Сохранить", "save"));
        add(item("Удалить", "delete"));
        add(item("Курсы студента", "courses"));
        add(item("Записать на курс", "enroll"));

    }
    private static JMenuItem item(String text, String command) {
        JMenuItem button = new JMenuItem(text);
        button.setActionCommand(command);
        button.addActionListener(menuActionListener);

        return button;
    }

    static class MenuActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int rowIndex = StudentListPanel.table.getSelectedRow();
            int id = Integer.parseInt(StudentListPanel.table.getValueAt(rowIndex, 0).toString());
            String name = StudentListPanel.table.getValueAt(rowIndex, 1).toString();
            String surname = StudentListPanel.table.getValueAt(rowIndex, 2).toString();

            switch (e.getActionCommand()) {
                case "save":
                    Student.update(id, name, surname);
                    break;
                case "delete":
                    Student.delete(id, rowIndex);
                    break;
                case "courses":
                    ArrayList<Course> courses = Student.getCoursesById(id);
                    System.out.println(courses);
                    new GetCoursesFrame(Student.getStudentById(id));
                    break;
                case "enroll":
                    //new EnrollFrame(Student.getStudentById(id));
                    System.out.println("Зачисляем студента");
                    break;
                default:
                    System.out.println("Неизвестная команда");
            }
        }
    }


}
