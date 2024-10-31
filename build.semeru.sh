podman build -f Dockerfile.quarkus.semeru.base --cap-add=ALL --secret id=criu_secrets,src=.env -t pingperf-semeru-base .
podman build -f Dockerfile.quarkus.semeru --cap-add=ALL --security-opt seccomp=unconfined --cpuset-cpus 2 -m 1g -t pingperf-semeru-1cpu --no-cache .
podman build -f Dockerfile.quarkus.semeru --cap-add=ALL --security-opt seccomp=unconfined --cpuset-cpus 2-3 -m 1g -t pingperf-semeru-2cpu --no-cache .
podman build -f Dockerfile.quarkus.semeru --cap-add=ALL --security-opt seccomp=unconfined --cpuset-cpus 2-5 -m 1g -t pingperf-semeru-4cpu --no-cache .
