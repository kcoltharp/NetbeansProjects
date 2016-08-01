package org.mycompany.hello;

import org.openide.modules.ModuleInstall;

public class Installer extends ModuleInstall {

    @Override
    public void restored() {
        System.out.println("hello world!");
    }

}
