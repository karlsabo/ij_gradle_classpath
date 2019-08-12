plugins {
    application
}

dependencies {
    implementation(project(":MainProject"))
}

application {
    mainClassName = "demo.app.App"
}
