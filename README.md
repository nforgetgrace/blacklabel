
# 개요
현재 SI개발팀에서 SI수행을 담당하고 있어 기본적인 프로젝트 세트가 필요하여 개발하게 되었다.

아래 기재된 기능을 구현할 것이고, 기본적인 API서버의 아주 기본적인 구색을 갖출 예정이다.

### Spec
* 자바 11(Zulu)
* 롬복(Lombok)
* 그래들(Gradle)
* 권한(Spring Security)
* 횡단관심 AOP(Logging)
* 공통예외처리 (GlobalException)
* 요청가공 (Filter)
* 레스트 템플릿 (RestTemplate & Configuration)
* 외부 OMDB API (영화검색 API)

<br />
<br />

# 시작하기


<br />
<br />
### 프로젝트 생성
해당프로젝트는 [스프링공식](https://start.spring.io/) 사이트에서 생성이 가능하다.
현재 로컬 IDE 환경이 인텔리제이고, 사이트에서 프로젝트 생성 후 Import 하였다.
초기에 Spring Boot버전과 Gradle 버전이 상이한 부분이 있었다. build.gradle 참고

<br />
<br />

# 지향점
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />

# 지양점
### Lombok - @Data
* @ToString, @Getter, @Setter, @EqualsAndHashCode, 
@RequiredArgsConstructor을 하나로 사용이 가능한 막강한 어노테이션이다.
그러므로 무분별한 Setter 남용을 불러일으킬 수 있고, 그런 남용은 의도가 분명하지 않고 객체의 상태를 
언제든 변경할 수 있기 때문에 객체의 안전성을 보장받기 힘들다.
<br />

# 참고
#### 콘솔 컬러
Configuration창에서 인자로 VM Options에서 -Dspring.output.ansi.enabled=ALWAYS 를 추가해주면 콘솔 
텍스들이 컬러가 먹여지는 것을 확인 할 수 있다.

인텔리제이를 처음에 설치했을때 자신에 맞는 설정들이 필요하다. Code Assistant, 자동저장기능, 코드수정 시 자동서버 재기동 등등...







##### Written By Gook

