import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import java.io.*;

public class Addition extends Mathematics{
	public Addition(){ //constructor

		//Initialize all audios needed  
		bgm = s.playMusic("Audio/Background music.wav");
		wrong_audio = s.playMusic("Audio/Wrong audio.wav");
		correct_audio = s.playMusic("Audio/Correct audio.wav");
		congrat_audio = s.playMusic("Audio/Cheering.wav");

		frame = new JFrame("Let's Learn Addition!"); //Create frame with title
		panel_home = new JPanel(); 
		q1_bg = new JLabel();
		
		frame.pack();
		frame.setSize(1280, 720);			//set size of frame, setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//quit when X is clicked
		frame.setResizable(false);			//do not allow user to resize window
		frame.setLocationRelativeTo(null);	//center the window on the screen   		
		frame.setVisible(true);				//show the frame
	} //end of constructor
	
	public void homepage(){
		//create a new JLabel for the home background image
		home_bg = new JLabel(formatImage("addition/add_video_bg.png", 1280, 720));
		home_bg.setBounds(0, -18, 1280, 720);
		panel_home.add(home_bg);
		
		//panel to display error message
		final JPanel errorPanel = new JPanel(); 
		errorPanel.setBounds(50, 50, 200, 50);
		JLabel errorLabel = new JLabel("Error: Unable to find video file.");
		JButton errorButton = new JButton("OK");
		errorPanel.add(errorLabel);
		errorPanel.add(errorButton);
		errorPanel.setVisible(false);
		frame.add(errorPanel);
		
		//Checks for a null pointer exception and handles it by displaying an error panel and allowing the user to continue to practice questions
		try {
			ImageIcon imgIcon = new ImageIcon(this.getClass().getResource("addition/addition_video.gif"));
			video = new JLabel(imgIcon);
			video.setBounds(190, 40, 880, 495);
			panel_home.add(video);
			video_sound = s.playMusic("addition/add_video_music.wav");
			video_sound.start(); 
			video_sound.loop(video_sound.LOOP_CONTINUOUSLY);

			btn_start = new JButton();
			btn_start.setIcon(new javax.swing.ImageIcon(getClass().getResource("menu/button_start_normal.png")));
			btn_start.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("menu/button_start_clicked.png")));
			btn_start.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("menu/button_start_hover.png")));
			btn_start.setContentAreaFilled(false);
			btn_start.setBorderPainted(false);
			btn_start.setBounds(502, 550, 250, 80);
			btn_start.setVisible(true);
			
			btn_start.addActionListener(act);
			panel_home.add(btn_start);
	
			panel_home.setComponentZOrder(btn_start, 0);
			panel_home.setComponentZOrder(video, 1);
			panel_home.setComponentZOrder(home_bg, 2);
			
			panel_home.setLayout(null);	//position components absolutely, using xy-coordinates
			frame.add(panel_home);
		}
		catch (NullPointerException e) {
			errorPanel.setVisible(true);
		    errorButton.addActionListener(new ActionListener() {
		        public void actionPerformed(ActionEvent e) {
		            errorPanel.setVisible(false);
		            lesson1();
		        }
		    });
		}
	}

	public void lesson1(){
		panel_lesson1 = new JPanel();
		panel_lesson1.setName("Panel 1");
		
		//initializes the components and resources for lesson 1
		init_lesson1(panel_lesson1, "addition/addition_q1.png");
		
		//add action listeners for buttons in lesson 1
		btn_home.addActionListener(act);
		btn_mute.addActionListener(act);
		btn_q1_ans1.addActionListener(act);
		btn_q1_ans2.addActionListener(act);
		btn_q1_ans3.addActionListener(act);
		btn_wrong_ok.addActionListener(act);
		btn_yes.addActionListener(act);
		btn_no.addActionListener(act);

		frame.add(panel_lesson1); //add the panel to the frame
		
		//make answer buttons visible in lesson 1
		btn_q1_ans1.setVisible(true);
		btn_q1_ans2.setVisible(true);
		btn_q1_ans3.setVisible(true);

	} //end of lesson1
	
	public void lesson2(){
		panel_lesson2 = new JPanel();
		panel_lesson2.setName("Panel 2");
		
		//initializes the components and resources for lesson 2
		init_lesson2(panel_lesson2, "addition/addition_q2.png");
		
		//add action listeners for buttons in lesson 2
		btn_home.addActionListener(act);
		btn_mute.addActionListener(act);
		btn_q2_ans1.addActionListener(act);
		btn_q2_ans2.addActionListener(act);
		btn_q2_ans3.addActionListener(act);
		btn_wrong_ok.addActionListener(act);
		btn_yes.addActionListener(act);
		btn_no.addActionListener(act);

		frame.add(panel_lesson2); //add the panel to the frame
		
		//make answer buttons visible in lesson 2
		btn_q2_ans1.setVisible(true);
		btn_q2_ans2.setVisible(true);
		btn_q2_ans3.setVisible(true);

	} //end of lesson2*/
	
	public void lesson3(){
		panel_lesson3 = new JPanel();
		panel_lesson3.setName("Panel 3");
		
		//initializes the components and resources for lesson 3
		init_lesson3(panel_lesson3, "addition/addition_q3.png");
		
		//add action listeners for buttons in lesson 3
		btn_home.addActionListener(act);
		btn_mute.addActionListener(act);
		btn_q3_ans1.addActionListener(act);
		btn_q3_ans2.addActionListener(act);
		btn_q3_ans3.addActionListener(act);
		btn_wrong_ok.addActionListener(act);
		btn_yes.addActionListener(act);
		btn_no.addActionListener(act);

		frame.add(panel_lesson3); //add the panel to the frame
		
		//make answer buttons visible in lesson 3
		btn_q3_ans1.setVisible(true);
		btn_q3_ans2.setVisible(true);
		btn_q3_ans3.setVisible(true);

	} //end of lesson3
	
	//This is an ActionListener that is triggered when a button is clicked
	ActionListener act = new ActionListener(){
		public void actionPerformed(ActionEvent e) {
			
			//If start button is clicked
			if(e.getSource() == btn_start){
				video_sound.stop(); //stop video sound
				frame.remove(panel_home); //remove home panel
				lesson1();
			}
			
			//If the wrong answer button for question 1 is clicked
			else if(e.getSource() == btn_q1_ans2 || e.getSource() == btn_q1_ans3 ){
				wrong_audio = s.playMusic("Audio/Wrong audio.wav"); //play audio for wrong answer
				wrong_audio.start();

				//make the wrong answer feedback visible
				btn_wrong_ok.setVisible(true); 
				wrong_bg.setVisible(true);

				//hide the answer buttons
				btn_q1_ans1.setVisible(false);
				btn_q1_ans2.setVisible(false);
				btn_q1_ans3.setVisible(false);
				
			}
			
			//If the wrong answer button for question 2 is clicked
			else if(e.getSource() == btn_q2_ans1 || e.getSource() == btn_q2_ans3){
				wrong_audio = s.playMusic("Audio/Wrong audio.wav"); //play audio for wrong answer
				wrong_audio.start();

				//make the wrong answer feedback visible
				btn_wrong_ok.setVisible(true);
				wrong_bg.setVisible(true);

				//hide the answer buttons
				btn_q2_ans1.setVisible(false);
				btn_q2_ans2.setVisible(false);
				btn_q2_ans3.setVisible(false);
			}

			//If the wrong answer button for question 3 is clicked
			else if(e.getSource() == btn_q3_ans1 || e.getSource() == btn_q3_ans3 ){
				wrong_audio = s.playMusic("Audio/Wrong audio.wav"); //play audio for wrong answer
				wrong_audio.start();

				//make the wrong answer feedback visible
				btn_wrong_ok.setVisible(true);
				wrong_bg.setVisible(true);

				//hide the answer buttons
				btn_q3_ans1.setVisible(false);
				btn_q3_ans2.setVisible(false);
				btn_q3_ans3.setVisible(false);
				
			}	

			//If the "OK" button is clicked OR the "No" button after a wrong answer was chosen is clicked 
			else if(e.getSource() == btn_wrong_ok || e.getSource() == btn_no){
				correct_audio = s.playMusic("Audio/Correct audio.wav"); //play audio for correct answer
				correct_audio.start();

				JPanel source_panel = (JPanel)btn_wrong_ok.getParent(); // Getting the source panel of the button

				// Checking which panel the button belongs to and calling the appropriate lesson method
				if ( source_panel.getName() == "Panel 1") {
					frame.remove(panel_lesson1);
					lesson1();
				}
				
				else if( source_panel.getName() == "Panel 2") {
					frame.remove(panel_lesson2);
					lesson2();
				}
				
				else if( source_panel.getName() == "Panel 3") {
					frame.remove(panel_lesson3);
					lesson3();
				}
			}
			
			//If the "Home" button is clicked
			else if(e.getSource() == btn_home){
				correct_audio = s.playMusic("Audio/Correct audio.wav"); //play audio for correct answer
				correct_audio.start();

				// Making the "Yes" and "No" buttons visible
				btn_yes.setVisible(true);
				btn_no.setVisible(true);
				quit_bg.setVisible(true);
				
				JPanel source_panel = (JPanel)btn_wrong_ok.getParent(); // Getting the source panel of the button
				
				// Checking which panel the button belongs to and hiding the appropriate answer buttons
				if ( source_panel.getName() == "Panel 1") {
					btn_q1_ans1.setVisible(false);
					btn_q1_ans2.setVisible(false);
					btn_q1_ans3.setVisible(false);
				}
				
				else if( source_panel.getName() == "Panel 2") {
					btn_q2_ans1.setVisible(false);
					btn_q2_ans2.setVisible(false);
					btn_q2_ans3.setVisible(false);
				}
				
				else if( source_panel.getName() == "Panel 3") {
					btn_q3_ans1.setVisible(false);
					btn_q3_ans2.setVisible(false);
					btn_q3_ans3.setVisible(false);
				}
			}
			
			//If "Yes" button is clicked
			else if(e.getSource() == btn_yes){
				correct_audio = s.playMusic("Audio/Correct audio.wav"); //play audio for correct answer
				correct_audio.start();

				JPanel source_panel = (JPanel)btn_yes.getParent(); // Getting the source panel of the button
 
				// Checking which panel the button belongs to, stop the background music and remove the appropriate panel
				if (source_panel.getName() == "Panel 1") {
					bgm.stop();
					frame.remove(panel_lesson1);
					Menu m = new Menu();
					m.main_menu();
					frame.setVisible(false);
				}
				
				else if(source_panel.getName() == "Panel 2") {
					bgm.stop();
					frame.remove(panel_lesson2);
					Menu m = new Menu();
					m.main_menu();
					frame.setVisible(false);
				}
				
				else if(source_panel.getName() == "Panel 3") {
					bgm.stop();
					frame.remove(panel_lesson3);
					Menu m = new Menu();
					m.main_menu();
					frame.setVisible(false);
				}	
			}
			
			//If the correct answer button for question 1 is clicked
			else if(e.getSource() == btn_q1_ans1){
				correct_audio = s.playMusic("Audio/Correct audio.wav"); //play audio for correct answer
				correct_audio.start();

				// remove panel_lesson1 and proceed to next lesson
				frame.remove(panel_lesson1);
				lesson2();
			}

			//If the correct answer button for question 1 is clicked
			else if(e.getSource() == btn_q2_ans2){
				correct_audio = s.playMusic("Audio/Correct audio.wav"); //play audio for correct answer
				correct_audio.start();

				// remove panel_lesson2 and proceed to next lesson
				frame.remove(panel_lesson2);
				lesson3();
			}	
			else if(e.getSource() == btn_q3_ans2){
				correct_audio = s.playMusic("Audio/Correct audio.wav"); //play audio for correct answer
				correct_audio.start();

				//Create panel for congratulations 
				panel_congratulations = new JPanel();
				congratulations(panel_congratulations);
				btn_ok.setVisible(true);
				btn_ok.addActionListener(act);
				frame.remove(panel_lesson3);
				frame.add(panel_congratulations);
				frame.setVisible(true);
				congrat_audio.start();
				bgm.stop();
				
				// Write "addition" to "completed_missions.txt" file, indicating addition mission is done
				File completedMissionsFile = new File("completed_missions.txt");
				FileWriter writer = null;
				try {
					writer = new FileWriter(completedMissionsFile, true);
					writer.write("addition\n");
					writer.close();
				} catch (IOException ex) {
					System.out.println("An error occurred.");
					ex.printStackTrace();
				} finally {
					if (writer != null) {
						try {
							writer.close();
						} catch (IOException ex) {
							ex.printStackTrace();
						}
					}
				}
			}

			//If button "OK" is clicked
			else if(e.getSource() == btn_ok){
				correct_audio = s.playMusic("Audio/Correct audio.wav"); //play audio for correct answer
				correct_audio.start();
				congrat_audio.stop();
				frame.remove(panel_congratulations);
				Menu m = new Menu();
				m.menu();
				frame.setVisible(false);
			}

			//Check if bgm is playing and stop/start it accordingly
			else if(e.getSource() == btn_mute){
				if(bgm.isRunning()){
					bgm.stop();
				}else{
					bgm.start();
				}
			}
		} 
	
	}; //end of ActionListener
}
