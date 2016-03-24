#!/bin/bash
curl "http://$1:$2@$3?path=/marketing-vk&update=true" --upload-file target/marketing-vk.war