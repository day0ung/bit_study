package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dto.Human;
import dto.Pitcher;
import panel.UpdatePitPanel;
import single.Singleton;

public class UpdateView extends JFrame implements ActionListener{

	Container contentPane;
	
	JTextField textField;
	JButton button;
	
	public UpdateView() {
		super("UpdateView");
		
		JLabel label = new JLabel("수정");
		JLabel nameLabel = new JLabel("이름:");
		textField = new JTextField(20);
		button = new JButton("선택");
		button.addActionListener(this);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.yellow);
		panel.add(label);
		panel.add(nameLabel);
		panel.add(textField);
		panel.add(button);
		
		JPanel botpanel = new JPanel();
				
		contentPane = getContentPane();
		contentPane.add(panel, BorderLayout.NORTH);
		contentPane.add(botpanel, BorderLayout.CENTER);
		
		setBounds(0, 0, 640, 480);
		setBackground(Color.LIGHT_GRAY);
		setVisible(true);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(null, "actionPerformed");
		
		Singleton s = Singleton.getInstance();
		Human h = s.map.get(textField.getText());
		
		contentPane = getContentPane();
		contentPane.remove(1);
		if(h instanceof Pitcher) {
			contentPane.add(new UpdatePitPanel(textField.getText(), this), BorderLayout.CENTER);
		}else {
			
		}
		revalidate();
	}
}
