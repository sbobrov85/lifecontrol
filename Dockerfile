FROM gitpod/workspace-full


ENV ANDROID_HOME=/home/gitpod/androidsdk \
# Get the latest version from https://developer.android.com/studio/index.html
    ANDROID_SDK_TOOLS_VERSION=4333796 \
    PATH=$ANDROID_HOME/tools/bin:$PATH

ENV ANDROID_SDK_HOME="$ANDROID_HOME"
ENV JAVA_HOME=/home/gitpod/.sdkman/candidates/java/current

USER gitpod

# Install Android SDK
RUN echo "Installing sdk tools ${ANDROID_SDK_TOOLS_VERSION}" && \
    wget --quiet --output-document=sdk-tools.zip \
        "https://dl.google.com/android/repository/sdk-tools-linux-${ANDROID_SDK_TOOLS_VERSION}.zip" && \
    mkdir --parents "$ANDROID_HOME" && \
    unzip -q sdk-tools.zip -d "$ANDROID_HOME" && \
    rm --force sdk-tools.zip

# Install SDKs
# Please keep these in descending order!
# The `yes` is for accepting all non-standard tool licenses.
RUN mkdir --parents "$ANDROID_HOME/.android/" && \
    echo '### User Sources for Android SDK Manager' > \
        "$ANDROID_HOME/.android/repositories.cfg" && \
    yes | "$ANDROID_HOME"/tools/bin/sdkmanager --licenses > /dev/null && \
    echo "Installing platforms" && \
    yes | "$ANDROID_HOME"/tools/bin/sdkmanager \
        "platforms;android-23" > /dev/null

RUN echo "Installing platform tools " && \
    yes | "$ANDROID_HOME"/tools/bin/sdkmanager \
        "platform-tools" > /dev/null
RUN echo "Installing build tools " && \
    yes | "$ANDROID_HOME"/tools/bin/sdkmanager \
        "build-tools;23.0.3" "build-tools;23.0.2" "build-tools;23.0.1" > /dev/null
RUN echo "Installing extras " && \
    yes | "$ANDROID_HOME"/tools/bin/sdkmanager \
        "extras;android;m2repository" \
        "extras;google;m2repository" > /dev/null
RUN echo "Installing play services " && \
    yes | "$ANDROID_HOME"/tools/bin/sdkmanager \
        "extras;google;google_play_services" \
        "extras;m2repository;com;android;support;constraint;constraint-layout;1.0.2" \
        "extras;m2repository;com;android;support;constraint;constraint-layout;1.0.1" > /dev/null
RUN echo "Installing Google APIs" && \
    yes | "$ANDROID_HOME"/tools/bin/sdkmanager \
        "add-ons;addon-google_apis-google-23" > /dev/null
