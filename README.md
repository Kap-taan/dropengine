# DocDrop Engine

Backend for docdrop app

## Prerequisites

This project is based on OpenJDK 17.

Ensure you have Docker installed on your system. Follow the instructions for your operating system:

- [Windows](https://docs.docker.com/desktop/install/windows-install/)
- [Linux](https://docs.docker.com/engine/install/ubuntu/)
- [Mac](https://docs.docker.com/desktop/install/mac-install/)

## Initial Commands

To get started, run the following commands:

##### After running the below command, configure the .env as per your system

```zsh
cp .env.example .env
```
##### This command will spin up a docker container

```zsh
docker compose up
```

This command will:

- Spin up a PostgreSQL database.
- Create a container with OpenJDK 17 as the base image, including our project.
- It will auto refresh on any changes in the project files
