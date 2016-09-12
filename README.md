## Solution to a counting-out game.

Imagine you are in a group of n people standing in a circle.  From some starting point, X you count
k people.  If you are standing in that kth spot, you are ‘out’.  The counting continues until there
is one person standing.  A concrete, but morbid, example of this is the Josephus Problem:

https://en.wikipedia.org/wiki/Josephus_problem

## Build, test and run

Application written in scala, using sbt.

`$ sbt test`

The application takes in 2 parameters: the number of people in the circle (n) and the step rate
(k).  For example, if k is the step rate, then you skip k-1 people and eliminate the kth person. For
n=10 and k=2:

`$ sbt "run 10 2"`

## Contributors

Reed Sandberg