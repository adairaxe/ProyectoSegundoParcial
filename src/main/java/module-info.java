module ec.edu.espol.proyectosegundopar {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens ec.edu.espol.proyectosegundopar to javafx.fxml;
    exports ec.edu.espol.proyectosegundopar;
    opens ec.edu.espol.controllers to javafx.fxml;
    exports ec.edu.espol.controllers;
    opens ec.edu.espol.modelfmxl to javafx.fxml;
    exports ec.edu.espol.modelfmxl;
   
}
