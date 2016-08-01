/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.hulles.geewhiz;

import java.io.Serializable;
import java.util.logging.Logger;
import javax.swing.JComponent;
import org.openide.loaders.DataObject;
import org.openide.util.ImageUtilities;
import org.openide.util.NbBundle;
import org.openide.windows.TopComponent;
import org.openide.windows.WindowManager;
import org.openide.util.Utilities;

/**
 * Top component which displays something.
 */
final class VPrologTopComponent extends TopComponent {
    private VPrologGraphScene scene;
    
    private static VPrologTopComponent instance;
    /** path to the icon used by the component and its open action */
    static final String ICON_PATH = "org/hulles/geewhiz/pl.gif";

    private static final String PREFERRED_ID = "VPrologTopComponent";

    private VPrologTopComponent() {
        initComponents();
        setName(NbBundle.getMessage(VPrologTopComponent.class, "CTL_VPrologTopComponent"));
        setToolTipText(NbBundle.getMessage(VPrologTopComponent.class, "HINT_VPrologTopComponent"));
        setIcon(ImageUtilities.loadImage(ICON_PATH, true));
        scene = new VPrologGraphScene();
        jPanel1.add(scene.createView());  
    }

    public void loadProlog(DataObject dObj) {
        VPrologSatelliteTopComponent top;
        
        scene = new VPrologGraphScene(dObj);
        jPanel1.removeAll();
        JComponent component =  scene.createView();
        jPanel1.add(component);
        top = VPrologSatelliteTopComponent.findInstance();
        if (top.isOpened()) {
            top.setView(scene);
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
        jPanel1 = new javax.swing.JPanel();

        jPanel1.setLayout(new java.awt.BorderLayout());
        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
    /**
     * Gets default instance. Do not use directly: reserved for *.settings files only,
     * i.e. deserialization routines; otherwise you could get a non-deserialized instance.
     * To obtain the singleton instance, use {@link #findInstance}.
     */
    public static synchronized VPrologTopComponent getDefault() {
        if (instance == null) {
            instance = new VPrologTopComponent();
        }
        return instance;
    }

    /**
     * Obtain the VPrologTopComponent instance. Never call {@link #getDefault} directly!
     */
    public static synchronized VPrologTopComponent findInstance() {
        TopComponent win = WindowManager.getDefault().findTopComponent(PREFERRED_ID);
        if (win == null) {
            Logger.getLogger(VPrologTopComponent.class.getName()).warning(
                    "Cannot find " + PREFERRED_ID + " component. It will not be located properly in the window system.");
            return getDefault();
        }
        if (win instanceof VPrologTopComponent) {
            return (VPrologTopComponent) win;
        }
        Logger.getLogger(VPrologTopComponent.class.getName()).warning(
                "There seem to be multiple components with the '" + PREFERRED_ID +
                "' ID. That is a potential source of errors and unexpected behavior.");
        return getDefault();
    }

    @Override
    public int getPersistenceType() {
        return TopComponent.PERSISTENCE_NEVER;
    }

    @Override
    public void componentOpened() {
        // TODO add custom code on component opening
    }

    @Override
    public void componentClosed() {
        TopComponent satellite;
        
        satellite = VPrologSatelliteTopComponent.findInstance();
        if (satellite.isOpened()) {
            satellite.close();
        }
    }

    /** replaces this in object stream */
    @Override
    public Object writeReplace() {
        return new ResolvableHelper();
    }

    @Override
    protected String preferredID() {
        return PREFERRED_ID;
    }

    final static class ResolvableHelper implements Serializable {

        private static final long serialVersionUID = 1L;

        public Object readResolve() {
            return VPrologTopComponent.getDefault();
        }
    }
}
