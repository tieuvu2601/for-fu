mvn install:install-file -DgroupId=com.oracle -DartifactId=ojdbc -Dversion=11.2.0.3.0 -Dpackaging=jar -Dfile=ojdbc6-11.2.0.3.jar -DgeneratePom=true
mvn install:install-file -DgroupId=org.springmodules -DartifactId=spring-modules-validation -Dversion=0.8 -Dpackaging=jar -Dfile=spring-modules-validation-0.8.jar -DgeneratePom=true
mvn install:install-file -DgroupId=taglibs -DartifactId=string -Dversion=1.1.0 -Dpackaging=jar -Dfile=string-1.1.0.jar -DgeneratePom=true
mvn install:install-file -Dfile=ojdbc6.jar -DgroupId=com.oracle -DartifactId=ojdbc6 -Dversion=11.2.0 -Dpackaging=jar