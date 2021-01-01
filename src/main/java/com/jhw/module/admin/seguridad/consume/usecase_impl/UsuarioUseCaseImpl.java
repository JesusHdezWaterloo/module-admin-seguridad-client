/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.module.admin.seguridad.consume.usecase_impl;

import com.root101.clean.core.app.usecase.DefaultCRUDUseCase;
import com.jhw.module.admin.seguridad.consume.module.SeguridadConsumeCoreModule;
import com.jhw.module.admin.seguridad.consume.repo_impl.*;
import com.jhw.module.admin.seguridad.consume.usecase_def.*;
import com.jhw.module.admin.seguridad.core.domain.*;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class UsuarioUseCaseImpl extends DefaultCRUDUseCase<UsuarioDomain> implements UsuarioUseCaseConsume {

    private final UsuarioRepoImpl repoUC = SeguridadConsumeCoreModule.getInstance().getImplementation(UsuarioRepoImpl.class);

    public UsuarioUseCaseImpl() {
        setRepo(repoUC);
    }

    @Override
    public UsuarioDomain loadUserByUsername(String username) throws Exception {
        return repoUC.loadUserByUsername(username);
    }

}
