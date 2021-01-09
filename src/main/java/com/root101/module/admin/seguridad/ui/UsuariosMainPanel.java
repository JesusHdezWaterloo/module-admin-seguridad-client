/*
 * Copyright 2021 Root101 (jhernandezb96@gmail.com, +53-5-426-8660).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Or read it directly from LICENCE.txt file at the root of this project.
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.root101.module.admin.seguridad.ui;

import com.root101.module.admin.seguridad.ui.rol.RolDetailView;
import com.root101.module.admin.seguridad.ui.usuario.UsuarioDetailView;
import com.root101.utils.interfaces.Update;
import com.root101.swing.material.components.container.panel._PanelTransparent;
import java.awt.BorderLayout;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
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
