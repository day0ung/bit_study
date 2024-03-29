package awtSample06;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.BadLocationException;

public class WindowTest extends JFrame  {
	//대화입력하는창 
	JTextField textField;
	
	//대화창
	JTextArea textArea;
	
	//
	JButton btn1, btn2;
	
	public WindowTest() {
		super("간단한 예제"); 
		
		JPanel panel = new JPanel();
		
		textArea = new JTextArea();
		textArea.setLineWrap(true); //라인그려주는것
		
		JScrollPane  scrPane = new JScrollPane(textArea);
		scrPane.setPreferredSize(new Dimension(400,600)); //텍스트에어리어의 사이즈
		
		panel.add(scrPane); //텍스트에어리어를 넣어놈
		
		//텍스트 필드부분
		JPanel botpan = new JPanel();
		textField = new JTextField(20); //글자의 숫자 가 몇칸까지 되는가 getter
		
		
		btn1 = new JButton("next insert");
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			//	JOptionPane.showMessageDialog(null, "next insert");
				if(!textField.getText().equals("")) { //비어있지 않을떄 !
					String msg = textField.getText()+ "\n"; //개행까지 같이 실행 \n
					textArea.append(msg);
				}
			}
		});
		
		btn2 = new JButton("prev insert");
		btn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			//	JOptionPane.showMessageDialog(null, "prev insert");
				if(textField.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "문장을 작성해주십시오");
					return; 
				}
				
				try {
					textArea.insert(textField.getText()+"\n",
										textArea.getLineStartOffset(0));
					//pos position 어느위치에 추가할거냐, 몇번째 라인에 넣을거야?라는것, 에러가아니라 익셉션
				} catch (BadLocationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
			}
		});
		
		
		botpan.add(textField);
		botpan.add(btn1);
		botpan.add(btn2);
		
		//LayOut
		Container contentPane = getContentPane();
		
		contentPane.add(panel, BorderLayout.CENTER);
		contentPane.add(botpan, BorderLayout.SOUTH);
		
		setSize(640, 480); // 윈도우의 크기(폭, 높이)
		setLocation(100, 0); //윈도우가 실행 위치(x오른쪽으로갈수록 늘어남, y 밑으로내려갈수록 늘어남)
		setVisible(true); // 윈도우 시각화
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}


}
