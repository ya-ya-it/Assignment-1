package assignment;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GUI_Code_Davydenko_200335788 extends Application {

    Stage window;
    Button buttonAdd;
    Button buttonDelete;
    TableView<GUI_Course_Davydenko_200335788> table;
    TextField courseName, courseCode, instructor, grade;
    Label labelOverallAverageGrade;
    List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Courses and Grades");

        //add button
        buttonAdd = new Button("Add");

        //delete button
        buttonDelete = new Button("Delete");

        //course name
        courseName = new TextField();
        courseName.setPromptText("Course Name");
        courseName.setMinWidth(50);

        //course code
        courseCode = new TextField();
        courseCode.setPromptText("Course Code");
        courseCode.setMinWidth(50);

        //instructor name
        instructor = new TextField();
        instructor.setPromptText("Instructor");
        instructor.setMinWidth(50);

        //grade
        grade = new TextField();
        grade.setPromptText("Grade");
        grade.setMinWidth(50);

        //column in table
        TableColumn<GUI_Course_Davydenko_200335788, String> courseNameColumn = new TableColumn<>("Course Name");
        courseNameColumn.setCellValueFactory(new PropertyValueFactory<>("courseName"));

        TableColumn<GUI_Course_Davydenko_200335788, String> courseCodeColumn = new TableColumn<>("Course Code");
        courseCodeColumn.setCellValueFactory(new PropertyValueFactory<>("courseCode"));

        TableColumn<GUI_Course_Davydenko_200335788, String> instructorColumn = new TableColumn<>("Instructor");
        instructorColumn.setCellValueFactory(new PropertyValueFactory<>("instructor"));

        TableColumn<GUI_Course_Davydenko_200335788, Integer> gradeColumn = new TableColumn<>("Grade");
        gradeColumn.setCellValueFactory(new PropertyValueFactory<>("grade"));

        TableColumn<GUI_Course_Davydenko_200335788, Integer> letterGradeColumn = new TableColumn<>("Letter Grade");
        letterGradeColumn.setCellValueFactory(new PropertyValueFactory<>("letterGrade"));

        //create table
        table = new TableView<>();
        table.setItems(getInformation());
        table.getColumns().addAll(courseNameColumn, courseCodeColumn, instructorColumn, gradeColumn, letterGradeColumn);

        //action on button
        buttonAdd.setOnAction(e -> addButtonClicked());
        buttonDelete.setOnAction(e -> deleteButtonClicked());

        labelOverallAverageGrade = new Label("");
        labelOverallAverageGrade.setText("The overall average mark is " + getAverageGrade()
                + ", which is a letter grade of " + getLetterAverageGrade());

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);

        grid.getChildren().addAll(buttonAdd, buttonDelete, courseName, courseCode,
                instructor, grade, labelOverallAverageGrade);

        GridPane.setConstraints(buttonAdd, 1, 2);
        GridPane.setConstraints(buttonDelete, 2, 2);
        GridPane.setConstraints(courseName, 0, 1);
        GridPane.setConstraints(courseCode, 1, 1);
        GridPane.setConstraints(instructor, 2, 1);
        GridPane.setConstraints(grade, 0, 2);
        GridPane.setConstraints(labelOverallAverageGrade, 3, 2);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(table);

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(vBox);
        borderPane.setBottom(grid);

        Scene scene = new Scene(borderPane, 900, 500);

        window.setScene(scene);
        window.show();
    }

    public ObservableList<GUI_Course_Davydenko_200335788> getInformation() {
        ObservableList<GUI_Course_Davydenko_200335788> info = FXCollections.observableArrayList();

        info.add(new GUI_Course_Davydenko_200335788("Programming Fundamentals", "COMP1030", "Jaret Wright", 100));
        return info;
    }

    //Add button clicked
    public void addButtonClicked() {
        GUI_Course_Davydenko_200335788 info = new GUI_Course_Davydenko_200335788();
        info.setCourseName(courseName.getText());
        info.setCourseCode(courseCode.getText());
        info.setInstructor(instructor.getText());
        info.setGrade(Integer.parseInt(grade.getText()));
        double inputedGrade = Double.parseDouble(grade.getText());
        info.setLetterGrade(getLetterGrades(inputedGrade));
        table.getItems().add(info);
        courseName.clear();
        courseCode.clear();
        instructor.clear();
        grade.clear();
        labelOverallAverageGrade.setText("The overall average mark is " + getAverageGrade()
                + ", which is a letter grade of " + getLetterAverageGrade());
        list.clear();
        
    }

    //Delete button clicked
    public void deleteButtonClicked() {
        ObservableList<GUI_Course_Davydenko_200335788> productSelected, allProducts;
        allProducts = table.getItems();
        productSelected = table.getSelectionModel().getSelectedItems();
        labelOverallAverageGrade.setText("The overall average mark is " + getAverageGrade()
                + ", which is a letter grade of " + getLetterAverageGrade());
        list.clear();
        
        productSelected.forEach(allProducts::remove);
    }

    public static String getLetterGrades(double grade) {
        String letterGrade;
        if (grade <= 100 && grade >= 80) {
            letterGrade = "A";
        } else if (grade <= 79 && grade >= 70) {
            letterGrade = "B";
        } else if (grade <= 69 && grade >= 60) {
            letterGrade = "C";
        } else if (grade <= 59 && grade >= 50) {
            letterGrade = "D";
        } else if (grade <= 49 && grade >= 0) {
            letterGrade = "F";
        } else {
            letterGrade = "Error! Grade can not be more than 100% and less than 0%";
        }
        return letterGrade;
    }

    private double getAverage(List<Integer> grade) {
        Integer num = 0;
        if (!grade.isEmpty()) {
            for (Integer mark : grade) {
                num += mark;
            }
            double averageGrade = num.doubleValue() / grade.size();
            return averageGrade;
        }
        return num;
    }

    public String getAverageGrade() {
        list.clear();
        table.getItems().forEach(item -> list.add(item.getGrade()));

        double averageGrade = getAverage(list);
        String pattern = "##0.0";
        DecimalFormat decimalFormat = new DecimalFormat(pattern);
        String formatAverageGrade = decimalFormat.format(averageGrade);

        return formatAverageGrade;
    }

    public String getLetterAverageGrade() {
        String letterAverageGrade = getLetterGrades(getAverage(list));

        return letterAverageGrade;
    }
}