plugins {
    `java-library`
    id("net.tetratau.tokimak.userdev") version "0.1.1-SNAPSHOT"
}

group = "io.papermc.paperweight"
version = "1.0.0-SNAPSHOT"
description = "Test plugin for paperweight-userdev"

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(17))
}

repositories {
    maven("https://maven.fabricmc.net/")
    maven("https://mvn.tetratau.net/releases/")
}

dependencies {
    paperweight.paperDevBundle("1.19.4-R0.1-SNAPSHOT")
    api("net.fabricmc:fabric-loader:0.14.19")
    api("net.fabricmc:sponge-mixin:0.12.4+mixin.0.8.5") {
        exclude(module = "launchwrapper")
        exclude(module = "guava")
    }
}

tasks {
    assemble {
        dependsOn(reobfJar)
    }

    compileJava {
        options.encoding = Charsets.UTF_8.name()

        options.release.set(17)
    }
    javadoc {
        options.encoding = Charsets.UTF_8.name()
    }
    processResources {
        filteringCharset = Charsets.UTF_8.name()
    }
}
