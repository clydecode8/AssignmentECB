package utility;

import control.Driver;
import java.awt.AWTException;
import java.awt.Robot;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Clear {
    public static void clrscreen() throws InterruptedException {

        try {
            Robot pressbot = new Robot();
            // Create Robot object to press CTRL + L
            pressbot.keyPress(17);   // Holds CTRL key.
            pressbot.keyPress(76);   // Holds L key.
            pressbot.keyRelease(17); // Releases CTRL key.
            pressbot.keyRelease(76); // Releases L key.
            Thread.sleep(250);
        } catch (AWTException ex) {
            Logger.getLogger(Driver.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}