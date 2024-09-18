# We don't want to start from scratch.
# That is why we tell node here to use the openjdk image with java 12 as base.
FROM openjdk:17


# We use a varibale here as the port is something that can differ on the environment.
EXPOSE 9090

ADD build/libs/*.jar appdockerappi.jar

# Start the app
ENTRYPOINT [ "java", "-jar", "appdockerappi.jar" ]