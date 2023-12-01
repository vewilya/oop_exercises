# Java Projekt-Template fuer OOP/PLAB, AD, VSK, SWDA und DEVOPS

## Zweck
Dieses Projekt dient in den Modulen OOP/PLAB, AD, VSK, SWDA und DEVOPS als 
Vorlage fuer Java-Projekte. Es nutzt einen auf 
[Apache Maven](https://maven.apache.org/) basierenden (und somit IDE-unabhaengigen)
Build und definiert die dafuer notwendige, standardisierte Verzeichnisstruktur.

## Verwendung
Die Demoprojekte werden laufend ergänzt und anhand der wöchtnlichen Inputs im Unterricht OOP weiter ausgearbeitet. Ziel ist es Mini-Projekte wie Temperature, Car, etc.bis Ende des Semesters in einer soliden Form zu haben, mit integrierten Unit-Tests und dergleichen.

## Enthaltene Libraries (Dependencies)
* Simple Logging Facade (SLF4J) - https://www.slf4j.org/
* LogBack - https://logback.qos.ch/ (Default)
* Log4J Framework - https://logging.apache.org/log4j/2.x/ (alternativ)

## Enthaltene Test-Libraries (Test Dependencies)
* AssertJ - https://assertj.github.io/doc/
* EqualsVerifier - https://jqno.nl/equalsverifier/
* Console Captor - https://github.com/Hakky54/console-captor
* JUnit 5 - https://junit.org/junit5/
* JUnit Pioneer - https://junit-pioneer.org/

## Integrierte Analysewerkzeuge (Code Qualitaet)
* Checkstyle - https://checkstyle.sourceforge.io/
* PMD - https://pmd.github.io/
* JaCoCo - https://www.eclemma.org/jacoco/
* Spotbugs - https://spotbugs.github.io/

## Weitere Integrationen (benoetigen ggf. Konfiguration/Account)
* [AsciiDoctor-Plugin](https://asciidoctor.org/) fuer [AsciiDoc](https://asciidoc.org/)
* Deployment in Package Repository (Maven Repo) von http://gitlab.com vorbereitet
* Dockerfile fuer Bau eines [Docker-Images](https://www.docker.com/)
* [Fabric/Docker-Plugin](https://dmp.fabric8.io/) fuer Build und Deploy auf [DockerHub](https://hub.docker.com/)
* [GitLab CI/CD](https://docs.gitlab.com/ee/ci/) (.gitlab-ci.yml) inkl. Coverageauswertung fuer Java.
* [JIB-Plugin](https://github.com/GoogleContainerTools/jib/tree/master/jib-maven-plugin) (Google) fuer Build und Deploy auf DockerHub (alternative).

Feedback und Fehlermeldungen zum Template: roland.gisler@hslu.ch <br/>
Probleme und Fragen bei Code-Beispielen: urs.bollhalder@stud.hslu.ch
