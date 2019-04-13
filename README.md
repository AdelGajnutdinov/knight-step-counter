# Knight Step Counter Project

### Description
This is a REST API that calculates the minimum number of moves for a knight chess piece to move from the initial to the final position on an empty board.
It uses _Breadth-First-Search (BFS)_ algorithm.

### Request examples
1) [/horse/servlet/count?width=8&height=8&start=B1&end=A3](/horse/servlet/count?width=10&height=10&start=B1&end=A3)
_Result_: text
2) [/horse/rest/count?width=8&height=8&start=B1&end=A3](/horse/rest/count?width=10&height=10&start=B1&end=A3)
_Result_: JSON

Parameters description:
* _width_ - width of a chessboard
* _height_ - height of a chessboard
* _start_ - start position of a knight
* _end_ - end position of a knight

### Useful links
1) [Building an Application with Spring Boot](https://spring.io/guides/gs/spring-boot/)
2) [Maven Getting Started Guide](https://maven.apache.org/guides/getting-started/)
3) [Importing an existing Maven project into IntelliJ](https://www.lagomframework.com/documentation/1.4.x/java/IntellijMaven.html)

