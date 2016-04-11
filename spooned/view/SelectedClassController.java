package view;


public class SelectedClassController {
    private controller.MainApp _mainApp;

    @javafx.fxml.FXML
    private javafx.scene.control.TextField _txtFieldClassDir;

    @javafx.fxml.FXML
    private javafx.scene.control.Button _btnBuscar;

    @javafx.fxml.FXML
    private javafx.scene.control.Button _btnGenerarTest;

    @javafx.fxml.FXML
    private javafx.scene.control.ScrollPane _scrollPaneMethods;

    @javafx.fxml.FXML
    private javafx.scene.layout.Pane _paneLoadClass;

    @javafx.fxml.FXML
    private javafx.scene.layout.Pane _paneMain;

    @javafx.fxml.FXML
    private javafx.scene.control.cell.CheckBoxListCell<java.lang.String> _chkListMethods;

    public SelectedClassController() {
    }

    @javafx.fxml.FXML
    private void initialize() {
        view.SelectedClassController.this._txtFieldClassDir = new javafx.scene.control.TextField("java file");
        view.SelectedClassController.this._chkListMethods = new javafx.scene.control.cell.CheckBoxListCell<>();
        view.SelectedClassController.this._chkListMethods.setText("aaaaaaaa");
    }

    public void openFileChooser() {
        javafx.stage.FileChooser fileChooser = new javafx.stage.FileChooser();
        fileChooser.setTitle("Selecciona un archivo .java");
        java.util.List<java.lang.String> extensions = new java.util.ArrayList<java.lang.String>();
        extensions.add("*.java");
        javafx.stage.FileChooser.ExtensionFilter filter = new javafx.stage.FileChooser.ExtensionFilter("java files(.java)" , extensions);
        fileChooser.getExtensionFilters().add(filter);
        java.io.File fileClass = fileChooser.showOpenDialog(view.SelectedClassController.this._mainApp.getPrimaryStage());
        java.lang.System.out.println(fileClass.getName());
        if (fileClass != null) {
            view.SelectedClassController.this._txtFieldClassDir.setText(fileClass.getName());
        } 
        model.SpoonedClass sc = new model.SpoonedClass(fileClass.getAbsolutePath());
        sc.loadClass();
        java.lang.System.out.println(sc.getAllMethods());
        javafx.scene.control.ListView<java.lang.String> listView = new javafx.scene.control.ListView<>();
    }

    public void setMainApp(controller.MainApp mainApp) {
        view.SelectedClassController.this._mainApp = mainApp;
    }

    public void changeText(java.lang.String txt) {
        view.SelectedClassController.this._txtFieldClassDir.setText(txt);
    }
}

