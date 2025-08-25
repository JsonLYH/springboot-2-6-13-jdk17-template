FROM 10.10.10.13:8898/base-image/base-jdk8:1.0.0
COPY target/mebay_template.jar mebay_template.jar
ENV SW_AGENT_NAME "mebay-template"

ENTRYPOINT ["java","-javaagent:/home/skywalking-agent/skywalking-agent/skywalking-agent.jar","-jar","/mebay_template.jar","--spring.profiles.active=prod"," >mebay_template.log 2>&1 &"]