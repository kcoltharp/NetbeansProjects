package org.netbeans.cheats.extensions;

import org.netbeans.cheats.api.CodeTemplateFileProcessor;
import org.openide.filesystems.FileObject;
import org.openide.filesystems.FileUtil;
import org.openide.util.lookup.ServiceProvider;

@ServiceProvider(service = CodeTemplateFileProcessor.class)
public class JSONCodeTemplateFileProcessor implements CodeTemplateFileProcessor {
    @Override
    public FileObject getInternalFile() {
        return null;
    }
    @Override
    public FileObject getFolderContainingCustomizableFile() {
        return FileUtil.getConfigFile("Editors/text/x-json/CodeTemplates");
    }
    @Override
    public String toString() {
        return "JSON";
    }
}
