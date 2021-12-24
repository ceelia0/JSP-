#!/usr/bin/env bash
git add .
git commit -m 'update'
eval `ssh-agent`
ssh-add /home/ceelia/.ssh/github_id_rsa
git push -u origin main
