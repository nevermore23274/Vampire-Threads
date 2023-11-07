# Vampire-Threads
The initial thread will be called the main thread, the main thread creates and starts two worker threads. Then, each worker thread will work on its task while the main thread joins the two worker threads in the end and computes the final result.

## Podman Commands
### Build
```
podman build -t vamp:latest -f docker/Dockerfile .
```
### Run
```
podman run --name vamp -v /home/catdog/Documents/vamp:/vamp -it vamp
```
### Run Already Named Container (if you've ran the previous command once)
```
podman run -v vamp -v /home/catdog/Documents/vamp:/vamp -it vamp
```
### Cleanup
```
podman system prune -a
```
