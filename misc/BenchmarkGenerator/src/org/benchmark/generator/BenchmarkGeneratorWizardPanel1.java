/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.benchmark.generator;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import javax.swing.JOptionPane;
import javax.swing.event.ChangeListener;
import org.openide.WizardDescriptor;
import org.openide.filesystems.FileStateInvalidException;
import org.openide.util.Exceptions;
import org.openide.util.HelpCtx;

public class BenchmarkGeneratorWizardPanel1 implements WizardDescriptor.Panel<WizardDescriptor> {

    /**
     * The visual component that displays this panel. If you need to access the
     * component from this class, just use getComponent().
     */
    private BenchmarkGeneratorVisualPanel1 component;

    // Get the visual component for the panel. In this template, the component
    // is kept separate. This can be more efficient: if the wizard is created
    // but never displayed, or not all panels are displayed, it is better to
    // create only those which really need to be visible.
    @Override
    public BenchmarkGeneratorVisualPanel1 getComponent() {
        if (component == null) {
            try {
                component = new BenchmarkGeneratorVisualPanel1();
            } catch (IOException ex) {
                Exceptions.printStackTrace(ex);
            }
        }
        return component;
    }

    @Override
    public HelpCtx getHelp() {
        // Show no Help button for this panel:
        return HelpCtx.DEFAULT_HELP;
        // If you have context help:
        // return new HelpCtx("help.key.here");
    }

    @Override
    public boolean isValid() {
        // If it is always OK to press Next or Finish, then:
        return true;
        // If it depends on some condition (form filled out...) and
        // this condition changes (last form field filled in...) then
        // use ChangeSupport to implement add/removeChangeListener below.
        // WizardDescriptor.ERROR/WARNING/INFORMATION_MESSAGE will also be useful.
    }

    @Override
    public void addChangeListener(ChangeListener l) {
    }

    @Override
    public void removeChangeListener(ChangeListener l) {
    }

    @Override
    public void readSettings(WizardDescriptor wiz) {
        // use wiz.getProperty to retrieve previous panel state
    }

    @Override
    public void storeSettings(WizardDescriptor wiz) {
        try {
            String url = getComponent().getSelectedFileObject().getURL().toURI().toString();
            wiz.putProperty("fileLoc", url);
        } catch (URISyntaxException ex) {
            Exceptions.printStackTrace(ex);
        } catch (FileStateInvalidException ex) {
            Exceptions.printStackTrace(ex);
        }
    }

}
