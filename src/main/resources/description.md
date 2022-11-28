# Java Collections #

A little review, but deep.

## Basic Data Structures ##

### Static Array ###

* Lineal structure
* Fast access by index
* can't insert
* can't remove

### Dynamic Array ###

* Lineal structure
* Fast access by index
* Slow insert by index
* Slow remove by index

[Array vs Array Lists in Java](https://medium.com/@teamtechsis/java-array-vs-arraylist-b50994c58525)

### Linked List ###

* Lineal structure
* Slow access by index
* Fast insert by iterator
* Fast remove by iterator

### Hash Table ###

* No lineal structure
* Fast insert and remove
* Fast search

## Measuring Java Collections performance ##

### Stage 1 ###

Many access operations.
Some insert and remove operations.

### Stage 2 ###

Many insert and remove operations.
some access operations.

### Stage 3 ###

Many search operations. For example [Two sum problem](https://leetcode.com/problems/two-sum/).

##  Sources ##

[Algorithms 4th edition](https://algs4.cs.princeton.edu/home/)

[Robert Sedgewick Courses](https://sedgewick.io/courses/algorithms/)