buildscript {
    repositories {
        google()
        jcenter()
    }
    dependencies {
        classpath(buildsrc.Depends.ClassPaths.gradle)
        classpath(
            kotlin(
                buildsrc.Depends.ClassPaths.kotlin_gradle_plugin,
                version =buildsrc.Depends.Versions.kotlinVersion
            )
        )
    }
}

allprojects {
    repositories {
        google()
        jcenter()

    }
}

task<Delete>("clean") {
    delete(rootProject.buildDir)
}
