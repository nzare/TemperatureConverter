package nidhizare;

import java.util.Optional;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
public class Main extends Application{

	public static void main(String[] args) {
		launch(args);
	}
	@Override
	public void init() throws Exception{
		super.init();
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		  FXMLLoader loader = new FXMLLoader(getClass().getResource("App_layout.fxml"));
		  VBox rootNode = loader.load();
		  MenuBar menuBar = createMenu();
		  rootNode.getChildren().add(0,menuBar);
		  Scene scene = new Scene(rootNode);

		  primaryStage.setScene(scene);
		  primaryStage.setTitle("Temperature Converter");
		  //primaryStage.setResizable(false);
		  primaryStage.show();
		
	}
	private MenuBar createMenu() {
		
		//File Menu
		Menu fileMenu = new Menu("File");
		MenuItem newMenuItem = new MenuItem("New");
		
		newMenuItem.setOnAction(event -> System.out.println("New Menu Clicked"));
		
		SeparatorMenuItem separatorMenuItem = new SeparatorMenuItem();
		MenuItem quitMenuItem = new MenuItem("Quit");
		quitMenuItem.setOnAction(event -> {
			Platform.exit();
			System.exit(0);
		});
		
		fileMenu.getItems().addAll(newMenuItem,separatorMenuItem ,quitMenuItem);
		
		//Help Menu
		Menu helpMenu = new Menu("Help");
		MenuItem aboutApp = new MenuItem("About");
		
		aboutApp.setOnAction(event -> {
			aboutApp();
		});
			
		
		
		helpMenu.getItems().addAll(aboutApp);
		
		//Combine Menu
		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().addAll(fileMenu,helpMenu);
		return menuBar;
	}
	private void aboutApp() {
		Alert alertDialogue = new Alert(Alert.AlertType.INFORMATION);
		alertDialogue.setTitle("First Desktop Java Application");
		alertDialogue.setHeaderText("Learning JavaFx");
		alertDialogue.setContentText("It is fun to learn JavaFx.");
		
		ButtonType yesBtn = new ButtonType("Yes");
		ButtonType noBtn = new ButtonType("No");
		
		alertDialogue.getButtonTypes().setAll(yesBtn,noBtn);
		Optional <ButtonType> clickedBtn = alertDialogue.showAndWait();
		if(clickedBtn.isPresent() &&  clickedBtn.get()==yesBtn) {
			System.out.println("You pressed YES");
		}
		else if(clickedBtn.isPresent() && clickedBtn.get()==noBtn) {
			System.out.println("You pressed NO");
		}
		
	}
	@Override
	public void stop() throws Exception{
		super.stop();
	}
}
