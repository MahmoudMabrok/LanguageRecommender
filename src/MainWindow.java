import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;


public class MainWindow extends Application {

    public  ArrayList<String> proj_types = new ArrayList<>() ;
    public  ArrayList<String> os = new ArrayList<>();
    public  ArrayList<String> hardAccess = new ArrayList<>();
    public  ArrayList<String> complexixty = new ArrayList<>() ;

    public  String in_proj_type , in_os ,in_hw , in_access , in_complex ;

    Alert alert ;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        //intialize data sets
        initProjTypes();
        initOs();
        initHw();
        initComplexity();

        //main pane
        VBox root = new VBox(15) ;
        root.setAlignment(Pos.CENTER);
        GridPane inputPane = new GridPane() ;

        //cutimize grid
        inputPane.getColumnConstraints().add(new ColumnConstraints(100)); // column 0 is 100 wide
        inputPane.getColumnConstraints().add(new ColumnConstraints(250)); // column 1 is 200 wide
        inputPane.setVgap(15);
        inputPane.setHgap(20);
        inputPane.setPrefSize(200, 200);
        inputPane.setPadding(new Insets(15));


        //create labels
        Label welcome = new Label("Welecom To LanguageRecommender") ;
        welcome.setAlignment(Pos.CENTER);
        Label label_projectType = new Label("projectType") ;
        Label label_OS = new Label("OS") ;
        Label label_hardware = new Label("HW.Acessiblity ") ;
        Label label_complixity = new Label("Complexity") ;


        //contol
        Button btnGetLang = new Button("Recommend") ;
        btnGetLang.setAlignment(Pos.CENTER);

        //create combobox
        ComboBox cb_proj = new ComboBox() ;
        ComboBox cb_os = new ComboBox() ;
        ComboBox cb_hw = new ComboBox() ;
        ComboBox cb_complexity = new ComboBox() ;

        //add data
        cb_proj.getItems().setAll(proj_types) ;
        cb_os.getItems().setAll(os) ;
        cb_hw.getItems().setAll(hardAccess) ;
        cb_complexity.getItems().setAll(complexixty) ;

        //add to layout
        inputPane.addColumn(0 , label_projectType ,label_OS ,
                label_hardware,label_complixity);
        inputPane.addColumn(1 , cb_proj,cb_os ,cb_hw,cb_complexity);
        root.getChildren().addAll(welcome , inputPane , btnGetLang) ;

        alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Recommendation");
        alert.setHeaderText("Recommendation Language");

        //logic here
        //// TODO: 4/2/2018  handle data
        btnGetLang.setOnAction(e->{
            in_proj_type = cb_proj.getValue().toString() ;
            in_os = cb_os.getValue().toString() ;
            in_hw = cb_hw.getValue().toString() ;
            in_complex = cb_complexity.getValue().toString() ;
            //// TODO: 4/2/2018 u have data do your logic


            //// TODO: 4/2/2018 here to output the result

            alert.setContentText("Language is ");
            alert.show();
        });



        Scene s = new Scene(root);
        primaryStage.setScene(s);
        primaryStage.setTitle("Language Recommender");
        primaryStage.show();

    }

    public  void initProjTypes(){
        proj_types.add("Desktop");
        proj_types.add("Android ");
        proj_types.add("Web");
        proj_types.add("Windows Phone Apps");
        proj_types.add("Games");
        proj_types.add("IOS");
        proj_types.add("Embedded");
        proj_types.add("Data Science");
        proj_types.add("Maths");
        proj_types.add("Image Processing");
        proj_types.add("NLP");
        proj_types.add("AI");
        proj_types.add("Data Visualization");
    }

    public void initOs(){
        os.add("Windows");
        os.add("Linux");
        os.add("Mac");
    }

    public void initHw (){
        hardAccess.add("High");
        hardAccess.add("Low");
    }
    public void initComplexity(){
        complexixty.add("Low");
        complexixty.add("Medium");
        complexixty.add("High");

    }


}
