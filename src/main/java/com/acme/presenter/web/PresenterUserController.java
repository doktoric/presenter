package com.acme.presenter.web;

import com.acme.presenter.domain.PresenterUser;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/presenterusers")
@Controller
@RooWebScaffold(path = "presenterusers", formBackingObject = PresenterUser.class)
public class PresenterUserController {
}
