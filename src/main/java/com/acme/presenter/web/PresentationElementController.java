package com.acme.presenter.web;

import com.acme.presenter.domain.PresentationElement;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/presentationelements")
@Controller
@RooWebScaffold(path = "presentationelements", formBackingObject = PresentationElement.class)
public class PresentationElementController {
}
