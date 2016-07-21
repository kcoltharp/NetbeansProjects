
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Kenny
 */
public class FilePickerForm extends JFrame implements PropertyChangeListener
{
	String textFieldLabel;
	String buttonLabel;
	
	JLabel label;
	JTextField textField;
	JButton button;
	
	JFileChooser fileChooser;
	
	int mode;
	int MODE_OPEN = 1;
	int MODE_SAVE = 2;
	
public static void main(String[] args)
	{
		try
		{
			// set look and feel to system dependent
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex)
		{
		}

		SwingUtilities.invokeLater(new Runnable()
		{
			@Override
			public void run()
			{
				new FilePickerForm().setVisible(true);
			}
		});
	}

	@Override
	public void propertyChange(PropertyChangeEvent pce)
	{
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
}