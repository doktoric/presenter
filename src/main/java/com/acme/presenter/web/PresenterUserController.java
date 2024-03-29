package com.acme.presenter.web;

import com.acme.presenter.domain.Adress;
import com.acme.presenter.domain.PresenterUser;
import com.acme.presenter.domain.Roles;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.joda.time.format.DateTimeFormat;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriUtils;
import org.springframework.web.util.WebUtils;

@RequestMapping("/presenterusers")
@Controller
@RooWebScaffold(path = "presenterusers", formBackingObject = PresenterUser.class)
public class PresenterUserController {

	@RequestMapping(method = RequestMethod.POST, produces = "text/html")
    public String create(@Valid PresenterUser presenterUser, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, presenterUser);
            return "presenterusers/create";
        }
        uiModel.asMap().clear();
        presenterUser.persist();
        return "redirect:/presenterusers/" + encodeUrlPathSegment(presenterUser.getId().toString(), httpServletRequest);
    }

	@RequestMapping(params = "form", produces = "text/html")
    public String createForm(Model uiModel) {
        populateEditForm(uiModel, new PresenterUser());
        return "presenterusers/create";
    }

	@RequestMapping(value = "/{id}", produces = "text/html")
    public String show(@PathVariable("id") Long id, Model uiModel) {
        addDateTimeFormatPatterns(uiModel);
        uiModel.addAttribute("presenteruser", PresenterUser.findPresenterUser(id));
        uiModel.addAttribute("itemId", id);
        return "presenterusers/show";
    }

	@RequestMapping(produces = "text/html")
    public String list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("presenterusers", PresenterUser.findPresenterUserEntries(firstResult, sizeNo));
            float nrOfPages = (float) PresenterUser.countPresenterUsers() / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("presenterusers", PresenterUser.findAllPresenterUsers());
        }
        addDateTimeFormatPatterns(uiModel);
        return "presenterusers/list";
    }

	@RequestMapping(method = RequestMethod.PUT, produces = "text/html")
    public String update(@Valid PresenterUser presenterUser, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, presenterUser);
            return "presenterusers/update";
        }
        uiModel.asMap().clear();
        presenterUser.merge();
        return "redirect:/presenterusers/" + encodeUrlPathSegment(presenterUser.getId().toString(), httpServletRequest);
    }

	@RequestMapping(value = "/{id}", params = "form", produces = "text/html")
    public String updateForm(@PathVariable("id") Long id, Model uiModel) {
        populateEditForm(uiModel, PresenterUser.findPresenterUser(id));
        return "presenterusers/update";
    }

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/html")
    public String delete(@PathVariable("id") Long id, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        PresenterUser presenterUser = PresenterUser.findPresenterUser(id);
        presenterUser.remove();
        uiModel.asMap().clear();
        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
        return "redirect:/presenterusers";
    }

	void addDateTimeFormatPatterns(Model uiModel) {
        uiModel.addAttribute("presenterUser_birthdate_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
    }

	void populateEditForm(Model uiModel, PresenterUser presenterUser) {
        uiModel.addAttribute("presenterUser", presenterUser);
        addDateTimeFormatPatterns(uiModel);
        uiModel.addAttribute("adresses", Adress.findAllAdresses());
        uiModel.addAttribute("roleses", Arrays.asList(Roles.values()));
    }

	String encodeUrlPathSegment(String pathSegment, HttpServletRequest httpServletRequest) {
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
