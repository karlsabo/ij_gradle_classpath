Example output from Gradle application run:
```text
> Task :ResourceProject:run
Classpath=C:\Users\ksabo\git\ij_gradle_classpath\ResourceProject\build\classes\java\main;C:\Users\ksabo\git\ij_gradle_classpath\ResourceProject\build\resources\main;C:\Users\ksabo\git\ij_gradle_classpath\MainProject\build\libs\MainProject.jar
Everything ran a-ok!
```

IntelliJ version:
```text
IntelliJ IDEA 2019.2 (Ultimate Edition)
Build #IU-192.5728.98, built on July 22, 2019
Licensed to ********
Subscription is active until December 6, 2019
Runtime version: 11.0.3+12-b304.10 amd64
VM: OpenJDK 64-Bit Server VM by JetBrains s.r.o
Windows 10 10.0
GC: ParNew, ConcurrentMarkSweep
Memory: 1981M
Cores: 8
Registry: git.explicit.commit.renames.prohibit.multiple.calls=false
Non-Bundled Plugins: 
```

If you create an IntelliJ run configuration with demo.app.App as the "Main class:" then the classpath is not set correctly when "Use classpath of module" is set to ResourceProject.main. See runConfigurations/App.xml:
```text
> Task :MainProject:App.main() FAILED
Classpath=C:\Users\ksabo\git\ij_gradle_classpath\MainProject\build\classes\java\main;C:\Users\ksabo\git\ij_gradle_classpath\MainProject\build\resources\main
Exception in thread "main" java.lang.RuntimeException: Couldn't find resource hello.txt
	at demo.app.App.main(App.java:11)
```

It is expected that it's classpath would be:
```text
Classpath=C:\Users\ksabo\git\ij_gradle_classpath\ResourceProject\build\classes\java\main;C:\Users\ksabo\git\ij_gradle_classpath\ResourceProject\build\resources\main;C:\Users\ksabo\git\ij_gradle_classpath\MainProject\build\libs\MainProject.jar
```

If you duplicate the run configuration and set the main class to AppWrapper then the classpath is correct:

```text
> Task :ResourceProject:AppWrapper.main()
Classpath=C:\Users\ksabo\git\ij_gradle_classpath\ResourceProject\build\classes\java\main;C:\Users\ksabo\git\ij_gradle_classpath\ResourceProject\build\resources\main;C:\Users\ksabo\git\ij_gradle_classpath\MainProject\build\libs\MainProject.jar
Everything ran a-ok!

BUILD SUCCESSFUL in 465ms
```