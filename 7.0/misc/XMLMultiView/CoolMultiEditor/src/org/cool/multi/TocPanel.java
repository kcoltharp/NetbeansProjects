/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * TocPanel.java
 *
 * Created on Jul 17, 2011, 11:34:24 AM
 */
package org.cool.multi;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.List;
import java.util.ListIterator;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import org.cool.multi.model.Toc;
import org.cool.multi.model.Tocitem;
import org.netbeans.modules.xml.multiview.ui.LinkButton;
import org.netbeans.modules.xml.multiview.ui.SectionInnerPanel;
import org.netbeans.modules.xml.multiview.ui.SectionView;

/**
 *
 * @author geertjan
 */
public class TocPanel extends SectionInnerPanel {

    public TocPanel(SectionView view, Toc toc) {

        super(view);
        initComponents();

        ListIterator<Tocitem> it = toc.getTocitem().listIterator();
        while (it.hasNext()) {
            //Create the first level of items:
            List<Tocitem> list = iterateThroughOneLevel(it.next(), createConstraintsForView(20));
            ListIterator<Tocitem> it2 = list.listIterator();
            while (it2.hasNext()) {
                //Create the second level of items:
                List<Tocitem> list2 = iterateThroughOneLevel(it2.next(), createConstraintsForView(50));
                ListIterator<Tocitem> it3 = list2.listIterator();
                while (it3.hasNext()) {
                    //Create the third level of items:
                    List<Tocitem> list3 = iterateThroughOneLevel(it3.next(), createConstraintsForView(80));
                    ListIterator<Tocitem> it4 = list3.listIterator();
                    while (it4.hasNext()) {
                        //Create the fourth level of items:
                        List<Tocitem> list4 = iterateThroughOneLevel(it4.next(), createConstraintsForView(110));
                        ListIterator<Tocitem> it5 = list4.listIterator();
                        while (it5.hasNext()) {
                            //Create the fifth level of items:
                            iterateThroughOneLevel(it5.next(), createConstraintsForView(110));
                        }
                    }
                }
            }
        }

//        GridBagConstraints gbc = new GridBagConstraints();
//        gbc.insets = new Insets(2, 5, 1, 1); // spacer
//        gbc.weightx = 1.0; // allow horiz dispersion
//        gbc.anchor = GridBagConstraints.WEST; // align left (requires \^)
//        gbc.gridwidth = GridBagConstraints.REMAINDER; // one component per row
//        JTextField textField = new JTextField();
//
//        List<Tocitem> list = toc.getTocitem();
//        for (int i = 0; i < list.size(); i++) {
//            Tocitem item = list.get(i);
//            String oneItem = item.getText();
//            textField = new JTextField();
//            add(textField, gbc);
//            textField.setText(oneItem);
//        }

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setLayout(new java.awt.GridBagLayout());
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    @Override
    public void setValue(JComponent jc, Object o) {
    }

    @Override
    public void linkButtonPressed(Object o, String string) {
    }

    @Override
    public JComponent getErrorComponent(String string) {
        return null;
    }

    public GridBagConstraints createConstraintsForView(int inset) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(2, inset, 1, 1); // spacer
        gbc.weightx = 1.0; // allow horiz dispersion
        gbc.anchor = GridBagConstraints.WEST; // align left (requires \^)
        gbc.gridwidth = GridBagConstraints.REMAINDER; // one component per row
        return gbc;
    }

    public void addFieldToView(String name, GridBagConstraints gbc) {
        JTextField textField = new JTextField();
        textField.setText(name);
        add(textField, gbc);
    }

    public void addLabToView(String name, GridBagConstraints gbc) {
        JLabel label = new JLabel(name);
        add(label, gbc);
    }

    public void addButtToView(String name, String target, GridBagConstraints gbc) {
        LinkButton butt = new LinkButton(this, null, target);
        butt.setText(name);
        add(butt, gbc);
    }

    public boolean isTopic(String target) {
        //If target is null, we return false,
        //because the toc item not a help topic:
        if (target == null) {
            return false;
            //If target is not null, we return true,
            //because the toc item is a help topic:
        } else {
            return true;
        }
    }

    public List iterateThroughOneLevel(Tocitem item, GridBagConstraints gbc) {
        String name = item.getText();
        String target = item.getTarget();
        if (isTopic(target)) {
            addButtToView(name, target, gbc);
            //addFieldToView(name, gbc);
        } else {
            addLabToView(name, gbc);
        }
        return item.getTocitem();
    }
}
