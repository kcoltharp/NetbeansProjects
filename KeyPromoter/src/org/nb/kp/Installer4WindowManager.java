package org.nb.kp;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import org.openide.util.NbPreferences;
import org.openide.windows.OnShowing;
import org.openide.windows.TopComponent;
import org.openide.windows.WindowManager;

@OnShowing
public class Installer4WindowManager implements Runnable {

    @Override
    public void run() {
        WindowManager.getDefault().getRegistry().addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if (evt.getNewValue() instanceof TopComponent) {
                    TopComponent tc = (TopComponent) evt.getNewValue();
                    String name = "Window";
                    if (tc.getDisplayName()!=null){
                        name = tc.getDisplayName();
                    }
                    else if (tc.getName()!=null){
                        name = tc.getName();
                    }
                    switch (evt.getPropertyName()) {
                        case TopComponent.Registry.PROP_TC_CLOSED:
                            NbPreferences.forModule(Installer4WindowManager.class).put("currentAction", "Closed " + name);
                            break;
                        case TopComponent.Registry.PROP_TC_OPENED:
                            NbPreferences.forModule(Installer4WindowManager.class).put("currentAction", "Opened " + name);
                            break;
                        case TopComponent.Registry.PROP_ACTIVATED:
                            NbPreferences.forModule(Installer4WindowManager.class).put("currentAction", "Activated " + name);
                            break;
                    }
                }
            }
        }
        );
    }

}
