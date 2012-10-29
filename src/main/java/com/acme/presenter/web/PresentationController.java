package com.acme.presenter.web;

import com.acme.presenter.domain.Presentation;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/presentations")
@Controller
@RooWebScaffold(path = "presentations", formBackingObject = Presentation.class)
public class PresentationController {
}
