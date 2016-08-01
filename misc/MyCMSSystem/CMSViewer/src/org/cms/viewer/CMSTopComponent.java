/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cms.viewer;

import java.awt.BorderLayout;
import java.util.logging.Logger;
import org.netbeans.api.settings.ConvertAsProperties;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.explorer.ExplorerManager;
import org.openide.explorer.ExplorerUtils;
import org.openide.explorer.view.BeanTreeView;
import org.openide.nodes.AbstractNode;
import org.openide.nodes.Children;
import org.openide.util.NbBundle;
import org.openide.windows.TopComponent;
import org.openide.windows.WindowManager;

/**
 * Top component which displays something.
 */
@ConvertAsProperties(dtd = "-//org.cms.viewer//CMS//EN",
autostore = false)
@TopComponent.Description(preferredID = "CMSTopComponent",
//iconBase="SET/PATH/TO/ICON/HERE", 
persistenceType = TopComponent.PERSISTENCE_ALWAYS)
@TopComponent.Registration(mode = "explorer", openAtStartup = true)
@ActionID(category = "Window", id = "org.cms.viewer.CMSTopComponent")
@ActionReference(path = "Menu/Window" /*
 * , position = 333
 */)
@TopComponent.OpenActionRegistration(displayName = "#CTL_CMSAction",
preferredID = "CMSTopComponent")
public final class CMSTopComponent extends TopComponent implements ExplorerManager.Provider {

    private static CMSTopComponent instance;
    /** path to the icon used by the component and its open action */
//    static final String ICON_PATH = "SET/PATH/TO/ICON/HERE";
    private static final String PREFERRED_ID = "CMSTopComponent";
    private ExplorerManager em = new ExplorerManager();

    public CMSTopComponent() {
        initComponents();
        setName(NbBundle.getMessage(CMSTopComponent.class, "CTL_CMSTopComponent"));
        setToolTipText(NbBundle.getMessage(CMSTopComponent.class, "HINT_CMSTopComponent"));
//        setIcon(ImageUtilities.loadImage(ICON_PATH, true));

        em.setRootContext(new AbstractNode(Children.create(new ArticleFactory(), true)));

        BeanTreeView beanTreeView = new BeanTreeView();
        beanTreeView.setRootVisible(false);
        add(beanTreeView, BorderLayout.CENTER);

        associateLookup(ExplorerUtils.createLookup(em, getActionMap()));
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setLayout(new java.awt.BorderLayout());
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    /**
     * Gets default instance. Do not use directly: reserved for *.settings files only,
     * i.e. deserialization routines; otherwise you could get a non-deserialized instance.
     * To obtain the singleton instance, use {@link #findInstance}.
     */
    public static synchronized CMSTopComponent getDefault() {
        if (instance == null) {
            instance = new CMSTopComponent();
        }
        return instance;
    }

    /**
     * Obtain the CMSTopComponent instance. Never call {@link #getDefault} directly!
     */
    public static synchronized CMSTopComponent findInstance() {
        TopComponent win = WindowManager.getDefault().findTopComponent(PREFERRED_ID);
        if (win == null) {
            Logger.getLogger(CMSTopComponent.class.getName()).warning(
                    "Cannot find " + PREFERRED_ID + " component. It will not be located properly in the window system.");
            return getDefault();
        }
        if (win instanceof CMSTopComponent) {
            return (CMSTopComponent) win;
        }
        Logger.getLogger(CMSTopComponent.class.getName()).warning(
                "There seem to be multiple components with the '" + PREFERRED_ID
                + "' ID. That is a potential source of errors and unexpected behavior.");
        return getDefault();
    }

    @Override
    public int getPersistenceType() {
        return TopComponent.PERSISTENCE_ALWAYS;
    }

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

    Object readProperties(java.util.Properties p) {
        if (instance == null) {
            instance = this;
        }
        instance.readPropertiesImpl(p);
        return instance;
    }

    private void readPropertiesImpl(java.util.Properties p) {
        String version = p.getProperty("version");
        // TODO read your settings according to their version
    }

    @Override
    protected String preferredID() {
        return PREFERRED_ID;
    }

    @Override
    public ExplorerManager getExplorerManager() {
        return em;
    }
}
