# test-gradle-git-release-plugin

Delete All local tags. (Optional Recommended)

    git tag -d $(git tag -l)

Fetch remote All tags. (Optional Recommended)

    git fetch

Delete All remote tags.

    git push origin --delete $(git tag -l) # Pushing once should be faster than multiple times

Delete All local tags.

    git tag -d $(git tag -l)

[![Codacy Badge](https://app.codacy.com/project/badge/Grade/b757ffad32634c4ebc15f247f08a8f92)](https://www.codacy.com/gh/arthurstrokov/test-gradle-git-release-plugin/dashboard?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=arthurstrokov/test-gradle-git-release-plugin&amp;utm_campaign=Badge_Grade)