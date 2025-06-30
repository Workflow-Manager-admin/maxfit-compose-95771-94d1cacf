#!/bin/bash
cd /home/kavia/workspace/code-generation/maxfit-compose-95771-94d1cacf/android_jetpack_compose_ui
./gradlew lint
LINT_EXIT_CODE=$?
if [ $LINT_EXIT_CODE -ne 0 ]; then
   exit 1
fi

