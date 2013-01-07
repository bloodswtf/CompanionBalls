package companionBalls.gui;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
//import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import GurrUI.AddrobottoArrayButtonHandler;
import GurrUI.B2ButtonHandler;
import GurrUI.B3ButtonHandler;
import GurrUI.B4ButtonHandler;
import GurrUI.BackwardButtonHandler;
import GurrUI.ChangeColorButtonHandler;
import GurrUI.ConnectButtonHandler;
import GurrUI.DisconnectButtonHandler;
import GurrUI.ForwardButtonHandler;
import GurrUI.LeftButtonHandler;
import GurrUI.PanicButtonHandler;
import GurrUI.RightButtonHandler;
import GurrUI.SpinButtonHandler;
import GurrUI.StopButtonHandler;


import se.nicklasgavelin.sphero.macro.MacroObject;
import se.nicklasgavelin.sphero.macro.command.Delay;
import se.nicklasgavelin.sphero.macro.command.FrontLED;
import se.nicklasgavelin.sphero.macro.command.RGBSD2;
import se.nicklasgavelin.sphero.macro.command.Roll;
import se.nicklasgavelin.sphero.Robot;

import companionBalls.buttonActinos.*;
import companionBalls.robotContainerParts.RobotController;


public class JavaGui extends JFrame {
	private String iptoserver;
	// Dimensions
	private static final int windowWIDTH = 700;
	private static final int windowHEIGHT =200;

	//String ButtonsMapping
	private static String ForwardMAP = 		"UP";
	private static String BackwardMAP = 	"DOWN";
	private static String RightMAP = 		"RIGHT";
	private static String LeftMAP = 		"LEFT";
	private static String StopMAP = 		"E";
	private static String PanicMAP =		"ENTER";					
	private static String SpinMAP =     	"Q";
	private static String ChangeColorMAP = 	"W";
	private static String ConnectMAP =    	"1";
	private static String DisconnectMAP = 	"2";

	//unbinded - do as above
	private static String AddrobottoArrayMAP = 	"";
	private static String B2MAP = 	"";
	private static String B3MAP = 	"";
	private static String B4MAP = 	"";



	// strings
	private static String headerstring = "The ball coordinator";
	// strings buttons, please dont mess around with spacing
	private static String Forward = "  Forward ";
	private static String Backward = "Backward";
	private static String Right = "Right";
	private static String Left = " Left";

	private static String Stop = "           Stop           ";
	private static String Panic ="         PANIC!!        ";

	private static String Spin =        "                 Spin";
	private static String ChangeColor = "Change Color";

	private static String Connect =    "Connect ALL THE THINGS      ";
	private static String Disconnect = "Disconnect ALL THE THINGS";

	//TODO: change this button so it says "Finilize Connection"
	private static String AddrobottoArray = "Add Robots To Array";
	private static String B2 = "Get some kind of response";
	private static String B3 = "THIS IS SERVER";
	private static String B4 = "ohh, and I am client";
	//end configs

	// the buttons
	private JButton ForwardB, BackwardB, RightB, LeftB,
	StopB, PanicB, SpinB, ChangeColorB,
	ConnectB, AddRobotsToListB, DisconnectB,
	AddrobottoArrayB, B2B, B3B, B4B
	;

	//-buttons part 1
	private ForwardButtonHandler ForwardbHandler;
	private BackwardButtonHandler BackwardbHandler;
	private RightButtonHandler RightbHandler;
	private LeftButtonHandler LeftbHandler;
	//-buttons part 2
	private StopButtonHandler StopbHandler;
//	private PanicButtonHandler PanicbHandler;
	private SpinButtonHandler SpinbHandler;
	private ChangeColorButtonHandler ChangeColorbHandler;
	//-buttons part 3
//	private ConnectButtonHandler ConnectbHandler;
//	private DisconnectButtonHandler Disconnectbhandler;
//	//buttons part 4
//	private AddrobottoArrayButtonHandler AddrobottoArraybHandler;
//	private B2ButtonHandler B2bHandler;
//	private B3ButtonHandler B3bHandler;
//	private B4ButtonHandler B4bHandler;

	//TODO: make new constructor
//	public GurrUI (ConnectThread ct, String nameonserver){
//		iptoserver = nameonserver;
//		this.ct = ct;
//	}
	public void fixGUI(){
		createbuttons();

		JPanel panel = new JPanel();
		JPanel left = new JPanel();
		JPanel middle = new JPanel();
		JPanel right = new JPanel();
		JPanel middlehorizontal = new JPanel();

		panel.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

		left.setLayout(new BoxLayout(left, BoxLayout.Y_AXIS));
		middle.setLayout(new BoxLayout(middle, BoxLayout.Y_AXIS));
		right.setLayout(new BoxLayout(right, BoxLayout.Y_AXIS));
		middlehorizontal.setLayout(new BoxLayout(middlehorizontal, BoxLayout.X_AXIS));

		middle.add(Box.createRigidArea(new Dimension(300,0)));

		addbuttonsConnectDisconnect(left);
		addbuttonsforward(middle);
		addbuttonsDirections(middlehorizontal);
		middle.add(middlehorizontal);
		addbuttonsStopPanic(middle);
		addbuttonsSpinColor(right);
		addbuttonsB14(right);

		//Add listeners to keyboard
		addbuttonslistener(ForwardB, ForwardMAP);
		addbuttonslistener(LeftB, LeftMAP);
		addbuttonslistener(BackwardB, BackwardMAP);
		addbuttonslistener(RightB, RightMAP);
		addbuttonslistener(StopB, StopMAP);
		addbuttonslistener(PanicB, PanicMAP);
		addbuttonslistener(SpinB, SpinMAP);
		addbuttonslistener(ChangeColorB, ChangeColorMAP);
		addbuttonslistener(ConnectB, ConnectMAP);
		addbuttonslistener(DisconnectB, DisconnectMAP);
		addbuttonslistener(AddrobottoArrayB, AddrobottoArrayMAP);
		addbuttonslistener(B2B, B2MAP);
		addbuttonslistener(B3B, B3MAP);
		addbuttonslistener(B4B, B4MAP);


		panel.add(left);
		panel.add(middle);
		panel.add(right);
		add(panel);

		setTitle(headerstring);
		setSize(windowWIDTH , windowHEIGHT);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		panel.requestFocusInWindow();
		
		//creating the buttons
		private void createbuttons(){
			// handlers for each button and ActionListeners to each button.

			ForwardB = new JButton(Forward);
			ForwardB.setAlignmentX(CENTER_ALIGNMENT);

			BackwardB = new JButton(Backward);
			BackwardbHandler = new BackwardButtonHandler();
			BackwardB.addActionListener(BackwardbHandler);
			BackwardB.setAlignmentX(CENTER_ALIGNMENT);

			RightB = new JButton(Forward);
			RightbHandler = new RightButtonHandler();
			RightB.addActionListener(RightbHandler);
			RightB.setAlignmentX(CENTER_ALIGNMENT);

			LeftB = new JButton(Left);
			LeftbHandler = new LeftButtonHandler();
			LeftB.addActionListener(LeftbHandler);
			LeftB.setAlignmentX(CENTER_ALIGNMENT);

			RightB = new JButton(Right);
			RightbHandler = new RightButtonHandler();
			RightB.addActionListener(RightbHandler);
			RightB.setAlignmentX(CENTER_ALIGNMENT);

			StopB = new JButton(Stop);
			StopbHandler = new StopButtonHandler();
			StopB.addActionListener(StopbHandler);
			StopB.setAlignmentX(CENTER_ALIGNMENT);

			PanicB = new JButton(Panic);
			PanicbHandler = new PanicButtonHandler();
			PanicB.addActionListener(PanicbHandler);
			PanicB.setAlignmentX(CENTER_ALIGNMENT);

			SpinB = new JButton(Spin);
			SpinbHandler = new SpinButtonHandler();
			SpinB.addActionListener(SpinbHandler);
			SpinB.setAlignmentX(RIGHT_ALIGNMENT);

			ChangeColorB = new JButton(ChangeColor);
			ChangeColorbHandler = new ChangeColorButtonHandler();
			ChangeColorB.addActionListener(ChangeColorbHandler);
			ChangeColorB.setAlignmentX(RIGHT_ALIGNMENT);

			ConnectB = new JButton(Connect);
			ConnectbHandler = new ConnectButtonHandler();
			ConnectB.addActionListener(ConnectbHandler);
			ConnectB.setAlignmentX(LEFT_ALIGNMENT);

			DisconnectB = new JButton(Disconnect);
			Disconnectbhandler = new DisconnectButtonHandler();
			DisconnectB.addActionListener(Disconnectbhandler);
			DisconnectB.setAlignmentX(LEFT_ALIGNMENT);

			AddrobottoArrayB = new JButton(AddrobottoArray);
			AddrobottoArraybHandler= new AddrobottoArrayButtonHandler();
			AddrobottoArrayB.addActionListener(AddrobottoArraybHandler);
			AddrobottoArrayB.setAlignmentX(LEFT_ALIGNMENT);

			B2B = new JButton(B2);
			B2bHandler= new B2ButtonHandler();
			B2B.addActionListener(B2bHandler);
			B2B.setAlignmentX(RIGHT_ALIGNMENT);

			B3B = new JButton(B3);
			B3bHandler= new B3ButtonHandler();
			B3B.addActionListener(B3bHandler);
			B3B.setAlignmentX(LEFT_ALIGNMENT);

			B4B = new JButton(B4);
			B4bHandler= new B4ButtonHandler();
			B4B.addActionListener(B4bHandler);
			B4B.setAlignmentX(RIGHT_ALIGNMENT);
		}
		
		//Adds the action listeners to the buttons
		public void addForwardButtonHandler(ActionListener actionListener, RobotControllerButton robotControllerButton)	{
			ForwardbHandler = new ForwardButtonHandler();
			ForwardB.addActionListener(ForwardbHandler);
		}
		public void addBackwardButtonHandler(ActionListener actionListener, RobotController robotController)	{
			
		}
		public void addLeftButtonHandler(ActionListener actionListener, RobotController robotController)	{
			
		}
		public void addRightButtonHandler(ActionListener actionListener, RobotController robotController)	{
			
		}
		public void addStopButtonHandler(ActionListener actionListener, RobotController robotController)	{
			
		}
		public void addSpinButtonHandler(ActionListener actionListener, RobotController robotController)	{
			
		}
		public void addChangeColorButtonHandler(ActionListener actionListener, RobotController robotController)	{
			
		}
		public void addConnectButtonHandler(ActionListener actionListener)	{
			
		}
		public void addDisconnectButtonHandler(ActionListener actionListener)	{
			
		}
		public void addAddRobotsToArrayButtonHandler(ActionListener actionListener)		{
			
		}
		
		
		//THESE CONTAIN THE SPACING BETWEEN THE BUTTONS, PLEASE DONT MESS AROUND WITH IT
		private void addbuttonsforward(Container C){
			C.add(ForwardB);
			C.add(Box.createRigidArea(new Dimension(0, 5)));
		}
		private void addbuttonsDirections(Container C){
			C.add(LeftB);
			C.add(Box.createRigidArea(new Dimension(5, 0)));
			C.add(BackwardB);
			C.add(Box.createRigidArea(new Dimension(5, 0)));
			C.add(RightB);	
		}
		private void addbuttonsStopPanic(Container C){
			C.add(Box.createRigidArea(new Dimension(0, 20)));
			C.add(PanicB);
			C.add(Box.createRigidArea(new Dimension(0, 5)));
			C.add(StopB);		
		}
		private void addbuttonsSpinColor(Container C){
			C.add(SpinB);
			C.add(Box.createRigidArea(new Dimension(0, 5)));
			C.add(ChangeColorB);
		}

		private void addbuttonsConnectDisconnect(Container C){
			C.add(ConnectB);
			C.add(Box.createRigidArea(new Dimension(0, 5)));
			C.add(B3B);
			C.add(Box.createRigidArea(new Dimension(0, 5)));
			C.add(AddrobottoArrayB);
			C.add(Box.createRigidArea(new Dimension(0, 5)));
			C.add(DisconnectB);
		}

		private void addbuttonsB14(Container C){

			C.add(Box.createRigidArea(new Dimension(0, 5)));
			C.add(B2B);
			
			C.add(Box.createRigidArea(new Dimension(0, 5)));
			C.add(B4B);
		}

		private void addbuttonslistener(JButton B, String key){
			B.getInputMap(B.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(key),"pressed");
			B.getInputMap(B.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("released "+ key), "released");
		}
	}

