package com.asshgar.springbootapp;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootappApplication extends Application{

	@Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/studentView.fxml"));
        loader.setControllerFactory(SpringApplication.run(SpringbootappApplication.class)::getBean);
        Pane pane = loader.load();      
        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Hello World!");
        primaryStage.show();   
    }
    public static void main(String[] args) {
		//SpringApplication.run(ExamApplication.class, args);
                launch(args);
	}


}
