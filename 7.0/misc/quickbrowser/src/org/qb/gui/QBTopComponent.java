package org.qb.gui;

import java.io.File;
import java.util.Collection;
import org.openide.util.LookupEvent;
import org.openide.util.NbBundle;
import org.openide.windows.TopComponent;
import org.netbeans.api.settings.ConvertAsProperties;
import org.qb.domain.QBChildFactory;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.StatusDisplayer;
import org.openide.explorer.ExplorerManager;
import org.openide.explorer.ExplorerUtils;
import org.openide.filesystems.FileObject;
import org.openide.filesystems.FileUtil;
import org.openide.nodes.AbstractNode;
import org.openide.nodes.Children;
import org.openide.nodes.Node;
import org.openide.util.Lookup.Result;
import org.openide.util.LookupListener;
import org.openide.util.NbPreferences;
import org.openide.util.Utilities;
import org.openide.util.lookup.AbstractLookup;
import org.openide.util.lookup.InstanceContent;
import org.openide.util.lookup.ProxyLookup;

/**
 * Top component which displays something.
 */
@ConvertAsProperties(dtd = "-//org.qb.gui//QBViewer//EN",
autostore = false)
@TopComponent.Description(preferredID = "QBViewerTopComponent",
//iconBase="SET/PATH/TO/ICON/HERE", 
persistenceType = TopComponent.PERSISTENCE_ALWAYS)
@TopComponent.Registration(mode = "properties", openAtStartup = true)
@ActionID(category = "Window", id = "org.qb.gui.QBViewerTopComponent")
@ActionReference(path = "Menu/Window" /*, position = 333 */)
@TopComponent.OpenActionRegistration(displayName = "#CTL_QBViewerAction",
preferredID = "QBViewerTopComponent")
public final class QBTopComponent extends TopComponent
        implements ExplorerManager.Provider, LookupListener {

    private ExplorerManager em = new ExplorerManager();
    private InstanceContent ic = new InstanceContent();

    public QBTopComponent() {
        initComponents();
        setName(NbBundle.getMessage(QBTopComponent.class, "CTL_QBViewerTopComponent"));
        String path = NbPreferences.forModule(QBChildFactory.class).get("rootPath", System.getProperty("user.home"));
        refresh(path);
//        em.addPropertyChangeListener(new PropertyChangeListener() {
//            @Override
//            public void propertyChange(PropertyChangeEvent evt) {
//                Node rootNode = em.getRootContext();
//                if (rootNode != null && !rootNode.isLeaf() && rootNode.getChildren().nodes().hasMoreElements()) {
//                    Node firstChild = rootNode.getChildren().getNodes()[0];
//                    if (firstChild != null) {
//                        try {
//                            em.setSelectedNodes(new Node[]{firstChild});
//                        } catch (PropertyVetoException ex) {
//                            Exceptions.printStackTrace(ex);
//                        }
//                    }
//                }
//            }
//        });
        associateLookup(new ProxyLookup(new AbstractLookup(ic), ExplorerUtils.createLookup(em, getActionMap())));
    }

    public boolean isShowHidden() {
        return showHiddenCB.isSelected();
    }

    public boolean isPreviewImages() {
        return previewImagesCB.isSelected();
    }

    public boolean isShowLarge() {
        return showLargeCB.isSelected();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        previewImagesCB = new javax.swing.JCheckBox();
        showHiddenCB = new javax.swing.JCheckBox();
        iconView1 = new org.qb.gui.IconView();
        upLabel = new javax.swing.JLabel();
        showLargeCB = new javax.swing.JCheckBox();

        org.openide.awt.Mnemonics.setLocalizedText(previewImagesCB, org.openide.util.NbBundle.getMessage(QBTopComponent.class, "QBTopComponent.previewImagesCB.text")); // NOI18N
        previewImagesCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previewImagesCBActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(showHiddenCB, org.openide.util.NbBundle.getMessage(QBTopComponent.class, "QBTopComponent.showHiddenCB.text")); // NOI18N
        showHiddenCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showHiddenCBActionPerformed(evt);
            }
        });

        iconView1.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0))));

        upLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/qb/resources/up.png"))); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(upLabel, org.openide.util.NbBundle.getMessage(QBTopComponent.class, "QBTopComponent.upLabel.text")); // NOI18N
        upLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                upLabelMouseClicked(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(showLargeCB, org.openide.util.NbBundle.getMessage(QBTopComponent.class, "QBTopComponent.showLargeCB.text")); // NOI18N
        showLargeCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showLargeCBActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(iconView1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(showHiddenCB, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(previewImagesCB, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                        .addComponent(upLabel))
                    .addComponent(showLargeCB, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(showHiddenCB)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(previewImagesCB))
                    .addComponent(upLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(showLargeCB)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(iconView1, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void refresh(final String path) {
        Children kids = Children.create(new QBChildFactory(path,
                isShowHidden(),
                isPreviewImages(),
                isShowLarge()), false);
        Node rootNode = new AbstractNode(kids);
        em.setRootContext(rootNode);
    }

    private void upLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_upLabelMouseClicked
        String path = NbPreferences.forModule(QBChildFactory.class).get("rootPath", System.getProperty("user.home"));
        int lastSlash = path.lastIndexOf("/");
        String parentPath = path.substring(0, lastSlash);
        if (parentPath.length() > 0) {
            path = parentPath;
            refresh(path);
            NbPreferences.forModule(QBChildFactory.class).put("rootPath", parentPath);
        } else {
            path = System.getProperty("user.home");
            refresh(path);
        }
        ic.add(FileUtil.toFileObject(new File(path)));
    }//GEN-LAST:event_upLabelMouseClicked

    private void showHiddenCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showHiddenCBActionPerformed
        String path = NbPreferences.forModule(QBChildFactory.class).get("rootPath", System.getProperty("user.home"));
        refresh(path);
    }//GEN-LAST:event_showHiddenCBActionPerformed

    private void previewImagesCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previewImagesCBActionPerformed
        String path = NbPreferences.forModule(QBChildFactory.class).get("rootPath", System.getProperty("user.home"));
        refresh(path);
    }//GEN-LAST:event_previewImagesCBActionPerformed

    private void showLargeCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showLargeCBActionPerformed
        String path = NbPreferences.forModule(QBChildFactory.class).get("rootPath", System.getProperty("user.home"));
        refresh(path);
    }//GEN-LAST:event_showLargeCBActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.qb.gui.IconView iconView1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JCheckBox previewImagesCB;
    private javax.swing.JCheckBox showHiddenCB;
    private javax.swing.JCheckBox showLargeCB;
    private javax.swing.JLabel upLabel;
    // End of variables declaration//GEN-END:variables

    @Override
    public void resultChanged(LookupEvent ev) {
        Collection<? extends FileObject> allInstances = result.allInstances();
        for (FileObject o : allInstances) {
            setDisplayName(o.getName());
            StatusDisplayer.getDefault().setStatusText("Selected: "+o.getPath());
        }
    }
    
    Result<FileObject> result;

    @Override
    public void componentOpened() {
        result = Utilities.actionsGlobalContext().lookupResult(FileObject.class);
        result.addLookupListener(this);
    }

    @Override
    public void componentClosed() {
        result.removeLookupListener(this);
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

    @Override
    public ExplorerManager getExplorerManager() {
        return em;
    }
}
