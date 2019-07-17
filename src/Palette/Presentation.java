package Palette;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Presentation {

    private Controle controle;

    public void setControle(Controle controle) {
        this.controle = controle;
    }


    public Presentation(HBox hbox) {

        hbox.setPadding(new Insets(20, 20, 20, 20));
        hbox.setAlignment(Pos.CENTER);
        String cssLayout = "-fx-border-color: #ff9e18;\n" +
                "-fx-border-insets: 5;\n" +
                "-fx-border-width: 3;\n" +
                "-fx-border-style: dashed;\n";
        hbox.setStyle(cssLayout);

        Button button = new Button("Augmenter");
        Button button2 = new Button("Deminuer");
        Button button3 = new Button("Remise a zero");
        Button button4 = new Button("Format Tableau");

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                controle.changeValueBy(10);
            }
        });

        button2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                controle.changeValueBy(-10);
            }
        });

        button3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                controle.remiseZero();
            }
        });

        button4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                controle.afficherFormeTableau();
            }
        });
        //Setting the space between the nodes of a VBox pane
        hbox.setSpacing(10);

        //Setting the margin to the nodes
        hbox.setMargin(button, new Insets(20, 20, 20, 20));
        hbox.setMargin(button2, new Insets(20, 20, 20, 20));
        hbox.setMargin(button3, new Insets(20, 20, 20, 20));
        hbox.setMargin(button4, new Insets(20, 20, 20, 20));

        //retrieving the observable list of the VBox
        ObservableList list = hbox.getChildren();

        //Adding all the nodes to the observable list
        list.addAll(button, button2, button3,button4);
    }
}
