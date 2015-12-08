package FivePoints.Simulation;

import FivePoints.Graphics.CustomGraphics;

import FivePoints.Threading.Shared;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;


/**
 *
 * @author Warren
 */
public class FivePoints extends Application {

    
    private Shared<Text> textPane;

    //reference to controller
    private Controller controller;
    
  
    
    

    @Override
    public void start(Stage primaryStage) {
        
        /*
            Creates root layout pane(BorderPane)
            creates Canvas and menubar
            then adds them to root BorderPane
        */
        /*
        BorderPane root = new BorderPane();

        canvas = new Shared<CustomCanvas>(new CustomCanvas(800, 600));
        textPane = new Shared<Text>(new Text());

       textPane.perform((Text x) -> x.setTextAlignment(CENTER));

        TextFlow flow = new TextFlow();

        flow.getChildren().add(textPane.getSharedUnsafe());
        root.setRight(canvas.getSharedUnsafe());

        root.setLeft(flow);
        root.setTop(createMenu());
*/
        /*
            Creates Maine Scene, Shows Window
        */
        controller = new Controller();
        System.out.println("00");
        
        System.out.println("01");
        Scene scene = new Scene(controller.getRoot());
        System.out.println("02");
        
        System.out.println("yo");

        primaryStage.setTitle("Five Points Traffic Simulation");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        
        controller.defaultScenario();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    /*
    private MenuBar createMenu() {
        MenuBar menuBar = new MenuBar();
        Menu menuFile = new Menu("File");
        Menu menuEdit = new Menu("Edit");
        Menu menuView = new Menu("View");

        //create menuitems and eventhandlers
        MenuItem start = new MenuItem("Start");
        start.setOnAction((ActionEvent event) -> {
            controller.begin();
        });

        MenuItem stop = new MenuItem("Stop");
        stop.setOnAction((ActionEvent event) -> {
            try {
                controller.pauseWorld();
            } catch(InterruptedException e){

            }
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
    }*/

    /*
        Getter Methods
    */
    
    /*
    public Shared<CustomCanvas> requestCanvas() {
            return canvas;
    }


    public Shared<Text> requestTextPane() {
        return textPane;
    }
    */
}
