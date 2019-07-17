package app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PAC extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
//        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
//        primaryStage.setTitle("Hello World");
//        primaryStage.setScene(new Scene(root, 300, 275));
//        primaryStage.show();

        Principale.Controle controle = new Principale.Controle();
        controle.creePresentation(primaryStage);

//
//        Stage stage = new Stage();
//        ViewInput view2 = new ViewInput(stage) ;
//        Model model = new Model(0);
//        Controller controller=new Controller(model,view,view2);
//        controller.control();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
