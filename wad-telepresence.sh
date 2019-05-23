#!/bin/bash
set -euo pipefail

trap cleanup EXIT

function cleanup() {
  rm -Rf /tmp/wad-dropins/*
  [[ ${pid} ]] && kill -15 ${pid} &> /dev/null || true
}

docker build -t japan-tour .

mkdir -p /tmp/wad-dropins/

telepresence --swap-deployment japan-tour \
  --docker-run --rm \
  -p 9080:9080 \
  -p 9443:9443 \
  -v /tmp/wad-dropins/:/opt/wlp/usr/servers/defaultServer/dropins/ \
  japan-tour &

pid=$!

wad.sh
