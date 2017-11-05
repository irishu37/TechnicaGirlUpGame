import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class StartMenu {

	
	public void render(Graphics g) {
		Font font1 = new Font("arial", Font.BOLD, 50);
		g.setFont(font1);
		g.setColor(Color.blue);
		g.drawString("Can you help this girl get to school?", MainGUI.WIDTH, 100);
	}
}
