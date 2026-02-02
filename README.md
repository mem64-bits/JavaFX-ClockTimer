# Clock Timer

A simple application using JavaFX and AlantaFX for styling,
made to serve the purpose for serving as a simple Stopwatch
with a button to switch functionality to a Timer.

<img width="604" height="497" alt="image" src="https://github.com/user-attachments/assets/62f7fb33-d37a-4df8-a71c-0cd3acae2067" />


## Build Instructions

The project can be easily built with
Apache Maven as a .jar, and using package
to package the app as an .exe, with an included jre.

#### Install Java

The project requires OpenJDK 25 Adoptium Termurin  
Install it from here [https://adoptium.net/en-GB](https://adoptium.net/en-GB)
Or install OpenJDK 25 with your systems recommended package manager.

#### Java 25 SDKMAN Install

For managing multiple JDKS existing on your system and for easy switch SDKMAN is recommended for UNIX (Linux, MacOS) and
WSL2 and MSYS2 for windows.
SDKMAN Official Install Guide: [https://sdkman.io/install/](https://sdkman.io/install/)

```bash
#Installing OpenJdk 25 with sdkman 
sdk install java tem-25
sdk use java tem-25
```

#### Install Maven (Optional)

You do not need to install Maven to run this project thanks to the maven wrappers that
automatically install an instance of Maven to the project folder if ran.

To install Maven on Windows, Mac, or Linux, use the appropriate package manager on your system, or manually download
Apache Maven and add the bin folder to the system PATH.
Maven install guide for Window Linux and
MacOS: [https://maven.apache.org/install.html](https://maven.apache.org/install.html)

(Wrapper Scripts are recommended for this project, replace script with `mvn` command, if using
system installed Maven.)

#### Maven SDKMAN

```bash
#Installing Maven with SDKMAN (optional)
sdk install maven
```

#### Running Build System

```bash
git clone 
cd ClockTimer
```

#### Jar Build (Windows Wrapper)

```bash 
.\mvnw.cmd clean package -P build-jar
```

#### JPackage Build (Windows Wrapper)

```bash
.\mvnw.cmd clean install -P build-jar,build-jpackage
```

#### Jar Build (Linux & MacOS Wrapper)

```bash 
./mvnw clean package -P build-jar
```

#### JPackage Build (Linux & MacOS Wrapper)

```bash
./mvnw clean install -P build-jar,build-jpackage
```


## Running Output 

The resulting build files can be found here:
- **JAR:** build/jar/ClockTimer.jar
- **Executable Folder:** build/jpackage/ClockTimer/
  
  
