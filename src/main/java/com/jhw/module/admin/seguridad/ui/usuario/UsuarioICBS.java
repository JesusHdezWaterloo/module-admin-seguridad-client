package com.jhw.module.admin.seguridad.ui.usuario;

import com.jhw.module.admin.seguridad.core.domain.*;
import com.jhw.module.admin.seguridad.ui.module.SeguridadModuleNavigator;
import com.jhw.module.admin.seguridad.ui.module.SeguridadSwingModule;
import com.jhw.swing.models.input.icbs.InputComboBoxSelection;
import com.jhw.swing.models.input.panels.ModelPanel;
import java.util.List;

/**
 *
 * @author Jesús Hernández Barrios (jhernandezb96@gmail.com)
 */
public class UsuarioICBS extends InputComboBoxSelection<UsuarioDomain> {

    public UsuarioICBS() {
        setLabel("Usuario");
        setIcon(SeguridadModuleNavigator.ICON_ROL);
    }

    @Override
    public List<UsuarioDomain> getList() throws Exception {
        return SeguridadSwingModule.usuarioUC.findAll();
    }

    @Override
    public ModelPanel<UsuarioDomain> inputPanel() {
        return UsuarioInputView.from();
    }

    @Override
    protected void addPropertyChange() {
        SeguridadSwingModule.rolUC.addPropertyChangeListener(this);
        SeguridadSwingModule.usuarioUC.addPropertyChangeListener(this);
    }
}
