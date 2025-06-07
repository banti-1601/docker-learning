# Use Eclipse Temurin JDK 24 as base image
FROM eclipse-temurin:24

# Set environment variables for Maven
ENV MAVEN_VERSION=3.9.10 \
    MAVEN_HOME=/opt/maven

# Install Maven
RUN apt-get update && apt-get install -y curl unzip && \
    curl -fsSL https://downloads.apache.org/maven/maven-3/${MAVEN_VERSION}/binaries/apache-maven-${MAVEN_VERSION}-bin.zip -o /tmp/maven.zip && \
    unzip /tmp/maven.zip -d /opt && \
    mv /opt/apache-maven-${MAVEN_VERSION} ${MAVEN_HOME} && \
    ln -s ${MAVEN_HOME}/bin/mvn /usr/bin/mvn && \
    rm -rf /var/lib/apt/lists/* /tmp/maven.zip

# Define working directory
WORKDIR /app

# Copy source code
COPY . .

# Optional: show files copied
RUN ls -la

# Build the jar (skip tests)
RUN mvn clean install -DskipTests

# Expose port
EXPOSE 8082

# Run the jar
CMD ["java", "-jar", "/app/target/cicd-demo-0.0.1-SNAPSHOT.jar"]
