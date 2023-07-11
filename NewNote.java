import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.JTextField;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.JFormattedTextField;
import javax.swing.DropMode;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JFileChooser;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.Color;

public class NewNote {

	private JFrame frame;
	JTextArea txt = new JTextArea();
	

	/**
	 * Launch the application.
	 */
	public static void NewNote() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewNote window = new NewNote();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public NewNote() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 894, 547);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(new Color(255, 255, 240));
		lblNewLabel.setBounds(0, 27, 894, 510);
		frame.getContentPane().add(lblNewLabel); 
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 854, 28);
		frame.getContentPane().add(menuBar);
		
		JMenu mnNewMenu = new JMenu("File");
		mnNewMenu.setFont(new Font("Segoe UI", Font.BOLD, 12));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("New");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txt.setText("");
				
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Open");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser open = new JFileChooser();
				int choice = open.showOpenDialog(frame);
				if(choice == JFileChooser.APPROVE_OPTION) {
					try {
					Scanner sc = new Scanner(new FileReader(open.getSelectedFile().getPath()));
					  while(sc.hasNext()) {
						  txt.append(sc.nextLine()+"\n");
					  }
					}
					catch(FileNotFoundException e1) {
						JOptionPane.showMessageDialog(null, e1);
					}
				}
			}
		});
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenuItem saved = new JMenuItem("Save");
		saved.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser save = new JFileChooser();
				int choice = save.showSaveDialog(frame);
				if(choice == JFileChooser.APPROVE_OPTION) {
					
					try {
						BufferedWriter bf = new BufferedWriter(new FileWriter(save.getSelectedFile().getPath()));
						 bf.write(txt.getText());
						 bf.close();
					} 
					catch (IOException e2) {
						JOptionPane.showMessageDialog(null, e2);
						
					}
				}
			}
		});
		mnNewMenu.add(saved);
		
		//JTextArea txt = new JTextArea();
		txt.setBounds(0, 27, 894, 510);
		frame.getContentPane().add(txt);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("New menu item");
		mntmNewMenuItem_1.setBounds(-28, 52, 133, 24);
		frame.getContentPane().add(mntmNewMenuItem_1);
		
		JButton btnNewButton = new JButton("X");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				secondFrame sf = new secondFrame();
				sf.NewScreen();
				
				
			}
		});
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(852, 0, 42, 28);
		frame.getContentPane().add(btnNewButton);
		
		frame.setUndecorated(true);
		
	}
}
