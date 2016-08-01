package org.customer.editor;

import java.util.Set;
import org.customer.domain.Customer;
import org.openide.util.NbBundle.Messages;
import org.openide.windows.TopComponent;

@Messages({
    "CTL_CustomerEditorTopComponent=Customer Editor for ",
    "HINT_CustomerEditorTopComponent=This is a CustomerEditor window"
})
public final class CustomerEditorTopComponent extends TopComponent {

    Set<Customer> uniqueCustomers = CustomerUtilities.uniqueCustomers;
    private final Customer c;
    
    public CustomerEditorTopComponent(Customer c) {
        this.c = c;
        initComponents();
        setName(Bundle.CTL_CustomerEditorTopComponent() + c.getName());
        setToolTipText(Bundle.HINT_CustomerEditorTopComponent());
        nameField.setText(c.getName());
    }

    @Override
    protected void componentClosed() {
        uniqueCustomers.remove(c);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();

        org.openide.awt.Mnemonics.setLocalizedText(jLabel2, org.openide.util.NbBundle.getMessage(CustomerEditorTopComponent.class, "CustomerEditorTopComponent.jLabel2.text")); // NOI18N

        nameField.setText(org.openide.util.NbBundle.getMessage(CustomerEditorTopComponent.class, "CustomerEditorTopComponent.nameField.text")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nameField, javax.swing.GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(261, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField nameField;
    // End of variables declaration//GEN-END:variables
}
