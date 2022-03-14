/*
 * This Groovy source file was generated by the Gradle 'init' task.
 */
package com.gmail.arthurstrokov.plugin

import org.gradle.testfixtures.ProjectBuilder
import spock.lang.Specification

/**
 * A simple unit test for the 'com.gmail.arthurstrokov.plugin.greeting' plugin.*/
class TestGradleGitReleasePluginPluginTest extends Specification {
    def "plugin registers task"() {
        given:
        def project = ProjectBuilder.builder().build()

        when:
        project.plugins.apply("com.gmail.arthurstrokov.plugin.testGradleGitReleasePlugin")

        then:
        project.tasks.findByName("greeting") != null
    }
}
