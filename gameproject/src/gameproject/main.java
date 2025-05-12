package gameproject;

import javax.swing.SwingUtilities;

public class main {
	public static void main(String[] args) {
       

        new Frame2(3);
        
        SwingUtilities.invokeLater(() -> {
            AppleHarvestGame game = new AppleHarvestGame();
            game.setVisible(true);
        });
    }
}

