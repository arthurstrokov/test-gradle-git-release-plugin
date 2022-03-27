package com.gmail.arthurstrokov.plugin.utils

import org.gradle.api.GradleScriptException

class GitUtil {

    public static final def MAJOR_BRANCH = "master"

    static def getGitVersion() {
        return ("git --version").execute().text
    }

    static def getGitStatusResult() {
        return ("git status").execute().text
    }

    static def getCurrentBranch() {
        return ("git branch --show-current").execute().text
    }

    static def getCurrentTagVersion() {
        def tags = ("git tag -l").execute().text
        if (tags.isEmpty()) {
            createTag("v0.0")
        }
        def tagsArray = tags.replace("v", "").split("\n")
        def floatTagsArray = []
        for (element in tagsArray) {
            floatTagsArray.add(Float.parseFloat(element))
        }
        def floatTagsArraySorted = floatTagsArray.collect { it as Float }.sort { it } // or -it for reverse
        def currentTagVersion = "v" + floatTagsArraySorted[floatTagsArraySorted.size() - 1]
        return currentTagVersion
    }

    public static final def getTags = ("git tag").execute().text

    static def createTag(String version) {
        def result = ("git tag -a $version -m \"Created\"").execute().text
        if (!result.isEmpty()) {
            throw new GradleScriptException("Tag was not created", null)
        }
    }

    static def getLastCommitLog() {
        return ("git log -1").execute().text
    }
}
