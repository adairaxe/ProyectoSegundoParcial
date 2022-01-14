module ec.edu.espol.proyectosegundopar {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens ec.edu.espol.proyectosegundopar to javafx.fxml;
    exports ec.edu.espol.proyectosegundopar;
}
