# Vampire-Threads
The initial thread will be called the main thread, the main thread creates and starts two worker threads. Then, each worker thread will work on its task while the main thread joins the two worker threads in the end and computes the final result.

## Podman Commands
### Build
```
podman build -t assignment3:latest -f docker/Dockerfile .
```
### Run
```
podman run --name assignment3 -v /home/sineyed/Documents/assignment:/assignment3 -it assignment3
```
### Run Already Named Container (if you've ran the previous command once)
```
podman run -v assignment3 -v /home/sineyed/Documents/assignment:/assignment3 -it assignment3
```
### Cleanup
```
podman system prune -a
```
