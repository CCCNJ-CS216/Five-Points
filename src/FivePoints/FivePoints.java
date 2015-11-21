package FivePoints;

import FivePoints.General.Pair;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import static javafx.scene.text.TextAlignment.CENTER;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Warren
 */
public class FivePoints extends Application {

    private Pair<Semaphore, CustomCanvas> canvas;
    private Pair<Semaphore, Text> textPane;

    // Check to see if
    private final Semaphore available = new Semaphore(1);

    //reference to controller
    private Controller controller;

    @Override
    public void start(Stage primaryStage) {
        
        /*
            Creates root layout pane(BorderPane)
            creates Canvas and menubar
            then adds them to root BorderPane
        */
        BorderPane root = new BorderPane();
        canvas = new Pair(new Semaphore(1), new CustomCanvas(800, 600));
        textPane = new Pair(new Semaphore(1), new Text());

        try {
            textPane.getItem1().acquire();
            textPane.getItem2().setTextAlignment(CENTER);
            textPane.getItem1().release();
        } catch (InterruptedException e) {
            System.out.println(e.getStackTrace());
        }

        TextFlow flow = new TextFlow();

        flow.getChildren().add(textPane.getItem2());
        root.setRight(canvas.getItem2());

        root.setLeft(flow);
        root.setTop(createMenu());

        /*
            Creates Maine Scene, Shows Window
        */
        Scene scene = new Scene(root);

        primaryStage.setTitle("Traffic Simulation Rewrite 01");
        primaryStage.setScene(scene);
        primaryStage.show();
        controller = new Controller(this);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    private MenuBar createMenu() {
        MenuBar menuBar = new MenuBar();
        Menu menuFile = new Menu("File");
        Menu menuEdit = new Menu("Edit");
        Menu menuView = new Menu("View");

        //create menuitems and eventhandlers
        MenuItem start = new MenuItem("Start");
        start.setOnAction((ActionEvent event) -> {
            controller.start();
        });

        MenuItem stop = new MenuItem("Stop");
        stop.setOnAction((ActionEvent event) -> {
            controller.stop();
        });

        MenuItem clear = new MenuItem("Clear");
        clear.setOnAction((ActionEvent event) -> {
            controller.clear();
        });

        //add menuitems to file
        menuFile.getItems().addAll(start, stop, clear);

        //add menus to menubar
        menuBar.getMenus().addAll(menuFile, menuEdit, menuView);

        //return constructed menubar
        return menuBar;
    }

    /*
        Getter Methods
    */
    public Pair<Semaphore, CustomCanvas> requestCanvas() {
        try {
            return canvas;
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
        return null;
    }


    public Pair<Semaphore, Text> requestTextPane(){
        try{
            return textPane;
        } catch (Exception e){
            System.out.println(e.getStackTrace());
        }
        return null;
    }
}
