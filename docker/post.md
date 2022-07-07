## 도커 network 설정

```
docker network create redis-net
```

## 도커 redis 서버 실행

```
docker run --name redis \
-p 6379:6379 \
--network redis-net \
--appendonly yea
```

## redis 컨테이너 접속

```
docker run -it --network redis-net --rm redis:latest redis-cli -h redis
```

## network ip 확인

```
docker network inspect redis-net
```

```
docker run -it --network redis-net --rm redis:latest ash
```

```
redis-cli -h redis
```