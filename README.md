# baoqu-landing

This is the landing page of the Baoqu project

## Run the development environment

Clone the repository and inside its folder, run this to start watching the `ClojureScript` code:

```sh
lein cljsbuild auto
```

and this to run the server:

```sh
lein ring server
```

go to http://localhost:3030

## Create the standalone jar

To build the standalone jar, just run:

```sh
lein ring uberjar
```

The output file will be located in the `target` directory.
