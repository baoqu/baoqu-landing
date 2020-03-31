start-front:
	lein cljsbuild auto

start-back:
	lein ring server

clean:
	rm -rf target

uberjar: clean
	lein ring uberjar

docker: uberjar
	docker build -t baoqu-landing .
