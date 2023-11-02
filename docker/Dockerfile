# Run Commands:
# NOTE: If any folder in your pathing has spaces, ensure you place quotes around the -v command. This goes for all OS's. For example:
# docker run --name assignment3 -v "C:\My Drive\<rest>:/assignment3" -it assignment3
# --- Docker ---
# --- Linux ---
# docker build -t assignment3:latest -f docker/Dockerfile .
# docker run --name assignment3 -v <location>:/assignment3 -it assignment3
# When coming back (the --name assigns a name to a container, so no need to do it again since you've already made the container)
# docker run -v <location>:assignment3 -it assignment3
# To clean up your system after you're done:
# docker system prune --all
# --- Windows ---
# docker build -t assignment3:latest -f Docker/Dockerfile .
# docker run --name assignment3 -v <drive>:<location>:/assignment3 -it assignment3
# When coming back (the --name assigns a name to a container, so no need to do it again since you've already made the container)
# docker run -v <drive>:<location>:/assignment3 -it assignment3
# To clean up your system after you're done:
# docker system prune --all
# --- Podman ---
# --- Linux ---
# podman build -t assignment3:latest -f docker/Dockerfile .
# podman run --name assignment3 -v <location>:/assignment3:z -it assignment3
# When coming back (the --name assigns a name to a container, so no need to do it again since you've already made the container)
# podman run -v <location>:/assignment3 -it assignment3
# To clean up your system after you're done:
# podman system prune --all
# --- Windows ---
# podman build -t assignment3:latest -f Docker/Dockerfile .
# podman run --name assignment3 -v <drive>:<location>:/assignment3 -it assignment3
# When coming back (the --name assigns a name to a container, so no need to do it again since you've already made the container)
# podman run -v <drive>:<location>:/assignment3 -it assignment3
# To clean up your system after you're done:
# podman system prune --all

# Specifies base image
FROM ubuntu:22.04

# Timezone config
ENV DEBIAN_FRONTEND=noninteractive 
ENV TZ=America/New_York
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && \
    echo $TZ > /etc/timezone

# Install Java tools
RUN apt-get update -y && \
    apt-get install -y wget maven gradle && \
    apt-get clean && \
    rm -rf /var/lib/apt/lists/*

# Install static version of openjdk
RUN wget https://download.oracle.com/java/21/latest/jdk-21_linux-x64_bin.tar.gz && \
    tar -xzvf jdk-21_linux-x64_bin.tar.gz && \
    mkdir -p /usr/lib/jvm && \
    mv jdk-21.0.1 /usr/lib/jvm/ && \
    update-alternatives --install "/usr/bin/java" "java" "/usr/lib/jvm/jdk-21.0.1/bin/java" 2 && \
    update-alternatives --install "/usr/bin/javac" "javac" "/usr/lib/jvm/jdk-21.0.1/bin/javac" 2 && \
    rm jdk-21_linux-x64_bin.tar.gz

# Set JAVA_HOME
ENV JAVA_HOME /usr/lib/jvm/jdk-21.0.1
ENV PATH=$JAVA_HOME/bin:$PATH

# Set the default working directory
WORKDIR /assignment3
