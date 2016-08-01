/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.groovy.editorpane;

import java.io.IOException;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.text.Document;
import javax.swing.text.EditorKit;
import org.netbeans.api.editor.DialogBinding;
import org.openide.util.NbBundle;
import org.openide.windows.TopComponent;
import org.netbeans.api.settings.ConvertAsProperties;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.filesystems.FileObject;
import org.openide.filesystems.FileUtil;
import org.openide.loaders.DataObject;
import org.openide.text.CloneableEditorSupport;
import org.openide.util.Exceptions;
import org.openide.windows.IOProvider;
import org.openide.windows.InputOutput;

/**
 * Top component which displays something.
 */
@ConvertAsProperties(dtd = "-//org.groovy.editorpane//Groovy//EN",
autostore = false)
@TopComponent.Description(preferredID = "GroovyTopComponent",
//iconBase="SET/PATH/TO/ICON/HERE", 
persistenceType = TopComponent.PERSISTENCE_ALWAYS)
@TopComponent.Registration(mode = "properties", openAtStartup = true)
@ActionID(category = "Window", id = "org.groovy.editorpane.GroovyTopComponent")
@ActionReference(path = "Menu/Window" /*, position = 333 */)
@TopComponent.OpenActionRegistration(displayName = "#CTL_GroovyAction",
preferredID = "GroovyTopComponent")
public final class GroovyTopComponent extends TopComponent {

    public GroovyTopComponent() {
        initComponents();
        setName(NbBundle.getMessage(GroovyTopComponent.class, "CTL_GroovyTopComponent"));
        setToolTipText(NbBundle.getMessage(GroovyTopComponent.class, "HINT_GroovyTopComponent"));

        EditorKit kit = CloneableEditorSupport.getEditorKit("text/x-groovy");
        editorPane.setEditorKit(kit);
        FileObject fob;
        try {
            //Create a file in memory:
            fob = FileUtil.createMemoryFileSystem().getRoot().createData("tmp", "groovy");
            DataObject dob = DataObject.find(fob);
            editorPane.getDocument().putProperty(
                    Document.StreamDescriptionProperty,
                    dob);
            DialogBinding.bindComponentToFile(fob, 0, 0, editorPane);
            //Provide some default content:
            editorPane.setText("def scores = [80, 90, 70]"
                    + "\n"
                    + "\n"
                    + "\"\"\"Maximum: ${scores.max()}"
                    + "\nMinimum: ${scores.min()}\"\"\"");
        } catch (IOException ex) {
            Exceptions.printStackTrace(ex);
        }

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        editorPane = new javax.swing.JEditorPane();
        jButton1 = new javax.swing.JButton();

        jScrollPane1.setViewportView(editorPane);

        org.openide.awt.Mnemonics.setLocalizedText(jButton1, org.openide.util.NbBundle.getMessage(GroovyTopComponent.class, "GroovyTopComponent.jButton1.text")); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(312, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ScriptEngineManager factory = new ScriptEngineManager();
        ScriptEngine engine = factory.getEngineByName("groovy");
        try {
            InputOutput inout = IOProvider.getDefault().getIO("Result", true);
            inout.select();
            inout.getOut().print(engine.eval(editorPane.getText()));
        } catch (ScriptException ex) {
            Exceptions.printStackTrace(ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JEditorPane editorPane;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void componentOpened() {
        // TODO add custom code on component opening
    }

    @Override
    public void componentClosed() {
        // TODO add custom code on component closing
    }

    void writeProperties(java.util.Properties p) {
        // better to version settings since initial version as advocated at
        // http://wiki.apidesign.org/wiki/PropertyFiles
        p.setProperty("version", "1.0");
        // TODO store your settings
    }

    void readProperties(java.util.Properties p) {
        String version = p.getProperty("version");
        // TODO read your settings according to their version
    }
}
