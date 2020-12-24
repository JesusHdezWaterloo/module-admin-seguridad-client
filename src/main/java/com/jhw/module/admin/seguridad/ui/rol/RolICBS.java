package com.jhw.module.admin.seguridad.ui.rol;

import com.jhw.module.admin.seguridad.core.domain.RolDomain;
import com.jhw.module.admin.seguridad.ui.module.SeguridadModuleNavigator;
import com.jhw.module.admin.seguridad.ui.module.SeguridadSwingModule;
import com.jhw.swing.models.input.icbs.InputComboBoxSelection;
import com.jhw.swing.models.input.panels.ModelPanel;
import java.util.List;

/**
 *
 * @author Jesús Hernández Barrios (jhernandezb96@gmail.com)
 */
public class RolICBS extends InputComboBoxSelection<RolDomain> {

    public RolICBS() {
        setLabel("Rol");
        setIcon(SeguridadModuleNavigator.ICON_ROL);
    }

    @Override
    public List<RolDomain> getList() throws Exception {
        return SeguridadSwingModule.rolUC.findAll();
    }

    @Override
    public ModelPanel<RolDomain> inputPanel() {
        return RolInputView.from();
    }

    @Override
    protected void addPropertyChange() {
    }
}
