package agh.ics.oop.presenter;

import agh.ics.oop.OptionsParser;
import agh.ics.oop.Simulation;
import agh.ics.oop.SimulationEngine;
import agh.ics.oop.model.*;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.List;

public class SimulationPresenter implements MapChangeListener {


    private WorldMap map;
    @FXML
    private Label infoLabel;
    @FXML
    private TextField textField;
    @FXML
    private Label moveInformationsLabel;

    public void setMap(WorldMap map) {
        this.map = map;
    }
    public void drawMap(){
        infoLabel.setText(map.toString());
    }

    @Override
    public void mapChanged(WorldMap worldMap, String message) {
        Platform.runLater(() -> {
            drawMap();
            moveInformationsLabel.setText(message);
        });
    }

    public void onSimulationStartClicked() {
        List<MoveDirection> directions = OptionsParser.parse(textField.getText().split(","));
        List<Vector2d> positions = List.of(new Vector2d(2, 2), new Vector2d(3, 4));

        GrassField map = new GrassField(10);
        map.addListener(this);
        this.setMap(map);


        Simulation simulation = new Simulation(map,positions,directions);
        SimulationEngine simulationEngine = new SimulationEngine(List.of(simulation));
        simulationEngine.runAsync();
    }
}
