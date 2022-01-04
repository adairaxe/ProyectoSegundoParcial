module ec.edu.espol.proyectosegundopar {
    requires javafx.controls;
    requires javafx.fxml;

    opens ec.edu.espol.proyectosegundopar to javafx.fxml;
    exports ec.edu.espol.proyectosegundopar;
}
