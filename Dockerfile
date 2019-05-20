FROM sdaschner/open-liberty:javaee8-jdk12-b1

COPY src/main/liberty/server.xml $CONFIG_DIR

COPY target/japan-tour.war $DEPLOYMENT_DIR
