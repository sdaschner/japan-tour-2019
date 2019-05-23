#!/bin/bash
set -euo pipefail

trap cleanup EXIT

function cleanup() {
  echo stopping Docker container...
  docker stop japan-tour &> /dev/null || true
  rm -Rf /tmp/wad-dropins/*
}

echo building project...
docker build -t japan-tour .
docker stop japan-tour &> /dev/null || true

mkdir -p /tmp/wad-dropins/

echo starting container...
docker run -d --rm \
  --name japan-tour \
  -p 9080:9080 \
  -p 9443:9443 \
  -v /tmp/wad-dropins/:/opt/wlp/usr/servers/defaultServer/dropins/ \
  japan-tour

wad.sh
