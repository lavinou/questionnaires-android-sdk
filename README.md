[![](https://jitpack.io/v/lavinou/questionnaires-android-sdk.svg)](https://jitpack.io/#lavinou/questionnaires-android-sdk)
---
# [Lavinou Questionnaire SDK](https://questionnaire.lavinou.com)
---
## Introduction
Welcome to the Questionnaire SDK repository. Here you will learn how to use the Questionnaire
SDK for Android Applications.

## Getting Started
To start first lets make sure we have access to the repository. Add the [jitpack.io](https://jtpack.io)
url to maven
```groovy
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        ...
        maven { url = uri("https://jitpack.io") }
    }
}
```
Once that is setup next, add the [latest](https://github.com/lavinou/questionnaires-android-sdk/tags) 
questionnaire dependency to your application:
```groovy
dependencies {
    ...
    implementation("com.github.lavinou:questionnaires-android-sdk:<version>")
    ...
}
```

## Project Key
Once android gradle file is setup and you have access to the questionnaire sdk, a project api key
is required to access your questionnaires. To create the project key go to your [projects](https://questionnaire.lavinou.com/console/projects/),
select the project you would like to have an api key for and click on the **+ API KEY** button. Copy the key
and add it to the Questionnaire Builder:
```kotlin
val questionnaire = Questionnaire
            .Builder(activity = this, apiKey = "<project-api-key>")
            .build()
```