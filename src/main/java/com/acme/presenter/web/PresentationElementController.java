package com.acme.presenter.web;

import com.acme.presenter.domain.Component;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/presentationelements")
@Controller
@RooWebScaffold(path = "presentationelements", formBackingObject = Component.class)
public class PresentationElementController {
}
