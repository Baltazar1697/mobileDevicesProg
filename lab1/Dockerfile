FROM zenika/kotlin:latest
WORKDIR /app
COPY . .
RUN kotlinc ./ -include-runtime -d ./app.jar
CMD [ "java", "-jar", "/app/app.jar"]