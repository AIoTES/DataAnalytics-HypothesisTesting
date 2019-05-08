package eu.activage.services.cucumber.stepdefs;

import eu.activage.services.SimlifeApp;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.ResultActions;

import org.springframework.boot.test.context.SpringBootTest;

@WebAppConfiguration
@SpringBootTest
@ContextConfiguration(classes = SimlifeApp.class)
public abstract class StepDefs {

    protected ResultActions actions;

}
