package com.gmail.arthurstrokov.plugin.tasks

import com.gmail.arthurstrokov.plugin.service.GitTagVersionService
import com.gmail.arthurstrokov.plugin.service.GitCommandService
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

class MinorReleaseTask extends DefaultTask {

    @TaskAction
    def createMinorRelease() {
        def currentTagVersion = GitTagVersionService.gitTagVersion()
        def tagVersionDetail = currentTagVersion.split('\\.')
        def updateMinorTagVersion = Integer.parseInt(tagVersionDetail[1]) + 1
        def newTagVersion = String.join(".", tagVersionDetail[0], updateMinorTagVersion as String)
        println("new tag version $newTagVersion")
        GitCommandService.createTag(newTagVersion)
        ("git push origin $newTagVersion").execute()
    }
}
