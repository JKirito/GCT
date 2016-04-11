package controller;


public class MainApp extends javafx.application.Application {
    private javafx.stage.Stage primaryStage;

    private javafx.scene.layout.AnchorPane rootLayout;

    @java.lang.Override
    public void start(javafx.stage.Stage primaryStage) {
        controller.MainApp.this.primaryStage = primaryStage;
        controller.MainApp.this.primaryStage.setTitle("Generador de casos de Tests Unitarios");
        initRootLayout();
    }

    public void initRootLayout() {
        try {
            javafx.fxml.FXMLLoader loader = new javafx.fxml.FXMLLoader();
            loader.setLocation(controller.MainApp.class.getResource("../view/GCTWindow.fxml"));
            rootLayout = ((javafx.scene.layout.AnchorPane)(loader.load()));
            javafx.scene.Scene scene = new javafx.scene.Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
            view.SelectedClassController controller = loader.getController();
            controller.setMainApp(controller.MainApp.this);
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }

    public javafx.stage.Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(java.lang.String[] args) {
        javafx.application.Application.launch(args);
    }
}

