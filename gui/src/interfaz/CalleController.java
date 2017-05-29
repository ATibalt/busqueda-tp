package interfaz;

import domain.Calle;
import domain.Mapa;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import org.apache.commons.collections4.list.NodeCachingLinkedList;

import java.net.URL;
import java.util.*;

/**
 * Created by Juxtar on 28/05/2017.
 */
public class CalleController implements Initializable {
    Mapa mapa;
    boolean cortadas; // Indica si debe agregar a lista de cortadas, congestionadas e.o.c.

    @FXML ComboBox callesCombo;
    @FXML ComboBox alturasCombo;
    @FXML VBox callesContainer;

    public CalleController(Mapa mapa, boolean cortadas) {
        this.mapa = mapa;
        this.cortadas = cortadas;
    }

    public void setMapa(Mapa mapa) {
        this.mapa = mapa;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Set<String> calles = new HashSet<>();
        mapa.getCalles().forEach((c) -> calles.add(c.getNombre()));
        List<String> callesSorted = new ArrayList<>(calles);
        callesSorted.sort(String::compareToIgnoreCase);
        callesCombo.getItems().addAll(callesSorted);
        alturasCombo.setDisable(true);
        callesCombo.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                alturasCombo.getItems().clear();
                alturasCombo.getSelectionModel().clearSelection();
                alturasCombo.setDisable(false);
                Set<Integer> alturas = new HashSet<>();
                for (Calle calle : mapa.getCalles()) {
                    if (calle.getNombre().equals(newValue)) {
                        alturas.add(calle.getAltura());
                    }
                }
                List<Integer> alturasSorted = new ArrayList<>(alturas);
                Collections.sort(alturasSorted);
                alturasCombo.getItems().addAll(alturasSorted);
            }
        });

        if (cortadas)
            for (Calle calle : mapa.getCallesCortadas())
                initCalle(calle);
        else
            for (Calle calle : mapa.getCallesCongestionadas())
                initCalle(calle);

    }

    public void onCalleAgregada(ActionEvent actionEvent) {
        if (alturasCombo.getSelectionModel().isEmpty() && callesCombo.getSelectionModel().isEmpty()) {
            return;
        }
        String nombreCalle = (String)callesCombo.getSelectionModel().getSelectedItem();
        int alturaCalle = (int)alturasCombo.getSelectionModel().getSelectedItem();
        List<Calle> callesAAgregar = new ArrayList<>();
        for (Calle calle : mapa.getCalles()) {
            if (calle.getNombre().equals(nombreCalle) && calle.getAltura() == alturaCalle) {
                callesAAgregar.add(calle);
            }
        }
        if (callesAAgregar.isEmpty())
            return;
        CalleNode nodeCalle = new CalleNode(callesAAgregar.get(0));
        if (callesContainer.getChildren().contains(nodeCalle))
            return;
        nodeCalle.setOnEliminarHandler(event -> {
            if (cortadas)
                mapa.getCallesCortadas().removeAll(callesAAgregar);
            else
                mapa.getCallesCongestionadas().removeAll(callesAAgregar);
            callesContainer.getChildren().remove(nodeCalle);
        });
        callesContainer.getChildren().add(nodeCalle);
        if (cortadas)
            mapa.getCallesCortadas().addAll(callesAAgregar);
        else
            mapa.getCallesCongestionadas().addAll(callesAAgregar);
    }

    private void initCalle(Calle calle) {
        CalleNode nodeCalle = new CalleNode(calle);
        nodeCalle.setOnEliminarHandler(event -> {
            List<Calle> callesAEliminar = new ArrayList<>();
            for (Calle c : mapa.getCalles()) {
                if (c.getNombre().equals(calle.getNombre()) && c.getAltura() == calle.getAltura()) {
                    callesAEliminar.add(c);
                }
            }
            if (cortadas)
                mapa.getCallesCortadas().removeAll(callesAEliminar);
            else
                mapa.getCallesCongestionadas().removeAll(callesAEliminar);
            callesContainer.getChildren().remove(nodeCalle);
        });
        if (!callesContainer.getChildren().contains(nodeCalle))
            callesContainer.getChildren().add(nodeCalle);
    }
}
