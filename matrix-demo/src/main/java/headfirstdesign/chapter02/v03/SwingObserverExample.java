package headfirstdesign.chapter02.v03;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class SwingObserverExample {
	JFrame jframe;

	public static void main(String[] args) {
		new SwingObserverExample().go();
	}

	public void go() {

		jframe = new JFrame();

		JButton button = new JButton("Should i do it?");

		button.addActionListener(new AngelListener());
		button.addActionListener(new DevilListener());

		jframe.getContentPane().add(BorderLayout.CENTER, button);

	}

	class AngelListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("i am angel...");
		}

	}

	class DevilListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("i am devil....");
		}

	}

}
