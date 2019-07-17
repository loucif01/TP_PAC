package Principale;

import app.Tempurature;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Presentation {

    private Scene scene;

    public HBox pallettePresentation;
    public VBox saisiPresentation;
    private XYChart.Series series;

    private Group linechartG;

    public Presentation(Stage primaryStage) {

        VBox vBoxR = new VBox();
        Group root = new Group();

        primaryStage.setTitle("PAC TP IHM");
        primaryStage.setWidth(700);
        primaryStage.setHeight(600);

        HBox hBox0 = new HBox();

        //Defining X axis
        NumberAxis xAxis = new NumberAxis(0, 20, 1);
        xAxis.setLabel("Modif");
        //Defining y axis
        NumberAxis yAxis = new NumberAxis(-10, 100, 10);
        yAxis.setLabel("Temperature");
        LineChart linechart = new LineChart(xAxis, yAxis);
        series = new XYChart.Series();
        series.setName("Température (°C)");
        series.getData().add(new XYChart.Data(0, 0));
        //Setting the data to Line chart
        linechart.getData().add(series);
        linechartG = new Group(linechart);
        hBox0.getChildren().add(linechartG);


        saisiPresentation = new VBox();
        hBox0.getChildren().add(saisiPresentation);


        vBoxR.getChildren().add(hBox0);


        pallettePresentation = new HBox();
        vBoxR.getChildren().add(pallettePresentation);


        vBoxR.setSpacing(10);
        vBoxR.setMargin(pallettePresentation, new Insets(10, 60, 60, 20));


        root.getChildren().add(vBoxR);

        scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public XYChart.Series getSeries() {
        return series;
    }

}
