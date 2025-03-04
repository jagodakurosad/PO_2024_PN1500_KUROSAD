package agh.ics.oop.presenter;

import agh.ics.oop.OptionsParser;
import agh.ics.oop.Simulation;
import agh.ics.oop.SimulationEngine;
import agh.ics.oop.model.*;
import agh.ics.oop.model.util.Boundary;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;

import java.util.Collection;
import java.util.List;

public class SimulationPresenter implements MapChangeListener {
    private final int CELL_WIDTH = 40;
    private final int CELL_HEIGHT = 40;
    private WorldMap map;
    private Boundary mapBounadries;
    private int gridHeight;
    private int gridWidth;
    @FXML
    private TextField textField;
    @FXML
    private Label moveInformationsLabel;
    @FXML
    private GridPane MapDisplayGrid;

    public void setMap(WorldMap map) {
        this.map = map;
    }
    private void createGrid(){
        gridHeight = mapBounadries.upperRightCorner().getY() - mapBounadries.lowerLeftCorner().getY() +1;
        gridWidth = mapBounadries.upperRightCorner().getX() - mapBounadries.lowerLeftCorner().getX() +1;

        for(int j=0; j<gridHeight+1; j++){
            MapDisplayGrid.getRowConstraints().add(new RowConstraints(CELL_HEIGHT));
        }
        for(int i=0; i<gridWidth+1; i++){
            MapDisplayGrid.getColumnConstraints().add(new ColumnConstraints(CELL_WIDTH));
        }
    }

    private void addLabels(){
        Label label = new Label("y/x");
        GridPane.setHalignment(label, HPos.CENTER);
        MapDisplayGrid.add(label, 0, gridHeight);

        for(int i=0; i< gridWidth; i++){
            Label labelX = new Label(String.valueOf(mapBounadries.lowerLeftCorner().getX() +i));
            GridPane.setHalignment(labelX, HPos.CENTER);
            MapDisplayGrid.add(labelX,1+i,gridHeight);
        }

        for(int i=0; i<gridHeight; i++){
            Label labelY = new Label(String.valueOf(mapBounadries.upperRightCorner().getY() -i));
            GridPane.setHalignment(labelY, HPos.CENTER);
            MapDisplayGrid.add(labelY,0,i);
        }
    }
    public void addElementsOnMap(){
        Collection<WorldElement> elements = map.getElements();
        for(WorldElement element : elements){
            Label elementLabel = new Label(element.toString());
            GridPane.setHalignment(elementLabel, HPos.CENTER);
            Vector2d position = element.getPositionOnMap();
            MapDisplayGrid.add(elementLabel, position.getX() +1 - mapBounadries.lowerLeftCorner().getX(),mapBounadries.upperRightCorner().getY() - position.getY());
    }}
    public void drawMap(){
        clearGrid();

        mapBounadries = map.getCurrentBounds();
        createGrid();
        addLabels();
        addElementsOnMap();
    }
    private void clearGrid() {
        MapDisplayGrid.getChildren().retainAll(MapDisplayGrid.getChildren().get(0)); // hack to retain visible grid lines
        MapDisplayGrid.getColumnConstraints().clear();
        MapDisplayGrid.getRowConstraints().clear();
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


