Sudoku Solver
=============

A sudoku solver in Java using the OptaPlanner framework.

Performance
-----------

It is able to solve the 2 star sudoku from http://www.sudokuonline.nl/ in under a minute.
For a 4 star sudoku I get after 15 minutes the following score: Hardscore: -12, softscore: 0


TODO-s
-----

1. Warning and error messages, at the start.

   WARNING: An illegal reflective access operation has occurred
   
   WARNING: Illegal reflective access by com.thoughtworks.xstream.core.util.Fields (file XXX/.m2/repository/com/thoughtworks/xstream/xstream/1.4.11.1/xstream-1.4.11.1.jar) to field java.util.TreeMap.comparator
 
   WARNING: Please consider reporting this to the maintainers of com.thoughtworks.xstream.core.util.Fields

   WARNING: Use --illegal-access=warn to enable warnings of further illegal reflective access operations

   WARNING: All illegal access operations will be denied in a future release
   
   Related: https://github.com/x-stream/xstream/issues/101

   SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
   
   SLF4J: Defaulting to no-operation (NOP) logger implementation
   
   SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
   
   Related: https://stackoverflow.com/questions/7421612/slf4j-failed-to-load-class-org-slf4j-impl-staticloggerbinder