/*
 * Copyright (c) 2004, 2023, Michael Tomas Fox's and/or his affiliates. All rights reserved.
 * @MT_F0XTR0T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package myviciouscoke.Student;

class StudentController {
    private final Student model;
    private final StudentView view;
    public StudentController(Student model, StudentView view) {
        this.model = model;
        this.view = view;
    }
    public Student getModel() {
            return model;
    }
    public String getStudentName() {
        return model.getName();
    }
    public String getStudentRollNo() {
        return model.getRollNo();
    }
    public void setStudentName(String name) {
        model.setName(name);
    }
    public void setStudentRollNo(String rollNo) {
        model.setRollNo(rollNo);
    }
    public void updateView() {
        view.printStudentDetails(model);
    }
}
