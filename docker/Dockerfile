FROM @from.image@ as builder
# First stage : Extract the layers

WORKDIR /@project.name@

ADD ./ /@project.name@

ARG JAR_FILE=*.jar
COPY ${JAR_FILE} app.jar

RUN java -Djarmode=layertools -jar app.jar extract

FROM @from.image@ as final

## Second stage : Copy the extracted layers

WORKDIR /@project.name@

VOLUME /tmp

COPY --from=builder @project.name@/dependencies/ ./
COPY --from=builder @project.name@/spring-boot-loader/ ./
COPY --from=builder @project.name@/snapshot-dependencies/ ./
COPY --from=builder @project.name@/application/ ./

ENV JAVA_OPTS=""
ENV SPRING_PROFILES_ACTIVE=""
ENV SPRING_RABBITMQ_ADDRESSES=""
ENV SPRING_CLOUD_CONFIG_SERVER_GIT_PASSWORD=""
ENV SPRING_CLOUD_CONFIG_SERVER_GIT_USERNAME=""
ENV LOKI_HOST="loki"

ENV TZ="America/Sao_Paulo"
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone
EXPOSE 8888

ENTRYPOINT ["java", "org.springframework.boot.loader.launch.JarLauncher" ,"--spring.profiles.active=${SPRING_PROFILES_ACTIVE}"]

