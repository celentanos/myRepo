package u2013_05_28;

import javax.swing.*;

public class SwingDatenmodelle {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		JFrame frame = new JFrame();
		
		JSlider top = new JSlider(JSlider.HORIZONTAL, 0, 100, 50);
		JSlider bot = new JSlider(JSlider.HORIZONTAL, 0, 100, 50);
		bot.setModel(top.getModel());
		
		//frame.getContentPane().set
		frame.getContentPane().add(bot);
		
		frame.pack();
		frame.setVisible(true);
		
	}

}
