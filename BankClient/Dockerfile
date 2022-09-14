FROM openjdk:11
ADD target/BankClient-0.0.1-SNAPSHOT.jar bankclient.jar
EXPOSE 8089
ENTRYPOINT ["java","-jar","bankclient.jar"]