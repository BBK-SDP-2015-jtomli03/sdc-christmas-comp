# sdc-christmas-comp
A solution to the following problem;

In a non-leap year February has 28 days, April has 30, and January and May both have 31. Using letters for digits consistently, JAN and MAY are divisible by 31, APR is divisible by 30, and FEB is divisible by 28.
Write a computer a program that uniquely identifies the three-digit number for FEB and writes it to stdout along with execution time expressed in microseconds.
For example: if J=8, A=7, N=9 then the number representing MAY could be 178 but not 169 because N is already represented by 9 and we’ve already established A=7.
N.B Numbers are unique. If A=8 then no other letter can respresent 8.

# How to Build and Run

1) To build you will need to download the Scala 2.11.7 binaries for your system from http://www.scala-lang.org/download/

2) Once built simply run the code and you will be prompted on the console to type the word "feb" - this will start the calculation and return the value of Feb and the execution time in microseconds.

