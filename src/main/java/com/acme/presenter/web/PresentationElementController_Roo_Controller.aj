// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.acme.presenter.web;

import com.acme.presenter.domain.ElementType;
import com.acme.presenter.domain.PresentationElement;
import com.acme.presenter.web.PresentationElementController;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriUtils;
import org.springframework.web.util.WebUtils;

privileged aspect PresentationElementController_Roo_Controller {
    
    @RequestMapping(method = RequestMethod.POST, produces = "text/html")
    public String PresentationElementController.create(@Valid PresentationElement presentationElement, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, presentationElement);
            return "presentationelements/create";
        }
        uiModel.asMap().clear();
        presentationElement.persist();
        return "redirect:/presentationelements/" + encodeUrlPathSegment(presentationElement.getId().toString(), httpServletRequest);
    }
    
    @RequestMapping(params = "form", produces = "text/html")
    public String PresentationElementController.createForm(Model uiModel) {
        populateEditForm(uiModel, new PresentationElement());
        return "presentationelements/create";
    }
    
    @RequestMapping(value = "/{id}", produces = "text/html")
    public String PresentationElementController.show(@PathVariable("id") Long id, Model uiModel) {
        uiModel.addAttribute("presentationelement", PresentationElement.findPresentationElement(id));
        uiModel.addAttribute("itemId", id);
        return "presentationelements/show";
    }
    
    @RequestMapping(produces = "text/html")
    public String PresentationElementController.list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("presentationelements", PresentationElement.findPresentationElementEntries(firstResult, sizeNo));
            float nrOfPages = (float) PresentationElement.countPresentationElements() / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("presentationelements", PresentationElement.findAllPresentationElements());
        }
        return "presentationelements/list";
    }
    
    @RequestMapping(method = RequestMethod.PUT, produces = "text/html")
    public String PresentationElementController.update(@Valid PresentationElement presentationElement, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, presentationElement);
            return "presentationelements/update";
        }
        uiModel.asMap().clear();
        presentationElement.merge();
        return "redirect:/presentationelements/" + encodeUrlPathSegment(presentationElement.getId().toString(), httpServletRequest);
    }
    
    @RequestMapping(value = "/{id}", params = "form", produces = "text/html")
    public String PresentationElementController.updateForm(@PathVariable("id") Long id, Model uiModel) {
        populateEditForm(uiModel, PresentationElement.findPresentationElement(id));
        return "presentationelements/update";
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/html")
    public String PresentationElementController.delete(@PathVariable("id") Long id, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        PresentationElement presentationElement = PresentationElement.findPresentationElement(id);
        presentationElement.remove();
        uiModel.asMap().clear();
        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
        return "redirect:/presentationelements";
    }
    
    void PresentationElementController.populateEditForm(Model uiModel, PresentationElement presentationElement) {
        uiModel.addAttribute("presentationElement", presentationElement);
        uiModel.addAttribute("elementtypes", Arrays.asList(ElementType.values()));
    }
    
    String PresentationElementController.encodeUrlPathSegment(String pathSegment, HttpServletRequest httpServletRequest) {
        String enc = httpServletRequest.getCharacterEncoding();
        if (enc == null) {
            enc = WebUtils.DEFAULT_CHARACTER_ENCODING;
        }
        try {
            pathSegment = UriUtils.encodePathSegment(pathSegment, enc);
        } catch (UnsupportedEncodingException uee) {}
        return pathSegment;
    }
    
}
