package org.nb.kp;

import java.awt.KeyboardFocusManager;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import org.openide.modules.OnStart;
import org.openide.util.NbPreferences;

@OnStart
public class Installer4KeyboardFocusManager implements Runnable {

    @Override
    public void run() {
        KeyboardFocusManager keyboardFocusManager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
        keyboardFocusManager.addKeyEventDispatcher((KeyEvent e) -> {
            KeyEvent kev = (KeyEvent) e;
            if (kev.getModifiers() == InputEvent.CTRL_MASK && kev.getKeyCode() == KeyEvent.VK_TAB) {
                NbPreferences.forModule(Installer4WindowManager.class).put("currentAction", "Popup Switcher (Ctrl-Tab)");
            } else if (kev.getModifiers() == InputEvent.CTRL_MASK + InputEvent.SHIFT_MASK && kev.getKeyCode() == KeyEvent.VK_DOWN) {
                NbPreferences.forModule(Installer4WindowManager.class).put("currentAction", "Copy Down (Ctrl-Shift-Down)");
            } else if (kev.getModifiers() == InputEvent.CTRL_MASK + InputEvent.SHIFT_MASK && kev.getKeyCode() == KeyEvent.VK_UP) {
                NbPreferences.forModule(Installer4WindowManager.class).put("currentAction", "Copy Up (Ctrl-Shift-Up)");
            } else if (kev.getModifiers() == InputEvent.ALT_MASK + InputEvent.SHIFT_MASK && kev.getKeyCode() == KeyEvent.VK_DOWN) {
                NbPreferences.forModule(Installer4WindowManager.class).put("currentAction", "Move Down (Alt-Shift-Down)");
            } else if (kev.getModifiers() == InputEvent.ALT_MASK + InputEvent.SHIFT_MASK && kev.getKeyCode() == KeyEvent.VK_UP) {
                NbPreferences.forModule(Installer4WindowManager.class).put("currentAction", "Move Up (Alt-Shift-Up)");
            } else if (kev.getModifiers() == InputEvent.CTRL_MASK + InputEvent.SHIFT_MASK && kev.getKeyCode() == KeyEvent.VK_R) {
                NbPreferences.forModule(Installer4WindowManager.class).put("currentAction", "Toggle Rectangular Selection (Ctrl-Shift-R)");
            } else if (kev.getModifiers() == InputEvent.CTRL_MASK && kev.getKeyCode() == KeyEvent.VK_F3) {
                NbPreferences.forModule(Installer4WindowManager.class).put("currentAction", "Find Selection (Ctrl-F3)");
            }
            return false;
        });
    }
}
