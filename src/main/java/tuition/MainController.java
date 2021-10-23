package tuition;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class MainController {

    @FXML
    private ToggleGroup Major;

    @FXML
    private ToggleGroup NYorCT;

    @FXML
    private ToggleGroup Residency;

    @FXML
    private RadioButton baMajor;

    @FXML
    private TextField creditHoursTextField;

    @FXML
    private RadioButton csMajor;

    @FXML
    private RadioButton ctResidency;

    @FXML
    private RadioButton eeMajor;

    @FXML
    private RadioButton internationalResidency;

    @FXML
    private RadioButton itMajor;

    @FXML
    private RadioButton meMajor;

    @FXML
    private RadioButton nonResidentResidency;

    @FXML
    private RadioButton nyResidency;

    @FXML
    private TextArea outPutField;

    @FXML
    private Button performAddStudent;

    @FXML
    private Button performDeleteStudent;

    @FXML
    private Button performSetStudyAbroad;

    @FXML
    private RadioButton residentResidency;

    @FXML
    private TextField studentNameTextField;

    @FXML
    private RadioButton studyAbroadResidency;

    @FXML
    private RadioButton triStateResidency;

    @FXML
    void addStudentToRoster(ActionEvent event) {
    }

    @FXML
    void deleteStudentFromRoster(ActionEvent event) {

    }

    @FXML
    void setStudyAbroadStatus(ActionEvent event) {

    }

}
