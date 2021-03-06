package gui.dialogs;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import gui.MainWindow;
import gui.internalpanels.SouthPanel;

public class RemoveWordDialog extends JDialog {

	private static final long serialVersionUID = -7027128860972850689L;
	
	private final JPanel contentPanel = new JPanel();

	private JTextField wordFieldLabel, wordField;
	


	/**
	 * Create the dialog.
	 */
	public RemoveWordDialog() {
		setBounds(810, 465, 300, 150);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		{
			wordFieldLabel = new JTextField("Word to remove:");
			wordFieldLabel.setEditable(false);
			
			wordField = new JTextField();
			wordField.setPreferredSize(new Dimension(200, 20));
			contentPanel.add(wordFieldLabel);
			contentPanel.add(wordField);
		}
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Remove word");
				okButton.setActionCommand("Remove word");
				okButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						String name = wordField.getText();
						if (name.equals("")){
							SouthPanel.displayWarningMessage("Please enter a word!");
						}
						else{
							MainWindow.dictionary.removeWord(name);
							dispose();
						}
						
					}
				});
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						dispose();
						
					}
				});
				buttonPane.add(cancelButton);
			}
		}
	}

}
