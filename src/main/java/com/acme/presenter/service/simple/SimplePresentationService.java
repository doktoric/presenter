package com.acme.presenter.service.simple;

import com.acme.presenter.domain.FileType;
import com.acme.presenter.domain.Presentation;
import com.acme.presenter.service.PresentationService;

public class SimplePresentationService implements PresentationService {

    @Override
    public void save(Presentation presentation) {
        if (presentation != null) {
            presentation.persist();
        }
    }

    @Override
    public String export(FileType type, Presentation presentation) {
        
        FileConverter converter;
        if (type.equals(FileType.PDF)){
            converter = new PdfFileConverter();
            converter.convert();
        }
        
        return null;
    }

    @Override
    public void edit(Presentation presentation) {
        // TODO Auto-generated method stub

    }

    @Override
    public void importFile() {
        // TODO Auto-generated method stub

    }

    @Override
    public void create() {
        // TODO Auto-generated method stub

    }

}
