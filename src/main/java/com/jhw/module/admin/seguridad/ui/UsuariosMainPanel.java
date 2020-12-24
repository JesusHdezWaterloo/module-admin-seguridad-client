package com.jhw.module.admin.seguridad.ui;

import com.jhw.module.admin.seguridad.ui.rol.RolDetailView;
import com.jhw.module.admin.seguridad.ui.usuario.UsuarioDetailView;
import com.jhw.utils.interfaces.Update;
import com.jhw.swing.material.components.container.panel._PanelTransparent;
import java.awt.BorderLayout;

/**
 *
 * @author Jesús Hernández Barrios (jhernandezb96@gmail.com)
 */
public class UsuariosMainPanel extends _PanelTransparent implements Update {

    public UsuariosMainPanel() {
        initComponents();
    }

    private void initComponents() {
        rolDetailView = new RolDetailView();
        usuarioDetailView = new UsuarioDetailView();
        this.setLayout(new BorderLayout());
        this.add(rolDetailView, BorderLayout.EAST);
        this.add(usuarioDetailView, BorderLayout.CENTER);
    }

    // Variables declaration - do not modify
    private RolDetailView rolDetailView;
    private UsuarioDetailView usuarioDetailView;
    // End of variables declaration                   

    @Override
    public void update() {
        usuarioDetailView.update();
        rolDetailView.update();
    }
}
