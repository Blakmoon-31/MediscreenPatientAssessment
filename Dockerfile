FROM openjdk:11-jdk
COPY target/mediscreenPatientAssessment-0.0.1-SNAPSHOT.jar mediscreenPatientAssessment-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/mediscreenPatientAssessment-0.0.1-SNAPSHOT.jar"]