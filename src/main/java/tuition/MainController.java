package tuition;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class MainController {
    private Roster roster = new Roster();
    private Major major = null;
    private String studentName = null;
    private String paymentAmount = null;
    private int maxCreditHours = 24;
    private int minCreditHours = 3;
    private int PLACE_HOLDER_FOR_CREDIT_HOURS = 12;

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
    private RadioButton baMajorTwo;

    @FXML
    private RadioButton baMajorThree;

    @FXML
    private TextField creditHoursTextField;

    @FXML
    private TextField creditHoursTextFieldTwo;

    @FXML
    private RadioButton csMajor;

    @FXML
    private RadioButton csMajorThree;

    @FXML
    private RadioButton ctResidency;

    @FXML
    private RadioButton eeMajor;

    @FXML
    private RadioButton eeMajorThree;

    @FXML
    private RadioButton internationalResidency;

    @FXML
    private RadioButton itMajor;

    @FXML
    private RadioButton itMajorThree;

    @FXML
    private RadioButton meMajor;

    @FXML
    private RadioButton meMajorThree;

    @FXML
    private RadioButton csMajorTwo;

    @FXML
    private RadioButton ctResidencyTwo;

    @FXML
    private RadioButton eeMajorTwo;

    @FXML
    private RadioButton internationalResidencyTwo;

    @FXML
    private RadioButton itMajorTwo;

    @FXML
    private RadioButton meMajorTwo;

    @FXML
    private RadioButton oneStudent;

    @FXML
    private RadioButton entireRoster;

    @FXML
    private RadioButton nonResidentResidency;

    @FXML
    private RadioButton nonResidentResidencyTwo;

    @FXML
    private RadioButton nyResidency;

    @FXML
    private RadioButton nyResidencyTwo;

    @FXML
    private TextArea outPutField;

    @FXML
    private Button performAddStudent;

    @FXML
    private Button performDeleteStudent;

    @FXML
    private Button performSetStudyAbroad;

    @FXML
    private Button performCalculateStudent;

    @FXML
    private Button performCalculateRoster;

    @FXML
    private RadioButton residentResidency;

    @FXML
    private RadioButton residentResidencyTwo;

    @FXML
    private TextField studentNameTextField;

    @FXML
    private TextField studentNameTextFieldTwo;

    @FXML
    private TextField studentNameTextFieldThree;

    @FXML
    private TextField paymentAmountTextField;

    @FXML
    private RadioButton studyAbroadResidency;

    @FXML
    private RadioButton triStateResidency;

    @FXML
    private RadioButton studyAbroadResidencyTwo;

    @FXML
    private RadioButton triStateResidencyTwo;

    @FXML
    void triStateSelectedHide(ActionEvent event) {
        nyResidency.setDisable(false);
        ctResidency.setDisable(false);
        studyAbroadResidency.setDisable(true);
        studyAbroadResidency.setSelected(false);
        performSetStudyAbroad.setDisable(true);
    }

    @FXML
    void residentSelectedHide(ActionEvent event) {
        studyAbroadResidency.setDisable(true);
        studyAbroadResidency.setSelected(false);
        nyResidency.setDisable(true);
        nyResidency.setSelected(false);
        ctResidency.setDisable(true);
        ctResidency.setSelected(false);
        performSetStudyAbroad.setDisable(true);
    }

    @FXML
    void InternationalSelectedHide(ActionEvent event) {
        studyAbroadResidency.setDisable(false);
        nyResidency.setDisable(true);
        nyResidency.setSelected(false);
        ctResidency.setDisable(true);
        ctResidency.setSelected(false);
        performSetStudyAbroad.setDisable(false);
    }

    @FXML
    public boolean checkIfValidStudentInput(ActionEvent event) {
        try {
            if (studentName.isEmpty()) {
                outPutField.appendText("Enter a name for the student.\n");
                return false;
            } else if (!(studentName.isEmpty())) {
                char[] checkIfStudentNameOnlyHasLetters = studentName.toCharArray();
                for (char c : checkIfStudentNameOnlyHasLetters) {
                    if (!Character.isLetter(c) && !(Character.isSpaceChar(c))) {
                        outPutField.appendText("Please use only characters for student name.\n");
                        return false;
                    }
                }
            }
            if (major == null) {
                outPutField.appendText("Please select a major.\n");
                return false;
            }
            if (Residency.getSelectedToggle() == null) {
                outPutField.appendText("Please select a form of residency.\n");
                return false;
            }
            if (Integer.parseInt(creditHoursTextField.getText()) < minCreditHours) {
                outPutField.appendText("Please use only credit hours greater than 2.\n");
                return false;
            } else if (Integer.parseInt(creditHoursTextField.getText()) > maxCreditHours) {
                outPutField.appendText("Please use only credit hours less than 24.\n");
                return false;
            }
            return true;
        } catch (NumberFormatException e) {
            outPutField.appendText("You must use only numbers ranging from 2-24 for credit amount.\n");
            return false;
        }
    }

    @FXML
    public void setStudentName(ActionEvent event) {
        studentName = studentNameTextField.getText().trim();
    }

    @FXML
    public void setPaymentAmount(ActionEvent event) {
        paymentAmount = paymentAmountTextField.getText().trim();
    }

    @FXML
    public void setMajorCS(ActionEvent event) {
        if (csMajor.isSelected()) {
            major = Major.CS;
        }
    }

    @FXML
    public void setMajorBA(ActionEvent event) {
        if (baMajor.isSelected()) {
            major = Major.BA;
        }
    }

    @FXML
    public void setMajorEE(ActionEvent event) {
        if (eeMajor.isSelected()) {
            major = Major.EE;
        }
    }

    @FXML
    public void setMajorME(ActionEvent event) {
        if (meMajor.isSelected()) {
            major = Major.ME;
        }
    }

    @FXML
    public void setMajorIT(ActionEvent event) {
        if (itMajor.isSelected()) {
            major = Major.IT;
        }
    }

    @FXML
    public void addResident(ActionEvent event) {
        Resident resident = new Resident(studentNameTextField.getText(), major,
                Integer.parseInt(creditHoursTextField.getText()));
        if (roster.add(resident)) {
            outPutField.appendText(studentNameTextField.getText() + " was added to roster.\n");
        } else {
            outPutField.appendText(studentNameTextField.getText() + " student is already in roster.\n");
        }
    }

    @FXML
    public void addInternationalStudentStudyAbroad(ActionEvent event) {
        International international = new International(studentNameTextField.getText(), major,
                Integer.parseInt(creditHoursTextField.getText()), true);
        if (roster.add(international)) {
            outPutField.appendText(studentNameTextField.getText() + " was added to roster.\n");
        } else {
            outPutField.appendText(studentNameTextField.getText() + " student is already in roster.\n");
        }
    }

    @FXML
    public void addInternationalStudentNotStudyAbroad(ActionEvent event) {
        International international = new International(studentNameTextField.getText(), major,
                Integer.parseInt(creditHoursTextField.getText()), false);
        if (Integer.parseInt(creditHoursTextField.getText()) < 12) {
            outPutField.appendText("International students credits cannot be less than 12");
        } else if (roster.add(international)) {
            outPutField.appendText(studentNameTextField.getText() + " was added to roster.\n");
        } else {
            outPutField.appendText(studentNameTextField.getText() + " student is already in roster.\n");
        }
    }

    @FXML
    public void addTriStateStudentNY(ActionEvent event) {
        TriState tristate = new TriState(studentNameTextField.getText(), major,
                Integer.parseInt(creditHoursTextField.getText()), "NY");
        if (roster.add(tristate)) {
            outPutField.appendText(studentNameTextField.getText() + " was added to roster.\n");
        } else {
            outPutField.appendText(studentNameTextField.getText() + " student is already in roster.\n");
        }
    }

    @FXML
    public void addTriStateStudentCT(ActionEvent event) {
        TriState tristate = new TriState(studentNameTextField.getText(), major,
                Integer.parseInt(creditHoursTextField.getText()), "CT");
        if (roster.add(tristate)) {
            outPutField.appendText(studentNameTextField.getText() + " was added to roster.\n");
        } else {
            outPutField.appendText(studentNameTextField.getText() + " student is already in roster.\n");
        }
    }

    @FXML
    void addStudentToRoster(ActionEvent event) {
        setStudentName(event);
        if (checkIfValidStudentInput(event)) {
            if (residentResidency.isSelected()) {
                addResident(event);
            } else if (internationalResidency.isSelected()) {
                if (studyAbroadResidency.isSelected()) {
                    addInternationalStudentStudyAbroad(event);
                } else {
                    addInternationalStudentNotStudyAbroad(event);
                }
            } else if (triStateResidency.isSelected()) {
                if (nyResidency.isSelected()) {
                    addTriStateStudentNY(event);
                } else if (ctResidency.isSelected()) {
                    addTriStateStudentCT(event);
                } else {
                    outPutField.appendText("Please select either CT or NY if adding a tristate student.\n");
                }
            }
        }
    }


    @FXML
    void deleteStudentFromRoster(ActionEvent event) {
        setStudentName(event);
        if (checkIfValidStudentInput(event)) {
            Student student = new Student(studentNameTextField.getText(), major, PLACE_HOLDER_FOR_CREDIT_HOURS);
            if (roster.remove(student)) {
                outPutField.appendText(studentNameTextField.getText() + " was removed.\n");
            } else {
                outPutField.appendText(studentNameTextField.getText() + " is not in the roster.\n");
            }

        }
    }

    @FXML
    @FXML
    void displayRoster(ActionEvent event) {
        if (roster.getSize() == 0) {
            outPutField.appendText("Student roster is empty!\n");
        } else {
            outPutField.appendText("* list of students **\n");
            outPutField.appendText(roster.print() + "\n");
            outPutField.appendText("* end of roster **\n");
        }
    }


    @FXML
    void displayRosterByName(ActionEvent event) {
        if (roster.getSize() == 0) {
            outPutField.appendText("Student roster is empty!\n");
        } else {
            outPutField.appendText("* list of students ordered by name **\n");
            outPutField.appendText(roster.printByName() + "\n");
            outPutField.appendText("* end of roster **\n");
        }
    }

    @FXML
    void displayRosterByPaymentDate(ActionEvent event) {
        if (roster.getSize() == 0) {
            outPutField.appendText("Student roster is empty!\n");
        } else {
            outPutField.appendText("* list of students ordered by Date **\n");
            outPutField.appendText(roster.printByDate() + "\n");
            outPutField.appendText("* end of roster **\n");
        }
    }


    @FXML
    void setStudyAbroadStatus(ActionEvent event) {
        setStudentName(event);
        if (checkIfValidStudentInput(event)) {
            Student student = new Student(studentNameTextField.getText(), major, PLACE_HOLDER_FOR_CREDIT_HOURS);
            if (roster.studentInRoster(student) == null) {
                outPutField.appendText("International student not found.\n");

            } else if (roster.replaceStudyAbroad(student) != null) {
                International international = (International) roster.replaceStudyAbroad(student);
                if (international.getStudyAbroadStatus() != true) {
                    international.setStudyAbroadStatus(true);
                    international.setTotalCreditHours(12);
                    international.setTuitionDue(0);
                    international.tuitionDue();
                    international.setLastPaymentDate(null);
                    outPutField.appendText(studentNameTextField.getText() + " is all set to study abroad.\n");
                } else {
                    outPutField.appendText("Student is already studying abroad.\n");
                }
            }

        }
    }


    @FXML
    void calculateOneStudentTuition(ActionEvent event) {
        setStudentName(event);
        if (checkIfValidStudentInput(event)) {
            Student student = new Student(studentNameTextFieldThree.getText(), major, PLACE_HOLDER_FOR_CREDIT_HOURS);
            if (roster.studentInRoster(student) == null) {
                outPutField.appendText("Student not found.\n");
            } else {
                student.setTuitionDue(0);
                student.tuitionDue();
                outPutField.appendText(studentNameTextFieldThree.getText() + " tuition due:" + student.getTuitionDue());
            }
        }
    }


    @FXML
    void calculateEntireRosterTuition(ActionEvent event) {
        setStudentName(event);
        int totalTuitionDue = 0;
        if (roster.getSize() == 0) {
            outPutField.appendText("Student roster is empty!\n");
        } else if (roster.getSize() > 0) {
            for (int i = 0; i < roster.getSize(); i++) {
                student[i].setTuitionDue(0);
                totalTuitionDue += student[i].tuitionDue();
                outPutField.appendText("Roster total tuition due:" + totalTuitionDue);
            }
        }
    }


    @FXML
    void financialAid(ActionEvent event) {
        setStudentName(event);
        if (checkIfValidStudentInput(event)) {
            Student student = new Student(studentNameTextFieldTwo.getText(), major, PLACE_HOLDER_FOR_CREDIT_HOURS);
            if (roster.studentInRoster(student) == null) {
                outPutField.appendText("Student not found.\n");
            } else if (paymentAmountTextField.getText() == null) {
                outPutField.appendText("Payment amount not found.\n");
            } else if (Integer.parseInt(paymentAmountTextField.getText()) == 0) {
                outPutField.appendText("Please enter payment amount greater than zero.\n");
            } else if (Integer.parseInt(paymentAmountTextField.getText()) < 0) {
                outPutField.appendText("Please enter a non-negative payment amount.\n");
            } else if (roster1.replaceFinancialAid(student) != null) {
                Resident resident = (Resident) roster1.replaceFinancialAid(student);
                if (resident.financialAid()) {
                    outPutField.appendText("Awarded once already.\n");
                } else if (resident.getTotalCreditHours() < MINIMUM_CREDIT_FOR_FULL_TIME) {
                    outPutField.appendText("Parttime student doesn't qualify for the award.\n");
                } else {
                    resident.setResidentFinancialAid(Double.valueOf(parse[3]));
                    resident.setFinancialAidRecieved(true);
                    resident.setRecievedFinancialAidAmount(Double.valueOf(parse[3]));
                    outPutField.appendText("Tuition updated.\n");
                }
            } else {
                outPutField.appendText("Not a resident student.\n");
            }

        }
    }


    @FXML
    void calculatePayment(ActionEvent event) {
        setStudentName(event);
        if (checkIfValidStudentInput(event)) {
            Student student = new Student(studentNameTextFieldTwo.getText(), major, PLACE_HOLDER_FOR_CREDIT_HOURS);
            if (roster.studentInRoster(student) == null) {
                outPutField.appendText("Student not found.\n");
            } else if (paymentAmountTextField.getText() == null) {
                outPutField.appendText("Payment amount not found.\n");
            } else if (Integer.parseInt(paymentAmountTextField.getText()) == 0) {
                outPutField.appendText("Please enter payment amount greater than zero.\n");
            } else if (Integer.parseInt(paymentAmountTextField.getText()) < 0) {
                outPutField.appendText("Please enter a non-negative payment amount.\n");
            } else {
                student.tuitionDue() = student.tuitionDue() - Integer.parseInt(paymentAmountTextField.getText());
                outPutField.appendText("Tuition due after payment:" + student.getTuitionDue());
            }

        }
    }


}


