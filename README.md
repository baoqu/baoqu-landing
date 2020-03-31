# baoqu-landing

This is the landing page of the Baoqu project

## Run the development environment

Clone the repository and inside its folder, run this to start watching the `ClojureScript` code:

```sh
make start-front
```

and this to run the server:

```sh
make start-back
```

go to http://localhost:3030

## Create the standalone jar

To build the standalone jar, just run:

```sh
make uberjar
```

The output file will be located in the `target` directory.

## Generate the docker image

```sh
make docker
```
