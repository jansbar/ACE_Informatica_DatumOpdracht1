package view.panels;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import view.MainWindow;

public class ButtonPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	JButton blueButton;
	JButton yellowButton;
	JButton redButton;
	
	BluePanel bluePanel;
	YellowPanel yellowPanel;
	RedPanel redPanel;
	
	MainWindow mainWindow;

	public ButtonPanel(MainWindow mainWindow) {
		super();
		
		GridBagLayout gbl = new GridBagLayout();
		gbl.columnWidths = new int[] { 50,100,50 };
		
		int numberOfRows=14;
		int[] heights=new int[numberOfRows];
		int windowHeight=580;
		
		for(int i=0;i<numberOfRows;i++){
			heights[i]=windowHeight/numberOfRows;
		}
		
		gbl.rowHeights = heights;
		setLayout(gbl);
		
		bluePanel=new BluePanel();
		yellowPanel=new YellowPanel();
		redPanel=new RedPanel();

		this.mainWindow = mainWindow;
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx=1;
		gbc.gridy=0;
		gbc.fill=GridBagConstraints.HORIZONTAL;
		blueButton = new JButton("Blue");
		blueButton.addActionListener(new BlueButtonListener());
		add(blueButton,gbc);
		
		gbc = new GridBagConstraints();
		gbc.gridx=1;
		gbc.gridy=1;
		gbc.fill=GridBagConstraints.HORIZONTAL;
		redButton = new JButton("Red");
		redButton.addActionListener(new RedButtonListener());
		add(redButton,gbc);
		
		gbc = new GridBagConstraints();
		gbc.gridx=1;
		gbc.gridy=2;
		gbc.fill=GridBagConstraints.HORIZONTAL;
		yellowButton = new JButton("Yellow");
		yellowButton.addActionListener(new YellowButtonListener());
		add(yellowButton,gbc);
	}
	
	public JPanel getHomePanel(){
		return bluePanel;
	}

	class BlueButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			mainWindow.changeViewPanel(bluePanel);
			bluePanel.repaint();
		}
	}

	class RedButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			mainWindow.changeViewPanel(redPanel);
			redPanel.repaint();
		}
	}

	class YellowButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			mainWindow.changeViewPanel(yellowPanel);
			yellowPanel.repaint();
		}
	}

}
