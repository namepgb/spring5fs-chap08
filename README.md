[![JIHO's GitHub stats](https://github-readme-stats.vercel.app/api?username=namepgb&include_all_commits=true&theme=nord&hide_border=true&count_private=true)](https://github.com/namepgb/github-readme-stats)

## Preview
`초보 웹 개발자를 위한 스프링 5 프로그래밍 입문` 서적에서 안내된 예제 프로젝트를 생성하고 `Spring`을 학습합니다.
> 
> 이 프로젝트의 개발 환경
>
> <img src="https://img.shields.io/badge/IntelliJ IDEA:2020.3 Ultimate Edition-000000?style=for-the-badge&logo=intellijidea&logoColor=white">
> <img src="https://img.shields.io/badge/OpenJDK:12-437291?style=for-the-badge&logo=openjdk&logoColor=white">
> <img src="https://img.shields.io/badge/Spring:5.0.2.RELEASE-6DB33F?style=for-the-badge&logo=spring&logoColor=white">
> <img src="https://img.shields.io/badge/Gradle:7.3-02303A?style=for-the-badge&logo=gradle&logoColor=white">
> <img src="https://img.shields.io/badge/MySQSL:8.2.0-4479A1?style=for-the-badge&logo=mysql&logoColor=white">

> 이 프로젝트에서는 다음 내용을 포함합니다.
> * Chapter 8 DB 연동
>   * JDBC 프로그래밍의 단점을 보완하는 스프링
>   * 프로젝트 준비
>     * 프로젝트 생성
>     * DB 테이블 생성 
>   * DataSource 설정
>     * Tomcat JDBC의 주요 프로퍼티
>   * JdbcTemplate을 이용한 쿼리 실행
>     * JdbcTemplate 생성하기
>     * JdbcTemplate을 이용한 조회 쿼리 실행
>     * 결과가 1행인 경우 사용 할 수 있는 queryForObject() 메소드
>     * JdbcTemplate을 이용한 변경 쿼리 실행
>     * INSERT 쿼리 실행 시 KeyHolder를 이용해서 자동 생성 키값 구하기
>   * memberDao 테스트하기
>     * DB 연동 과정에서 발생 가능한 Exception
>   * 트랜잭션 처리
>     * @Transactional을 이용한 트랜잭션 처리
>     * @Transactional과 프록시
>     * @Transactional 적용 메소드의 롤백 처리
>     * @Transactional의 주요 속성
>     * @EnableTransactionManagement 어노테이션의 주요 속성
>     * 트랜잭션 전파
>   * 전체 기능 연동한 코드 실행

## sp5-chap08/src/main/java/chap08
> * `JdbcTemplate`을 사용해 `MySQL`에 연동하고 쿼리를 실행합니다.
> 
> 블로그 참고 문서
> * [Spring 5 입문: Chapter 08. JdbcTemplate을 사용한 DB 연동](https://namepgb.tistory.com/266)
