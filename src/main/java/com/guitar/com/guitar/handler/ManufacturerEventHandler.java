package com.guitar.com.guitar.handler;

import com.guitar.model.Manufacturer;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

@Component
@RepositoryEventHandler(Manufacturer.class)
public class ManufacturerEventHandler {

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @HandleBeforeCreate
    public void handlerBeforeCreate(Manufacturer m) {
        // do a check to see if new Manufacturer has valid fields values

        // only allows to create new Manufacturers to be created in the active state
        if(!m.getActive()){
            throw new IllegalArgumentException("New Manufacturers must be 'active'");
        }
    }
}
