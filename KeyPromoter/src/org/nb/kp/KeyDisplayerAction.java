package org.nb.kp;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractAction;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionRegistration;
import org.openide.awt.ColorComboBox;
import org.openide.util.NbBundle.Messages;
import org.openide.util.actions.Presenter;

@ActionID(
        category = "Tools",
        id = "org.nb.kp.KeyDisplayerAction"
)
@ActionRegistration(
        lazy = false,
        displayName = "#CTL_KeyDisplayerAction"
)
@ActionReference(path = "Toolbars/Keys", position = 0)
@Messages("CTL_KeyDisplayerAction=KeyDisplayer")
public final class KeyDisplayerAction extends AbstractAction implements Presenter.Toolbar {

    @Override
    public Component getToolbarPresenter() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        ColorComboBox cc = new ColorComboBox();
        cc.setSelectedColor(Color.GREEN);
        JLabel label = KeyPromoterUtilities.createLabel();
        label.setForeground(Color.GREEN);
        cc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setForeground(cc.getSelectedColor());
            }
        });
        panel.add(cc);
        panel.add(new JLabel("  "));
        panel.add(label);
        return panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //UNUSED
    }

}
