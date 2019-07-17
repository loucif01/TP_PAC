package FormeTableau;

import app.Tempurature;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class Presentation {

    private Controle controle;
    private Stage stage;
    private Scene scene;
    private TableView<Tempurature> table = new TableView<>();


    public Presentation(Controle controle) {
        this.controle = controle;
        stage = new Stage();

        stage.setX(0);
        stage.setY(0);

        stage.setTitle("Format Tableau");

        TableColumn<Tempurature, Integer> modifCol = new TableColumn("Modif");
        modifCol.setCellValueFactory(new PropertyValueFactory<>("modif"));
        TableColumn<Tempurature, Integer> tempCol = new TableColumn("Tempurature °C");
        tempCol.setCellValueFactory(new PropertyValueFactory<>("temp"));

        table.getColumns().addAll(modifCol, tempCol);

        fillTable();

        scene = new Scene(table);
        stage.setScene(scene);
        stage.show();
    }


    public void fillTable() {
        table.getItems().clear();
        System.out.println(controle.abstraction.getHistory());
        for (int i = 0; i < controle.abstraction.getHistory().size(); i++) {
            table.getItems().add(new Tempurature(i,
                    controle.abstraction.getHistory().get(i)));
        }

    }
}
