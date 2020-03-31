FROM clojure:openjdk-8

LABEL maintainer="miguel@mcrx.me"

RUN mkdir /baoqu

COPY target/baoqu-landing-0.1.0-SNAPSHOT-standalone.jar /baoqu-landing.jar

WORKDIR /baoqu

CMD java -jar /baoqu-landing.jar
