package com.acme.presenter.service;

import com.acme.presenter.domain.FileType;
import com.acme.presenter.domain.Presentation;

public interface PresentationService {

    /**
     * Save the presentation file.
     */
    void save(Presentation presentation);
    /**
     * .
     * @param type
     * @return return file URL
     */
    String export(FileType type, Presentation presentation);
    
    void edit(Presentation presentation);
    
    void importFile();
    
    void create();
}
