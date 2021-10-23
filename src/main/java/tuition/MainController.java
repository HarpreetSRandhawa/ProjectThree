package tuition;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class MainController {
    Roster roster = new Roster();

    @FXML
    private Button displayRosterButton;

    @FXML
    private Button displayRosterByNameButton;

    @FXML
    private Button displayRosterByPaymentDateButton;

    @FXML
    private ToggleGroup MajorGroup;

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
        Major major = null;
        if(csMajor.isSelected()){
            major = Major.CS;
        }
        else if(baMajor.isSelected()){
            major = Major.BA;
        }
        else if(meMajor.isSelected()){
            major = Major.ME;
        }
        else if(eeMajor.isSelected()){
            major = Major.EE;
        }
        else if(itMajor.isSelected()){
            major = Major.IT;
        }
        if(residentResidency.isSelected()){
            Resident resident = new Resident(studentNameTextField.getText(), major,
                    Integer.parseInt(creditHoursTextField.getText()));
            if(roster.add(resident)){
                outPutField.setText(studentNameTextField.getText() + " was added to roster.");
            }
            else{
                outPutField.setText(studentNameTextField.getText() + " student is already in roster.");
            }
        }
        else if(internationalResidency.isSelected()){
            if(studyAbroadResidency.isSelected()){
                International international = new International(studentNameTextField.getText(), major,
                        Integer.parseInt(creditHoursTextField.getText()), true);
                if(roster.add(international)){
                    outPutField.setText(studentNameTextField.getText() + " was added to roster.");
                }
                else{
                    outPutField.setText(studentNameTextField.getText() + " student is already in roster.");
                }
            }
            else{
                International international = new International(studentNameTextField.getText(), major,
                        Integer.parseInt(creditHoursTextField.getText()), false);
                if(roster.add(international)){
                    outPutField.setText(studentNameTextField.getText() + " was added to roster.");
                }
                else{
                    outPutField.setText(studentNameTextField.getText() + " student is already in roster.");
                }
            }
        }
        else if(triStateResidency.isSelected()){
            if(nyResidency.isSelected()){
                TriState tristate = new TriState(studentNameTextField.getText(), major,
                        Integer.parseInt(creditHoursTextField.getText()), "NY");
                if(roster.add(tristate)){
                    outPutField.setText(studentNameTextField.getText() + " was added to roster.");
                }
                else{
                    outPutField.setText(studentNameTextField.getText() + " student is already in roster.");
                }
            }
            else{
                TriState tristate = new TriState(studentNameTextField.getText(), major,
                        Integer.parseInt(creditHoursTextField.getText()), "CT");
                if(roster.add(tristate)){
                    outPutField.setText(studentNameTextField.getText() + " was added to roster.");
                }
                else{
                    outPutField.setText(studentNameTextField.getText() + " student is already in roster.");
                }
            }
        }
    }


    @FXML
    void deleteStudentFromRoster(ActionEvent event) {
        Major major = null;
        if(csMajor.isSelected()){
            major = Major.CS;
        }
        else if(baMajor.isSelected()){
            major = Major.BA;
        }
        else if(meMajor.isSelected()){
            major = Major.ME;
        }
        else if(eeMajor.isSelected()){
            major = Major.EE;
        }
        else if(itMajor.isSelected()){
            major = Major.IT;
        }
        Student student = new Student(studentNameTextField.getText(), major, 5);
        if(roster.remove(student)){
            outPutField.setText(studentNameTextField.getText() + " was removed");
        }
        else{
            outPutField.setText(studentNameTextField.getText() + " is not in the roster.");
        }

    }
    //I got the print statements
    @FXML
    void displayRoster(ActionEvent event) {
    }

    @FXML
    void displayRosterByName(ActionEvent event) {

    }

    @FXML
    void displayRosterByPaymentDate(ActionEvent event) {

    }

    @FXML
    void setStudyAbroadStatus(ActionEvent event) {
        Major major = null;
        if(csMajor.isSelected()){
            major = Major.CS;
        }
        else if(baMajor.isSelected()){
            major = Major.BA;
        }
        else if(meMajor.isSelected()){
            major = Major.ME;
        }
        else if(eeMajor.isSelected()){
            major = Major.EE;
        }
        else if(itMajor.isSelected()){
            major = Major.IT;
        }
        Student student = new Student(studentNameTextField.getText(), major, 5);
        if(roster.studentInRoster(student) == null){
            outPutField.setText("International student not found.");
        }
        else if(roster.replaceStudyAbroad(student) != null){
            International international = (International) roster.replaceStudyAbroad(student);
            international.setStudyAbroadStatus(true);
            international.setTotalCreditHours(12);
            international.setTuitionDue(0);
            international.tuitionDue();
            international.setLastPaymentDate(null);
            outPutField.setText(studentNameTextField.getText() + " is all set to study abroad.");
        }

    }

}
