package org.shop.editor;

import demo.Customer;
import demo.DiscountCode;
import demo.MicroMarket;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.Icon;
import org.netbeans.api.settings.ConvertAsProperties;
import org.netbeans.spi.actions.AbstractSavable;
import org.openide.DialogDisplayer;
import org.openide.NotifyDescriptor;
import org.openide.NotifyDescriptor.Confirmation;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.UndoRedo;
import org.openide.util.ImageUtilities;
import org.openide.util.Lookup;
import org.openide.util.LookupEvent;
import org.openide.util.LookupListener;
import org.openide.util.NbBundle.Messages;
import org.openide.util.lookup.AbstractLookup;
import org.openide.util.lookup.InstanceContent;
import org.openide.windows.TopComponent;
import org.openide.windows.WindowManager;

/**
 * Top component which displays something.
 */
@ConvertAsProperties(
	   dtd = "-//org.shop.editor//CustomerEditor//EN",
	   autostore = false
)
@TopComponent.Description(
	   preferredID = "CustomerEditorTopComponent",
	   //iconBase="SET/PATH/TO/ICON/HERE",
	   persistenceType = TopComponent.PERSISTENCE_ALWAYS
)
@TopComponent.Registration(mode = "editor", openAtStartup = true)
@ActionID(category = "Window", id = "org.shop.editor.CustomerEditorTopComponent")
@ActionReference(path = "Menu/Window" /* , position = 333 */)
@TopComponent.OpenActionRegistration(
	   displayName = "#CTL_CustomerEditorAction",
	   preferredID = "CustomerEditorTopComponent"
)
@Messages({
	"CTL_CustomerEditorAction=CustomerEditor",
	"CTL_CustomerEditorTopComponent=CustomerEditor Window",
	"HINT_CustomerEditorTopComponent=This is a CustomerEditor window"
})
public final class CustomerEditorTopComponent extends TopComponent implements LookupListener{

	private Lookup.Result result = null;
	private InstanceContent instanceContent = new InstanceContent();
	private UndoRedo.Manager manager = new UndoRedo.Manager();
	private Customer customer;

	public CustomerEditorTopComponent(){
		initComponents();
		setName(Bundle.CTL_CustomerEditorTopComponent());
		setToolTipText(Bundle.HINT_CustomerEditorTopComponent());
		nameField.getDocument().addUndoableEditListener(manager);
		cityField.getDocument().addUndoableEditListener(manager);
		nameField.addKeyListener(new KeyAdapter(){
			@Override
			public void keyReleased(KeyEvent e){
				modify();
			}
		});
		cityField.addKeyListener(new KeyAdapter(){
			@Override
			public void keyReleased(KeyEvent e){
				modify();
			}
		});
		associateLookup(new AbstractLookup(instanceContent));
	}

	private void modify(){
		if(getLookup().lookup(MySavable.class) == null){
			instanceContent.add(new MySavable());
		}
	}

	private static final Icon ICON = ImageUtilities.loadImageIcon("org/shop/editor/blue.png", true);

	private class MySavable extends AbstractSavable implements Icon{

		MySavable(){
			register();
		}

		@Override
		protected String findDisplayName(){
			String name = nameField.getText();
			String city = cityField.getText();
			return name + " from " + city;
		}

		@Override
		protected void handleSave() throws IOException{
			Confirmation message = new NotifyDescriptor.Confirmation("Do you want to save \""
				   + nameField.getText() + " (" + cityField.getText() + ")\"?",
				   NotifyDescriptor.OK_CANCEL_OPTION,
				   NotifyDescriptor.QUESTION_MESSAGE);
			Object result = DialogDisplayer.getDefault().notify(message);
			//When user clicks "Yes", indicating they really want to save,
			//we need to disable the Save action,
			//so that it will only be usable when the next change is made
			//to the JTextArea:
			if(NotifyDescriptor.YES_OPTION.equals(result)){
				EntityManager entityManager = Persistence.createEntityManagerFactory("CustomerLibraryPU").createEntityManager();
				entityManager.getTransaction().begin();
				if(customer.getCustomerId() != null){
					Customer c = entityManager.find(Customer.class, customer.getCustomerId());
					c.setName(nameField.getText());
					c.setCity(cityField.getText());
					entityManager.getTransaction().commit();
				}else{
					Query query = entityManager.createNamedQuery("Customer.findAll");
					List<Customer> resultList = query.getResultList();
					customer.setCustomerId(resultList.size() + 1);
					customer.setName(nameField.getText());
					customer.setCity(cityField.getText());
					customer.setAddressline1("some address line 1");
					customer.setAddressline2("some address line 2");
					customer.setCreditLimit(1);
					customer.setDiscountCode(new DiscountCode("N"));
					customer.setEmail("foo@bar.com");
					customer.setFax("001122");
					customer.setPhone("555-555-555");
					customer.setState("CA");
					customer.setZip(new MicroMarket());
					//add more fields that will populate all the other columns in the table!
					entityManager.persist(customer);
					entityManager.getTransaction().commit();
				}
			}
		}

		CustomerEditorTopComponent tc(){
			return CustomerEditorTopComponent.this;
		}

		@Override
		public boolean equals(Object obj){
			if(obj instanceof MySavable){
				MySavable m = (MySavable) obj;
				return tc() == m.tc();
			}
			return false;
		}

		@Override
		public int hashCode(){
			return tc().hashCode();
		}

		@Override
		public void paintIcon(Component c, Graphics g, int x, int y){
			ICON.paintIcon(c, g, x, y);
		}

		@Override
		public int getIconWidth(){
			return ICON.getIconWidth();
		}

		@Override
		public int getIconHeight(){
			return ICON.getIconHeight();
		}

	}

	@Override
	public UndoRedo getUndoRedo(){
		return manager;
	}

	public void resetFields(){
		customer = new Customer();
		nameField.setText("");
		cityField.setText("");
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        cityField = new javax.swing.JTextField();

        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(CustomerEditorTopComponent.class, "CustomerEditorTopComponent.jLabel1.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel2, org.openide.util.NbBundle.getMessage(CustomerEditorTopComponent.class, "CustomerEditorTopComponent.jLabel2.text")); // NOI18N

        nameField.setText(org.openide.util.NbBundle.getMessage(CustomerEditorTopComponent.class, "CustomerEditorTopComponent.nameField.text")); // NOI18N

        cityField.setText(org.openide.util.NbBundle.getMessage(CustomerEditorTopComponent.class, "CustomerEditorTopComponent.cityField.text")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nameField)
                    .addComponent(cityField, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cityField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addContainerGap(234, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cityField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField nameField;
    // End of variables declaration//GEN-END:variables

	@Override
	public void componentOpened(){
		result = WindowManager.getDefault().findTopComponent("CustomerEditorTopComponent").getLookup().lookupResult(Customer.class);
//        result = Utilities.actionsGlobalContext().lookupResult(Customer.class);
		result.addLookupListener(this);
		resultChanged(new LookupEvent(result));
	}

	@Override
	public void componentClosed(){
		result.removeLookupListener(this);
		result = null;
	}

	@Override
	public void resultChanged(LookupEvent lookupEvent){
		Lookup.Result r = (Lookup.Result) lookupEvent.getSource();
		Collection<Customer> coll = r.allInstances();
		if(!coll.isEmpty()){
			for(Customer cust : coll){
				customer = cust;
				nameField.setText(cust.getName());
				cityField.setText(cust.getCity());
			}
		}else{
			nameField.setText("[no name]");
			cityField.setText("[no city]");
		}
	}

	void writeProperties(java.util.Properties p){
		// better to version settings since initial version as advocated at
		// http://wiki.apidesign.org/wiki/PropertyFiles
		p.setProperty("version", "1.0");
		// TODO store your settings
	}

	void readProperties(java.util.Properties p){
		String version = p.getProperty("version");
		// TODO read your settings according to their version
	}
}
