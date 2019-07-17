package Saisi;

import javafx.animation.PauseTransition;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class Presentation {

    private Controle controle;
    private TextField textField;

    public void setControle(Controle controle) {
        this.controle = controle;
    }

    public Presentation(VBox vBox) {

        Text text = new Text();
        text.setText("Température (°C) :");

        textField = new TextField();

        textField.setPromptText("0");

        PauseTransition pause = new PauseTransition(Duration.millis(400));
        textField.textProperty().addListener((observable, oldValue, newValue) -> {

            pause.setOnFinished(event -> {
                        try {
                            int i = Integer.parseInt(newValue);
                            System.out.println("textfield changed from " + oldValue + " to " + newValue);
                            controle.updateAbstraction(i);
                        } catch (Exception e) {
                            textField.setText("");
                        }
                    }
            );

            pause.playFromStart();
        });

        //Setting the space between the nodes of a HBox pane
        vBox.setSpacing(10);

        //Setting the margin to the nodes
        vBox.setMargin(text, new Insets(20, 20, 20, 20));
        vBox.setMargin(textField, new Insets(20, 20, 20, 20));

        //retrieving the observable list of the HBox
        ObservableList list = vBox.getChildren();

        //Adding all the nodes to the observable list (HBox)
        list.addAll(text, textField);
    }

    public void changeTemp(String t) {
        textField.setText(t);
    }
}
