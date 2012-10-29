package com.acme.presenter.web;

import com.acme.presenter.domain.Adress;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/adresses")
@Controller
@RooWebScaffold(path = "adresses", formBackingObject = Adress.class)
public class AdressController {
}
