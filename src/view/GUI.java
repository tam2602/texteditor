package view;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import model.FunctionFile;

import java.awt.event.ActionListener;

public class GUI {
	private JFrame window;
	private JTextArea textArea;
	private JMenuBar menuBar;
	private JMenu menuFile;
	private JMenuItem iNew, iOpen, iSave, iSaveAs, iExit;

	private FunctionFile file;

	public GUI() {
		createWindow();
		createTextArea();
		createMenuBar();
		createFileMenu();
		FunctionFile functionFile = new FunctionFile(this);
		setFile(functionFile);
		window.setVisible(true);

	}

	public JFrame getWindow() {
		return window;
	}

	public JTextArea getTextArea() {
		return textArea;
	}

	public FunctionFile getFile() {
		return file;
	}

	public void setFile(FunctionFile file) {
		this.file = file;
	}

	private void createWindow() {
		window = new JFrame("Notepad");
		window.setSize(800, 600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void createTextArea() {
		textArea = new JTextArea();
		JScrollPane scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		window.add(scrollPane);
		scrollPane.setBorder(BorderFactory.createEmptyBorder());
	}

	private void createMenuBar() {
		menuBar = new JMenuBar();
		window.setJMenuBar(menuBar);

		menuFile = new JMenu("File");
		menuBar.add(menuFile);
	}

	private void createFileMenu() {
		iNew = new JMenuItem("New");
		iNew.addActionListener(e -> file.newFile());
		menuFile.add(iNew);

		iOpen = new JMenuItem("Open");
		iOpen.addActionListener(e -> file.open());
		menuFile.add(iOpen);

		iSave = new JMenuItem("Save");
		iSave.addActionListener(e -> file.save());
		menuFile.add(iSave);

		iSaveAs = new JMenuItem("SaveAs");
		iSaveAs.addActionListener(e -> file.saveAs());
		menuFile.add(iSaveAs);

		iExit = new JMenuItem("Exit");
		iExit.addActionListener(e -> file.exit());
		menuFile.add(iExit);
	}
}
