import java.applet.Applet;
import java.awt.Graphics;

import java.util.*;
/*
<applet code="SimpleApplet" width=200 height=60>
</applte>
*/
public class apt {
    @Deprecated
    public class SimpleApplet extends Applet{
        public void paint(Graphics g){
            g.drawString("A Simple Applet",20,20);
        }
    }
}
