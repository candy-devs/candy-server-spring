# Candy Server (using Spring)

## 계획

```
 - 조회, 생성&업데이트 프로젝트 분리
 - Article 엔티티의 조회수,북마크 수 증감 부하가 큼으로 캐시노드로 분리해야함
    (조회를 따로 만들면 캐시 미스시에만 db조회 나머지는 그냥 디비 조회,
     조회가 백엔드에 미치는 영향을 최소화하자)
 - Github Actions 코드부분 커밋아니면 안돌아가게 설정
```

## 개발 방법

```
 - Clean Code: 최대한 유지보수하기 쉬운 코드로 작성
 - Logging: 추적 가능한 오류 생성
 - DDD: 추후 MSA 채택 등 코드 분리의 용이함을 위함
 - No Throw: 불필요한 객채 생성을 막아 CPU를 덜 갈굴 수 있음 
```

## 배포 관련

```
 - 테스트 서버가 작아서 bootBuildImage 이미지를 못 돌림
```

## Spring 부가 내용들

### JVM

```
 - GC Logging 필요한가? 더 정확히는 GC Log 분석이 필요할까?
   - 일단 트래픽이 커지면 Scale Out 방식으로 서버를 늘리자
 - APM을 언제 사용해야할까?
```

#### GraalVM?

```
 - SubstracteVM으로 AOT 빌드 가능
   - Monolithic Arch에선 일단 JIT이 더 낫다고 생각
     - G1GC보다 낮은 성능의 GC
     - JIT의 HotSpot Optimization 이점이 사라짐     
```

### Security

```
 - Session과 Token 기반 인증을 조화롭게 설정하는 방법은 무엇인가
```

### JPA

```
 - Prefetch나 Fetch/Inner Join, QueryDSL으로 N+1문제 해결
 - Presentation Layer 건드려서 Proxy Object 참조들 한 번에 가져오기
   - 이렇게까지 해야할 필요가 있는가? 프로젝트의 복잡성 증대, 유지보수 불편할 것 같다고 생각
 - Read가 압도적으로 많은 상황을 가정하면 Spring Backend를 통해 DB를 조회하는게 합당한가?
   - JPA Persistence Context, 2차 캐시 고갈 문제
```
