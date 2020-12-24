package com.jhw.module.admin.seguridad.consume.module;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import com.jhw.module.admin.seguridad.consume.repo_impl.*;
import com.jhw.module.admin.seguridad.consume.usecase_def.*;
import com.jhw.module.admin.seguridad.core.usecase_def.*;

/**
 * Configuracion del injection del modulo de Seguridad-consume-core.
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class SeguridadConsumeCoreInjectionConfig extends AbstractModule {

    @Override
    protected void configure() {
        bind(RolUseCase.class).to(RolRepoImpl.class).in(Singleton.class);
        bind(RolUseCaseConsume.class).to(RolRepoImpl.class).in(Singleton.class);
        
        bind(UsuarioUseCase.class).to(UsuarioRepoImpl.class).in(Singleton.class);
        bind(UsuarioUseCaseConsume.class).to(UsuarioRepoImpl.class).in(Singleton.class);
    }

}
