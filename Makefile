quarkus:
	mvnd compile quarkus:dev -Dparallel=all -DperCoreThreadCount=false -DthreadCount=16 -T 1C -e
test:
	mvnd test -Dparallel=all -DperCoreThreadCount=false -DthreadCount=16 -T 1C -e
verify:
	mvnd clean verify -Dparallel=all -DperCoreThreadCount=false -DthreadCount=16 -T 1C -e
compile:
	mvnd compile -Dparallel=all -DperCoreThreadCount=false -DthreadCount=16 -T 1C -e
install:
	mvnd install -Dparallel=all -DperCoreThreadCount=false -DthreadCount=16 -T 1C -e

release:
	mvnd jreleaser:full-release -Dparallel=all -DperCoreThreadCount=false -DthreadCount=16 -T 1C -e

package:
	mvnd clean package -Dparallel=all -DperCoreThreadCount=false -DthreadCount=16 -T 1C -e