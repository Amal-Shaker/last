/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exprine.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.springframework.stereotype.Component;

/**
 * FXML Controller class
 *
 * @author rant
 */

@Component
public class StudentViewController implements Initializable {

    @FXML
    private TextField txtFieldStdID;
    @FXML
    private TextField txtFieldCouID;
    @FXML
    private TextField txtFieldSemesterID;
    @FXML
    private TableView<registration> CourseView;
    @FXML
    private TableColumn<registration, Integer> tcStdID;
    @FXML
    private TableColumn<registration, Integer> tcCouID;
    @FXML
    private TableColumn<registration, Integer> tcSemester;
    @FXML
    private TextArea textArea;
    @FXML
    private TextField txtFieldID;
    @FXML
    private TextField txtFieldName;
    @FXML
    private TextField txtFieldMajor;
    @FXML
    private TextField txtFieldGrade;
    @FXML
    private TableView<Student> tableView;
    @FXML
    private TableColumn<Student, Integer> tcID;
    @FXML
    private TableColumn<Student, String> tcName;
    @FXML
    private TableColumn<Student,String > tcMajor;
    @FXML
    private TableColumn<Student, Double> tcGrade;
    @FXML
    private Button buttonShow;
    @FXML
    private Button buttonAdd;
    @FXML
    private Button buttonEdit;
    @FXML
    private Button buttonDelete;
    @FXML
    private Button buttonReset;
    @FXML
    private Button buttonAddCourse;
    @FXML
    private Button buttonShowTextArea;
    @FXML
    private Button buttonShowCourse;
    @FXML
    private Button buttonUpdateText;
     private EntityManagerFactory emf;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       tcID.setCellValueFactory(new PropertyValueFactory("id"));
        tcName.setCellValueFactory(new PropertyValueFactory("name"));
        tcMajor.setCellValueFactory(new PropertyValueFactory("major"));
        tcGrade.setCellValueFactory(new PropertyValueFactory("grade"));
        tcStdID.setCellValueFactory(new PropertyValueFactory("studentid"));
        tcCouID.setCellValueFactory(new PropertyValueFactory("courseid"));
        tcSemester.setCellValueFactory(new PropertyValueFactory("semester"));

      this.emf = Persistence.createEntityManagerFactory("JPAworkPU");
       tableView.getSelectionModel().selectedItemProperty().addListener(
            event -> showSelectedStudent() );
        // TODO
    }    

  

    @FXML
    private void buttonShowHandle(ActionEvent event) {
         EntityManager em = emf.createEntityManager();
        List<Student> students = em.createNamedQuery("Student.findAll").getResultList();
        tableView.getItems().setAll(students);
        em.close();     
    }

    @FXML
    private void buttonAddHandle(ActionEvent event) {
        Student student = new Student();
        student.setId(Integer.parseInt(txtFieldID.getText()));
        student.setName(txtFieldName.getText());
        student.setMajor(txtFieldMajor.getText());
        student.setGrade(Double.parseDouble(txtFieldGrade.getText()));
        EntityManager em = this.emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(student);
        em.getTransaction().commit();
        em.close();
    }

    @FXML
    private void buttonEditHandle(ActionEvent event) {
       EntityManager em = this.emf.createEntityManager();
       em.getTransaction().begin();
        int student = em.createNamedQuery("Student.update")
                .setParameter("id", Integer.parseInt(txtFieldID.getText()))
                .setParameter("name", txtFieldName.getText())
                .setParameter("major", txtFieldMajor.getText())
                .setParameter("grade", Double.parseDouble(txtFieldGrade.getText()))
                .executeUpdate();
       
        em.getTransaction().commit();

        
    }

    @FXML
    private void buttonDeleteHandle(ActionEvent event) {
        EntityManager em = this.emf.createEntityManager();
       em.getTransaction().begin();
      int student = em.createNamedQuery("Student.delete")
              .setParameter("id", Integer.parseInt(txtFieldID.getText()))
              .executeUpdate();
           em.getTransaction().commit();

    }

    @FXML
    private void buttonResetHandle(ActionEvent event) {
         resetControls();
    }

    @FXML
    private void buttonAddCourseHandle(ActionEvent event) {
         registration student = new registration();
        student.setStudentid(Integer.parseInt(txtFieldStdID.getText()));
        student.setCourseid(Integer.parseInt(txtFieldCouID.getText()));
        student.setSemester(txtFieldSemesterID.getText());
        EntityManager em = this.emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(student);
        em.getTransaction().commit();
        em.close();
        
    }

    @FXML
    private void buttonShowTextAreaHandle(ActionEvent event) {
              
 EntityManager em = emf.createEntityManager();
        List<Student> students = em.createQuery(textArea.getText())
                .getResultList();
        tableView.getItems().setAll(students);
        em.close();     
        
    }

    @FXML
    private void buttonShowCourseHandle(ActionEvent event) {
         EntityManager em = emf.createEntityManager();
        List<registration> students = em.createNamedQuery("rigistration.findAll").getResultList();
        CourseView.getItems().setAll(students);
        em.close();   
        
    }

    @FXML
    private void buttonUpdateTextHandle(ActionEvent event) {
          EntityManager em = this.emf.createEntityManager();
       em.getTransaction().begin();
        int student = em.createQuery(textArea.getText())
                .executeUpdate(); 
        em.getTransaction().commit();
       
    }
     private void resetControls(){
        txtFieldName.setText("");
        txtFieldID.setText("");
        txtFieldMajor.setText("");
        txtFieldGrade.setText("");
        txtFieldStdID.setText("");
        txtFieldCouID.setText("");
        txtFieldSemesterID.setText("");
        tableView.getItems().clear();
        CourseView.getItems().clear();

    }
     private void showSelectedStudent(){
        Student student = tableView.getSelectionModel().getSelectedItem();
        if(student != null){
         txtFieldID.setText(String.valueOf(student.getId()));
        txtFieldName.setText(student.getName());
        txtFieldMajor.setText(student.getMajor());
        txtFieldGrade.setText(String.valueOf(student.getGrade()));
    }
     }
    
    
}
