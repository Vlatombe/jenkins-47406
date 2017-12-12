package org.jenkinsci.plugins;

import static hudson.init.InitMilestone.JOB_LOADED;

import java.io.IOException;
import java.util.logging.Logger;

import hudson.init.Initializer;
import hudson.model.FreeStyleProject;
import jenkins.model.Jenkins;

public class JobAdder {
    private static final Logger LOGGER = Logger.getLogger(JobAdder.class.getName());

    @Initializer(after = JOB_LOADED)
    public void addJob() throws IOException {
        LOGGER.info("[JENKINS-47406] Adding job");
        Jenkins jenkins = Jenkins.getInstance();
        jenkins.createProject(FreeStyleProject.class, "JENKINS-47406");
        LOGGER.info("[JENKINS-47406] Added job");
    }
}
