package org.nb.kp;

import java.awt.Dimension;
import java.awt.Font;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.util.logging.StreamHandler;
import java.util.prefs.PreferenceChangeEvent;
import java.util.prefs.PreferenceChangeListener;
import javax.swing.Action;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import org.openide.awt.Mnemonics;
import org.openide.util.NbPreferences;

public class KeyPromoterUtilities {

    public static JLabel createLabel() throws SecurityException {
        JLabel label = new JLabel();
        label.setPreferredSize(new Dimension(600, 20));
        Font font = label.getFont();
        label.setFont(new Font(font.getName(), Font.BOLD, 18));
        Logger logger = Logger.getLogger("org.netbeans.ui.actions");
        logger.addHandler(new StreamHandler() {
            @Override
            public void publish(LogRecord record) {
                Object[] parameters = record.getParameters();
                if (parameters[2] instanceof Action) {
                    Action a = (Action) parameters[2];
                    JMenuItem menu = new JMenuItem();
                    Mnemonics.setLocalizedText(
                            menu,
                            a.getValue(Action.NAME).toString());
                    String name = menu.getText().replace("...", "");
                    if (a.getValue(Action.ACCELERATOR_KEY) != null) {
                        String rawText = a.getValue(Action.ACCELERATOR_KEY).toString();
                        NbPreferences.forModule(Installer4WindowManager.class).put("currentAction", formatText(rawText) + " (" + name + ")");
                    } else {
                        NbPreferences.forModule(Installer4WindowManager.class).put("currentAction", name);
                    }
                } else if (record.getMessage().equals("UI_ACTION_KEY_PRESS")) {
                    String rawName = record.getParameters()[4].toString();
                    JMenuItem menu = new JMenuItem();
                    Mnemonics.setLocalizedText(
                            menu,
                            rawName);
                    String name = menu.getText();
                    NbPreferences.forModule(Installer4WindowManager.class).put("currentAction", formatText(record.getParameters()[0].toString() + " (" + name + ")"));
                }
            }
        });
        NbPreferences.forModule(Installer4WindowManager.class).addPreferenceChangeListener(new PreferenceChangeListener() {
            @Override
            public void preferenceChange(PreferenceChangeEvent evt) {
                switch (evt.getKey()) {
                    case "currentAction":
                        label.setText(evt.getNewValue());
                        break;
                }
            }
        });
        return label;
    }

    private static String formatText(String rawText) {
        rawText = rawText.replace("pressed", "").
                replace("alt", "Alt -").
                replace("ctrl", "Ctrl -").
                replace("shift", "Shift -").
                replace("PAGE_DOWN", "Page Down").
                replace("KP_LEFT", "Left").
                replace("RIGHT", "Right").
                replace("PAGE_UP", "Page Up");
        return rawText;
    }

}
