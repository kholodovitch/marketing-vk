#!/bin/bash
curl "http://$1:$2@$3?path=/david&update=true" --upload-file target/david.war 