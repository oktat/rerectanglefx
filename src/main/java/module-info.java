/*
* File: module-info.java
* Author: Sallai András
* Copyright: 2024, Sallai András
* Group: szit.hu
* Date: 2024-12-01
* Github: https://github.com/oktat/rerectanglefx/
* Licenc: MIT
*/

module hu.szit {
    requires transitive javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;

    opens hu.szit to javafx.fxml;
    exports hu.szit;
}
