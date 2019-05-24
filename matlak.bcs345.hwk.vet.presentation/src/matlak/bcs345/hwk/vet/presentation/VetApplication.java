 package matlak.bcs345.hwk.vet.presentation;
import matlak.bcs345.hwk.vet.business.Visit;
import matlak.bcs345.hwk.vet.business.VisitProcedure;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.Scanner;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

/**
 * Creates the GUI thats the users sees. It give you the choice to open a file
 * containing the data, save the data/ save the data in a report format, export it as a json
 * and exit the gui without closing the program.
 * 
 * Options are:
 * Open
 * Save As
 * Save Report
 * Export Json
 * Exit
 *
 * @author Ian Matlak
 * @version 1.0
 * @since 12/12/2018
 */
public class VetApplication extends Application {

	private Visit visit = new Visit();
	private TabPane tabPane;
	private Tab t_OverView;
	private Tab t_VPData;
	private MenuBar menuBar;
	private Menu m_File;
	private MenuItem mi_open;
	private MenuItem mi_saveas;
	private MenuItem mi_saverep;
	private MenuItem mi_exJS;
	private MenuItem mi_exit;
	private SeparatorMenuItem[] separator;
	private Label[] label;
	private TextField[] textfield;
	//private VisitProcedure[] vp;
	private ObservableList<VisitProcedure> vpoblist;
	private ListView<VisitProcedure> vplist;
	
/*	private Label l_VNam;
	private Label l_PNam;
	private Label l_PSpec;
	private Label l_PGen;
	private Label l_TPAmt;
	private Label l_TPACov;
	private Label l_TPADue;
	private SeparatorMenuItem TseparatorMI;
	private SeparatorMenuItem MseparatorMI;
	private SeparatorMenuItem BseparatorMI;
	*/


	/**
	 * This method creates the main stage and borderpanes then links them together.
	 * It gives each tabpane a borderpane.
	 * It sets the policies for the tabs and stage
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		//tabPane = new TabPane();
		//t_OverView = new Tab();
		//t_VPData = new Tab();
		
		BorderPane root = new BorderPane();
		BorderPane bp_OView = new BorderPane(); //borderpane for overview tab
		BorderPane bp_VPData = new BorderPane(); //borderpane for VisitProcedure Data tab

		root.setTop(MenuTabs()); //Border pain for main scene

		tabPane.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE); //Takes away exit option for tab
		
		t_OverView.setContent(bp_OView); //
		bp_OView.setRight(cTextFields());
		bp_OView.setLeft(cLabels());
		
		t_VPData.setContent(bp_VPData);
		bp_VPData.setCenter(cListView());
		
		/*label = new Label[] {
				new Label("Veterinarian Name"),
				new Label("Pet Name"),
				new Label("Pet species"),
				new Label("Pet gender"),
				new Label("Total Procedure amount"),
				new Label("Total Procedure Amount Covered"),
				new Label("Total Procedure Amount Due"),};


	GridPane grid = new GridPane();
		grid.setHgap(20);
		grid.setVgap(20);
		t_OverView.setContent(grid);

		grid.add(label[1], 1, 1);
		grid.add(label[2], 10, 1);
*/
		
		Scene scene = new Scene(root, 400, 450);

		primaryStage.setScene(scene);
		primaryStage.setTitle("Vet Application");
		primaryStage.show();
		
	}
	
	/**
	 * Creates menu and tabs for the scene
	 * creates all menu items and EventHandler for them.
	 * @return vbox
	 */
	public VBox MenuTabs() {
		VBox vbox = new VBox();
		//Creates instance of menu bar
		menuBar = new MenuBar();
		
		//creates instance of menu
		m_File = new Menu("File");
		
		separator = new SeparatorMenuItem[] {
			new SeparatorMenuItem(),
			new SeparatorMenuItem(),
			new SeparatorMenuItem()
		};
		
/*		TseparatorMI = new SeparatorMenuItem();
		MseparatorMI = new SeparatorMenuItem();
		BseparatorMI = new SeparatorMenuItem();*/
		
		//Creates instances of menu items
		mi_open = new MenuItem("Open...");
		mi_saveas = new MenuItem("Save As...");
		mi_saverep = new MenuItem("Save Report...");
		mi_exJS = new MenuItem("Export As JSON...");
		mi_exit = new MenuItem("Exit");

		//add Menu Instance to menu bar
		menuBar.getMenus().add(m_File);
		
		//Adds menu items to File menu
		m_File.getItems().add(mi_open);
		m_File.getItems().add(separator[0]);
		m_File.getItems().add(mi_saveas);
		m_File.getItems().add(mi_saverep);
		m_File.getItems().add(separator[1]);
		m_File.getItems().add(mi_exJS);
		m_File.getItems().add(separator[2]);
		m_File.getItems().add(mi_exit);
		
		//FXMLLoader loader = new FXMLLoader();

		/**
		 * EventHandler for mi_open "Open" option on the menu
		 */
		mi_open.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				Open();
			}
		});	
		
		/**
		 * EventHandler for mi_saveas "Save as" option on the menu
		 */
		mi_saveas.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				SaveAs();
			}
		});	
		
		/**
		 * EventHandler for mi_saverep "Save Report as" option on the menu
		 */
		mi_saverep.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				SaveReport();
			}
		});	
		
		/**
		 * EventHandler for mi_exJS "export json" option on the menu
		 */
		mi_exJS.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				ExportJSON();
			}
		});	
		
		/**
		 * EventHandler for mi_exit "Exit" option on the menu
		 */
		mi_exit.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				Exit();
			}
		});	
		
		//Tab panes and tabs
		tabPane = new TabPane();
		t_OverView = new Tab();
		t_VPData = new Tab();
		
		//Sets title for tab panes
		t_OverView.setText("OverView");
		t_VPData.setText("Visit Procedure Data");
		
		//sets the tab to the tabpane
		tabPane.getTabs().add(t_OverView);
		
		tabPane.getTabs().add(t_VPData);
		
		vbox.getChildren().add(menuBar);
		vbox.getChildren().add(tabPane);
		
		return vbox;
	}
	
	/**
	 * Open function which opens a file which is chosen by the user to read in data to the program and outputs it in a formatted way
	 */
	public void Open() {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Open");
		File dir = new File(System.getProperty("user.dir"));
        System.getProperty("user.dir");
		fileChooser.setInitialDirectory(dir);
		fileChooser.getExtensionFilters().addAll(new ExtensionFilter("txt Files", "*.txt"));
		File file = fileChooser.showOpenDialog(null); //Title auto 'open'. Why do some people replace null with stage? sometimes you need a new stage example for example mac os doesnt open newdialog box it needs new stage stackof deleted post
		//file = fileChooser.getInitialDirectory();
		//File sad = file.getParentFile();
//String file1 = fileChooser.getInitialFileName();
		Scanner s = null;
		if(file != null) {
			try {
				s = new Scanner(new FileReader(file));
				visit.Read(s);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				System.out.println("FileNotFoundException");
			}
			textfield[0].setText(visit.getVeterinarian());// String vetname = visit.getVeterinarian(); setText(vetname); Ether method is okay
			textfield[1].setText(visit.getAppointment().getpet().getName()); //But if you separate out parameters with its own string
			textfield[2].setText(visit.getAppointment().getpet().getSpecies());//it can help with debugging by seeing what variable name is. 
			textfield[3].setText(visit.getAppointment().getpet().getGender()); 
			String amt = Double.toString(visit.amt());
			textfield[4].setText(amt);
			String cov = Double.toString(visit.cov());
			textfield[5].setText(cov);
			String due = Double.toString(visit.due());
			textfield[6].setText(due);
			
			//vp = new VisitProcedure[visit.getNumOfProcedures()]; for array of visitprocedure method of getting list for
			//vp = visit.getVisitProcedure();
			
			//Array to get each VisitProcedure index
			for(int i = 0; i < visit.getNumOfProcedures(); i++) {
				vpoblist.add(visit.GetByIndex(i));
			}
		}else {
			System.out.println("No File Selected");
		}
	}
	
	/**
	 * Lets you saves the data you imported from open as a txt
	 */
	public void SaveAs() {
		FileChooser fileChooser = new FileChooser(); //Filechooser lets the user pick a file which is basically just a string
		fileChooser.setTitle("Save As");
		File dir = new File(System.getProperty("user.dir"));
        System.getProperty("user.dir");
		fileChooser.setInitialDirectory(dir); //Sets directory to the current directory of the project
		fileChooser.getExtensionFilters().addAll(new ExtensionFilter("txt Files", "*.txt")); //Sets directory to the current directory of the project
		File file = fileChooser.showSaveDialog(null); //title is auto 'save as'
		PrintStream ps = null;
		if(file != null) { //If user doesnt pick a string program wont crash
			try {
				ps = new PrintStream(file);
				visit.Write(ps);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				System.out.println("FileNotFoundException");
			}
		}else {
			System.out.println("No File Selected");
		}
	}
	
	/**
	 * Saves data in a formated way in a .txt that presents a report using data from open method
	 */
	public void SaveReport() {
		FileChooser fileChooser = new FileChooser(); //Filechooser lets the user pick a file which is basically just a string
		fileChooser.setTitle("Save Report");
		File dir = new File(System.getProperty("user.dir")); 
        System.getProperty("user.dir");
		fileChooser.setInitialDirectory(dir);//Sets directory to the current directory of the project
		fileChooser.getExtensionFilters().addAll(new ExtensionFilter("txt Files", "*.txt")); //Sets directory to the current directory of the project
		File file = fileChooser.showSaveDialog(null);  //title is auto 'save as'
		PrintStream ps = null;
		if(file != null) { //If user doesnt pick a string program wont crash
			try {
				ps = new PrintStream(file);
				visit.Report(ps);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				System.out.println("FileNotFoundException");
			}
		}else {
			System.out.println("No File Selected");
		}
	}
	
	/**
	 * Exports data in a json format to a .txt from the open method
	 */
	public void ExportJSON() {
		FileChooser fileChooser = new FileChooser(); //Filechooser lets the user pick a file which is basically just a string
		fileChooser.setTitle("Export Json");
		File dir = new File(System.getProperty("user.dir"));
        System.getProperty("user.dir");
		fileChooser.setInitialDirectory(dir);//Sets directory to the current directory of the project
		fileChooser.getExtensionFilters().addAll(new ExtensionFilter("txt Files", "*.txt")); //Sets directory to the current directory of the project
		File file = fileChooser.showSaveDialog(null);  //title is auto 'save as'
		PrintStream ps = null;
		if(file != null) { //If user doesnt pick a string program wont crash
			try {
				ps = new PrintStream(file);
				ps.print(visit.GetJSON());
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				System.out.println("FileNotFoundException");
			}
		}else {
			System.out.println("No File Selected");
		}
	}
	
	/**
	 * exits the whole program
	 */
	public void Exit() {
		System.exit(0);
	}
	
	/**
	 * Creates labels and spacing for them
	 * @return vbox
	 */
	public VBox cLabels() {
		VBox vbox = new VBox();

		label = new Label[] {
				new Label("Veterinarian Name"),
				new Label("Pet Name"),
				new Label("Pet species"),
				new Label("Pet gender"),
				new Label("Total Procedure amount"),
				new Label("Total Procedure Amount Covered"),
				new Label("Total Procedure Amount Due"),
		};
		
/*		l_VNam = new Label("Veterinarian Name");
		l_PNam = new Label("Pet Name");
		l_PSpec	= new Label("Pet species");
		l_PGen	= new Label("Pet gender");
		l_TPAmt	= new Label("Total Procedure amount");
		l_TPACov = new Label("Total Procedure Amount Covered");
		l_TPADue = new Label("Total Procedure Amount Due");*/
		
		vbox.setPadding(new Insets(5,0,0,0));
		vbox.setSpacing(13);
		vbox.getChildren().addAll(label);
		
/*		vbox.getChildren().add(l_VNam);
		vbox.getChildren().add(l_PNam);
		vbox.getChildren().add(l_PSpec);
		vbox.getChildren().add(l_PGen);
		vbox.getChildren().add(l_TPAmt);
		vbox.getChildren().add(l_TPACov);
		vbox.getChildren().add(l_TPADue);*/

		return vbox;
	}

	/**
	 * creates text fields and spacing for them
	 * @return vbox
	 */
	public VBox cTextFields() {
		
		VBox vbox = new VBox();
		
		vbox.setSpacing(5);
		
		textfield = new TextField[] {
				new TextField(),
				new TextField(),
				new TextField(),
				new TextField(),
				new TextField(),
				new TextField(),
				new TextField()
		};
		vbox.getChildren().addAll(textfield);

/*		TextField tf_VNam = new TextField();
		TextField tf_PNam = new TextField();
		TextField tf_PSpec = new TextField();
		TextField tf_PGen = new TextField();
		TextField tf_TPAmt = new TextField();
		TextField tf_TPACov = new TextField();
		TextField tf_TPADue = new TextField();
		vbox.getChildren().add(tf_VNam);
		vbox.getChildren().add(tf_PNam);
		vbox.getChildren().add(tf_PSpec);
		vbox.getChildren().add(tf_PGen);
		vbox.getChildren().add(tf_TPAmt);
		vbox.getChildren().add(tf_TPACov);
		vbox.getChildren().add(tf_TPADue);*/

		return vbox;
	}
	
	/**
	 * creates a list view that read data from the open file and outputs it into a List View
	 * @return vbox
	 */
	public VBox cListView() {
		VBox vbox = new VBox();
		//ObservableList ToString = FXCollections.observableArrayList();
        vplist = new ListView<VisitProcedure>();
    	vpoblist = FXCollections.observableArrayList(); //GLOBAL MEMEBER VARIABLE****************************************
        vplist.setEditable(false);
    	vplist.setItems(vpoblist);
		vbox.getChildren().add(vplist);
		return vbox;
	}
	
}
