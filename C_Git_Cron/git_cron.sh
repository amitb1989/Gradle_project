#!/bin/bash

# Define variables
REPO_URL="https://github.com/amitb1989/Gradle_project.git"  
CLONE_DIR="/tmp/repo_clone"
LOG_DIR="/home/user/git_logs"  # Change this to your preferred log directory
LOG_FILE="${LOG_DIR}/gitlog_$(date +'%d%m%Y')"

mkdir -p "$LOG_DIR"
git clone "$REPO_URL" "$CLONE_DIR" --quiet

cd "$CLONE_DIR" || exit

# Extract last 5 commit logs (Author and Modified Files)
git log -n 5 --pretty=format:"Author: %an%nFiles Modified:%n" --name-only | sed '/^$/d' > "$LOG_FILE"


rm -rf "$CLONE_DIR"
