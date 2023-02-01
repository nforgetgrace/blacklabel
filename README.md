
# [개요]
현재 국내 대기업 IT회사에서 SI개발(대외사업)을 담당하고 있어서 기본적인 프로젝트 세트가 필요하기도 하였고,
흐트러진 지식들을 조금이나마 정리하는 차원에서 해당 레파지토리를 생성하게되었다.
프로젝트 현장에서 "필요한 것들", "과거에 유용했던 것들"을 참고하여 개발했다.
그저 copy & paste를 하는 것은 용납할 수 없기에 이해하고자 한다.
copy & paste도 알아야 가능한 것이지만, 이번 기회를 통해서 생각이 재정리가 된 것들도 있었다.
아래 기재된 기능을 구현할 것이고, 기본적인 API서버의 아주 기본적인 구색을 갖출 예정이다.
자! 시작이다 꾹스!

<br />

### 작업환경
IntelliJ
Spring-boot
Java 11(Zulu)
Gradle
H2(TBD)
<br />
<br />
### Spec
* AOP(Logging) 
* logback
* slf4j MDC(Mapped Diagnostic Context) 쓰레드 별 로그 분리
* 공통예외처리 (GlobalException 런타임 익셉션 처리) - 보완
* 필터 (Filter)
* 커스컴 오브젝트 매퍼
* 공통응답 정의(RestControllerAdvice 사용)
* 외부연동 RestTemplate Config (버퍼링) 를 사용하여 로깅처리 - TODO
* RestTemplate (RestTemplate & Configuration) - TODO
* WebClient - TODO
* 외부 OMDB API (영화검색 API) - TODO
* 이력 DB 저장 기능
* H2 인메모리 DB 셋업
* DB연동 Mabatis(Jpa[QueryDsl]는 다른 레포지토리에서 작업할 예정) - TODO
* 비지니스 로직에서의 에러처리 - TODO
* 권한(Spring Security) - TODO
* MOCK - TODO
  <br />
  <br />

# [시작하기]
### 프로젝트 생성
해당프로젝트는 [스프링공식](https://start.spring.io/) 사이트에서 생성이 가능하다.
현재 로컬 IDE 환경이 인텔리제이고, 사이트에서 프로젝트 생성 후 Import 하였다.
초기에 Spring Boot버전과 Gradle 버전이 상이한 부분이 있었다. build.gradle 참고

<br />
<br />

# [지향점]
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />

# [지양점]
### Lombok - @Data
* @ToString, @Getter, @Setter, @EqualsAndHashCode, 
@RequiredArgsConstructor을 하나로 사용이 가능한 막강한 어노테이션이다.
그러므로 무분별한 Setter 남용을 불러일으킬 수 있고, 그런 남용은 의도가 분명하지 않고 객체의 상태를 
언제든 변경할 수 있기 때문에 객체의 안전성을 보장받기 힘들다.
<br />
<br />
<br />
# [참고]
#### -콘솔 컬러
Configuration창에서 인자로 VM Options에서 -Dspring.output.ansi.enabled=ALWAYS 를 추가해주면 콘솔 
텍스들이 컬러가 먹여지는 것을 확인 할 수 있다.
인텔리제이를 처음에 설치했을때 자신에 맞는 설정들이 필요하다. Code Assistant, 자동저장기능, 코드수정 시 자동서버 재기동 등등...
<br />
<br />
#### -공통예외 및 응답처리
@RestControllerAdvice <br />
@ControllerAdvice <br />
@Exceptionhandler
<br />
<br />

#### -WebClient || RestTemplate
WebClient는 RestTemplate이 할 수 있는 동기호출을 할 수 있고 비동기 호출도 가능하다. 
하지만 RestTemplate은 WebClient가 가능한 비동기 호출을 할 수 없다. 
RestTemplate을 사용한다면 응답이 올 때까지 계속 기다려야 할 것이다.
<br />
<br />

#### -OMDB API KEY

    OMDB_API_KEY='ae898d58'
    상세: `https://www.omdbapi.com/?apikey=${OMDB_API_KEY}&i=${id}&plot=full`
    목록: `https://www.omdbapi.com/?apikey=${OMDB_API_KEY}&s=${payload.title}&type=${payload.type}&y=${payload.year}&page=${payload.page}`
<br />
<br />

#### -slf4j MDC 
ThreadLocal을 쓰레드의 로컬 컨텍스트 변수로 Thread 가 존재하는 한 계속해서 남아 있는 변수이다.
slf4j,logback,log4j2등의 자바 로그 프레임워크에서는 이런 기능을 MDC(Mapped Diagnostic Context) 제공함.
<br />
<br />

#### -자료형에 관한 추가 자료
* List를 ArrayList로 업케스팅으로 선언해서 사용하는 이유.
* Map, List는 인터페이스이다. 구현체를 받아서 사용해야함.
<br />

List를 ArrayList로 선언하는 이유는 다음과 같다.
이것을 업케스팅이라고 부르는데 객체지향프로그램의 일환으로 다형성을 지원하기 위함이다.
처음부터 변경이 유연한 구조로 미리 짜는 방식

ArrayList 는 탐색에 유리한 장점이 있고 LinkedList는 삽입/삭제에 유리하다는 장점
만약 ArrayList<Object> list = new ArrayList<>(); 로 인스턴스를 생성하면 나중에 데이터의 용도가 바뀌어 삽입/삭제ㄱ가 유리한 LiskedList 자료구조로 변경해야할때 ArratList로 선업된 모든 부분을
LinkedList 로 변경해야한다. 또, ArrayList에선 지원하지만 LinkedList에는 지원하지 않는 메소드들사용했다면 그 메소드들을 더이상 사용할 수 없게 된다. 이는 변경에 유연하지 못한 것!
반면 List<Object> list = new ArrayList<>(); 로 선언하면 선언부만 바뀌고 다른 부분은 변경 필요 없음. 이런부분이 업케스팅을 사용하는 의도임.

##### Written By Gook

