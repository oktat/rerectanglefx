/*
* File: MainController.java
* Author: Sallai András
* Copyright: 2024, Sallai András
* Group: szit.hu
* Date: 2024-12-01
* Github: https://github.com/oktat/rerectanglefx/
* Licenc: MIT
*/

package hu.szit;

import java.io.FileWriter;
import java.io.IOException;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class MainController {

    // Az areaField tartalmazza a téglalap területét
    @FXML
    private TextField c;

    // Az asideField, bsideField tartalmazza az oldalok hosszúkat
    @FXML
    private TextField a;

    @FXML
    private TextField b;

    @FXML
    void onClickAboutButton(ActionEvent event) {
        System.out.println("Névjegy");
        Alert br = new Alert(Alert.AlertType.INFORMATION);
        br.setTitle("Névjegy");
        br.setHeaderText("Téglalap");
        br.setContentText("Sallai András");
        br.showAndWait();
    }

    @FXML
    void onClickCalcButton(ActionEvent event) {
        System.out.println("Számítás");
        double aside = Double.parseDouble(a.getText());
        double bside = Double.parseDouble(b.getText());
        double area = aside * bside;
        c.setText(String.valueOf(area));
    }

    @FXML
    void onClickExitButton(ActionEvent event) {
        System.out.println("Kilépés");
        Platform.exit();
    }

    @FXML
    void onClickSaveButton(ActionEvent event) {
        /*
         * Itt sokat kellett godolkoznom. Vajon milyen adatokat kell kinyerni?
         * Milyen adatokat kell fájlba irni? Az egész előtt kiírjam, hogy mi fog
         * történi a konzolra? A main napig nem tudom, hogy ez szükséges
         * vagy nem. Az adatoka fájlba írása is elgondolkodtató. Biztos
         * kettőponttal tagoljam a kiírást, vagy legyen valmai más?
         */
        System.out.println("Mentés");
        //Adatok kinyerése        
        
        //Lekérdezük a bevitelimezők tartalmát.
        double aka = Double.parseDouble(a.getText());
        double beke = Double.parseDouble(b.getText());
        double e  = Double.parseDouble(c.getText());

        //TODO: Ellenőrizni kell, vajon üres-e a beviteli mező

        //Adatok fájlbaírása
        FileWriter fw = null;
        try { //Hibakezelés
            fw = new FileWriter("data.txt", true);
            fw.write(aka + ":");
            fw.write(beke + ":");
            fw.write(e + "\n");
            fw.close();
        } catch (IOException gere) { //Hibakezelés vége
            System.err.println("Hiba! A kiírás sikertelen!");
            System.err.println(gere.getMessage());
        }
    }

}
