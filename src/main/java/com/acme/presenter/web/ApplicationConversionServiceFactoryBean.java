package com.acme.presenter.web;

import com.acme.presenter.domain.Adress;
import com.acme.presenter.domain.Component;
import com.acme.presenter.domain.Presentation;
import com.acme.presenter.domain.PresenterUser;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.support.FormattingConversionServiceFactoryBean;
import org.springframework.roo.addon.web.mvc.controller.converter.RooConversionService;

@Configurable
/**
 * A central place to register application converters and formatters. 
 */
@RooConversionService
public class ApplicationConversionServiceFactoryBean extends FormattingConversionServiceFactoryBean {

	@Override
	protected void installFormatters(FormatterRegistry registry) {
		super.installFormatters(registry);
		// Register application converters and formatters
	}

	public Converter<Adress, String> getAdressToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.acme.presenter.domain.Adress, java.lang.String>() {
            public String convert(Adress adress) {
                return new StringBuilder().append(adress.getCity()).append(" ").append(adress.getStreet()).append(" ").append(adress.getHouse()).toString();
            }
        };
    }

	public Converter<Long, Adress> getIdToAdressConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.acme.presenter.domain.Adress>() {
            public com.acme.presenter.domain.Adress convert(java.lang.Long id) {
                return Adress.findAdress(id);
            }
        };
    }

	public Converter<String, Adress> getStringToAdressConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.acme.presenter.domain.Adress>() {
            public com.acme.presenter.domain.Adress convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), Adress.class);
            }
        };
    }

	public Converter<Component, String> getComponentToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.acme.presenter.domain.Component, java.lang.String>() {
            public String convert(Component component) {
                return new StringBuilder().toString();
            }
        };
    }

	public Converter<Long, Component> getIdToComponentConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.acme.presenter.domain.Component>() {
            public com.acme.presenter.domain.Component convert(java.lang.Long id) {
                return Component.findComponent(id);
            }
        };
    }

	public Converter<String, Component> getStringToComponentConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.acme.presenter.domain.Component>() {
            public com.acme.presenter.domain.Component convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), Component.class);
            }
        };
    }

	public Converter<Presentation, String> getPresentationToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.acme.presenter.domain.Presentation, java.lang.String>() {
            public String convert(Presentation presentation) {
                return new StringBuilder().append(presentation.getName()).toString();
            }
        };
    }

	public Converter<Long, Presentation> getIdToPresentationConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.acme.presenter.domain.Presentation>() {
            public com.acme.presenter.domain.Presentation convert(java.lang.Long id) {
                return Presentation.findPresentation(id);
            }
        };
    }

	public Converter<String, Presentation> getStringToPresentationConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.acme.presenter.domain.Presentation>() {
            public com.acme.presenter.domain.Presentation convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), Presentation.class);
            }
        };
    }

	public Converter<PresenterUser, String> getPresenterUserToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.acme.presenter.domain.PresenterUser, java.lang.String>() {
            public String convert(PresenterUser presenterUser) {
                return new StringBuilder().append(presenterUser.getFirstName()).append(" ").append(presenterUser.getLastName()).append(" ").append(presenterUser.getUserName()).append(" ").append(presenterUser.getEmail()).toString();
            }
        };
    }

	public Converter<Long, PresenterUser> getIdToPresenterUserConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.acme.presenter.domain.PresenterUser>() {
            public com.acme.presenter.domain.PresenterUser convert(java.lang.Long id) {
                return PresenterUser.findPresenterUser(id);
            }
        };
    }

	public Converter<String, PresenterUser> getStringToPresenterUserConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.acme.presenter.domain.PresenterUser>() {
            public com.acme.presenter.domain.PresenterUser convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), PresenterUser.class);
            }
        };
    }

	public void installLabelConverters(FormatterRegistry registry) {
        registry.addConverter(getAdressToStringConverter());
        registry.addConverter(getIdToAdressConverter());
        registry.addConverter(getStringToAdressConverter());
        registry.addConverter(getComponentToStringConverter());
        registry.addConverter(getIdToComponentConverter());
        registry.addConverter(getStringToComponentConverter());
        registry.addConverter(getPresentationToStringConverter());
        registry.addConverter(getIdToPresentationConverter());
        registry.addConverter(getStringToPresentationConverter());
        registry.addConverter(getPresenterUserToStringConverter());
        registry.addConverter(getIdToPresenterUserConverter());
        registry.addConverter(getStringToPresenterUserConverter());
    }

	public void afterPropertiesSet() {
        super.afterPropertiesSet();
        installLabelConverters(getObject());
    }
}
