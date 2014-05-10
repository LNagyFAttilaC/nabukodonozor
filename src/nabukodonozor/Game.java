package nabukodonozor;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Game extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private JPanel field;
	private JPanel tools;
	private JPanel infos;
	private JPanel icons;
	
	public Game() {	
		field = new JPanel();
		tools = new JPanel();
		infos = new JPanel();
		icons = new JPanel();
	}
	
	public void startGame() {
		//az ablak alap beallitasai
		setTitle("A két torony");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
		//layout kialakitasa
		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		
		field.setPreferredSize(new Dimension(960, 560));
		field.setBackground(Color.RED);
		
		tools.setPreferredSize(new Dimension(300, 120));
		tools.setBackground(Color.GREEN);
		
		infos.setPreferredSize(new Dimension(620, 120));
		infos.setBackground(Color.YELLOW);
		
		icons.setPreferredSize(new Dimension( 40, 120));
		icons.setBackground(Color.BLUE);

		layout.setHorizontalGroup(layout.createParallelGroup()
				.addComponent(field)
				.addGroup(layout.createSequentialGroup()
						.addComponent(tools)
						.addComponent(infos)
						.addComponent(icons)));
		
		layout.setVerticalGroup(layout.createSequentialGroup()
				.addComponent(field)
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(tools)
						.addComponent(infos)
						.addComponent(icons)));
		
		//megjelenites
		pack();
		setVisible(true);
	}
}
