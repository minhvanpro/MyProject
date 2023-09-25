# Use a suitable OpenJDK base image
FROM eclipse-temurin:17-jre-alpine
COPY ./out/artifacts/news_jar/ .
CMD ["java", "-jar", "news.jar"]
EXPOSE 8080