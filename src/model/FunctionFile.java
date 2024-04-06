package model;

import java.awt.FileDialog;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import view.GUI;

public class FunctionFile {
	private GUI gui;
	private String fileName;
	private String fileAddress;

	public FunctionFile(GUI gui) {
		this.gui = gui;
	}

	public void newFile() {
		gui.getTextArea().setText("");
		gui.getWindow().setTitle("New");
		fileName = null;
		fileAddress = null;
	}

	public void open() {
		FileDialog fd = new FileDialog(gui.getWindow(), "Open", FileDialog.LOAD);
		fd.setVisible(true);

		if (fd.getFile() != null) {
			fileName = fd.getFile();
			fileAddress = fd.getDirectory();
			gui.getWindow().setTitle(fileName);

			try {
				BufferedReader br = new BufferedReader(new FileReader(fileAddress + fileName));
				gui.getTextArea().setText("");
				String line = null;
				while ((line = br.readLine()) != null) {
					gui.getTextArea().append(line + "\n");
				}
				br.close();
			} catch (IOException e) {
				System.out.println("File not opened");
			}
		}
	}

	public void save() {
		if (fileName == null) {
			saveAs();
		} else {
			try {
				FileWriter fw = new FileWriter(fileAddress + fileName);
				fw.write(gui.getTextArea().getText());
				fw.close();
			} catch (IOException e) {
				System.out.println("Something wrong!");
			}
		}
	}

	public void saveAs() {
		FileDialog fd = new FileDialog(gui.getWindow(), "Save", FileDialog.SAVE);
		fd.setVisible(true);

		if (fd.getFile() != null) {
			fileName = fd.getFile();
			fileAddress = fd.getDirectory();
			gui.getWindow().setTitle(fileName);

			try {
				FileWriter fw = new FileWriter(fileAddress + fileName);
				fw.write(gui.getTextArea().getText());
				fw.close();
			} catch (IOException e) {
				System.out.println("Something wrong!");
			}
		}
	}

	public void exit() {
		System.exit(0);
	}
}
